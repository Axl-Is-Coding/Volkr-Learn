package com.ta.utdid2.b.a;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: DebugUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f19352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Method f103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f19353b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f19354e;

    static {
        f19354e = getInt("alidebug", 0) == 1;
        f19352a = null;
        f103a = null;
        f19353b = null;
    }

    private static void a() {
        try {
            if (f19352a == null) {
                f19352a = Class.forName("android.os.SystemProperties");
                f103a = f19352a.getDeclaredMethod("get", String.class);
                f19353b = f19352a.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int getInt(String str, int i) {
        a();
        try {
            return ((Integer) f19353b.invoke(f19352a, str, Integer.valueOf(i))).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }
}
