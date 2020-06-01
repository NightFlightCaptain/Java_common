package base.code.random;

import java.util.Random;

/**
 * Author: 小栗旬
 * Date: 2019/2/22 15:11
 */
public class RandomString {

	public static void main(String[] args) {
		RandomString randomString = new RandomString(10);
		System.out.println(randomString.nextString());
	}
	private static final char[] symbols;

	static {
		StringBuilder stringBuilder = new StringBuilder();
		for (char i = '0'; i <= '9'; i++) {
			stringBuilder.append(i);
		}
		for (char i = 'a'; i <= 'z'; i++) {
			stringBuilder.append(i);
		}
		symbols = stringBuilder.toString().toCharArray();
	}

	Random random = new Random();

	private final char[] buf;

	public RandomString(int length) {
		if (length < 1) {
			throw new IllegalArgumentException("length < 1: " + length);
		}
		buf = new char[length];
	}

	public String nextString() {
		for (int i = 0; i < buf.length; i++) {
			buf[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}
}
