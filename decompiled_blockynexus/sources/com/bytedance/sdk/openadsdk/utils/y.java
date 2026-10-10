package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.umeng.analytics.pro.au;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TTCrashHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class y implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7144a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7145b;

    private y() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    public static y a() {
        return new y();
    }

    private void b() {
        File externalFilesDir;
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        if (contextA == null) {
            return;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = contextA.getExternalFilesDir("TTCache")) != null) {
                externalFilesDir.mkdirs();
                this.f7145b = externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.f7145b)) {
                File file = new File(contextA.getFilesDir(), "TTCache");
                file.mkdirs();
                this.f7145b = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    private void c() {
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC2Proxy", au.at, Context.class);
            if (methodA != null) {
                methodA.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
            }
        } catch (Throwable unused) {
        }
        try {
            Method methodA2 = z.a("com.bytedance.sdk.openadsdk.TTC3Proxy", au.at, Context.class);
            if (methodA2 != null) {
                methodA2.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.g.f.a();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
        } catch (Throwable unused4) {
        }
        try {
            String strB = com.bytedance.sdk.adnet.a.b(com.bytedance.sdk.openadsdk.core.o.a());
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            File file = new File(strB);
            if (file.exists()) {
                i.c(file);
            }
        } catch (Throwable unused5) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        boolean zContains = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null) {
                zContains = string.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (zContains) {
            a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7144a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.Thread r19, java.lang.Throwable r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.y.a(java.lang.Thread, java.lang.Throwable):void");
    }
}
