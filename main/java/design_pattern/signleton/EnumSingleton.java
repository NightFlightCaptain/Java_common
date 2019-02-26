package design_pattern.signleton;

public enum EnumSingleton {
	UNIQUESINGLETON;

	int i = 0;


	public void someMethod() {
		System.out.println(i++);
	}


	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					EnumSingleton enumSingleton = EnumSingleton.UNIQUESINGLETON;
//					enumSingleton.someMethod();
//
//				}
//			}).start();

			new Thread(
					()->{
						EnumSingleton enumSingleton = EnumSingleton.UNIQUESINGLETON;
						enumSingleton.someMethod();
					}
			).start();
		}
	}

}
