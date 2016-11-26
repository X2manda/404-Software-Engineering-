package com.berstek.uhacpayso.utils;


/**
 * Created by John on 11/26/2016.
 */

public class WeeklyDifferential {

    public static int getDayDifference(String startDay, String currentCurrentDay) {

        int start = getDayValue(startDay);
        int end = getEnd(start);
        int current = getDayValue(currentCurrentDay);
        int remainingDays;

        if(current >= start) {
            remainingDays = (7 - current) + start;
        }
        else {
            remainingDays = start - current;
        }

        return remainingDays;
    }

    private static int getDayValue(String day) {
        switch (day.toLowerCase()) {
            case "monday": return 1;
            case "tuesday": return 2;
            case "wednesday": return 3;
            case "thursday": return 4;
            case "friday": return 5;
            case "saturday": return 6;
            case "sunday": return 7;
            default:return 1000;

        }
    }

    private static int getEnd(int start) {
        if(start == 1) {
            return 7;
        } else {
            return start - 1;
        }
    }

    private int specialCase() {
        int start = 5;
        int current = 1;
        int answer = 4;

        return 0;
    }
}
