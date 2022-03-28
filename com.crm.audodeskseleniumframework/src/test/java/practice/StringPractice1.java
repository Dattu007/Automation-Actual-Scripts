package practice;

import java.util.Date;

public class StringPractice1 {

	public static void main(String[] args) {
		
		
//		String date = LocalDateTime.now().toString();
//		System.out.println(date);
//		String date1 = date.replace(":", "-").replace(".", "-");
//		System.out.println(date1);
		
		Date date = new Date();
		System.out.println(date);
		String date1 = date.toString().replace(" ","-").replace(":","-");
		System.out.println(date1);
	}

}
