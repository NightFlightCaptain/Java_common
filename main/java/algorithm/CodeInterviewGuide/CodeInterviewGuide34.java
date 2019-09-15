package algorithm.CodeInterviewGuide;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 【小根堆】	【打印N个数组整体最大的TopK】
 * <p>
 * 题目描述
 * 有N个长度不一的数组，所有的数组都是有序的，请从大到小打印这N个数组整体最大的前K个数。
 * 例如，输入含有N行元素的二维数组可以代表N个一维数组。
 * 219, 405, 538, 845, 971
 * 148, 558
 * 52, 99, 348, 691
 * 再输入整数k=5，则打印：
 * Top 5: 971, 845, 691, 558, 538
 * [要求]
 * 时间复杂度为O(klogk)，空间复杂度为O(klogk)
 * <p>
 * 输入描述:
 * 第一行两个整数T, K。分别表示数组个数，需要打印前K大的元素
 * 接下来T行，每行输入格式如下：
 * 开头一个整数N，表示该数组的大小，接下来N个已排好序的数表示数组内的数
 * 输出描述:
 * 从大到小输出输出K个整数，表示前K大。
 * 示例1
 * 输入
 * 3 5
 * 5 219 405 538 845 971
 * 2 148 558
 * 4 52 99 348 691
 * 输出
 * 971 845 691 558 538
 * 备注:
 * 1<=数组内数的总个数<=10^5
 * <p>
 * 0<=数组内元素<=10^9
 * <p>
 * 保证各个输入值合法
 *
 * @author: 小栗旬
 * @Date: 2019/9/14 21:41
 */
public class CodeInterviewGuide34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrCount = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] nums = new int[arrCount][];
        for (int i = 0; i < arrCount; i++) {
            int n = scanner.nextInt();
            nums[i] = new int[n];
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        method1(nums, k);

    }

    /*
    笔试的时候优先考虑使用JDK自带的方法
     */
    private static void method2(int[][] nums, int k) {
        PriorityQueue<HeapNode> queue = new PriorityQueue<>((o1,o2)->o2.value-o1.value);
        int arrCount = nums.length;
        for (int i = 0; i < arrCount; i++) {
            if (nums[i].length==0){
                continue;
            }
            queue.add(new HeapNode(nums[i][nums[i].length - 1], i, nums[i].length - 1));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            HeapNode heapNode = queue.poll();
            res.append(" ").append(heapNode.value);
            if (heapNode.index!=0){
                queue.add(new HeapNode(nums[heapNode.arrNum][heapNode.index-1],heapNode.arrNum,heapNode.index-1));
            }
        }
        System.out.println(res.substring(1));
    }

    //大根堆的方法，复杂，规范
    private static void method1(int[][] nums, int k) {
        int arrCount = nums.length;
        HeapNode[] heapNodes = getHeadpNode(nums);
        StringBuilder res = new StringBuilder();
        int heapSize =0;
        for (HeapNode heapNode:heapNodes){
            if (heapNode !=null){
                heapSize++;
            }
        }

        for (int i = 0; i < k; i++) {
            if (heapSize == 0) {
                break;
            }
            HeapNode large = heapNodes[0];
            res.append(" ").append(large.value);
            if (large.index == 0) {
                swapHeap(heapNodes, --heapSize, 0);
            } else {
                heapNodes[0] = new HeapNode(nums[large.arrNum][large.index - 1], large.arrNum, large.index - 1);
            }
            setNodesHead(heapNodes, heapSize);
        }
        System.out.println(res.substring(1));
    }

    /*
     5 9
     4 52 99 348 691
      6 219 405 538 845 971 1206
      0
      3 148 558 1000
      1 1000


     */
    private static HeapNode[] getHeadpNode(int[][] nums) {
        int arrCount = nums.length;
        HeapNode[] heapNodes = new HeapNode[arrCount];
        int nodesLength =0;
        for (int i = 0; i < arrCount; i++) {
            if (nums[i].length==0){
                continue;
            }
            heapNodes[nodesLength] = new HeapNode(nums[i][nums[i].length - 1], i, nums[i].length - 1);
            int index = nodesLength++;
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heapNodes[parent].value < heapNodes[index].value) {
                    swapHeap(heapNodes, parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }
        return heapNodes;
    }

    private static void setNodesHead(HeapNode[] heapNodes, int heapSize) {
        int index = 0;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largeIndex = index;
        while (left < heapSize) {
            if (heapNodes[left].value > heapNodes[index].value) {
                largeIndex = left;
            }
            if (right < heapSize && heapNodes[right].value > heapNodes[largeIndex].value) {
                largeIndex = right;
            }

            if (index == largeIndex) {
                break;
            } else {
                swapHeap(heapNodes, index, largeIndex);
            }
            index = largeIndex;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void swapHeap(HeapNode[] heapNodes, int index1, int index2) {
        HeapNode temp = heapNodes[index1];
        heapNodes[index1] = heapNodes[index2];
        heapNodes[index2] = temp;
    }
}

class HeapNode {
    public int value;
    public int arrNum;
    public int index;

    public HeapNode(int value, int arrNum, int index) {
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
