package algorithm.classwork.oo;

import java.util.Arrays;

/**
 * @author: 小栗旬
 * @Date: 2019/10/19 10:37
 */
public class Solution4 {
    static int maxPrice = 0;
    static int[] bestHarvest = new int[5];

    public static void main(String[] args) {
        int[][] profits = new int[][]{
                {3, 2, 4, 1},
                {15, 1, 17, 7},
                {9, 4, 6, 5},
                {11, 1, 4, 3}
        };
        int[] curHasvest = new int[5];
        harvest(profits, 1, 3, 0,curHasvest);
        System.out.println(maxPrice);
        String[] strings = {"水稻","大豆","燕麦","牧草"};
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(bestHarvest).forEachOrdered(o->stringBuilder.append(" ").append(strings[o]));
        System.out.println(stringBuilder.substring(1));

    }

    private static void harvest(int[][] profits, int year, int lastYearH, int price,int[] curHarvest) {
        if (year > 5) {
            if (price > maxPrice){
                maxPrice = price;
                bestHarvest = Arrays.copyOf(curHarvest,5);
            }
            return;
        }
        int[] profitThisYear = profits[lastYearH];

        for (int i = 0; i < profitThisYear.length; i++) {
            price += profitThisYear[i];
            curHarvest[year-1]=i;
            harvest(profits, year+1, i, price,curHarvest);
            price -= profitThisYear[i];
        }
    }
}
