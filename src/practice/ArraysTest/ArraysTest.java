package practice.ArraysTest;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};
		// 复制数组，返回一个新的数组
		int[] numsCopy = Arrays.copyOf(nums, 2*nums.length);
		int[] numsPartCopy = Arrays.copyOfRange(nums, 2, nums.length-1);
		System.out.println(Arrays.toString(numsPartCopy));
		/**
		 * 打印数组
		 * deepToString 用于打印二维数组
		 * deepEquals 用于比较两个二维数组是否完全相等
		 */
		System.out.println(Arrays.toString(numsCopy));
		/**
		 * 比较数组成员是否完全相等
		 */
		System.out.println(Arrays.equals(numsCopy, new int[]{1,2,3,4,5,0,0,0,0,0}));
		// 数组内查找
		System.out.println(Arrays.binarySearch(numsCopy, 1,5,3));
		// 填充数组
		Arrays.fill(numsCopy, 1);
		// 打印数组
		System.out.println(Arrays.toString(numsCopy));
	}
}
