package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.tenddata.TDAccount;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class TCAgent {
    public static boolean LOG_ON = true;

    public static synchronized String getDeviceId(Context context) {
        return ac.d(context, a.APP);
    }

    public static int getNFCStatus(Context context) {
        return ac.b(context);
    }

    public static String getOAID(Context context) {
        return ac.e(context, a.APP);
    }

    public static synchronized void init(Context context) {
        m.f20034a = LOG_ON;
        ac.a(context, a.APP);
    }

    public static void onAddItemToShoppingCart(String str, String str2, String str3, int i, int i2) {
        ac.a(str, str2, str3, i, i2, a.APP);
    }

    public static void onError(Context context, Throwable th) {
        ac.a(context, th, a.APP);
    }

    public static void onEvent(Context context, String str) {
        onEvent(context, str, "");
    }

    public static void onLogin(String str, TDAccount.AccountType accountType, String str2) {
        ac.a(str, accountType, str2, a.APP);
    }

    public static void onOrderPaySucc(String str, String str2, Order order) {
        ac.a(str, str2, order, a.APP);
    }

    public static void onPageEnd(Context context, String str) {
        ac.b(context, str, a.APP);
    }

    public static void onPageStart(Context context, String str) {
        ac.a(context, str, a.APP);
    }

    @Deprecated
    public static void onPause(Activity activity) {
        ac.b(activity, a.APP);
    }

    public static void onPlaceOrder(String str, Order order) {
        ac.a(str, order, a.APP);
    }

    public static void onRegister(String str, TDAccount.AccountType accountType, String str2) {
        ac.b(str, accountType, str2, a.APP);
    }

    @Deprecated
    public static void onResume(Activity activity) {
        ac.a(activity, a.APP);
    }

    public static void onViewItem(String str, String str2, String str3, int i) {
        ac.a(str, str2, str3, i, a.APP);
    }

    public static void onViewShoppingCart(ShoppingCart shoppingCart) {
        ac.a(shoppingCart, a.APP);
    }

    public static void removeGlobalKV(String str) {
        ac.a(str, a.APP);
    }

    @Deprecated
    public static void setAccountId(String str) {
        ac.setAccountId(str);
    }

    public static void setGlobalKV(String str, Object obj) {
        ac.a(str, obj, a.APP);
    }

    public static void setReportUncaughtExceptions(boolean z) {
        ac.a(z, a.APP);
    }

    public static void onEvent(Context context, String str, String str2) {
        onEvent(context, str, str2, null);
    }

    public static void onEvent(Context context, String str, String str2, Map<String, Object> map) {
        ac.a(context, str, str2, map, a.APP);
    }

    public static synchronized void init(Context context, String str, String str2) {
        m.f20034a = LOG_ON;
        ac.a(context, str, str2, a.APP);
    }

    public static void onEvent(Context context, String str, String str2, Map<String, Object> map, double d2) {
        ac.a(context, str, str2, map, d2, a.APP);
    }
}
