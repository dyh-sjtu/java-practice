package practice.algorithm;

import java.util.Scanner;

public class Algorithm_3 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
		System.out.println("请输入num1: ");
		String num1 = scanner.nextLine();
		System.out.println("请输入num2: ");
		String num2 = scanner.nextLine();
		Algorithm_3 algorithm3 = new Algorithm_3();
		System.out.println("大数相加和:" + algorithm3.addStrings(num1, num2));
	}
	
	public String addStrings(String num1, String num2) {
		char[] num1Arr = new StringBuilder(num1).reverse().toString().toCharArray();
		char[] num2Arr = new StringBuilder(num2).reverse().toString().toCharArray();
		int len1 = num1.length();
		int len2 = num2.length();
		int maxLen = len1 > len2 ? len1 : len2;
		int[] res = new int[maxLen + 1];
		for (int i = 0; i < maxLen + 1; i++) {
			int int1 = i < len1 ? (num1Arr[i] - '0') : 0;
			int int2 = i < len2 ? (num2Arr[i] - '0') : 0;
			res[i] = int1 + int2;
		}
		for (int j = 0; j < res.length; j++) {
			if (res[j] >= 10) {
				res[j] = res[j]%10;
				res[j+1] += 1;
			}
		}
		StringBuffer str = new StringBuffer();
		for (int k = 0; k < maxLen + 1; k++) {
			if (k == maxLen && res[k] == 0) {
				break;
			}
			str.append(res[k]);
		}
		return new StringBuilder(String.join("", str)).reverse().toString();
	}
}
