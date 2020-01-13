package algorithm.leetcode.todo;

/**
 * 【寻找两个有序数组的中位数】
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/11/28 13:01
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2,nums1);
        }

        int lmax1 = 0, lmax2 = 0, rmin1 = 0, rmin2 = 0;
        int cut1, cut2;
        int lo = 0, hi = 2 * m;
        while (lo <= hi) {
            cut1 = (lo + hi) / 2;
            cut2 = m + n - cut1;

            lmax1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[(cut1 - 1) / 2];
            rmin1 = cut1 == m * 2 ? Integer.MAX_VALUE : nums1[cut1 / 2];

            lmax2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[(cut2 - 1) / 2];
            rmin2 = cut2 == n * 2 ? Integer.MAX_VALUE : nums2[cut2 / 2];

            if (lmax1 > rmin2) {
                hi = cut1 - 1;
            } else if (lmax2 > rmin1) {
                lo = cut1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(lmax1, lmax2) + Math.min(rmin1, rmin2)) / 2.0;
    }

    public static void main(String[] args) {
        LeetCode4 solution = new LeetCode4();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
