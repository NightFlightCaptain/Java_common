package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/10 20:54
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		int length = matrix.length;

		for (int i = 0; i < length; i++) {
			boolean[] isWalked = new boolean[length];
			if (matrix[i] != str[0]) {
				continue;
			}
			boolean flag = hasPath(isWalked, matrix, (i) / cols, (i) % cols, rows, cols, str, 0);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	private boolean hasPath(boolean[] isWalked, char[] matrix, int rowIndex, int colIndex, int rows, int cols, char[] str, int index) {
//		if (index == str.length) {
//			return true;
//		}
		if (matrix[rowIndex * cols + colIndex] != str[index]) {
			return false;
		}

		isWalked[rowIndex * cols + colIndex] = true;
		index += 1;
		if (index == str.length) {
			return true;
		}
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		if (colIndex + 1 < cols && !isWalked[rowIndex * cols + colIndex + 1]) {
			flag1 = hasPath(isWalked, matrix, rowIndex, colIndex + 1, rows, cols, str, index);
			if (flag1) {
				return true;
			}
		}
		if (colIndex - 1 >= 0 && !isWalked[rowIndex * cols + colIndex - 1]) {
			flag2 = hasPath(isWalked, matrix, rowIndex, colIndex - 1, rows, cols, str, index);
			if (flag2) {
				return true;
			}
		}

		if (rowIndex + 1 < rows && !isWalked[(rowIndex + 1) * cols + colIndex]) {
			flag3 = hasPath(isWalked, matrix, rowIndex + 1, colIndex, rows, cols, str, index);
			if (flag3) {
				return true;
			}
		}
		if (rowIndex - 1 >= 0 && !isWalked[(rowIndex - 1) * cols + colIndex]) {
			flag4 = hasPath(isWalked, matrix, rowIndex - 1, colIndex, rows, cols, str, index);
			if (flag4) {
				return true;
			}
		}
		return flag1 || flag2 || flag3 || flag4;
	}

	public static void main(String[] args) {
		HasPath solution = new HasPath();
		char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i]);
			if ((i + 1) % 8 == 0) {
				System.out.println();
			}
		}
		String[] strings = {"SLHECCEIDEJFGGFIE"};
		for (String s : strings) {
			char[] str = s.toCharArray();
			System.out.println(solution.hasPath(matrix, 5, 8, str));
		}
//		System.out.println(solution.hasPath(matrix, 3, 4, "asfcceseeda".toCharArray()));
	}
}
