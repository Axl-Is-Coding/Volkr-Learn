package com.sandboxol.center.utils;

import android.util.Log;
import com.sandboxol.common.base.app.BaseApplication;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class NickNameRandomUtil {
    private static String getFirstAndSecondName() {
        String secondName = getSecondName();
        if (secondName.length() >= 8) {
            return secondName;
        }
        String firstName = getFirstName();
        if (firstName.length() <= 1 || firstName.length() + secondName.length() > 15) {
            return secondName;
        }
        return firstName + "_" + secondName;
    }

    private static String getFirstName() {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str = "";
        try {
            inputStreamOpen = BaseApplication.getApp().getAssets().open("rdm_first_name.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            str = str + (line + UMCustomLogInfoBuilder.LINE_SEP);
            String[] strArrSplit = str.split(UMCustomLogInfoBuilder.LINE_SEP);
            double dRandom = Math.random();
            double length = strArrSplit.length;
            Double.isNaN(length);
            return strArrSplit[(int) (dRandom * length)];
        }
        inputStreamOpen.close();
        String[] strArrSplit2 = str.split(UMCustomLogInfoBuilder.LINE_SEP);
        double dRandom2 = Math.random();
        double length2 = strArrSplit2.length;
        Double.isNaN(length2);
        return strArrSplit2[(int) (dRandom2 * length2)];
    }

    private static String getLeter() {
        String str = "";
        for (int i = 0; i < 3; i++) {
            str = str + ((char) ((Math.random() * 26.0d) + 97.0d));
        }
        return str;
    }

    public static String getNickName() {
        String firstAndSecondName = getFirstAndSecondName();
        Log.e("nameLength", String.valueOf(firstAndSecondName.length()));
        if (firstAndSecondName.length() >= 13) {
            firstAndSecondName = firstAndSecondName.substring(0, 12);
        }
        return firstAndSecondName + getLeter() + new Random().nextInt(10);
    }

    private static String getSecondName() {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str = "";
        try {
            inputStreamOpen = BaseApplication.getApp().getAssets().open("rdm_second_name.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            str = str + (line + UMCustomLogInfoBuilder.LINE_SEP);
            String[] strArrSplit = str.split(UMCustomLogInfoBuilder.LINE_SEP);
            double dRandom = Math.random();
            double length = strArrSplit.length;
            Double.isNaN(length);
            return strArrSplit[(int) (dRandom * length)];
        }
        inputStreamOpen.close();
        String[] strArrSplit2 = str.split(UMCustomLogInfoBuilder.LINE_SEP);
        double dRandom2 = Math.random();
        double length2 = strArrSplit2.length;
        Double.isNaN(length2);
        return strArrSplit2[(int) (dRandom2 * length2)];
    }
}
