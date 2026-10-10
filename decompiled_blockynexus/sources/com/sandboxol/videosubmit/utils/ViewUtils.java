package com.sandboxol.videosubmit.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.entity.LinkInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ViewUtils {
    public static List<String>[] getCountries() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : Locale.getISOCountries()) {
            Locale locale = new Locale("", str);
            arrayList.add(locale.getDisplayCountry());
            arrayList2.add(locale.getCountry());
        }
        return new List[]{arrayList, arrayList2};
    }

    public static String getFormatTime(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)).split(" ")[0];
        String str2 = str.split("-")[1];
        String str3 = str.split("-")[2];
        Resources resources = BaseApplication.getContext().getResources();
        return String.format(getMonth(Integer.parseInt(str2)), str3, str3.endsWith("1") ? resources.getString(R.string.videosubmit_date_st) : str3.endsWith("2") ? resources.getString(R.string.videosubmit_date_nd) : str3.endsWith("3") ? resources.getString(R.string.videosubmit_date_rd) : resources.getString(R.string.videosubmit_date_th));
    }

    public static List<String> getGameNames(Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.videosubmit_game_names);
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static List<LinkInfo> getGames(Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.videosubmit_game_names);
        String[] stringArray2 = context.getResources().getStringArray(R.array.videosubmit_game_ids);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            arrayList.add(new LinkInfo().setGameName(stringArray[i]).setGameCode(stringArray2[i]));
        }
        return arrayList;
    }

    public static Map<String, String> getLanguages() {
        HashMap map = new HashMap();
        for (Locale locale : Locale.getAvailableLocales()) {
            map.put(locale.getLanguage(), locale.getDisplayLanguage());
        }
        return map;
    }

    private static String getMonth(int i) {
        if (i < 1 || i > 12) {
            i = 1;
        }
        Resources resources = BaseApplication.getContext().getResources();
        return new String[]{resources.getString(R.string.videosubmit_January), resources.getString(R.string.videosubmit_february), resources.getString(R.string.videosubmit_March), resources.getString(R.string.videosubmit_April), resources.getString(R.string.videosubmit_May), resources.getString(R.string.videosubmit_June), resources.getString(R.string.videosubmit_July), resources.getString(R.string.videosubmit_August), resources.getString(R.string.videosubmit_September), resources.getString(R.string.videosubmit_October), resources.getString(R.string.videosubmit_November), resources.getString(R.string.videosubmit_December)}[i - 1];
    }

    public static List<String> getVideoType(Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.videosubmit_video_type);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, stringArray);
        return arrayList;
    }

    public static String getFormatTime(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = str.split("-")[1];
        String strSubstring = str.split("-")[2];
        Resources resources = BaseApplication.getContext().getResources();
        if (strSubstring.endsWith("1")) {
            string = resources.getString(R.string.videosubmit_date_st);
        } else if (strSubstring.endsWith("2")) {
            string = resources.getString(R.string.videosubmit_date_nd);
        } else if (strSubstring.endsWith("3")) {
            string = resources.getString(R.string.videosubmit_date_rd);
        } else {
            string = resources.getString(R.string.videosubmit_date_th);
        }
        if (strSubstring.startsWith("0")) {
            strSubstring = strSubstring.substring(1);
        }
        return String.format(getMonth(Integer.parseInt(str2)), strSubstring, string);
    }
}
