package com.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("现在的时间是: " + date);
		System.out.println("现在距离1970年1月1日00：00：00已经 " + date.getTime() + " 毫秒");
		String dateStr = "2018年2月14日 13时20分59秒";
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf1.format(date));
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			System.out.println(sdf2.parse(dateStr));
			System.out.println(calendar.getTime());
			System.out.println(sdf2.format(calendar.getTime()));
			System.out.println(sdf2.format(calendar.getTimeInMillis()));
			System.out.println(calendar.get(Calendar.YEAR));
			System.out.println(calendar.get(Calendar.MONTH) + 1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		LocalDate localDate =LocalDate.now();
		System.out.println(localDate.getYear());
		System.out.println(localDate.getMonthValue());
		System.out.println(localDate.getDayOfMonth());
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate.getDayOfWeek().getValue());
		System.out.println(localDate.getDayOfYear());
		
	}
}
