package algorithm.realExam.PDD2021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/7/25 18:51
 */
public class PDD2021A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[][] nums = new int[n][2];
//        for (int i =0;i<n;i++){
//            nums[i][0]=scanner.nextInt();
//            nums[i][1]=scanner.nextInt();
//        }
        Node[] nodes = new Node[n];
        for (int i =0;i<n;i++){
            nodes[i]= new Node();
            nodes[i].left = scanner.nextInt();
            nodes[i].right = scanner.nextInt();
        }

        Arrays.sort(nodes,(node1, node2)->{
            if (node1.left == node2.left){
                return node1.right-node2.right;
            }else {
                return node1.left - node2.left;
            }
        });
        int left =nodes[0].left;int right=nodes[0].right;
        for (int i =1;i<n;i++){
            if (nodes[i].left <=right && nodes[i].right<=right){
                System.out.println("true");
                return;
            }else {
                left = nodes[i].left;
                right = nodes[i].right;
            }
        }
        System.out.println("false");
    }

    static class Node{
        int left;
        int right;

        @Override
        public String toString() {
            return left+" "+right;
        }
    }
}
