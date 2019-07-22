package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/7/22 20:22
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
		int i, j;
		while (top < bottom && left < right) {
			i = left;
			j = top;
			while (j < right) {
				result.add(matrix[i][j++]);
			}
			top++;
			while (i < bottom) {
				result.add(matrix[i++][j]);
			}
			right--;
			while (j > left) {
				result.add(matrix[i][j--]);
			}
			bottom--;
			while (i >= top) {
				result.add(matrix[i--][j]);
			}
			left++;
		}
		while (top == bottom && left < right) {
			result.add(matrix[top][left++]);
		}
		while (left == right && top < bottom) {
			result.add(matrix[top++][right]);
		}
		if (left == right && top == bottom) {
			result.add(matrix[top][left]);
		}
		return result;
	}

	public static void main(String[] args) {
		PrintMatrix solution = new PrintMatrix();
		/*
		 1  2  3  4 5  6
		 7  8  9 10 11 12
		13 14 15 16 17 18
		*/
		int[][] a = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
		System.out.println(solution.printMatrix(a));

	}
}
