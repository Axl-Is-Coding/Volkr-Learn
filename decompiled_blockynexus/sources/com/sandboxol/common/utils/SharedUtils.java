package com.sandboxol.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class SharedUtils {
    private static final String DEFAULT_FILE_NAME = "data";
    private static final String DEFAULT_MULTI_PROCESS_FILE_NAME = "multiProcessFile";

    public static void clear(Context context) {
        clear(context, "data");
    }

    public static boolean getBoolean(Context context, String str) {
        return getBoolean(context, "data", str);
    }

    public static float getFloat(Context context, String str) {
        return getFloat(context, "data", str);
    }

    public static int getInt(Context context, String str) {
        return getInt(context, "data", str);
    }

    public static long getLong(Context context, String str) {
        return getLong(context, "data", str);
    }

    private static SharedPreferences getSharedPreferences(Context context, String str) {
        if (context != null) {
            return context.getApplicationContext().getSharedPreferences(str, 0);
        }
        return null;
    }

    public static String getString(Context context, String str) {
        return getString(context, str, null);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        putBoolean(context, "data", str, z);
    }

    public static void putFloat(Context context, String str, float f2) {
        putFloat(context, "data", str, f2);
    }

    public static void putInt(Context context, String str, int i) {
        putInt(context, "data", str, i);
    }

    public static void putLong(Context context, String str, long j) {
        putLong(context, "data", str, j);
    }

    public static void putString(Context context, String str, String str2) {
        putString(context, "data", str, str2);
    }

    public static void remove(Context context, String str) {
        remove(context, "data", str);
    }

    public static void clear(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public static boolean getBoolean(Context context, String str, String str2) {
        return getBoolean(context, str, str2, false);
    }

    public static float getFloat(Context context, String str, String str2) {
        return getFloat(context, str, str2, WheelView.DividerConfig.FILL);
    }

    public static int getInt(Context context, String str, String str2) {
        return getInt(context, str, str2, 0);
    }

    public static long getLong(Context context, String str, String str2) {
        return getLong(context, str, str2, 0L);
    }

    public static String getString(Context context, String str, String str2) {
        return getString(context, "data", str, str2);
    }

    public static void putBoolean(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.putBoolean(str2, z);
        editorEdit.apply();
    }

    public static void putFloat(Context context, String str, String str2, float f2) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.putFloat(str2, f2);
        editorEdit.apply();
    }

    public static void putInt(Context context, String str, String str2, int i) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.putInt(str2, i);
        editorEdit.apply();
    }

    public static void putLong(Context context, String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.putLong(str2, j);
        editorEdit.apply();
    }

    public static void putString(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }

    public static void remove(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        editorEdit.remove(str2);
        editorEdit.apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getBoolean(context, "data", str, z);
    }

    public static float getFloat(Context context, String str, float f2) {
        return getFloat(context, "data", str, f2);
    }

    public static int getInt(Context context, String str, int i) {
        return getInt(context, "data", str, i);
    }

    public static long getLong(Context context, String str, long j) {
        return getLong(context, "data", str, j);
    }

    public static String getString(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, str);
        return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
    }

    public static boolean getBoolean(Context context, String str, String str2, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, str);
        return sharedPreferences != null ? sharedPreferences.getBoolean(str2, z) : z;
    }

    public static float getFloat(Context context, String str, String str2, float f2) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, str);
        return sharedPreferences != null ? sharedPreferences.getFloat(str2, f2) : f2;
    }

    public static int getInt(Context context, String str, String str2, int i) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, str);
        return sharedPreferences != null ? sharedPreferences.getInt(str2, i) : i;
    }

    public static long getLong(Context context, String str, String str2, long j) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, str);
        return sharedPreferences != null ? sharedPreferences.getLong(str2, j) : j;
    }
}
