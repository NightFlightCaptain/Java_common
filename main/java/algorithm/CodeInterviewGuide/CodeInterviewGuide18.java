package algorithm.CodeInterviewGuide;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/28 16:15
 * 【最大值减去最小值小于或等于num的子数组数量】
 * <p>
 * 题目描述
 * 给定数组 arr 和整数 num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j] - min(arr[i...j]) <= num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值，min[arr[i...j])表示子数组arr[i...j]中的最小值。
 * <p>
 * 输入描述:
 * 第一行输入两个数 n 和 num，其中 n 表示数组 arr 的长度
 * 第二行输入n个整数X_i，表示数组arr中的每个元素
 * <p>
 * 输出描述:
 * 输出给定数组中满足条件的子数组个数
 * 示例1
 * 输入
 * 5 2
 * 1 2 3 4 5
 * 输出
 * 12
 */
public class CodeInterviewGuide18 {
    /*
    时间复杂度为O(n)不代表只能有一个循环，循环条件的中的某个变量如果是全局的，或者说是在当前循环外的，那么就有可能这一个循环总共只走了n次
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //存放的是最大值点的坐标，不涉及到这个点之后的坐标
        //例如，left=2，right=6;maxIndex = 4;那么qmax前四个值是maxIndex;index=5,6对于的qmax的值的时候就比index=maxIndex的时候小
        LinkedList<Integer> qmax = new LinkedList<>();
        //存放的是从left点开始，到当前每个点的最小值
        LinkedList<Integer> qmin = new LinkedList<>();
        int left = 0, right = 0;
        int totalCount = 0;
        //所有的下标值最多进qmax，qmin一次，出qmax，qmin一次，i和j的值也是不断增加，从未减少，所以整个的时间复杂度为O(n)
        while (left < n) {
            while (right < n) {
                //右边的值比左边的大，那么左边的值就全都没有用了
                while (!qmax.isEmpty() && nums[qmax.getLast()] <= nums[right]) {
                    qmax.pollLast();
                }
                qmax.addLast(right);

                while (!qmin.isEmpty() && nums[qmin.getLast()] >= nums[right]) {
                    qmin.pollLast();
                }
                qmin.addLast(right);

                if (nums[qmax.getFirst()] - nums[qmin.getFirst()] > num) {
                    break;
                }
                right++;
            }
            totalCount+=right-left;
            //最左边的点就是最大值，去掉最左边的点就要改变最大值，不然最大值保持不变
            if (qmax.getFirst() == left) {
                qmax.pollFirst();
            }
            if ( qmin.getFirst() == left) {
                qmin.pollFirst();
            }
            left++;

        }
        System.out.println(totalCount);
    }

    private static void method2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //存放的是从left点开始，到当前每个点的最大值，right是结束点。
        //例如 left = 2,right = 6,qmax[4]表示的是坐标从2到4的中间最大值的坐标
        LinkedList<Integer> qmax = new LinkedList<>();
        //存放的是从left点开始，到当前每个点的最小值
        LinkedList<Integer> qmin = new LinkedList<>();
        int left = 0, right = 0;
        int totalCount = 0;
        while (left < n) {
            while (right < n) {

            }

        }
        System.out.println(totalCount);
    }
}
