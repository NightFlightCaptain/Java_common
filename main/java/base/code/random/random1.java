package base.code.random;

import java.util.Random;

/**
 *
 * @author wanhaoran
 * @date 2018年5月9日 下午4:20:52
 *
 *	等概率返回1-n中的任一数
 */
public class random1 {

	public static void main(String[] args) {
		Random random = new Random();

		for (int i =1;i<100;i++)
			System.out.print(random.nextInt(2)+" ");

//		int n =9;
//		int[] k = new int[n];
//		for (int i = 0; i < 100000; i++) {
//			k[random(n)]++;
//		}
//		for (int i : k) {
//			System.out.println(i);
//		}
	}

	private static int random(int n) {
		int m  =n;
		n--;
		int count = 0;
		while (n > 0) {
			count++;
			n = n >> 1;
		}
		while (count-- > 0) {
			n += Rand();
			if (count != 0) {
				n = n << 1;				
			}
		}
		if (n>=m) {
			return random(m);
		}
		return n;
		
	}

	private static int Rand() {
		Random random = new Random();
		return random.nextInt(2);
	}
}
