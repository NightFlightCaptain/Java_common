package algorithm.datastruct.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wanhaoran
 * @date 2018年5月7日 下午6:37:46
 */
public class ErCha {

	/**
	 * Copyright(C) 2018-2018
	 * Author: wanhaoran
	 * Date: 2018/6/6 20:36
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		final int m = scanner.nextInt();
		scanner.nextLine();
		List<P> list = new LinkedList<P>();
		int count = 0;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String string = scanner.nextLine();
			String[] ps = string.split(";");
			for (int j = 0; j < ps.length; j++) {
				String[] nums = ps[j].split(",");
				list.add(new P(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])));
			}
		}
		Collections.sort(list);
		int nowXiao = list.get(0).x;
		int nowDa = list.get(0).y;
		for (int i = 1; i < list.size(); i++) {

			if (list.get(i).x <= nowDa) {
				if (list.get(i).y > nowDa) {
					nowDa = list.get(i).y;
				}
			} else {
				count++;
				stringBuilder.append(nowXiao+","+nowDa+";");

				nowXiao = list.get(i).x;
				nowDa = list.get(i).y;
			}
		}
		stringBuilder.append(nowXiao+","+nowDa);
		System.out.println(stringBuilder.toString());
	}

//
//3
//1,10;32,45
//78,94;5,16
//80,100;200,220;16,32
}


class P implements Comparable<P> {
	int x, y;

	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(P p) {
		if (x > p.x) {
			return 1;
		} else if (x < p.x) {
			return -1;
		} else {
			return 0;
		}
	}
}