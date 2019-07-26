package algorithm.JianZhiOffer;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/7/26 20:46
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

	public boolean verifySquenceOfBST(int[] sequence) {
		int length = sequence.length;
		if (length == 0) {
			return false;
		}
		int last = sequence[length - 1];
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < length; i++) {
			//二叉搜索树的后序遍历，对于任一子集，取最后一个数，能将前面的数分为两段，一段大于该数，一段小于该数，就认为是Yes
			if (flag && sequence[i] < last) {
				return false;
			}
			if (!flag && sequence[i] > last) {
				index = i;
				flag = true;
			}
		}
		flag = true;
		if (index > 0) {
			flag = verifySquenceOfBST(Arrays.copyOf(sequence, index));
		}
		if (index < length - 1) {
			flag = flag & verifySquenceOfBST(Arrays.copyOf(sequence, length - index - 1));
		}
		return flag;
	}

	public boolean verifySquenceOfBST2(int[] sequence) {
		return verifySquenceOfBSTHelper(sequence, 0, sequence.length - 1);
	}

	/* 通过传递数组和左右下表的方式就不用使用Arrays.copyOf，这样节约了内存 */
	private boolean verifySquenceOfBSTHelper(int[] sequence, int left, int right) {

		if (right < left) {
			return false;
		}
		int last = sequence[right];
		int index = left;
		boolean flag = false;
		for (int i = left; i < right; i++) {
			//二叉搜索树的后序遍历，对于任一子集，取最后一个数，能将前面的数分为两段，一段大于该数，一段小于该数，就认为是Yes
			if (flag && sequence[i] < last) {
				return false;
			}
			if (!flag && sequence[i] > last) {
				index = i;
				flag = true;
			}
		}
		flag = true;
		if (index > left) {
			flag = verifySquenceOfBSTHelper(sequence, left, index - 1);
		}
		if (index < right) {
			flag = flag & verifySquenceOfBSTHelper(sequence, index + 1, right);
		}
		return flag;
	}

	public static void main(String[] args) {
		VerifySquenceOfBST solution = new VerifySquenceOfBST();
		int[] squence = {1, 3, 2, 8, 4, 11, 12, 18, 22, 19, 14, 9};
		System.out.println(solution.verifySquenceOfBST2(squence));
	}
}
