package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.tenddata.TDAccount;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public interface ao {
    void a(Activity activity, a aVar);

    void a(Activity activity, String str, String str2, a aVar);

    void a(Context context, a aVar);

    void a(Context context, String str, a aVar);

    void a(Context context, String str, String str2, a aVar);

    void a(Context context, String str, String str2, String str3, a aVar);

    void a(Context context, String str, String str2, Map<String, Object> map, double d2, a aVar);

    void a(Context context, String str, String str2, Map<String, Object> map, a aVar);

    void a(Context context, Throwable th, a aVar);

    void a(ShoppingCart shoppingCart, a aVar);

    void a(String str, Order order, a aVar);

    void a(String str, TDAccount.AccountType accountType, a aVar);

    void a(String str, TDAccount.AccountType accountType, String str2, a aVar);

    void a(String str, a aVar);

    void a(String str, Object obj);

    void a(String str, String str2, int i, String str3, String str4, Order order, a aVar);

    void a(String str, String str2, int i, String str3, String str4, a aVar);

    void a(String str, String str2, int i, String str3, String str4, String str5, int i2, a aVar);

    void a(String str, String str2, Order order, a aVar);

    void a(String str, String str2, a aVar);

    void a(String str, String str2, String str3, int i, int i2, a aVar);

    void a(String str, String str2, String str3, int i, a aVar);

    void a(String str, String str2, String str3, a aVar);

    String b(Context context);

    String b(Context context, a aVar);

    void b(Activity activity, a aVar);

    void b(Context context, String str, a aVar);

    void b(String str, TDAccount.AccountType accountType, a aVar);

    void b(String str, TDAccount.AccountType accountType, String str2, a aVar);

    void b(String str, a aVar);

    void b(String str, String str2, int i, String str3, String str4, a aVar);

    String c(Context context, a aVar);

    void c(String str, TDAccount.AccountType accountType, a aVar);

    void c(String str, a aVar);

    void c(boolean z);

    Context d();

    String d(Context context, a aVar);

    String e(Context context, a aVar);

    void e();

    void onLogout(a aVar);

    void removeGlobalKV(String str);
}
