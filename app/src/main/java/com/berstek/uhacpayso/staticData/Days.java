package com.berstek.uhacpayso.staticData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/26/2016.
 */

public class Days {

    private static final String[] en_days = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Saturday",
            "Sunday"
    };

    public static List<String> getEn_days() {
        List<String> list = new ArrayList<>();
        for(String day : en_days) {
            list.add(day);
        }
        return list;
    }
}
