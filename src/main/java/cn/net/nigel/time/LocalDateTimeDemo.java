package cn.net.nigel.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("Month: " + month + ", day: " + day + ", seconds: " + seconds);
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        ZonedDateTime date6 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date6);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);

        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);

        LocalDate date7 = LocalDate.now();
        System.out.println("Current date: " + date7);
        LocalDate nextTuesday = date7.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on : " + nextTuesday);
        LocalDate firstInYear = LocalDate.of(date7.getYear(), date7.getMonth(), 1);
        LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                .with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Second saturday on : " + secondSaturday);

        LocalDate date8 = LocalDate.now();
        System.out.println("Current date: " + date8);
        LocalDate date9 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + date9);
        Period period = Period.between(date9, date8);
        System.out.println("Period: " + period);
        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(2);
        LocalTime time2 = time1.plus(twoHours);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);
    }
}
