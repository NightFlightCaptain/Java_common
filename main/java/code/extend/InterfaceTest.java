package code.extend;

public interface InterfaceTest {
	default void defaultMethod(){

	}

	void normalMethod();
	//默认是final
	int a = 0;
}
