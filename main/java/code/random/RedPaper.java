package code.random;

import java.math.BigDecimal;

/**
 * @author: 小栗旬
 * @Date: 2020/3/11 23:17
 */
public class RedPaper {

    private static BigDecimal[] getList(double total, int count, double min, double max) {
        BigDecimal[] res = new BigDecimal[count];
        for (int i = 0; i < res.length; i++) {
            res[i] = new BigDecimal(min);
        }
        BigDecimal left = new BigDecimal(total - min * count);

        for (int i = 0; i < count - 1; i++) {
            BigDecimal money;
            do {
                BigDecimal bigDecimal = new BigDecimal(Math.random() * (Math.min(max, left.doubleValue())));
                money = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
            } while ((count - i - 1) * max < left.subtract(money).doubleValue());

            res[i] = res[i].add(money);
            left = left.subtract(money);
        }
        System.out.println("left" + left);
        res[count - 1] = res[count - 1].add(left);
        return res;
    }

    public static void main(String[] args) {
        BigDecimal[] moneys = getList(100, 10, 1, 30);
        BigDecimal total = new BigDecimal(0);
        for (BigDecimal bigDecimal : moneys) {
            total = total.add(bigDecimal);
            System.out.println(bigDecimal.doubleValue());
        }
        System.out.println(total);
    }
}
