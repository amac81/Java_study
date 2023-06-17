import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
				
		/* ISO 8601 standard
		 * 
		 * Local Date/Hour
		 * Examples:
		 * 	
		 * 2023-07-17
		 * 2023-07-17T17:21
		 * 2023-07-17T17:21:33
		 * 2023-07-17T17:21:40.2233
		 * 
		 * -------------------------------- 
		 * Global Date/Hour
		 * Examples:
		 * 
		 * 2023-07-17T17:21:33Z
		 * 2023-07-17T17:21:33.254856Z
		 * 2023-07-17T17:21:33-01:00
		 * 
		 * */
		
		//DateTimeFormatter
		//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		
		DateTimeFormatter dataFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dataFormat2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter dataFormat3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault()); //format using system default format
		DateTimeFormatter dataFormat4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter dataFormat5 = DateTimeFormatter.ISO_INSTANT;
		
		//INSTANTIATION EXAMPLES:
		
		LocalDate date1 = LocalDate.now();
		LocalDateTime date2 = LocalDateTime.now();
		
		//Global date/hour GMT (Z - Zulu time)	
		Instant date3 = Instant.now();
		LocalDate date4 = LocalDate.parse("2023-07-20");
		LocalDateTime date5 = LocalDateTime.parse("2023-07-20T01:23:33");
		Instant date6 = Instant.parse("2023-07-20T04:23:13Z");
		Instant date7 = Instant.parse("2023-07-20T22:23:13-01:00"); //specifying a different time zone
		LocalDate date8 = LocalDate.parse("21/07/2023", dataFormat1);
		LocalDateTime date9 = LocalDateTime.parse("21/07/2023 12:33:23", dataFormat2);
		LocalDate date10 = LocalDate.of(2023, 10, 20);
		LocalDateTime date11 = LocalDateTime.of(2023, 02, 12, 23, 10, 34);
		
		
		System.out.println("Data1 = " + date1.toString()); //.toString() optional, outputs data "text" according to ISO 8601 standard
		System.out.println("Data2 = " + date2);
		System.out.println("Data3 = " + date3);
		System.out.println("Data4 = " + date4);
		System.out.println("Data5 = " + date5);
		System.out.println("Data6 = " + date6);
		System.out.println("Data7 = " + date7);
		System.out.println("Data8 = " + date8);
		System.out.println("Data9 = " + date9);
		System.out.println("Data10 = " + date10);
		System.out.println("Data11 = " + date11);
		
		//FORMAT OUTPUT
		System.out.println("Data10 (dd/MM/yyyy) = " + date10.format(dataFormat1));
		//we can do this too:
		System.out.println("Data10 (dd/MM/yyyy) = " + dataFormat1.format(date10)); 
		System.out.println("Data10 (dd/MM/yyyy) = " + date10.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); 
		//-------------------------
		
		System.out.println("Data11 (dd/MM/yyyy HH:mm:ss) = " + date11.format(dataFormat2));
		System.out.println("Data5 (dd/MM/yyyy HH:mm:ss) = " + date5.format(dataFormat2));
		
		
		//date6.format(dataFormat3) don't work!! The method format(DateTimeFormatter) is undefined for the type Instant
		System.out.println("Data6 (dd/MM/yyyy HH:mm:ss) = " + dataFormat3.format(date6));
		
		System.out.println("Data5 (with DateTimeFormatter.ISO_DATE_TIME) = " + date5.format(dataFormat4));
		System.out.println("Data3 (with DateTimeFormatter.ISO_INSTANT) = " + dataFormat5.format(date3));
		System.out.println("Data3 = " + date3.toString());
		
		//CONVERT GLOBAL DATE/HOUR TO LOCAL
		
		//print all available Zones id's
		//for (String zone : ZoneId.getAvailableZoneIds()) {
		//  System.out.println(zone);
		//} 
		
		LocalDate resultDate1 = LocalDate.ofInstant(date7, ZoneId.systemDefault());
		LocalDate resultDate2 = LocalDate.ofInstant(date7, ZoneId.of("Egypt"));
		LocalDateTime resultDate3 = LocalDateTime.ofInstant(date7, ZoneId.of("America/Manaus"));

		System.out.println();
		
		System.out.println("date7 (INSTANT / GLOBAL DATE HOUR) = " + date7);
		System.out.println("ResultDate1 (LocalDate conversion from date7 - systemDefault ) = " + resultDate1);
		System.out.println("ResultDate2 (LocalDate conversion from date7 - Egypt) = " + resultDate2);
		System.out.println("ResultDate3 (LocalDateTime conversion from date7 - America/Manaus) = " + resultDate3);
		
		//get separated elements from Date
		System.out.println();
		System.out.println("date4 = " + date4);
		System.out.println("DayOfWeek of date 4 = " + date4.getDayOfWeek());
		System.out.println("MonthValue of date 4 = " + date4.getMonthValue());
		System.out.println("Year of date 4 = " + date4.getYear());
		
		//calculations with dates
		System.out.println();
		System.out.println("date4 = " + date4);
		
		//Date4 in 7 days
		LocalDate nextWeekLocalDate = date4.plusDays(7);
		System.out.println("nextWeekLocalDate of date4 = " + nextWeekLocalDate);
		
		//Date4 2 days ago
		LocalDate minusDaysLocalDate = date4.minusDays(4);
		System.out.println("pastWeekLocalDate of date4 = " + minusDaysLocalDate);
		
		System.out.println();
		
		System.out.println("date5 = " + date5);
		
		//Date5 4days ago
		LocalDateTime minusDaysLocalDateTime = date5.minusDays(4);
		//Date5 in 2 years
		LocalDateTime plusYearsLocalDateTime = date5.plusYears(2);
		System.out.println("minusDaysLocalDateTime of date5 = " + minusDaysLocalDateTime);
		System.out.println("plusYearsLocalDateTime of date5 = " + plusYearsLocalDateTime);
		
		System.out.println();
		
		System.out.println("date3 = " + date3);
		//Date3 7 days ago
		Instant pastWeekInstant = date3.minus(7, ChronoUnit.DAYS);
		System.out.println("pastWeekInstant of date3 = " + pastWeekInstant);
		
		//DURATION
		System.out.println();
		Duration t1 = Duration.between(date4.atStartOfDay(), nextWeekLocalDate.atStartOfDay()); //atStartOfDay() needed because date4 and nextWeekLocalDate are LocalDate
		Duration t2 = Duration.between(minusDaysLocalDateTime, date5);
		Duration t3 = Duration.between(date3, pastWeekInstant);
		
		System.out.println("t1 = " + t1.toDays());
		System.out.println("t2 = " + t2.toDays());
		System.out.println("t3 = " + t3.toDays());

	}
}
