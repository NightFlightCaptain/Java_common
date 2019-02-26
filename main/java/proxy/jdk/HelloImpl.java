package proxy.jdk;
/**
 *
 *@author wanhaoran
 *@date 2018年4月18日 下午4:08:53
 *
 */
public class HelloImpl implements Hello{

	@Override
	public String  sayYourName(String name){
	
		System.out.println("hello hhhhhhh "+name);
		return name;
	}

	@Override
	public String tellMyName() {
		return null;
	}

	public void say() {
		System.out.println("??????????");
	}
}
