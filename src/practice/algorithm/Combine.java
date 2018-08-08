package practice.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Combine {
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,6,9};
		String[] strs = new String[nums.length];
		for (int i = 0, len = nums.length; i < len; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Combine combine = new Combine();
		combine.combine(strs);
	}
	
	public void combine(String[] strs) {
		ArrayList<String> res = new ArrayList<>();
		while (strs.length > 0) {
			int index = 0;
			while(index++ < strs.length) {
				String[] pre = Arrays.copyOfRange(strs, 0, index);  // System.arraycopy()方法也可以使用
				// arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
//				String[] next = Arrays.copyOfRange(strs, index, strs.length);
				String[] next = new String[strs.length - pre.length];
				System.arraycopy(strs, index, next, 0,  strs.length - pre.length);
				String preStr = String.join("-", pre);
				for (String str : next) {
					res.add(preStr +"-" + str);
				}
			}
			strs = Arrays.copyOfRange(strs, 1, strs.length);
		}
		System.out.println(res.toString());
	}
}
