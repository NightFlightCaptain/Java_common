package algorithm.JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/3/5 21:08
 * <p>
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
		//为什么这个地方是Math.sqrt(2*sum),i代表的是有多少个数，当数组从1开始的时候数组长度最大
		for (int i = (int)Math.sqrt(2*sum); i >=2; i--) {
			double midNum = (double) sum / i;
			boolean odd = (i & 1) == 1;
			boolean midNumInt = (int) (midNum) == midNum;
			boolean midNum_5 = (int) (midNum) != midNum && (int) (midNum * 2) == midNum * 2;
			if (odd) {
				if (midNumInt) {
					arrayLists.add(generateArrayList((int) (midNum - i / 2), i));
				}
			} else {
				if (midNum_5) {
					arrayLists.add(generateArrayList((int) (midNum - i / 2 + 1), i));
				}
			}
		}
		return arrayLists;
	}

	private ArrayList<Integer> generateArrayList(int firstNum, int count) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = firstNum; i < firstNum + count; i++) {
			arrayList.add(i);
		}
		return arrayList;
	}

	public static void main(String[] args) {
		FindContinuousSequence solution = new FindContinuousSequence();
		ArrayList<ArrayList<Integer>> arrayLists = solution.FindContinuousSequence(100);
		System.out.println(Arrays.deepToString(arrayLists.toArray()));
	}

}
