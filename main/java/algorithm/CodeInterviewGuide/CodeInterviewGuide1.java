package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * Author: 小栗旬
 * Date: 2019/8/4 8:18
 * <p>
 * 题目描述
 * 给定一个N×M的整形矩阵matrix和一个整数K, matrix的每一行和每一列都是排好序的。
 * 实现一个函数，判断K是否在matrix中
 * [要求]
 * 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 * 输入描述:
 * 第一行有三个整数N, M, K
 * 接下来N行，每行M个整数为输入的矩阵
 * 输出描述:
 * 若K存在于矩阵中输出"Yes"，否则输出"No"
 * <p>
 * 示例1
 * 输入
 * 2 4 5
 * 1 2 3 4
 * 2 4 5 6
 * 输出
 * Yes
 * 说明
 * <p>
 * 示例2
 * 输入
 * 2 4 233
 * 1 2 3 4
 * 2 4 5 6
 * 输出
 * No
 * 说明
 * <p>
 * 备注:
 * 1⩽N,M⩽1000
 * 0⩽K,矩阵中的数⩽10^9
 */
public class CodeInterviewGuide1 {
	public boolean codeInterviewGuide1() {
		Scanner scanner = new Scanner(System.in);
		final int N = scanner.nextInt();
		final int M = scanner.nextInt();
		final int K = scanner.nextInt();
		scanner.nextLine();
		int[][] a = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = scanner.nextInt();
			}
		}


		int j = M - 1, i = 0;
		while (j >= 0 && i < N) {
			if (a[i][j] == K) {
				System.out.println("Yes");
				return true;
			}else if (a[i][j] > K){
				j--;
			}else {
				i++;
			}
		}
		System.out.println("No");
		return false;

	}

	public static void main(String[] args) {
		CodeInterviewGuide1 solution = new CodeInterviewGuide1();
		solution.codeInterviewGuide1();
	}
}
