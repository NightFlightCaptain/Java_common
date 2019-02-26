package proxy.jdk;
/**
 *
 *@author wanhaoran
 *@date 2018年4月18日 下午4:07:11
 *
 */
public interface Hello {

	public default String sayYourName(String name) {
		return name;
	}

	public String tellMyName();
}
