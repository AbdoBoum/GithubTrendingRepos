package com.example.githubtrendingrepos.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.githubtrendingrepos.Retrofit.GithubRepoApi;
import com.example.githubtrendingrepos.Retrofit.RetrofitClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    private static final String BASE_URL = "https://api.github.com/";

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

    public static GithubRepoApi getApiService() {
        return new RetrofitClient(BASE_URL).getRetrofit().create(GithubRepoApi.class);
    }


}
