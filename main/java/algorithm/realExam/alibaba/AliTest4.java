package algorithm.realExam.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 小栗旬
 * @Date: 2020/3/16 20:21
 */
public class AliTest4 {
    public static void main(String[] args) {
        AliTest4 test2 = new AliTest4();
        System.out.println(test2.wordPattern("abbac", "北京 杭州 杭州 北京 上海") == true);
        System.out.println(test2.wordPattern("aacbb", "北京 北京 上海 杭州 北京") == false);
        System.out.println(test2.wordPattern("baabcc", "北京 杭州 杭州 北京 上海 上海") == true);
    }

    private  boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        String[] strs = str.split(" ");
        int length = pattern.length();
        if (strs.length != length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character character = pattern.charAt(i);
            String city = strs[i];
            boolean isKeyExist = map.containsKey(character);
            boolean isValueExist = map.containsValue(city);
            if (isKeyExist){
                if (!city.equals(map.get(character))){
                    return false;
                }
            }else {
                if (isValueExist){
                    return false;
                }else {
                    map.put(character,city);
                }
            }
        }
        return true;
    }
}
