package practice.console;

import java.io.Console;

public class ConsoleTest {
	/**
	 * 在控制台输入密码示例
	 */
	public void passwordExample() {
		
		Console console = System.console();
		
		/**
		 * 需要从未重定向的原生terminal中运行程序才行
		 * javac practice.console.ConsoleTest.java
		 * java practice.console.ConsoleTest
		 */
		if (console == null) {
			System.out.println("Couldn't get Console instance, maybe you're running this from within an IDE?");
			System.exit(0);
		}
		
		console.printf("Testing password%n");
		char passwordArray[] = console.readPassword("Enter your secret password: ");
		console.printf("Password entered was: %s%n", new String(passwordArray));
		
	}
	
	/**
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		new ConsoleTest().passwordExample();
	}
}
