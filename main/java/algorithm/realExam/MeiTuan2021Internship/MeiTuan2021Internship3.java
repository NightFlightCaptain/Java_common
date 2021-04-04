package algorithm.realExam.MeiTuan2021Internship;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/4/4 9:48
 * <p>
 * <p>
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美发明了一个函数：f(x)，表示将x的所有正整数因子提取出来之后从小到大排列，再将数字拼接之后得到的数字串。例如：10的所有因子为1,2,5,10，那么将这些因子从小到大排序之后再拼接得到的数字串为12510，即f(10)=12510。
 * <p>
 * 小美十分讨厌数字k，如果f(x)中含有某个子串对应的数字等于k，那么她的不高兴度就会增加1。例如：f(8)=1248，那么其所有的子串为：1,2,4,8,12,24,48,124,248,1248，只要k等于其中任意一个值，那么小美的不高兴度就会增加1。对于每一个数，其不高兴度至多增加1。
 * <p>
 * 现在，有一个长度为n的正整数序列，定义其不高兴度为序列中所有数的不高兴度的总和。小美想要知道自己对于这个序列的总不高兴度为多少。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行两个正整数n,k；
 * <p>
 * 第二行n个正整数ai，表示该序列。
 * <p>
 * 1≤n≤105，1≤k，ai≤2x104
 * <p>
 * 输出描述
 * 输出一行一个正整数，表示小美的总不高兴度。
 * <p>
 * <p>
 * 样例输入
 * 5 13
 * 13 31 10 9 20
 * 样例输出
 * 3
 * <p>
 * 提示
 * f(13)=113,含有13；
 * f(31)=131,含有13；
 * f(10)=12510,不含有13；
 * f(9)=139，含有13；
 * f(20)=12451020,不含有13。
 * 综上，不高兴度为3。
 * 规则
 */
public class MeiTuan2021Internship3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        int happyValue =0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            happyValue+=isHappy(nums[i],k);
        }
        System.out.println(happyValue);
    }

    private static int isHappy(int num,int k){
        String s = getString(num);

        if (s.contains(String.valueOf(k))){
            return 1;
        }
        return 0;

    }

    private static String getString(int num){
        int low =1;
        int high = num;
        StringBuilder stringBuilder = new StringBuilder(1);
        while (low<=high){
            while (high%low==0){

                stringBuilder.append(low);
                low++;
            }
            low++;
        }
        return stringBuilder.toString();
    }
}
