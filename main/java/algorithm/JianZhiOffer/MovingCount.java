package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/15 20:32
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
	public int movingCount(int threshold, int rows, int cols) {
//		int count = 0;
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				if ((getSum(i) + getSum(j)) <= threshold) {
//					System.out.print(String.format("(%2d,%2d)", i, j));
//					count++;
//				} else if (i == 0) {
//					break;
//				} else if (j == 0) {
//					return count;
//				} else {
//					j = j - j % 10 + 9;
//					System.out.print("(     )");
//				}
//			}
//			System.out.println();
//		}
//		return count;
		boolean[][] isWalked = new boolean[rows][cols];
		return countSteps(isWalked, threshold, 0, 0, rows, cols);
	}

	private int countSteps(boolean[][] isWalked, int limit, int rowIndex, int colIndex, int rows, int cols) {
		if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols
				|| isWalked[rowIndex][colIndex] || (getSum(rowIndex) + getSum(colIndex) > limit)) {
			return 0;
		}
		isWalked[rowIndex][colIndex] = true;
		return countSteps(isWalked, limit, rowIndex + 1, colIndex, rows, cols)
				+ countSteps(isWalked, limit, rowIndex - 1, colIndex, rows, cols)
				+ countSteps(isWalked, limit, rowIndex, colIndex + 1, rows, cols)
				+ countSteps(isWalked, limit, rowIndex, colIndex - 1, rows, cols)
				+ 1;
	}

	private int getSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number = number / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		MovingCount solution = new MovingCount();
		System.out.println(solution.movingCount(10, 2, 31));
	}
}
