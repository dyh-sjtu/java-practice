package file.practice;

import java.io.*;

public class FilePractice {
	public static String filePath = "assets/css/dyh.txt";
	
	public static void main(String[] args) {
		FilePractice filePractice = new FilePractice();
		filePractice.writeFile(filePath, "dyh love gj all day all world!");
		filePractice.readFileByLine(filePath);
		filePractice.readFile(filePath);
	}
	
	/**
	 * 写入文件内容
	 * @param filePath 文件路径
	 * @param fileContent 追加内容
	 */
	public void writeFile(String filePath, String fileContent) {
		try {
			File file = new File(filePath);  // 首先创建文件
			if (!file.exists()) {
				file.createNewFile();  // 文件不存在时才创建
				System.out.println("文件创建");
			}
			FileOutputStream output = new FileOutputStream(file, true);  // 实例化文件输出流
			OutputStreamWriter is = new OutputStreamWriter(output);  // 实例化输出流输出器writer  new FileWriter(file) 也行
			Writer myWriter = new BufferedWriter(is);  // 实例化输出流缓冲区，性能比较好，当然可以不使用也行
			myWriter.write(fileContent + "\n");
			myWriter.write("我爱你，高瑾! 么么哒😘");
			System.out.println("文件更新");
			myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取文件内容
	 * @param filePath 文件路径
	 */
	public void readFile(String filePath) {
		File file = new File(filePath);
		try{
			Reader myReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int tempChar;
			while((tempChar = myReader.read()) != -1) {
				if (((char) tempChar) != '\r') {
					System.out.println((char)tempChar);
				}
			}
		}catch(Exception e) {
			System.out.println("出错啦: " + e);
		}
	}
	
	public void readFileByLine(String filePath) {
		File file = new File(filePath);
		try {
			BufferedReader myReader = new BufferedReader(new FileReader(file));
			String tempString;
			int line = 1;
			while ((tempString = myReader.readLine()) != null) {
				System.out.println("第" + line + "行" +  ":" +tempString);
				line++;
			}
		}catch(Exception e) {
			System.out.println("出错啦: " + e);
		}
	}
}
