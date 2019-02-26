package spring_demo.aop;

public interface ClassFilter {
	Boolean matchers(Class beanClass) throws Exception;
}
