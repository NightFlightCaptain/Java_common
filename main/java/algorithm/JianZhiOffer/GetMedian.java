package algorithm.JianZhiOffer;

import java.util.LinkedList;

/**
 * Author: 小栗旬
 * Date: 2019/3/31 9:35
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {
	LinkedList<Integer> list = new LinkedList<>();

	public void Insert(Integer num) {
		int size = list.size();
		int start = 0;
		int end = size;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (list.get(mid) > num) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		list.add(mid, num);
	}

	public Double getMedian() {
		int size = list.size();
		if ((size & 1) == 1) {
			return (double) list.get(size / 2);
		} else {
			return  (list.get(size / 2) + list.get(size / 2-1)) / ((double)2);
		}
	}

	public static void main(String[] args) {
		GetMedian solution = new GetMedian();
		int[] ints = {5,2,3,4,1,6,7,0,8};
		for (int a : ints) {
			solution.Insert(a);
			System.out.println(solution.getMedian());
		}
	}
}
