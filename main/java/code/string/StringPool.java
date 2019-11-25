package code.string;

/**
 * @author: 小栗旬
 * @Date: 2019/11/13 20:41
 */
public class StringPool {
    public static void main(String[] args) {
        String s1 = "he";
        String s2 = "hello";
        System.out.println("he" == s1);
        System.out.println("he" + "llo" == s2);
        System.out.println(s1 + "llo" == s2);
    }

}
