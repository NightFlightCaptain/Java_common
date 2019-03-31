package algorithm.JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: 小栗旬
 * Date: 2019/3/31 10:38
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<>(size);

		ArrayList<Integer> integers = new ArrayList<>(size);
		int length = num.length;
		if (size == 0 || length<size){
			return result;
		}
		for (int i = 0; i < size ; i++) {
			integers.add(num[i]);
		}
		result.add(Collections.max(integers));
		int index = 0;
		for (int i = size; i < num.length; i++) {
			if (index == size){
				index=0;
			}
			integers.set(index++, num[i]);
			result.add(Collections.max(integers));
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,3};
		MaxInWindows solution = new MaxInWindows();
		System.out.println(solution.maxInWindows(nums, 3));
	}
}
