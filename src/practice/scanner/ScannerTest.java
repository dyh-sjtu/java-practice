package practice.scanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScannerTest{
	public static void main(String[] args) throws IOException {
//		String relativePath = System.getProperty("user.dir"); // 读取当前文件相对路径
		String path = "assets/css/dyh.css";
		PrintWriter printWriter = new PrintWriter(path, "UTF-8");
		printWriter.write("高瑾，我爱你！\n");
		printWriter.write("很爱很爱你~");
		printWriter.flush();
		printWriter.close();
		try {
			Scanner in = new Scanner(Paths.get(path), "UTF-8");
			while (in.hasNext()) {
				System.out.println(in.nextLine());
			}
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取出错了");
		}
	}
}
