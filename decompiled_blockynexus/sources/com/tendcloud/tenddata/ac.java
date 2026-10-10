package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.tenddata.TDAccount;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ao f19753a;

    public static synchronized void a(Context context, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String b(Context context, a aVar) {
        return ab.a(context, aVar);
    }

    public static String c(Context context, a aVar) {
        return ab.b(context, aVar);
    }

    public static synchronized String d(Context context, a aVar) {
        try {
            f(context, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
        return f19753a.b(context, aVar);
    }

    public static synchronized String e(Context context, a aVar) {
        try {
            f(context, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
        return f19753a.e(context, aVar);
    }

    private static synchronized void f(Context context, a aVar) {
        if (context != null) {
            ab.g = context.getApplicationContext();
        }
        if (ab.g == null) {
            m.eForDeveloper("Init failed Context is null ");
            return;
        }
        if (f19753a == null) {
            System.currentTimeMillis();
            f19753a = zz.a();
        }
    }

    public static void setAccountId(String str) {
        try {
            ab.s = str;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Context b() {
        return f19753a.d();
    }

    public static void c() {
        try {
            m.f20034a = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Activity activity, a aVar) {
        try {
            f(activity, aVar);
            f19753a.b(activity, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(Context context, String str, a aVar) {
        b(context, str, "", aVar);
    }

    public static synchronized void a(Context context, String str, String str2, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(String str, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.b(str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str, a aVar) {
        try {
            f(context, aVar);
            f19753a.b(context, str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void a(Context context, String str, String str2, String str3, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, str, str2, str3, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str, String str2, a aVar) {
        a(context, str, str2, (Map<String, Object>) null, aVar);
    }

    public static int b(Context context) {
        return p.c(context);
    }

    public static void b(String str, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a() {
        return zz.f20075b;
    }

    public static synchronized String a(Context context) {
        try {
            f(context, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
        return f19753a.b(context);
    }

    public static void b(String str, TDAccount.AccountType accountType, String str2, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, accountType, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str, String str2, int i, String str3, String str4, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, i, str3, str4, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Activity activity, String str, String str2, a aVar) {
        try {
            f(activity, aVar);
            f19753a.a(activity, str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Activity activity, a aVar) {
        try {
            f(activity, aVar);
            f19753a.a(activity, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, str, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Object obj, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, obj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.removeGlobalKV(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, a aVar) {
        a(context, str, (String) null, map, aVar);
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, str, str2, map, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, double d2, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, str, str2, map, d2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(a aVar, String str) {
        try {
            f(ab.g, aVar);
            f19753a.a(ab.g, str, "", (Map<String, Object>) null, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(boolean z, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.c(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, Throwable th, a aVar) {
        try {
            f(context, aVar);
            f19753a.a(context, th, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, TDAccount.AccountType accountType, String str2, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.b(str, accountType, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.b(str, str2, i, str3, str4, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, Order order, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, order, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, Order order, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, i, str3, str4, order, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5, int i2, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, i, str3, str4, str5, i2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Order order, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, order, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i, int i2, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, str3, i, i2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, str3, i, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(ShoppingCart shoppingCart, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(shoppingCart, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, a aVar) {
        try {
            f(ab.g, aVar);
            f19753a.a(str, str2, str3, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
