package com.berstek.uhacpayso.staticData;

/**
 * Created by John on 11/26/2016.
 */

public class Transactions {

    public static final String getImageUrl(String str) {
        switch (str.toLowerCase()) {
            case "clothe": return "@drawable/ic_clothe";
            case "education": return "@drawable/ic_education";
            case "electricity": return "@drawable/ic_electricbill";
            case "food": return "@drawable/ic_food";
            case "gadgets": return "@drawable/ic_gadgets";
            case "gaming": return "@drawable/ic_gaming";
            case "gift": return "@drawable/ic_gift";
            case "grocery": return "@drawable/ic_grocery";
            case "gym": return "@drawable/ic_gym";
            case "internet": return "@drawable/ic_internetbill";
            case "medical": return "@drawable/ic_medical";
            case "pet": return "@drawable/ic_pet";
            case "mortgage": return "@drawable/ic_rentmortgage";
            case "transpo": return "@drawable/ic_transpo";
            case "vacation": return "@drawable/ic_vacation";
            case "music": return "@drawable/ic_music";
            case "water": return "@drawable/ic_waterbill";
            default: return "@drawable/ic_others";
        }
    }
}
