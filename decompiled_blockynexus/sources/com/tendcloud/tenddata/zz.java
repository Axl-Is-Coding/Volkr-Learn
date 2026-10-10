package com.tendcloud.tenddata;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.android.billingclient.api.BillingFlowParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.tendcloud.tenddata.TDAccount;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class zz implements ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f20075b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f20076c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f20077d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f20078e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f20079f = 102;
    private static volatile zz g = null;
    private static String h = null;
    private static String i = null;
    private static boolean j = false;
    private static final int k = 101;
    private static final int l = 103;
    private static Handler m;
    private static Handler o;
    private static final HandlerThread n = new HandlerThread("ProcessingThread", 10);
    private static final HandlerThread p = new HandlerThread("PauseEventThread", 10);

    /* JADX INFO: compiled from: td */
    public static class a {
        public HashMap<String, Object> paraMap = new HashMap<>();
    }

    static {
        o = null;
        n.start();
        m = new Handler(n.getLooper()) { // from class: com.tendcloud.tenddata.zz.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                co.a();
                cn.a();
                Object obj = message.obj;
                if (obj == null || !(obj instanceof a)) {
                    return;
                }
                try {
                    ag.a().post((a) obj);
                } catch (Throwable unused) {
                }
            }
        };
        p.start();
        o = new Handler(p.getLooper()) { // from class: com.tendcloud.tenddata.zz.12
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) message.obj;
                    if (ab.n == 1) {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 11);
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        aVar2.paraMap.put("sessionEnd", 1);
                        aVar2.paraMap.put("service", aVar);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        ab.Q.set(true);
                        ab.n = 2;
                    }
                } catch (Exception e2) {
                    bp.postSDKError(e2);
                }
            }
        };
    }

    public zz() {
        g = this;
    }

    static synchronized zz a() {
        if (g == null) {
            synchronized (zz.class) {
                if (g == null) {
                    g = new zz();
                }
            }
        }
        return g;
    }

    static Handler b() {
        return o;
    }

    public static Handler c() {
        return m;
    }

    @Override // com.tendcloud.tenddata.ao
    public Context d() {
        try {
            return ab.g;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void e() {
        try {
            m.f20034a = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void onLogout(final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
            } else {
                m.iForDeveloper("ModuleAccount.logout ");
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                            aVar2.paraMap.put("action", "logout");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "");
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void removeGlobalKV(String str) {
        if (!f20075b) {
            m.eForDeveloper("SDK have not been initialized");
            return;
        }
        if (str != null) {
            m.iForDeveloper("removeGlobalKV# key:" + str);
        }
        ab.f19750d.remove(str);
    }

    @Override // com.tendcloud.tenddata.ao
    public String b(Context context, com.tendcloud.tenddata.a aVar) {
        if (context != null) {
            try {
                if (!f20075b) {
                    m.iForDeveloper("SDK have not been initialized");
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return o.a(context);
    }

    @Override // com.tendcloud.tenddata.ao
    public String c(Context context, com.tendcloud.tenddata.a aVar) {
        return ab.a(context, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public String d(Context context, com.tendcloud.tenddata.a aVar) {
        return ab.b(context, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public String e(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
            }
            return de.b().c();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(boolean z) {
        try {
            ab.f19751e = z;
            m.iForDeveloper(" setReportUncaughtExceptions: " + z);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public String b(Context context) {
        try {
            return o.a(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final TDAccount.AccountType accountType, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onActivate: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onActivate called --> account is " + str + " ,type is " + accountType);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "activate");
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        if (accountType != null) {
                            aVar2.paraMap.put("type", accountType.name());
                        }
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(Activity activity, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
            } else {
                if (j) {
                    return;
                }
                a(activity);
                c.b(activity, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, com.tendcloud.tenddata.a aVar) {
        a(context, (String) null, (String) null, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, com.tendcloud.tenddata.a aVar) {
        a(context, str, str2, (String) null, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (context == null) {
                m.iForDeveloper("Init failed Context is null");
                return;
            }
            if (!af.b(context, "android.permission.INTERNET")) {
                m.eForDeveloper("[SDKInit] Permission \"android.permission.INTERNET\" is needed.");
                return;
            }
            if (aVar == null) {
                m.eForDeveloper("Failed to initialize!");
                return;
            }
            try {
                if (f20075b) {
                    return;
                }
                ab.g = context.getApplicationContext();
                h = str;
                i = str2;
                f20074a = str3;
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                String strA = af.a(bundle, ab.T);
                String strA2 = af.a(bundle, "TD_CHANNEL_ID");
                if (af.b(strA)) {
                    strA = h;
                }
                h = strA;
                if (af.b(strA2)) {
                    strA2 = i;
                }
                i = strA2;
                String strA3 = af.a(context, "ChannelConfig.json");
                if (af.b(strA3)) {
                    strA3 = i;
                }
                i = strA3;
                i = !af.b(i) ? i : "Default";
                if (af.b(h)) {
                    m.eForDeveloper("[SDKInit] TD AppId is null");
                    return;
                }
                h = h.trim();
                ab.a(h, i, aVar);
                bj.a();
                bh.a().a(h, i, aVar);
                a(context);
                bi.a();
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.22
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            bl.a();
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 1);
                            aVar2.paraMap.put("appId", zz.h != null ? zz.h : "");
                            aVar2.paraMap.put("channelId", zz.i != null ? zz.i : "");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("action", "init");
                            Message.obtain(zz.c(), 101, aVar2).sendToTarget();
                            bm.a();
                            if (af.a(ab.g)) {
                                cl.a();
                            }
                            if (af.a(ab.g)) {
                                c.a(aVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                f20075b = true;
            } catch (Throwable th) {
                m.a("[SDKInit] Failed to initialize!", th);
                bp.postSDKError(th);
            }
        } catch (Throwable th2) {
            bp.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(Context context, String str, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (af.b(str)) {
                    str = activity.getLocalClassName();
                }
                if ((activity.getChangingConfigurations() & 128) == 128) {
                    f20077d = true;
                    return;
                }
            }
            a(context, str, 5, aVar);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                m.iForDeveloper("onPay called --> accountID: " + str);
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                            aVar2.paraMap.put("action", "pay");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            m.eForDeveloper("onPay: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final TDAccount.AccountType accountType, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onLogin: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onLogin called --> account is " + str + " ，type is " + accountType + " , name is " + str2);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("action", FirebaseAnalytics.Event.LOGIN);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        if (accountType != null) {
                            aVar2.paraMap.put("type", accountType.name());
                        }
                        if (str2 != null) {
                            aVar2.paraMap.put("name", str2);
                        }
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onRegister: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onRegister called --> account is " + str);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final TDAccount.AccountType accountType, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onApply: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onApply called --> account is " + str + " ,type is " + accountType);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "apply");
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        if (accountType != null) {
                            aVar2.paraMap.put("type", accountType.name());
                        }
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Activity activity, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
            } else {
                if (j && ab.F) {
                    return;
                }
                a(activity);
                c.a(activity, aVar);
                ab.F = true;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final int i2, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                m.iForDeveloper("onPay called --> account: " + str + " ,orderid: " + str2 + " ,amount: " + i2 + " ,currencyType: " + str3 + " ,payType: " + str4);
                if (str3.trim().length() != 3) {
                    m.eForDeveloper("currencyType length must be 3 likes CNY so so");
                    return;
                } else {
                    af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.11
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("action", "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i2));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
            }
            m.eForDeveloper("onPay: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Activity activity, String str, String str2, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
            } else {
                a(activity);
                a(activity, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (f20077d) {
                f20077d = false;
                return;
            }
            if (af.b(str) && (context instanceof Activity)) {
                str = ((Activity) context).getLocalClassName();
            }
            a(context, str, 4, aVar);
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, final String str, final int i2, final com.tendcloud.tenddata.a aVar) {
        af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zz.f20075b) {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", Integer.valueOf(i2));
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        aVar2.paraMap.put("pageName", str == null ? "" : af.a(str));
                        aVar2.paraMap.put("service", aVar);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onEvent()# event id is empty.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onEvent being called! eventId: ");
            sb.append(str);
            String string = "null";
            if (aVar.index() != 3) {
                sb.append(", eventLabel: ");
                sb.append(str2 == null ? "null" : str2);
            }
            sb.append(", eventMap: ");
            if (map != null) {
                string = map.toString();
            }
            sb.append(string);
            m.iForDeveloper(sb.toString());
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.24
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("apiType", 2);
                        aVar2.paraMap.put("eventId", af.a(str));
                        aVar2.paraMap.put("eventLabel", str2 == null ? null : af.a(str2));
                        aVar2.paraMap.put("map", map);
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final String str2, final Map<String, Object> map, final double d2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onEvent()# event id is empty.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onEvent being called! eventId: ");
            sb.append(str);
            String string = "null";
            if (aVar.index() != 3) {
                sb.append(", eventLabel: ");
                sb.append(str2 == null ? "null" : str2);
            }
            sb.append(", eventMap: ");
            if (map != null) {
                string = map.toString();
            }
            sb.append(string);
            sb.append(", value: ");
            sb.append(d2);
            m.iForDeveloper(sb.toString());
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.25
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("apiType", 2);
                        aVar2.paraMap.put("eventId", af.a(str));
                        aVar2.paraMap.put("eventLabel", str2 == null ? null : af.a(str2));
                        aVar2.paraMap.put("map", map);
                        aVar2.paraMap.put("value", Double.valueOf(d2));
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final Throwable th, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
            } else {
                if (th == null) {
                    return;
                }
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.26
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 3);
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            aVar2.paraMap.put("throwable", th);
                            aVar2.paraMap.put("service", aVar);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, Object obj) {
        if (!f20075b) {
            m.eForDeveloper("SDK have not been initialized");
            return;
        }
        if (str != null && obj != null) {
            m.iForDeveloper("setGlobalKV# key:" + str + " value:" + obj.toString());
        }
        ab.f19750d.put(str, obj);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onLogin: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onLogin called --> account is " + str);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.27
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("action", FirebaseAnalytics.Event.LOGIN);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TDAccount.AccountType accountType, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onRegister: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onRegister called --> account is " + str + " ，type is " + accountType + " , name is " + str2);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.28
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        if (accountType != null) {
                            aVar2.paraMap.put("type", accountType.name());
                        }
                        if (str2 != null) {
                            aVar2.paraMap.put("name", str2);
                        }
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TDAccount.AccountType accountType, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onLogin: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onLogin called --> account is " + str + " ，type is " + accountType);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("action", FirebaseAnalytics.Event.LOGIN);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        if (accountType != null) {
                            aVar2.paraMap.put("type", accountType.name());
                        }
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                m.eForDeveloper("onRegister: account could not be null or empty");
                return;
            }
            m.iForDeveloper("onRegister called --> account is " + str + " invitationCode: " + str2);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        aVar2.paraMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        aVar2.paraMap.put("invitationCode", str2);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i2, final int i3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            m.iForDeveloper("onAddItemToShoppingCart called --> itemId: " + str + " ,category: " + str2 + " ,name: " + str3 + " ,unitPrice: " + i2 + " ,amount: " + i3);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                        aVar2.paraMap.put("action", "addItem");
                        aVar2.paraMap.put("service", aVar);
                        TreeMap treeMap = new TreeMap();
                        if (aVar.name().equals("APP") || aVar.name().equals("FINTECH")) {
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("id", str);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                treeMap.put("category", str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                treeMap.put("name", str3);
                            }
                            treeMap.put("unitPrice", Integer.valueOf(i2));
                            treeMap.put("count", Integer.valueOf(i3));
                        } else {
                            treeMap.put("id", str);
                            treeMap.put("category", str2);
                            treeMap.put("name", str3);
                            treeMap.put("unitPrice", Integer.valueOf(i2));
                            treeMap.put("count", Integer.valueOf(i3));
                        }
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i2, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                m.iForDeveloper("onOrderPaySucc called --> account: " + str + " ,orderid: " + str2 + " ,amount: " + i2 + " ,currencyType: " + str3 + " ,payType: " + str4);
                if (str3.trim().length() != 3) {
                    m.eForDeveloper("currencyType length must be 3 likes CNY so so");
                    return;
                } else {
                    af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.10
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                                aVar2.paraMap.put("action", "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i2));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
            }
            m.eForDeveloper("onOrderPaySucc: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i2, final String str3, final String str4, final String str5, final int i3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                m.iForDeveloper("onPay called --> account: " + str + " ,orderid: " + str2 + " ,amount: " + i2 + " ,currencyType: " + str3 + " ,payType: " + str4 + " ,itemId: " + str5 + " ,itemCount: " + i3);
                if (str3.trim().length() != 3) {
                    m.eForDeveloper("currencyType length must be 3 likes CNY so so");
                    return;
                } else {
                    af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.13
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                                aVar2.paraMap.put("action", "currencyPurchase");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i2));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                treeMap.put("itemId", str5);
                                treeMap.put("itemCount", Integer.valueOf(i3));
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
            }
            m.eForDeveloper("onPay: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i2, final String str3, final String str4, final Order order, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (order == null) {
                    m.eForDeveloper("onPay: order could not be null");
                    return;
                }
                m.iForDeveloper("onPay called --> account: " + str + " ,orderid: " + str2 + " ,amount: " + i2 + " ,currencyType: " + str3 + " ,payType: " + str4 + " ,order: " + order.toString());
                if (str3.trim().length() != 3) {
                    m.eForDeveloper("currencyType length must be 3 likes CNY so so");
                    return;
                } else {
                    af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.15
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                                aVar2.paraMap.put("action", "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i2));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("orderId", order.getString(Order.keyOrderId));
                                jSONObject.put("amount", order.getInt(Order.keyTotalPrice));
                                jSONObject.put("currencyType", order.getString(Order.keyCurrencyType));
                                if (order.has(Order.keyOrderDetail) && (jSONArray = order.getJSONArray(Order.keyOrderDetail)) != null && jSONArray.length() > 0) {
                                    jSONObject.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
                                }
                                treeMap.put("order", jSONObject);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
            }
            m.eForDeveloper("onPay: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final Order order, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (order != null && !order.optString(Order.keyOrderId).isEmpty()) {
                    m.iForDeveloper("onPay called --> account: " + str + " ,payType: " + str2 + " ,order: " + order.toString());
                    af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.16
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                                aVar2.paraMap.put("action", "pay");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                                if (aVar.name().equals("APP") || aVar.name().equals("FINTECH")) {
                                    treeMap.put("orderId", order.getString(Order.keyOrderId));
                                    if (!TextUtils.isEmpty(str2)) {
                                        treeMap.put("payType", str2);
                                    }
                                    treeMap.put("amount", Integer.valueOf(order.optInt(Order.keyTotalPrice)));
                                    String strOptString = order.optString(Order.keyCurrencyType);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = "CNY";
                                    }
                                    treeMap.put("currencyType", strOptString);
                                } else {
                                    treeMap.put("payType", str2);
                                    treeMap.put("orderId", order.getString(Order.keyOrderId));
                                    treeMap.put("amount", Integer.valueOf(order.optInt(Order.keyTotalPrice)));
                                    treeMap.put("currencyType", order.optString(Order.keyCurrencyType));
                                }
                                if (order.has(Order.keyOrderDetail) && (jSONArray = order.getJSONArray(Order.keyOrderDetail)) != null && jSONArray.length() > 0) {
                                    treeMap.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
                                }
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                m.eForDeveloper("onPay: order or orderID could not be null or empty");
                return;
            }
            m.eForDeveloper("onPay: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final Order order, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (order != null && !order.optString(Order.keyOrderId).isEmpty()) {
                    m.iForDeveloper("onPlaceOrder called --> account: " + str + " ,order: " + order.toString());
                    af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.17
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                                aVar2.paraMap.put("action", "placeOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                                treeMap.put("orderId", order.getString(Order.keyOrderId));
                                treeMap.put("amount", Integer.valueOf(order.optInt(Order.keyTotalPrice)));
                                if (aVar.name().equals("TRACKING")) {
                                    treeMap.put("currencyType", order.optString(Order.keyCurrencyType));
                                } else if (aVar.name().equals("APP") || aVar.name().equals("FINTECH")) {
                                    String strOptString = order.optString(Order.keyCurrencyType);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = "CNY";
                                    }
                                    treeMap.put("currencyType", strOptString);
                                }
                                if (order.has(Order.keyOrderDetail) && (jSONArray = order.getJSONArray(Order.keyOrderDetail)) != null && jSONArray.length() > 0) {
                                    treeMap.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
                                }
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                m.eForDeveloper("onPlaceOrder: order or orderID could not be null or empty");
                return;
            }
            m.eForDeveloper("onPlaceOrder: account could not be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            m.iForDeveloper("onViewItem called --> itemId: " + str + " ,category: " + str2 + " ,name: " + str3 + " ,unitPrice: " + i2);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.18
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                        aVar2.paraMap.put("action", "viewItem");
                        TreeMap treeMap = new TreeMap();
                        if (aVar.name().equals("APP") || aVar.name().equals("FINTECH")) {
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("id", str);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                treeMap.put("category", str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                treeMap.put("name", str3);
                            }
                            treeMap.put("unitPrice", Integer.valueOf(i2));
                        } else {
                            treeMap.put("id", str);
                            treeMap.put("category", str2);
                            treeMap.put("name", str3);
                            treeMap.put("unitPrice", Integer.valueOf(i2));
                        }
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final ShoppingCart shoppingCart, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            m.iForDeveloper("onViewShoppingCart called --> shoppingCart: " + shoppingCart);
            if (shoppingCart != null && shoppingCart.length() > 0) {
                af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.19
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", InAppPurchaseMetaData.IAP_KEY);
                            aVar2.paraMap.put("action", "viewItems");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put(FirebaseAnalytics.Param.ITEMS, shoppingCart);
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            m.eForDeveloper("viewShoppingCart# shoppingCart can't be null or empty");
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void a(final Context context) {
        if (af.a(14)) {
            Application application = null;
            try {
                if (ab.g instanceof Activity) {
                    application = ((Activity) ab.g).getApplication();
                } else if (ab.g instanceof Application) {
                    application = (Application) ab.g;
                }
                if (application == null || j) {
                    return;
                }
                f20078e = new b();
                application.registerActivityLifecycleCallbacks(f20078e);
                j = true;
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            af.a(Class.forName("android.app.ActivityManagerNative"), new z() { // from class: com.tendcloud.tenddata.zz.20
                @Override // com.tendcloud.tenddata.z
                public void afterMethodInvoked(Object obj, Method method, Object[] objArr, Object obj2) {
                }

                @Override // com.tendcloud.tenddata.z
                public void beforeMethodInvoke(Object obj, Method method, Object[] objArr) {
                    String name = method.getName();
                    if (context instanceof Activity) {
                        if (name.equalsIgnoreCase("activityPaused")) {
                            c.b((Activity) context, com.tendcloud.tenddata.a.APP);
                        } else if (name.equalsIgnoreCase("activityIdle")) {
                            c.a((Activity) context, com.tendcloud.tenddata.a.APP);
                        }
                    }
                }
            }, "gDefault", "android.app.IActivityManager");
            j = true;
        } catch (Throwable th) {
            m.eForDeveloper("registerActivityLifecycleListener " + th.getMessage());
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f20075b) {
                m.eForDeveloper("SDK have not been initialized");
                return;
            }
            m.iForDeveloper("onCreateCard called --> accountId: " + str + " method: " + str2 + "  content: " + str3);
            af.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.21
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", GameSharedConstant.ACCOUNT);
                        aVar2.paraMap.put("action", "card");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                        treeMap.put(FirebaseAnalytics.Param.METHOD, str2);
                        treeMap.put("content", str3);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }
}
