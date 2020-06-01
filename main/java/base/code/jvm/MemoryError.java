package base.code.jvm;

/**
 * Author: 小栗旬
 * Date: 2019/2/22 16:55
 */
public class MemoryError {
	static class StackD{
		private String[] strings;
		private int size;
		public StackD(int length){
			strings = new String[length];
			size =0;
		}

		public void push(String s){
			strings[size] = s;
			size++;
		}

		public String pop(){
			return strings[--size];
		}
	}

	public static void main(String[] args) {
		StackD stackD = new StackD(10);
		stackD.push("a");
		stackD.push("v");
		System.out.println(stackD.pop());
		System.out.println(stackD.pop());
		stackD.push("ccc");
		System.out.println(stackD.pop());
	}
}
