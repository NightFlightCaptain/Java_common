package spring_demo.aop;

public interface PointcutAdvisor extends Advisor {

	PointCut getPointCut();
}
