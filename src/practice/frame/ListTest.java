package practice.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 */
public class ListTest {
	/**
	 * 用于存放备选课程的List
	 */
	public List<Course> coursesToSelect;  // 泛型可以避免强类型转换的麻烦
//	public List<int> CourseId; // 泛型的类型只能为引用类型，对于基本类型数据，需要使用其对应的包装类
//	public List<Integer> CourseId;  // It'is ok
	public ListTest() {
		this.coursesToSelect = new ArrayList<Course>();
	}
	
	/**
	 * 在末尾追加一个课程实例
	 * @param course
	 */
	public void addItem(Course course) {
		coursesToSelect.add(course);
		int index = coursesToSelect.indexOf(course);
		try{
			Course item = coursesToSelect.get(index);
			System.out.println("添加了一个课程实例"+ item.id + ": " + item.name);
		}catch (IndexOutOfBoundsException e1) {
			e1.printStackTrace();
			System.out.println("数组下标越界异常");
		}catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	/**
	 * 往指定位置添加课程实例
	 * @param index
	 * @param course
	 */
	public void addItem(int index, Course course) {
		coursesToSelect.add(index, course);
		System.out.println("课程实例" + course.id + ": " + course.name + "成功插入了List第" + index + "个位置");
	}
	
	/**
	 * 添加多个课程实例
	 * @param courses
	 * @return
	 */
	public int addAllItem(Course[] courses) {
		coursesToSelect.addAll(Arrays.asList(courses));
		for(Course course: courses) {
			System.out.println("addAll方法添加了课程实例" + course.id + ": " + course.name);
		}
		return coursesToSelect.size();
	}
	
	/**
	 * 查询所有所选课程
	 */
	public void showAllSelectedCourse() {
		System.out.println("以下是您所选所有课程:");
		for (Course course: coursesToSelect) {  // 当然也可以使用传统的for循环
			System.out.println(course.id + ": " + course.name);
		}
	}
	
	/**
	 * 通过迭代器来遍历元素
	 */
	public void showWithIterable() {
		Iterator iterator = coursesToSelect.iterator();
		System.out.println("通过迭代器访问全部的课程实例: ");
		while (iterator.hasNext()) {
			Course course = (Course)iterator.next();
			System.out.println(course.id + ": " + course.name);
		}
	}
	
	/**
	 * 修改指定位置课程实例
	 * @param index
	 */
	public Course[] modifyItem(int index, Course course) {
		coursesToSelect.set(index, course);
		Course[] courses = new Course[coursesToSelect.size()];
		return coursesToSelect.toArray(courses);
	}
	
	public void deleteCourseItem(int index) {
		coursesToSelect.remove(index);
		// remove(Course course) 删除对象相等的课程实例
		// removeAll(List<Course> c) 删除一组List
		System.out.println("删除了第" + index + "个课程实例");
	}
	
}
