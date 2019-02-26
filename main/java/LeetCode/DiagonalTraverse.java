package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/15 9:40
 *
 * LeetCode 498 对角线遍历
 *
 *  * 给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
 * 输入:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse {
	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0){
			return null;
		}
		List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
		for (int i = 0; i < matrix.length + matrix[0].length - 1; i += 2) {
			int j = i;
			while (j >= 0) {
				if (j < matrix.length && i - j < matrix[0].length) {
					list.add(matrix[j][i - j]);
				}
				j--;
			}
			j = i + 1;
			while (j >= 0) {
				if (j < matrix[0].length && i + 1 - j < matrix.length) {
					list.add(matrix[i + 1 - j][j]);
				}
				j--;
			}
		}
		int[] nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}
		return nums;
	}

	public static void main(String[] args) {
		int[][] a = {{3}, {2}};
		for (int aa : findDiagonalOrder(a)) {
			System.out.println(aa);
		}
	}
}