package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TTReflectUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class z {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> clsA = a(str);
            if (clsA != null) {
                return clsA.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTClassLoader", "get method: " + str + ", " + str2, th);
            return null;
        }
    }

    public static Class<?> a(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, a());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str);
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str, true, z.class.getClassLoader());
        }
    }

    private static ClassLoader a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? z.class.getClassLoader() : contextClassLoader;
    }
}
