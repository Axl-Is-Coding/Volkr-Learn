package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SPMultiHelperImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SoftReference<Map<String, Map<String, Object>>> f7073a;

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static void b(String str) {
        Map<String, Object> map;
        SoftReference<Map<String, Map<String, Object>>> softReference = f7073a;
        if (softReference == null || softReference.get() == null || (map = f7073a.get().get(a(str))) == null) {
            return;
        }
        map.clear();
    }

    private static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(a(str), 0);
    }

    private static Object a(String str, String str2) {
        Map<String, Map<String, Object>> map;
        Map<String, Object> map2;
        SoftReference<Map<String, Map<String, Object>>> softReference = f7073a;
        if (softReference == null || (map = softReference.get()) == null || (map2 = map.get(a(str))) == null) {
            return null;
        }
        return map2.get(str2);
    }

    private static String c(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC == null ? str3 : sharedPreferencesC.getString(str2, str3);
    }

    private static Object b(Context context, String str, String str2, String str3) {
        String strA = a(str);
        if (!a(context, strA, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return c(context, strA, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(a(context, strA, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(a(context, strA, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(a(context, strA, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(a(context, strA, str2, WheelView.DividerConfig.FILL));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return c(context, strA, str2, null);
        }
        return null;
    }

    private static void a(String str, String str2, Object obj) {
        SoftReference<Map<String, Map<String, Object>>> softReference = f7073a;
        if (softReference == null || softReference.get() == null) {
            f7073a = new SoftReference<>(new HashMap());
        }
        String strA = a(str);
        Map<String, Map<String, Object>> map = f7073a.get();
        if (map.get(strA) == null) {
            map.put(strA, new HashMap());
        }
        map.get(strA).put(str2, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized <T> void a(Context context, String str, String str2, T t) {
        SharedPreferences sharedPreferencesC = c(context, str);
        if (sharedPreferencesC == null) {
            return;
        }
        if (t.equals(a(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editorEdit.putString(str2, (String) t);
        }
        if (t instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editorEdit.putLong(str2, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editorEdit.putFloat(str2, ((Float) t).floatValue());
        }
        editorEdit.apply();
        a(str, str2, t);
    }

    static void b(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesC = c(context, str);
        if (sharedPreferencesC == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
        editorEdit.remove(str2);
        editorEdit.apply();
    }

    static Map<String, ?> b(Context context, String str) {
        return c(context, str).getAll();
    }

    static String a(Context context, String str, String str2, String str3) {
        Object objA = a(str, str2);
        if (objA != null) {
            return objA + "";
        }
        Object objB = b(context, str, str2, str3);
        a(str, str2, objB);
        return objB + "";
    }

    private static int a(Context context, String str, String str2, int i) {
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC == null ? i : sharedPreferencesC.getInt(str2, i);
    }

    private static float a(Context context, String str, String str2, float f2) {
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC == null ? f2 : sharedPreferencesC.getFloat(str2, f2);
    }

    private static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC == null ? z : sharedPreferencesC.getBoolean(str2, z);
    }

    private static long a(Context context, String str, String str2, long j) {
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC == null ? j : sharedPreferencesC.getLong(str2, j);
    }

    static boolean a(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC != null && sharedPreferencesC.contains(str2);
    }

    static void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = c(context, str).edit();
        editorEdit.clear();
        editorEdit.apply();
        b(str);
    }
}
