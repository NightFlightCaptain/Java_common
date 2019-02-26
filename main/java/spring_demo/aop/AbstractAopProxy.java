package spring_demo.aop;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 17:46
 */
public class AbstractAopProxy implements AopProxy {

	protected AdvisedSupport advised;

	@Override
	public Object getProxy() {
		return null;
	}
}
