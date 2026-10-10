package com.tencent.mapsdk.rastercore.f;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f19598b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f19599a;

    private a() {
    }

    public static a a() {
        if (f19598b == null) {
            synchronized (a.class) {
                if (f19598b == null) {
                    f19598b = new a();
                }
            }
        }
        return f19598b;
    }

    public final String a(String str) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public final void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f19599a = applicationContext.getSharedPreferences(applicationContext.getPackageName(), 0);
    }

    public final boolean a(String str, int i) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putInt(str, i).commit();
    }

    public final boolean a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putString(str, str2).commit();
    }

    public final boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putBoolean(str, z).commit();
    }

    public final boolean a(String[] strArr) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str : strArr) {
            editorEdit.remove(str);
        }
        return editorEdit.commit();
    }

    public final int b(String str) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str, -1);
    }

    public final boolean c(String str) {
        SharedPreferences sharedPreferences = this.f19599a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }
}
