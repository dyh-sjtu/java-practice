package practice.frame;

import java.util.*;

public class SortTest {
	public static void main(String[] args) {
		SortTest sortTest = new SortTest();
		sortTest.testSortCompareTo();
	}
	
	/**
	 * 数字泛型排序
	 */
	public void testSort() {
		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			} while (list.contains(k));
			list.add(k);
			System.out.println("成功添加整数: " + k);
		}
		System.out.println("排序前元素: ");
		for (Integer item : list) {
			System.out.println("元素 " + item);
		}
		Collections.sort(list);
		System.out.println("排序后元素: ");
		for (Integer item : list) {
			System.out.println("元素 " + item);
		}
	}
	
	/**
	 * 字符串泛型排序
	 */
	public void testStringSort() {
		ArrayList<String> strList = new ArrayList<>();
		String[] str = new String[]{"dyh", "gj", "gaorui"};
		strList.addAll(Arrays.asList(str));
		System.out.println("排序前: ");
		for (String item : strList) {
			System.out.println(item);
		}
//		Collections.sort(strList);
		strList.sort(null);  // 这样写也行
		System.out.println("排序后: ");
		for (String item : strList) {
			System.out.println(item);
		}
	}
	
	public void testSortCompareTo() {
		Student student1 = new Student("4", "dyh");
		Student student2 = new Student("2", "gj");
		Student student3 = new Student("10", "gaorui");
		Student student4 = new Student("1", "liyipo");
		ArrayList<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		System.out.println("按学生ID排序前");
		for (Student item : students) {
			System.out.println("学生ID: " + item.id + ", 学生姓名: " + item.name);
		}
		students.sort(null);
		System.out.println("按学生ID排序后");
		for (Student item : students) {
			System.out.println("学生ID: " + item.id + ", 学生姓名: " + item.name);
		}
		System.out.println("按学生姓名排序前");
		for (Student item : students) {
			System.out.println("学生ID: " + item.id + ", 学生姓名: " + item.name);
		}
		students.sort(new StudentComparator());
		System.out.println("按学生姓名排序后");
		for (Student item : students) {
			System.out.println("学生ID: " + item.id + ", 学生姓名: " + item.name);
		}
	}
}
