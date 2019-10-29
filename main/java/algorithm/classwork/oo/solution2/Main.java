package algorithm.classwork.oo.solution2;

import java.util.*;

/**
 * @author: 小栗旬
 * @Date: 2019/10/24 10:45
 */
public class Main {
    static final byte count = 3;


    private Comparator<Status> statusComparator = (s1, s2) ->
            (int) ((s1.getGn() + s1.getHn()) - (s2.getGn() + s2.getHn()));

    public static void main(String args[]) {

        Main am = new Main();

        @SuppressWarnings("resource")
        //读入块数
                Scanner reader = new Scanner(System.in);
        byte size;
        size = count;

        Status.SIZE = size;
        //生成zobrist数组
        long[][] zobrist = new long[2][2 * Status.SIZE + 1];
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 * Status.SIZE + 1; j++) {
                zobrist[i][j] = random.nextLong();
            }
        }

        Status firstStat = am.initialStatus(zobrist);


        Queue<Status> priorityQueue = new PriorityQueue<Status>(am.statusComparator);
        Move move = new Move();
        Map<Long, Integer> hash_to_num = new HashMap<Long, Integer>();

        priorityQueue.add(firstStat);
        hash_to_num.put(firstStat.getZobrist(), firstStat.getGn());


        Status curStatus;
        //寻路
        do {
            curStatus = priorityQueue.poll();
            move.GetNextMoves(curStatus, priorityQueue, hash_to_num, zobrist);
        } while (curStatus.getHn() != 0 || curStatus.getStatus()[2 * Status.SIZE] != 0);


        //输出初始格局
        for (int i = 0; i < 2 * Status.SIZE + 1; i++) {
            System.out.print(curStatus.getStatus()[i]);
        }
        System.out.println("");

        int count = 0;
        Status ss = curStatus.getFather();

        //不断回溯，输出中间格局
        while (ss != null) {
            for (int i = 0; i < 2 * Status.SIZE + 1; i++) {
                System.out.print(ss.getStatus()[i]);
            }
            System.out.println("");
            ss = ss.getFather();
            count++;
        }

        System.out.println("移动次数：" + count);
        System.out.println("耗散值：" + curStatus.getGn());
        System.out.println("");


    }

    public Status initialStatus(long[][] zobrist) {

        Status firstStat = new Status();

        //初始化格局
        byte[] s = new byte[Status.SIZE * 2 + 1];
        int k;
        for (k = 0; k < Status.SIZE; k++) {
            s[k] = 1;
        }
        for (k = 0; k < Status.SIZE; k++) {
            s[Status.SIZE + k] = -1;
        }
        s[Status.SIZE + k] = 0;

        long zob = 0;
        for (int i = 0; i < 2 * Status.SIZE + 1; i++) {

            if (s[i] == 1) {
                zob ^= zobrist[1][i];
            }
            if (s[i] == -1) {
                zob ^= zobrist[0][i];
            }
        }

        //生成新节点
        firstStat = new Status(s, 0, null, 0, zob);

        return firstStat;
    }


}


class Status {
    public static byte SIZE;
    //当前格局
    private byte status[] = new byte[SIZE * 2 + 1];
    //累计路径耗散值(Dissipative value)
    private int gn;
    // 评价函数(Evaluation function)
    private int hn;
    //存放父节点位置
    private Status father;
    //存放移动方向
    private int direction;
    private long zobrist;
    private int empty;

    public Status() {

    }

    public Status(byte[] s, int g, Status father, int direction, long zobrist) {   //构造函数
        if (s.length != SIZE * 2 + 1) {
            System.out.println("Wrong input!");
        } else {
            this.setCurrentStatus(s);
            this.setDissipativeValue(g);
            this.setEvaluationFunction();
            this.setFather(father);
            this.setDirection(direction);
            this.setZobrist(zobrist);
            this.setEmpty();
        }
    }

    //六个get函数
    public byte[] getStatus() {
        return this.status;
    }

    public int getGn() {
        return this.gn;
    }

    public int getHn() {
        return this.hn;
    }

    public Status getFather() {
        return this.father;
    }

    public int getDirection() {
        return this.direction;
    }

    public long getZobrist() {
        return this.zobrist;
    }

    public int getEmpty() {
        return empty;
    }


    private void setCurrentStatus(byte status[]) {
        this.status = status;
    }

    private void setDissipativeValue(int g) {
        this.gn = g;
    }

    //评估函数的值是当前格局中每个白块前面黑块数目之和
    private void setEvaluationFunction() {

        int cc = 0;
        this.hn = 0;
        for (int i = 0; i < this.status.length; i++) {
            if (this.status[i] == 1) {
                cc++;
            }

            if (this.status[i] == -1) {
                this.hn += cc;
            }
        }
    }

    private void setFather(Status father) {
        this.father = father;
    }

    private void setDirection(int direction) {
        this.direction = direction;
    }

    private void setZobrist(long zobrist) {
        this.zobrist = zobrist;
    }

    private void setEmpty() {
        for (int i = 0; i < 2 * SIZE + 1; i++) {
            if (this.status[i] == 0) {
                this.empty = i;
                break;
            }
        }
    }
}

class Move {
    public void GetNextMoves(Status stat, Queue<Status> priorityQueue, Map<Long, Integer> hash_to_num, long[][] zobrist) {
        //对传入节点的所有后继节点进行评估
        //①此格局未出现过    ②此格局出现过但其gn大于新生成节点的gn，即新生成结点为更优节点
        //满足以上条件其中之一则入队

        //记录空格的位置
        int empty = stat.getEmpty();
        int i;
        //旧格局耗散值
        int g1 = stat.getGn();
        //耗散值增加量
        int g2;
        byte temp;
        byte[] s;
        long zob1 = stat.getZobrist();
        long zob2;

        //评估传入节点的每一个后继结点，符合条件则入队
        for (i = empty - 3; i <= empty + 3; i++) {

            if (i >= 0 && i < Status.SIZE * 2 + 1 && i != empty) {
                //计算本次移动带来的耗散值增加量
                g2 = this.calGn(i, empty);

                //对1或0 讨论
                if (stat.getStatus()[i] == 1) {
                    zob2 = zob1 ^ zobrist[1][i] ^ zobrist[1][empty];
                } else {
                    zob2 = zob1 ^ zobrist[0][i] ^ zobrist[0][empty];
                }

                //生成新格局
                s = Arrays.copyOf(stat.getStatus(), stat.getStatus().length);
                temp = s[i];
                s[i] = s[empty];
                s[empty] = temp;

                Status status = new Status(s, g1 + g2, stat, empty - i, zob2);     //生成新节点

                if (hash_to_num.get(status.getZobrist()) == null || hash_to_num.get(status.getZobrist()) > status.getGn()) {               //此格局未出现过   或   出现过但其gn大于新格局的gn，则入队
                    hash_to_num.put(status.getZobrist(), status.getGn());
                    priorityQueue.add(status);
                }

            }
        }
    }


    private int calGn(int start, int end) {     //计算本次移动带来的耗散值增加量
        int gn = 1;
        if (Math.abs(start - end) >= 3) {
            gn = Math.abs(start - end) - 1;
        }
        return gn;
    }
}