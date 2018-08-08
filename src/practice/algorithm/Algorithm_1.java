package practice.algorithm;

import java.util.Scanner;

public class Algorithm_1 {
	/**
	 * main函数，执行主入口
	 * @param args
	 */
	public static void main(String[] args) {
		Algorithm_1 algorithm1 = new Algorithm_1();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入任意十进制数字: ");
		int num = Integer.parseInt(scanner.nextLine(), 10);
		System.out.println("输出" + num + "的补余二进制数为: " + algorithm1.findComplement(num));
	}
	
	private int findComplement(int num) {
		String binaryString = Integer.toBinaryString(num);
		String[] charArr = new String[binaryString.length()];
		for (int i = 0; i < binaryString.length(); i++) {
			charArr[i] = binaryString.charAt(i) == '0' ? "1" : "0";
		}
		return Integer.parseInt(String.join("", charArr), 2);
	}
}
