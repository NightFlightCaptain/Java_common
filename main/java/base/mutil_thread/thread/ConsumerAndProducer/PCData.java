package base.mutil_thread.thread.ConsumerAndProducer;

/**
 * Author: 小栗旬
 * Date: 2019/1/13 22:01
 */
public class PCData {
	private final int intData;

	public PCData(int intData) {
		this.intData = intData;
	}

	public int getIntData() {
		return intData;
	}

	@Override
	public String toString() {
		return "PCData{" +
				"intData=" + intData +
				'}';
	}
}
