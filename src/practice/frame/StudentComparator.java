package practice.frame;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student obj1, Student obj2) {
		// 按照student的name值进行比较
		return obj1.name.compareTo(obj2.name);
	}
}
