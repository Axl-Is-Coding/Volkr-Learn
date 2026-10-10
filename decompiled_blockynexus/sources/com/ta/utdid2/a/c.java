package com.ta.utdid2.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.ta.utdid2.b.a.d;
import com.ta.utdid2.b.a.h;
import com.ta.utdid2.b.a.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AidStorageController.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    private static final String TAG = "com.ta.utdid2.a.c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, String> f19337a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Long> f19338b = new ConcurrentHashMap();

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return;
        }
        String strC = c(str, str3);
        long jCurrentTimeMillis = System.currentTimeMillis();
        f19337a.put(strC, str2);
        f19338b.put(strC, Long.valueOf(jCurrentTimeMillis));
        SharedPreferences sharedPreferences = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0);
        if (Build.VERSION.SDK_INT >= 9) {
            h.a(sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(strC), str2));
            h.a(sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(strC), jCurrentTimeMillis));
        } else {
            sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(strC), str2).commit();
            sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(strC), jCurrentTimeMillis).commit();
        }
    }

    private static String c(String str, String str2) {
        String strEncodeToString = Build.VERSION.SDK_INT >= 8 ? com.ta.utdid2.b.a.c.encodeToString(str.concat(str2).getBytes(), 2) : com.ta.utdid2.b.a.b.encodeToString(str.concat(str2).getBytes(), 2);
        if (d.f19354e) {
            Log.d(TAG, "encodedName:" + strEncodeToString);
        }
        return strEncodeToString;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m92a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return "";
        }
        String strC = c(str, str2);
        String str3 = f19337a.get(strC);
        if (d.f19354e) {
            Log.d(TAG, "cache AID:" + str3);
        }
        if (!i.m95a(str3)) {
            return str3;
        }
        String string = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getString("EvQwnbilKezpOJey".concat(strC), "");
        f19337a.put(strC, string);
        return string;
    }

    public static long a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return 0L;
        }
        String strC = c(str, str2);
        Long lValueOf = Long.valueOf(f19338b.containsKey(strC) ? f19338b.get(strC).longValue() : 0L);
        if (d.f19354e) {
            Log.d(TAG, "cache AIDGenTime:" + lValueOf);
        }
        if (lValueOf.longValue() == 0) {
            lValueOf = Long.valueOf(context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getLong("rKrMJgyAEbVtSQGi".concat(strC), 0L));
            f19338b.put(strC, lValueOf);
        }
        return lValueOf.longValue();
    }
}
