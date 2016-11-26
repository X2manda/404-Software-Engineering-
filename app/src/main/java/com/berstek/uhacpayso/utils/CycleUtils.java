package com.berstek.uhacpayso.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by John on 11/26/2016.
 */

public class CycleUtils {

    public static int getCycleLength() {

        int iYear = 2016;
        int iMonth = Calendar.NOVEMBER;
        int iDay = 1;

        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);

        return daysInMonth;
    }

    public static int getCurrentMonth() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        return Integer.parseInt(month.format(new Date()));
    }

    public static String getCurrentDay() {
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    public static int getCurrentDayINT() {
        String day = new SimpleDateFormat("EEEE").format(new Date());
        return dayToInt(day);
    }

    private static int dayToInt(String day) {
        switch (day.toLowerCase()) {
            case "monday": return 1;
            case "tuesday": return 2;
            case "wednesday": return 3;
            case "thursday": return 4;
            case "friday": return 5;
            case "saturday": return 6;
            case "sunday": return 7;
            default: return 0;
        }
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static double calculateDailyBalance(double budget, double spendings, int remainingDays) {
        return (budget - spendings) / remainingDays;
    }

    public static int getRemainingDays(String startDate, String currentDate) {
        switch (startDate.toLowerCase()) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
            case "saturday":
            case "sunday":

            return (7 - dayToInt(startDate)) + dayToInt(startDate);

            default: return 0;
        }
    }

}
