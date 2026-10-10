package com.sandboxol.center.utils;

import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.center.entity.TribeLevelExchange;
import com.sandboxol.center.entity.TribeVipExchange;
import com.sandboxol.common.base.app.BaseApplication;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LocalDataRequest {
    public static String[] getFileArray(String str) {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str2 = "";
        try {
            inputStreamOpen = BaseApplication.getContext().getAssets().open(str);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            str2 = str2 + (line + UMCustomLogInfoBuilder.LINE_SEP);
            return str2.split(UMCustomLogInfoBuilder.LINE_SEP);
        }
        inputStreamOpen.close();
        return str2.split(UMCustomLogInfoBuilder.LINE_SEP);
    }

    public static String getFirstName() {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str = "";
        try {
            inputStreamOpen = BaseApplication.getContext().getAssets().open("rdm_first_name.txt");
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

    public static Map<String, Map<String, String>> getSearchFriendGames() {
        try {
            InputStream inputStreamOpen = BaseApplication.getContext().getAssets().open("game_list.json");
            Map<String, Map<String, String>> map = (Map) new com.google.gson.j().a(inputStream2String(inputStreamOpen), new TypeToken<Map<String, Map<String, String>>>() { // from class: com.sandboxol.center.utils.LocalDataRequest.4
            }.getType());
            if (map != null) {
                return map;
            }
            inputStreamOpen.close();
        } catch (Exception e2) {
            Log.e("PrivilegeInfo", e2.toString());
        }
        return new HashMap();
    }

    public static Map<String, String> getSearchFriendLanguage() {
        try {
            InputStream inputStreamOpen = BaseApplication.getContext().getAssets().open("language_list.json");
            Map<String, String> map = (Map) new com.google.gson.j().a(inputStream2String(inputStreamOpen), new TypeToken<Map<String, String>>() { // from class: com.sandboxol.center.utils.LocalDataRequest.3
            }.getType());
            if (map != null) {
                return map;
            }
            inputStreamOpen.close();
        } catch (Exception e2) {
            Log.e("PrivilegeInfo", e2.toString());
        }
        return new HashMap();
    }

    public static String getSecondName() {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        String str = "";
        try {
            inputStreamOpen = BaseApplication.getContext().getAssets().open("rdm_second_name.txt");
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

    public static TribeLevelExchange getTribeLevelExchange(int i) {
        try {
            InputStream inputStreamOpen = BaseApplication.getContext().getAssets().open("clan_attr_config.json");
            List list = (List) new com.google.gson.j().a(inputStream2String(inputStreamOpen), new TypeToken<List<TribeLevelExchange>>() { // from class: com.sandboxol.center.utils.LocalDataRequest.2
            }.getType());
            inputStreamOpen.close();
            return (TribeLevelExchange) list.get(i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static TribeVipExchange getTribeVipExChange(int i) {
        try {
            InputStream inputStreamOpen = BaseApplication.getContext().getAssets().open("clan_vip_privilege_config.json");
            List list = (List) new com.google.gson.j().a(inputStream2String(inputStreamOpen), new TypeToken<List<TribeVipExchange>>() { // from class: com.sandboxol.center.utils.LocalDataRequest.1
            }.getType());
            inputStreamOpen.close();
            return (TribeVipExchange) list.get(i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String inputStream2String(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(i);
        }
    }
}
