package algorithm.realExam.Tecent2018Spring;

import java.util.Scanner;

/**
 * 【画家小Q】
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/6acc6504df67406c98a75f5575e4b94a
 * 来源：牛客网
 * <p>
 * 画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用'X'表示。
 * 小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如'/',即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;如果对角线的方向形如'\',即斜率为-1,小Q会选择这条斜线中的一段格子,都涂画为黄色,用'Y'表示。
 * 如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用'G'表示。
 * 小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数N和M(1 <= N, M <= 50), 表示画板的长宽。
 * 接下来的N行包含N个长度为M的字符串, 其中包含字符'B','Y','G','X',分别表示蓝色,黄色,绿色,空白。整个表示小Q要完成的作品。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个正整数, 表示小Q最少需要多少次操作完成绘画。
 * 示例1
 * 输入
 * 4 4
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 * 输出
 * 3
 * 说明
 * XXXX
 * XXXX
 * XXXX
 * XXXX
 * ->
 * YXXX
 * XYXX
 * XXYX
 * XXXY
 * ->
 * YXXB
 * XYBX
 * XBYX
 * BXXY
 * ->
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 *
 * @author: 小栗旬
 * @Date: 2019/10/31 10:40
 */
public class Tecent2018SpringF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        char[][] resultColors = new char[n][m];
        for (int i = 0; i < n; i++) {
            resultColors[i] = scanner.nextLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            // line表示连线是否中断，如果在一条直线种连线有中断，那么就可能需要画多次
            boolean line = false;
            for (int j = 0; i + j < n && j < m; j++) {
                if (resultColors[i + j][j] == 'Y' || resultColors[i + j][j] == 'G') {
                    if (!line) {
                        count++;
                        line = true;
                    }
                } else {
                    line = false;
                }
            }
        }

        for (int j = 1; j < m; j++) {
            boolean line = false;
            for (int i = 0; i < n && j + i < m; i++) {
                if (resultColors[i][j + i] == 'Y' || resultColors[i][j + i] == 'G') {
                    if (!line) {
                        count++;
                        line = true;
                    }
                } else {
                    line = false;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            boolean line = false;
            for (int i = 0; i < n && j - i >= 0; i++) {
                if (resultColors[i][j - i] == 'B' || resultColors[i][j - i] == 'G') {
                    if (!line) {
                        count++;
                        line = true;
                    }
                } else {
                    line = false;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            boolean line = false;
            for (int j = m - 1; j >= 0 && i + (m - 1 - j) < n; j--) {
                if (resultColors[i + (m - 1 - j)][j] == 'B' || resultColors[i + (m - 1 - j)][j] == 'G') {
                    if (!line) {
                        count++;
                        line = true;
                    }
                } else {
                    line = false;
                }
            }
        }
        /*
        4 4
YXXB
XYGX
XBYY
BXXY
         */
        System.out.println(count);
    }
}
