package com.berstek.uhacpayso.staticData;




import com.berstek.uhacpayso.model.TransactionSelectionItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/26/2016.
 */
public class TransactionInitData {

    public static String[] getTransactions() {
        return transactions;
    }

    private static final String[] transactions = {
            "Food",
            "Transpo",
            "Grocery",
            "Gaming",
            "Clothe",
            "Education",
            "Gym",
            "Medical",
            "Gadgets",
            "Electricity",
            "Internet",
            "Mortgage",
            "Pet",
            "Music",
            "Vacation",
            "Water",
            "Others"
    };

    public static List<TransactionSelectionItem> getData() {
        List<TransactionSelectionItem> data = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            TransactionSelectionItem item = new TransactionSelectionItem();
            item.setImageUrl(Transactions.getImageUrl(transactions[i]));
            item.setDetails(transactions[i]);
            data.add(item);
        }
        return data;
    }
}
