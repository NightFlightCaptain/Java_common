package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/16 20:45
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
	public boolean Find(int target, int[][] array) {
		int rows = array.length;
		int cols = array[0].length;

		int row = 0;
		int col = cols - 1;

		while (row < rows && col >= 0) {
			if (array[row][col] == target) {
				return true;
			}
			if (array[row][col] > target) {
				col--;
				continue;
			}
			if (array[row][col] < target) {
				row++;
				continue;
			}
//			System.out.println(" row:" + row + " col:" + col);
		}
		return false;
	}

	public static void main(String[] args) {
		Find solution = new Find();

		int[][] a = {
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}
		};

		System.out.println(solution.Find(5, a));
	}
}
