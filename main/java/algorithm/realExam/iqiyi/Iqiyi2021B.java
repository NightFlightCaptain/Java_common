package algorithm.realExam.iqiyi;

import java.util.*;

/**
 * @author: 小栗旬
 * @Date: 2021/8/1 14:50
 * <p>
 * [1,2,0,0,2,1]
 * [1,2,0,2,0,1]
 * [1,2,0,0,2,1]
 */
public class Iqiyi2021B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split("\\[");
        strings = strings[1].split("\\]");
        String[] numSs = strings[0].split(",");
        rains = new int[numSs.length];
        for (int i = 0; i < numSs.length; i++) {
            rains[i] = Integer.valueOf(numSs[i]);
        }
        lakes = new int[rains.length];
        operation = new int[rains.length];
        operate(0);
        System.out.println(Arrays.toString(operation));
    }

    static int[] lakes;
    static int[] operation;
    static int[] rains;

    private static boolean operate(int day) {
        if (day>=lakes.length){
            return true;
        }

        if (rains[day] != 0) {
            //下雨
            if (lakes[rains[day]-1]!=0){
                return false;
            }
            operation[day] = -1;
            lakes[rains[day]-1]=1;
            operate(day+1);
        } else {
            //不下雨
            for (int i = 0; i < lakes.length; i++) {
                //处理每一个湖泊
                if (lakes[i] !=0){
                    int temp = lakes[i];
                    lakes[i] = 0;
                    operation[day] = i+1;
                    boolean success = operate(day+1);
                    if (success){
                        break;
                    }
                    operation[day] = 0;
                    lakes[i] = temp;
                }
            }
        }
        return false;
    }

}
