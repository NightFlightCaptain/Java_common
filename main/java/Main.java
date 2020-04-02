import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] cards = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        main.movaCards(cards);
        System.out.println(Arrays.toString(cards));
    }

    private int[] movaCards(int[] nums){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            move(list,nums[i]);
        }
//        System.out.println(list);
        int index =0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            nums[index++] = iterator.next();
        }
        return nums;
    }

    private void move(LinkedList<Integer> list,int card){
        if (list.isEmpty()){
            list.addFirst(card);
            return;
        }
        list.addFirst(list.removeLast());
        list.addFirst(card);
    }

}
