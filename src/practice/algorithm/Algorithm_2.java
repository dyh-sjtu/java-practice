package practice.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithm_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串: ");
		String s = scanner.nextLine();
		Algorithm_2 algorithm2 = new Algorithm_2();
		System.out.println("输出所有字符串数组: " + algorithm2.letterCasePermutation(s));
	}
	
	
	/**
	 * 将字符串中字母转化为大小写
	 *
	 * @param s string
	 *
	 * @return String[]
	 */
	public List<String> letterCasePermutation(String s) {
		List<String> list = new ArrayList<>();
		dfs(list, s, "");
		return list;
	}
	
	public void dfs(List<String> list, String s, String subString) {
		if (subString.length() == s.length()) {
			list.add(subString);
			return;
		}
		char ch = Character.toLowerCase(s.charAt(subString.length()));
		if (ch >= 'a' && ch <= 'z') {
			dfs(list, s, subString + Character.toUpperCase(ch));
		}
		dfs(list, s, subString + ch);
	}
}
