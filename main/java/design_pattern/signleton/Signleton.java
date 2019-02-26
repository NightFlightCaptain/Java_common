package design_pattern.signleton;

/**
 *
 *@author wanhaoran
 *@date 2018年4月25日 下午5:38:27
 *
 */
public class Signleton {

//	volatile的必要性：JVM是有可能回发生指令重排的
//	signleton = new Signleton("");
//	这句话是分为3步进行的：
//	1.为signleton分配内存
//	2.初始化signleton
//	3.将signleton指向内存部分
//	由于指令重排可能导致发生的顺序为1->3->2,在这样的情况下,如果一个线程执行了1,3;
//  另外一个现场在第一次判断时发现signleton不为null,就会返回一个未初始化的signleton
	private volatile static Signleton signleton;
	private Signleton(String name) {

	}

	int i=1;
	public void someMethod(){
		System.out.println(i++);
	}
	public static Signleton getUniqueInstance(){
		if (signleton == null){
			synchronized (Signleton.class){
				if (signleton == null){
					signleton = new Signleton("wan");
				}
			}
		}
		return signleton;
	}

	public static Signleton getInstance() {
		if (signleton == null) {
			System.out.println(Thread.currentThread() + "此时还没有获取到signleton");
			synchronized (Signleton.class) {
				if (signleton == null) {
					signleton = new Signleton(new String());
				}
			}
		}else{
			System.out.println(Thread.currentThread() + "此时已经获取到signleton");
		}
//		System.out.println(signleton+" "+signleton.getName());
		return signleton;
	}
	
	public static void main(String[] args) {
		for(int i =1;i<=100;i++){
			new Thread(
					()->{
						Signleton signleton = Signleton.getInstance();
						signleton.someMethod();
					}
			).start();

		}
	}
}
