package practice.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashSetFrame {  // Set接口，无序且不重复， hashSet是Set的一个重要实现类
	public List<Course> selectedCourse;
	
	public HashSetFrame() {
		this.selectedCourse = new ArrayList<Course>();
	}
	
	/**
	 * 在末尾追加一个课程实例
	 *
	 * @param course
	 */
	public void addItem(Course course) {
		selectedCourse.add(course);
	}
	
	/**
	 * 查询所有所选课程
	 */
	public void showAllSelectedCourse() {
		System.out.println("以下是您所选所有课程:");
		for (Course course : selectedCourse) {  // 当然也可以使用传统的for循环
			System.out.println(course.id + ": " + course.name);
		}
	}
	
	public static void main(String[] args) {
		Course course1 = new Course("1", "计算机组成原理");
		Course course2 = new Course("2", "数据结构");
		Course course3 = new Course("3", "计算机网络技术");
		Course course4 = new Course("4", "c++高级程序设计");
		ListTest listTest  = new ListTest();
		listTest.addItem(course1);
		listTest.addItem(course2);
		listTest.addItem(course3);
		listTest.addItem(course4);
		int courseLen = 3;
		Student student1 = new Student("1", "段永洪");
		System.out.println(student1.name + ", 欢迎您来到选课系统!");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < courseLen; i++) {
			System.out.println("请输入课程id");
			String courseId = scanner.next();
			for (Course course: listTest.coursesToSelect) {
				if (course.id.equals(courseId)) {
					student1.courses.add(course);
				}
			}
		}
		student1.showAllSelectedCourse();
	}
}
