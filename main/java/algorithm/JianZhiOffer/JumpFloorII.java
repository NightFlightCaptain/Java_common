package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/19 18:09
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
	public int JumpFloorII(int target) {
		/*

		 逻辑解法
		if(target<=1){
			return target;
		}
		int count =0;
		for (int i = 1;i<target;i++){
			count += JumpFloorII(i);
		}
		return count+1;
		*/


		/* 数学解法
		* f(n)=f(n-1)+f(n-2)+...+f(1)
		因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
		所以f(n)=2*f(n-1) */
		if (target<=1){
			return target;
		}
		return 2*JumpFloorII(target-1);
	}

	public static void main(String[] args) {
		JumpFloorII solution = new JumpFloorII();
		System.out.println(solution.JumpFloorII(5));
	}
}
