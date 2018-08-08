package practice.frame;

public class Start {
	public static void main(String[] args) {
		Course course1 = new Course("1", "计算机组成原理");
		Course course2 = new Course("2", "数据结构");
		Course course3 = new Course("3", "计算机网络技术");
		Course course4 = new Course("6", "c++高级程序设计");
		ListTest listTest  = new ListTest();
		listTest.addItem(course1);
		listTest.addItem(course2);
		listTest.addItem(course3);
		listTest.addItem(course3);  // 说明List可以重复子元素
		Course[] courses = new Course[]{new Course("4", "高等数学"), new Course("5", "大学英语")};
		listTest.addAllItem(courses);
		listTest.addItem(2, course4);
		listTest.showAllSelectedCourse();
		listTest.showWithIterable();
		System.out.println();
		for(Course course: listTest.modifyItem(4, new Course("7", "java核心技术卷"))) {
			System.out.println(course.id + ": " + course.name);
		}
		listTest.deleteCourseItem(6);
	}
}
