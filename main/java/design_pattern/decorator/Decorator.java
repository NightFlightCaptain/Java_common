package design_pattern.decorator;

/**
 *
 * @author wanhaoran
 * @date 2018年5月15日 上午11:18:55
 *
 */

interface Coffee {
	void coffee();
}

class CoffeeImpl implements Coffee {
	@Override
	public void coffee() {
		System.out.println("黑咖啡");
	}
}

class CoffeeWrapper implements Coffee{
	private Coffee coffee;
	public CoffeeWrapper(Coffee coffee) {
		this.coffee = coffee;
	}
	public void coffee() {
		coffee.coffee();
	}
}

class SugerCoffee extends CoffeeWrapper{
	public SugerCoffee(Coffee coffee) {
		super(coffee);
	}
	public void coffee() {
		super.coffee();
		System.out.println("加糖");
	}
}
class MilkCoffee extends CoffeeWrapper{
	public MilkCoffee(Coffee coffee) {
		super(coffee);
	}
	public void coffee() {
		super.coffee();
		System.out.println("加牛奶");
	}
}
public class Decorator {
	public static void main(String[] args) {
		Coffee coffee = new CoffeeImpl();
		Coffee suger = new SugerCoffee(coffee);
		Coffee milk = new MilkCoffee(suger);
		milk.coffee();
	}
}
