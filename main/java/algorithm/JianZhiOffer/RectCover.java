package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/20 9:56
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
	public int RectCover(int target) {
		if(target<3){
			return target;
		}
		return RectCover(target-1)+RectCover(target-2);
	}

	public static void main(String[] args) {
		RectCover solution = new RectCover();
		System.out.println(solution.RectCover(3));
	}
}
