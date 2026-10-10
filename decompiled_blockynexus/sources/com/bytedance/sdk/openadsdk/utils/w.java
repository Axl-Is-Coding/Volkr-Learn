package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: compiled from: SimUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7139a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7140b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7141c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7142d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7143e = true;

    public static String a() {
        if (!f7139a) {
            d();
        }
        return f7140b;
    }

    public static String b() {
        try {
            if (!f7139a) {
                d();
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.o.a().getResources().getConfiguration();
            String strValueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : f7141c;
            o.e("MCC", "config=" + configuration.mcc + ",sMCC=" + f7141c);
            if (f7143e) {
                return strValueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(f7143e ? "有SIM卡" : "无SIM卡,MCC返回null");
            o.e("MCC", sb.toString());
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c() {
        if (!f7139a) {
            d();
        }
        return f7142d;
    }

    private static void d() {
        String simOperatorName;
        String simOperator;
        String strSubstring;
        if (com.bytedance.sdk.openadsdk.core.o.a() == null || f7139a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0 || simState == 1) {
                    f7143e = false;
                }
                o.e("MCC", f7143e ? "有SIM卡" : "无SIM卡");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            String strSubstring2 = null;
            try {
                simOperatorName = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                simOperatorName = null;
            }
            try {
                simOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                simOperator = null;
            }
            if (simOperator == null || simOperator.length() < 5) {
                try {
                    simOperator = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = simOperator.substring(0, 3);
                strSubstring = simOperator.substring(3);
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                f7140b = simOperatorName;
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                f7141c = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                f7142d = strSubstring;
            }
        } catch (Throwable unused4) {
        }
        f7139a = true;
    }
}
