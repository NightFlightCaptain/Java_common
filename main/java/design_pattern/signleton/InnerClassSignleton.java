package design_pattern.signleton;

/**
 * Author: 小栗旬
 * Date: 2019/2/22 15:22
 */
public class InnerClassSignleton {
	private static class InnerClassSignle {
		private static final InnerClassSignleton innerClassSignleton= new InnerClassSignleton();
	}

	private InnerClassSignleton(){}

	public InnerClassSignleton getInnerClassSignleton() {
		return InnerClassSignle.innerClassSignleton;
	}
}
