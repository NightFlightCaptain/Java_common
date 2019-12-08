package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【颜色分类】
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/8 15:12
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        int length = nums.length;
        // 下一个zero存放的地方（实际上，zeroIndex指向的永远都是1）
        int zeroIndex = 0;
        // 下一个two存放的地方
        int twoIndex = length - 1;
        int index = 0;
        while (index <= twoIndex) {
            if (nums[index] == 0) {
                swap(nums, index++, zeroIndex++);
                /* 遇到2时，需要将2移动到2该去的位置，但是index不能+1，因为那个该去的位置上的数被移动到当前位置了 */
            } else if (nums[index] == 2) {
                swap(nums, twoIndex--, index);
            } else { /* 为什么遇到1可以无视呢？因为如果遇到0或者2都会将其放到正确的位置，当0或者2都正确了，1自然也正确 */
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        LeetCode75 solution = new LeetCode75();
        solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});
        solution.sortColors(new int[]{2, 0, 2, 2, 2, 0});
        solution.sortColors(new int[]{2, 0, 1, 1, 1, 0});
        solution.sortColors(new int[]{2, 0, 1});
        solution.sortColors(new int[]{});
    }
}
