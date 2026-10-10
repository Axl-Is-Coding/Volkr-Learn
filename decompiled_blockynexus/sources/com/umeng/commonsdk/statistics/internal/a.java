package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: HeaderHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f21245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f21246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f21247c;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderHelper.java */
    private static class C0185a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f21248a = new a();

        private C0185a() {
        }
    }

    public static a a(Context context) {
        if (f21245a == null && context != null) {
            f21245a = context.getApplicationContext();
        }
        return C0185a.f21248a;
    }

    private void e(String str) {
        try {
            this.f21246b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f21245a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f21245a, th);
        }
    }

    private void f(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(au.aF);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith("=")) {
                        strSubstring = strSubstring.replace("=", "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.f21247c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f21245a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(au.az);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("z");
    }

    public void d(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        f(strSubstring);
        e(strSubstring);
    }

    private a() {
        this.f21246b = null;
        this.f21247c = null;
    }

    public String b() {
        return this.f21246b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(au.at);
    }

    public String a() {
        return this.f21247c;
    }
}
