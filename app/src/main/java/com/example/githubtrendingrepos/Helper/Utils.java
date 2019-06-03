package com.example.githubtrendingrepos.Helper;

import android.content.Context;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static final String BASE_URL = "https://api.github.com/";

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void makeToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static String getFormattedDateOneMonthAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date currentDate = calendar.getTime();
        return dateFormat.format(currentDate);
    }

    public static String formatStars(int nStars) {
        if (nStars < 1000) {
            return String.valueOf(nStars);
        } else {
            int r = nStars/1000;
            int _r = ((nStars%1000))/100;
            String result = r + "." + _r + "K";
            return result;
        }
    }


}
