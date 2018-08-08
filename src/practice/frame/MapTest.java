package practice.frame;

import java.util.*;

public class MapTest {
	public int stdLen = 3;
	public Map<String, Student> students;
	
	public MapTest() {
		this.students = new HashMap<>();
	}
	
	/**
	 * 测试添加： 输入学生ID， 判断是否被占用
	 * 若未被占用，则输入姓名，创建新学生对象，并且添加到students中
	 */
	public void testPut() {
		Scanner console = new Scanner(System.in);
		int i = 0;
		while (i < stdLen) {
			System.out.println("请输入学生ID");
			String stdId = console.next();
			Student st = students.get(stdId);
			if (st == null) {
				System.out.println("请输入学生姓名");
				String name = console.next();
				Student newStudent = new Student(stdId, name);
				students.put(stdId, newStudent);
				System.out.println("成功添加学生" + students.get(stdId).name);
				i++;
			} else {
				System.out.println("该学生ID已被占用");
				continue;
			}
		}
	}
	
	/**
	 * 测试Map的keySet方法, 返回所有键的集合
	 */
	public void testKeySet() {
		Set<String> keySet = students.keySet();
		for (String key : keySet) {
			System.out.println("学生中的键为ID: " + key);
		}
	}
	
	/**
	 * 测试Map的values方法
	 */
	public void testValues() {
		Collection<Student> valuesCollection = students.values();
		for (Student value : valuesCollection) {
			System.out.println("学生中的键为ID: " + value.id + "; 学生的值为姓名" + value.name);
		}
	}
	
	/**
	 * 测试Map中的entries方法
	 */
	public void testEntries() {
		Set<Map.Entry<String, Student>> entrySet = students.entrySet();
		for (Map.Entry<String, Student> entry : entrySet) {
			System.out.println("学生中的键为ID: " + entry.getKey() + "; 学生的值为姓名" + entry.getValue().name);
		}
	}
	
	/**
	 * 测试Map中的删除方法
	 */
	public void testRemove() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入要删除的学生ID: ");
			String ID = scanner.next();
			// 判断是否有该学生
			Student std = students.get(ID); // 获得该key ID对应的值
			if (std == null) {
				System.out.println("该ID不存在");
				continue;
			}
			students.remove(ID);
			System.out.println("成功删除学生" + std.name);
			break;
		}
	}
	
	/**
	 * 利用Map中的put方法修改已有映射
	 */
	
	public void testModify() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入要修改的学生ID: ");
			String stdId = scanner.next();
			Student student = students.get(stdId);
			if (student == null) {
				System.out.println("输入的学生ID: " + stdId + "不存在，请重新输入！");
				continue;
			}
			System.out.println("您输入的学生ID: " + stdId + ", 对应的学生名称为: " + student.name);
			System.out.println("请输入您要修改后的学生名称: ");
			String newName = scanner.next();
			students.put(stdId, new Student(stdId, newName));
			System.out.println("修改成功！");
			break;
		}
	}
	
	public void testContainKey() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查找的学生ID: ");
		String stdId = scanner.next();
		if(students.containsKey(stdId)) {
			System.out.println("学生中已有ID");
		}else {
			System.out.println("学生中不含该学生ID");
		}
	}
	
	public void testContainValue() {  // 调用元素的equals方法，
		// Student类的实例作为value值，先比较的是hashCode值是否相等，
		// 然后再比较内存地址是否相等，要想比较真实值是否存在，需要重写equals方法
		// 可以自定义equals方法
		Scanner scanner = new Scanner(System.in);
		Student student = new Student("1", "段永洪");
		if (students.containsValue(student)) {
			System.out.println("含有学生" + student.name);
		}else {
			System.out.println("不含有该学生！");
		}
	}
	
	
	public static void main(String[] args) {
		MapTest mapTest = new MapTest();
		mapTest.testPut();
		mapTest.testContainKey();
		mapTest.testContainValue();
//		mapTest.testKeySet();
//		mapTest.testValues();
//		mapTest.testEntries();
//		mapTest.testRemove();
//		mapTest.testEntries();
//		mapTest.testModify();
//		mapTest.testEntries();
	}
}
