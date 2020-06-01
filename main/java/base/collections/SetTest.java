package base.collections;

/**
 * Author: 小栗旬
 * Date: 2018/12/28 17:03
 */
public class SetTest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SetTest(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.substring(0, 1).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		SetTest s;
		if (obj instanceof SetTest && (s = (SetTest) obj).name.length() >= 1) {
			return name.substring(0, 1).equals(s.name.substring(0, 1));
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "SetTest{" +
				"name='" + name + '\'' +
				'}';
	}
}
