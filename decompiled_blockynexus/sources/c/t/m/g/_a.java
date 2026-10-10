package c.t.m.g;

import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class _a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3073b;
    public double g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f3075d = -1.0d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f3076e = -1.0d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f3077f = -1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3072a = -1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3074c = -1;
    public double h = 0.0d;
    public double i = 0.0d;

    public static SharedPreferences a(String str) {
        return C0458qa.d().getSharedPreferences(str, "com.tencent.mobileqq".equals(C0458qa.d().getPackageName()) ? 4 : 0);
    }

    public static Object b(String str, String str2, Object obj) {
        return b(a(str), str2, obj);
    }

    public static Object b(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void a(String str, String str2, Object obj) {
        a(a(str), str2, obj);
    }

    public static void a(SharedPreferences sharedPreferences, String str, Object obj) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        } else {
            editorEdit.putString(str, obj.toString());
        }
        if (Build.VERSION.SDK_INT >= 9) {
            editorEdit.apply();
        } else {
            editorEdit.commit();
        }
    }

    public final void a() {
        this.f3077f = -1.0d;
        this.f3072a = -1.0f;
        this.f3074c = -1L;
        this.h = 0.0d;
        this.i = 0.0d;
    }
}
