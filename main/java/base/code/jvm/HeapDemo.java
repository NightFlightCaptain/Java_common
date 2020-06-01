package base.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 小栗旬
 * Date: 2019/1/14 22:44
 */
public class HeapDemo {
	public static void main(String[] args) {
		List<byte[]> list = new ArrayList<byte[]>();

		int i = 0;
		boolean flag = true;

		while (flag) {
			try {
				i++;
				list.add(new byte[1024 * 1024]);
			} catch (Throwable e) {
				e.printStackTrace();
				flag = false;
				System.out.println("count = " + i);
			}
		}
	}
}
