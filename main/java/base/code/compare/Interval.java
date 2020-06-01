package base.code.compare;

/**
 * Author: 小栗旬
 * Date: 2018/12/28 17:21
 */
public class Interval implements Comparable<Interval> {
	int start;
	int end;
	private String name = "还好";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Interval interval) {
		if (this.start > interval.start) {
			return 1;
		} else if (this.start < interval.start) {
			return -1;
		} else {
			return 0;
		}
	}

	public void say(String string) {
		System.out.println(string);
	}

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval{" +
				"start=" + start +
				", end=" + end +
				", name='" + name + '\'' +
				'}';
	}
}