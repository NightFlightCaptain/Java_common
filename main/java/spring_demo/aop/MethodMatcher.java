package spring_demo.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {
	Boolean matchers(Method method,Class beanClass);
}
