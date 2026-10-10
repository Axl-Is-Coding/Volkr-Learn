package com.bytedance.sdk.adnet.d;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: MultiProcessFileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Context context, int i, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put("tnc_config", str);
            }
            c.b("MultiProcessFileUtils", "saveData = " + str);
            com.bytedance.sdk.adnet.a.a().a(context, linkedHashMap);
        } catch (Exception unused) {
        }
    }

    public static String a(Context context, int i) {
        String strA;
        if (i != 1) {
            strA = "";
        } else {
            try {
                strA = com.bytedance.sdk.adnet.a.a().a(context, "tnc_config", "");
            } catch (Exception unused) {
                strA = "";
            }
        }
        return strA instanceof String ? String.valueOf(strA) : "";
    }
}
