package code.compare;

import java.util.*;

/**
 *
 *@author wanhaoran
 *@date 2018年5月23日 上午9:06:43
 *
 */

public class Compare {

	public static void main(String[] args) {
		Interval interval = new Interval(4,9);
		Interval interval1 = new Interval(5,8);
		System.out.println(interval.compareTo(interval1));

		Comparator<Interval> comparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.end>o2.end){
					return 1;
				}else if (o1.end<o2.end){
					return -1;
				}else {
					return 0;
				}
			}
		};

		Comparator<Interval> comparatorLambda = (o1, o2) -> {
			if (o1.end>o2.end){
				return 1;
			}else if (o1.end<o2.end){
				return -1;
			}else {
				return 0;
			}
		};

		System.out.println(comparator.compare(interval, interval1));

		List<Interval> intervalList = new ArrayList<>();
		intervalList.add(interval);
		intervalList.add(interval1);
		Collections.sort(intervalList);
		System.out.println(Arrays.toString(intervalList.toArray()));
		Collections.sort(intervalList,comparator);
		System.out.println(intervalList);

		Map<Object,Interval> hashMap = new TreeMap<Object, Interval>();
		hashMap.put(new Object(),new Interval());

	}
}
