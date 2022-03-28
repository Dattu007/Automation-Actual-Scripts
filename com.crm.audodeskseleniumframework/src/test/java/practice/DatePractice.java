package practice;

import java.util.Date;

public class DatePractice {

	public static void main(String[] args) {
		Date date = new Date();
		String dateWithTime= date.toString();
		System.out.println(dateWithTime);
//		
//		String year= dateWithTime.split(" ")[5];
//		System.out.println(year);
//		String Date = dateWithTime.split(" ")[2];
//		System.out.println(Date);
//		int month = date.getMonth()+1;
//		System.out.println(month);
//		
//		String dateWithFormat = year+ "-" + month + "-" + Date;
//		
//		System.out.println(dateWithFormat);
		
//		String ldt = LocalDateTime.now().toString();
//		String date = ldt.split("T")[0];
//		System.out.println(date);
		
	}

}
