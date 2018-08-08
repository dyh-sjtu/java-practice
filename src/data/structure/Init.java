package data.structure;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class Init{
	public static void main(String[] args) throws ParseException{
		System.out.println(Double.hashCode(1.2));
		ArrayList<Integer> test = new ArrayList<>(100);
		test.add(2);
		System.out.println(test.size());
		String str = "110";
		System.out.println(Integer.parseInt(str, 8));
		System.out.println(Integer.valueOf(str, 2));
		try {
			System.out.println(NumberFormat.getNumberInstance().parse(str));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		int num = 72;
		System.out.println(Integer.toString(num, 8));
	}
	
}
