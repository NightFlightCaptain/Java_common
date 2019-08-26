package algorithm.leetcode;

/**
 * @author: 小栗旬
 * @Date: 2019/8/16 22:56
 */
public class LeetCode42 {
    /**
     * 每个柱子能装多少水由它左边最高的柱子和它右边最高的柱子共同决定
     * 遍历三次，第一次求每个柱子左边最高，第二次求右边最高，第三次求每个柱子能装多少水
     *
     * @param nums
     * @return
     */
    private int trap(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return 0;
        }
        int[] leftMaxHeight = new int[length];
        int[] rightMaxHeight = new int[length];
        int maxHeight = 0;
        for (int i = 0; i < length - 1; i++) {
            maxHeight = Math.max(nums[i], maxHeight);
            leftMaxHeight[i + 1] = maxHeight;
        }
        maxHeight = 0;
        for (int i = length - 1; i > 0; i--) {
            maxHeight = Math.max(nums[i], maxHeight);
            rightMaxHeight[i - 1] = maxHeight;
        }
        int total = 0;
        for (int i = 1; i < length - 1; i++) {
            int minHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (nums[i] < minHeight) {
                total += minHeight - nums[i];
            }
        }
        return total;
    }

    /**
     * 左右两个指针，左边最高柱，右边最高柱，实际上是4个指针。
     *
     * 在第一种方法中，我们需要两次遍历，每一种遍历当中，每一次的迭代都只能确定一个位置的左最高或者右最高。
     * 如果我们确定了一个位置的左最高值，并且左最高值要小于右边的某一值（只要有一个比左最高值高就行了），我们就可以确定当前位置的蓄水量。
     * 如果左最高值小于右边的一个值，我们就可以从右边入手，找到右边这个点的右最高值，并且此时的右最高值一定是小于左边某一值的
     *
     * @param nums
     * @return
     */
    private int trap2(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return 0;
        }
        int total = 0;
        int left = 0, right = length - 1;
        int leftMaxHeight = 0, rightMaxHeight = 0;
        while (left < right) {
            if (nums[left] > leftMaxHeight) {
                leftMaxHeight = nums[left];
            }
            if (nums[right] > rightMaxHeight) {
                rightMaxHeight = nums[right];
            }
            if (leftMaxHeight<=rightMaxHeight){
                total += leftMaxHeight-nums[left];
                left++;
            }else {
                total += rightMaxHeight - nums[right];
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        LeetCode42 solution = new LeetCode42();
        System.out.println(solution.trap2(a));
    }
}
