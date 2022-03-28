package practice;

import java.time.LocalDateTime;

public class StringPractice {

	public static void main(String[] args) {
		
		
		LocalDateTime date = LocalDateTime.now();
		int day = date.getDayOfMonth();
		String tempMonth = date.getMonth().toString();
		String month= tempMonth.substring(0, 1)+ tempMonth.substring(1).toLowerCase();
		int year = date.getYear();
		String currentMonthAndYear = month+" "+year;
		
		
		
	}

}
