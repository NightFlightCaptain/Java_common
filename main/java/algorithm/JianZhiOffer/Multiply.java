package algorithm.JianZhiOffer;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/3/17 10:23
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {
	public int[] multiply(int[] A) {
		int length = A.length;
		int[] res = new int[length];
		if (length==0){
			return res;
		}
		int[] head = new int[length];
		int[] tail = new int[length];

		head[0] = 1;
		tail[length - 1] = 1;


		for (int i = 1; i < length; i++) {
			head[i] = A[i - 1] * head[i - 1];
			tail[length - 1 - i] = A[length - i] * tail[length - i];
		}

		for (int i = 0;i<length;i++){
			res[i]= head[i]*tail[i];
		}
		return res;
	}

	public static void main(String[] args) {
		Multiply solution = new Multiply();
		int[] input = {};
		System.out.println(Arrays.toString(solution.multiply(input)));
	}
}
