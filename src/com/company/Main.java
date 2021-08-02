package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // TASK 1 is this a palindrome?

        Scanner scan = new Scanner(System.in);
        System.out.print("Please type a word or sentence to check if it's a palindrome: ");
        String checkForPalindrome = scan.nextLine();

        // convert to lower cases
        String stringLowerCase = checkForPalindrome.toLowerCase();


        // remove all spaces and special characters
        String stringNoSpaces = stringLowerCase.replaceAll("\\W", "");


        // reverse the string
        String reversedString = new StringBuffer(stringNoSpaces).reverse().toString();


        // compare the reversed string with the original
        if (reversedString.equals(stringNoSpaces)) {
            System.out.println(String.format("The word or sentence '%s' is a palindrome.", checkForPalindrome));
        } else {
            System.out.println(String.format("The word or sentence '%s' is not a palindrome.", checkForPalindrome));
        }
        System.out.println();

        // TASK 2 Date, Time, birth date (currently isn't working!)

        // birthday
        /*System.out.print("Please enter your date of birth as dd/mm/yyyy: ");
        String birthday = scan.nextLine();
        System.out.println(birthday);

        LocalDate birthdayLocalDate = LocalDate.parse(birthday);
        System.out.println("Birthday as LocalDate: " + birthdayLocalDate);

        */

        // LocalDate examples
        System.out.println("LocalDate examples");
        // today
        LocalDate todaysDate = LocalDate.now();
        System.out.println("Today's date: " + todaysDate);

        // a specific date based on input arguments
        LocalDate firstOfJan2021 = LocalDate.of(2021, Month.JANUARY, 1);
        System.out.println("Specific date: " + firstOfJan2021);

        // current day in Asia/HongKong, get it from ZoneId javadoc
        LocalDate todayTokyo = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current date in Tokyo, Japan is: " + todayTokyo);
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        // getting date from the base date, i.e. 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date is: " + dateFromBase);

        LocalDate hundredDay2021 = LocalDate.ofYearDay(2021, 100);
        System.out.println("100th day of 2021 is: " + hundredDay2021);
        System.out.println();

        //LocalTime examples
        System.out.println("LocalTime examples");
        // time now
        LocalTime timeNow = LocalTime.now();
        System.out.println("Time now is: " + timeNow);

        // a specific time based on input arguments
        LocalTime specificTime = LocalTime.of(12, 34);
        System.out.println("Specific time: " + specificTime);
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));

        // getting date from the base date, i.e. 01/01/1970
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time is: " + specificSecondTime);

        // current time in Tokyo
        LocalTime timeInTokyo = LocalTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current time in Tokyo, Japan is: " + timeInTokyo);
        System.out.println();

        //LocalDateTime examples
        System.out.println("LocalDateTime examples");
        // date and time now
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println("Today's date and time is: " + dateTimeNow);

        // current date using LocalDate and LocalTime
        dateTimeNow = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime is: " + dateTimeNow);

        // LocalDateTime by using arguments
        LocalDateTime specificDate = LocalDateTime.of(2021, Month.AUGUST, 18, 11, 11);
        System.out.println("Specific date is: " + specificDate);

        // current date in Tokyo
        LocalDateTime todayInTokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current date and time in Tokyo is: " + todayInTokyo);

        // getting date from the base date, i.e. 01/01/1970
        LocalDateTime dateFromBase1 = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970 is: " + dateFromBase1);
        System.out.println();

        //Instant examples
        System.out.println("Instance examples");
        // current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current timestamp is: " + timestamp);

        // instant from timestamp
        Instant specificTimeFromTimestamp = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific time is: " + specificTimeFromTimestamp);

        // duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
        System.out.println();

        // Date API Utilities
        System.out.println("Date API Utilities");
        // get the year and check if it's leap year
        System.out.println("Year " + todaysDate.getYear() + " is leap year? " + todaysDate.isLeapYear());

        // compare two LocalDate for before and after
        System.out.println("Is today before 01/01/2015? " + todaysDate.isBefore(LocalDate.of(2015, 1, 1)));

        // create LocalDateTime from LocalDate
        System.out.println("Current Time is: " + todaysDate.atTime(LocalTime.now()));

        // plus and minus operations
        System.out.println("10 days after today will be: " + todaysDate.plusDays(10));
        System.out.println("3 weeks after today will be: " + todaysDate.plusWeeks(3));
        System.out.println("20 months after today will be: " + todaysDate.plusMonths(20));

        System.out.println("10 days before today will be: " + todaysDate.minusDays(10));
        System.out.println("3 weeks before today will be: " + todaysDate.minusWeeks(3));
        System.out.println("20 months before today will be: " + todaysDate.minusMonths(20));

        // temporal adjusters for adjusting the dates
        System.out.println("First date of this month is: " + todaysDate.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = todaysDate.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last day of this year is: " + lastDayOfYear);

        Period period = todaysDate.until(lastDayOfYear);
        System.out.println("Period format is: " + period);
        System.out.println("Months remaining in this year: " + period.getMonths());
        System.out.println();

        //Parsing and formatting
        System.out.println("Parsing and formatting examples");
        // format examples
        LocalDate date = LocalDate.now();
        // default format
        System.out.println("Default format of LocalDate is: " + date);
        // specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime is: " + dateTime);
        // specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp1 = Instant.now();
        // default format
        System.out.println("Default format of Instant is: " + timestamp1);

        // Parse examples
        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48", DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing is: " + dt);
        System.out.println();

        //Date API Legacy support
        System.out.println("Date API legacy support examples");
        // date to Instant
        Instant timestamp2 = new Date().toInstant();
        // convert Instant to LocalDateTime or other similar classes
        LocalDateTime date2 = LocalDateTime.ofInstant(timestamp2, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("Date: " + date2);

        // calendar to Instant
        Instant time = Calendar.getInstance().toInstant();
        System.out.println(time);

        // TimeZone to ZoneId
        ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
        System.out.println(gregorianCalendarDateTime);

        // date API to legacy classes
        Date dt1 = Date.from(Instant.now());
        System.out.println(dt1);

        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz);

        GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
        System.out.println(gc);

    }

}

