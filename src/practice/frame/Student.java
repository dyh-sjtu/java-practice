package practice.frame;

import java.util.HashSet;
import java.util.Set;

/**
 * 创建学生类
 */
public class Student implements Comparable<Student> {
	public String id;
	public String name;
	public Set<Course> courses;
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet<>();
	}
	
	public void showAllSelectedCourse() {
		System.out.println("您所有选的课程有: ");
		for(Course course: courses) {
			System.out.println(course.id + ": " + course.name);
		}
	}
	
	@Override
	public int compareTo(Student obj) {
		return Integer.compare(Integer.parseInt(this.id), Integer.parseInt(obj.id));
	}
}
