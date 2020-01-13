package algorithm.leetcode;

/**
 * 【搜索旋转排序数组】
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/3 18:28
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        return normalSolution(nums,target);
    }

    /**
     * 还有一种真值表的解法，见连接吧
     * @param nums
     * @param target
     * @return
     */
    private int normalSolution(int[] nums,int target){
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else  {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }



    public static void main(String[] args) {
        LeetCode33 solution = new LeetCode33();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8));
        System.out.println("------");
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 0));
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 1));
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 2));
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 3));
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 4));
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 5));
        System.out.println(solution.search(new int[]{5, 6, 0, 1, 2, 3, 4}, 6));

        System.out.println("------");
        System.out.println(solution.search(new int[]{4, 5, 6, -1, 0, 1, 2}, 4));
        System.out.println("------");
        System.out.println(solution.search(new int[]{3, 1}, 1));
    }
}
