package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.g;
import java.io.File;

/* JADX INFO: compiled from: UMSLNetWorkSender.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21126a = 273;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f21127b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HandlerThread f21128c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f21129d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f21131f = 512;
    private static IntentFilter g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f21130e = new Object();
    private static boolean h = false;
    private static g i = null;
    private static BroadcastReceiver j = new BroadcastReceiver() { // from class: com.umeng.commonsdk.stateless.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            if (context == null || intent == null) {
                return;
            }
            try {
                if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Context unused = d.f21127b = context.getApplicationContext();
                    if (d.f21127b != null && (connectivityManager = (ConnectivityManager) d.f21127b.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                            ULog.i("walle", "[stateless] net reveiver disconnected --->>>");
                            boolean unused2 = d.h = false;
                        } else {
                            boolean unused3 = d.h = true;
                            ULog.i("walle", "[stateless] net reveiver ok --->>>");
                            d.b(273);
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d A[Catch: all -> 0x0077, DONT_GENERATE, TryCatch #0 {, blocks: (B:5:0x0008, B:7:0x0012, B:9:0x0016, B:11:0x0028, B:12:0x0035, B:14:0x003f, B:16:0x0050, B:18:0x0062, B:24:0x007d, B:23:0x007a), top: B:28:0x0006, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public d(android.content.Context r7) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.Object r0 = com.umeng.commonsdk.stateless.d.f21130e
            monitor-enter(r0)
            if (r7 == 0) goto L7d
            android.content.Context r1 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            com.umeng.commonsdk.stateless.d.f21127b = r1     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.Context r1 = com.umeng.commonsdk.stateless.d.f21127b     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            if (r1 == 0) goto L7d
            android.os.HandlerThread r1 = com.umeng.commonsdk.stateless.d.f21128c     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            if (r1 != 0) goto L7d
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            java.lang.String r2 = "SL-NetWorkSender"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            com.umeng.commonsdk.stateless.d.f21128c = r1     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.os.HandlerThread r1 = com.umeng.commonsdk.stateless.d.f21128c     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            r1.start()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.os.Handler r1 = com.umeng.commonsdk.stateless.d.f21129d     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            if (r1 != 0) goto L35
            com.umeng.commonsdk.stateless.d$2 r1 = new com.umeng.commonsdk.stateless.d$2     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.os.HandlerThread r2 = com.umeng.commonsdk.stateless.d.f21128c     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            com.umeng.commonsdk.stateless.d.f21129d = r1     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
        L35:
            android.content.Context r1 = com.umeng.commonsdk.stateless.d.f21127b     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            if (r1 == 0) goto L7d
            java.lang.String r1 = "walle"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            java.lang.String r4 = "[stateless] begin register receiver"
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            com.umeng.commonsdk.statistics.common.ULog.i(r1, r3)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.IntentFilter r1 = com.umeng.commonsdk.stateless.d.g     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            if (r1 != 0) goto L7d
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            r1.<init>()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            com.umeng.commonsdk.stateless.d.g = r1     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.IntentFilter r1 = com.umeng.commonsdk.stateless.d.g     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.addAction(r3)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.BroadcastReceiver r1 = com.umeng.commonsdk.stateless.d.j     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            if (r1 == 0) goto L7d
            java.lang.String r1 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            java.lang.String r3 = "[stateless] register receiver ok"
            r2[r5] = r3     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            com.umeng.commonsdk.statistics.common.ULog.i(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.Context r1 = com.umeng.commonsdk.stateless.d.f21127b     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.BroadcastReceiver r2 = com.umeng.commonsdk.stateless.d.j     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            android.content.IntentFilter r3 = com.umeng.commonsdk.stateless.d.g     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            r1.registerReceiver(r2, r3)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
            goto L7d
        L77:
            r7 = move-exception
            goto L7f
        L79:
            r1 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r7, r1)     // Catch: java.lang.Throwable -> L77
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            return
        L7f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.<init>(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        Context context;
        if (!h || (context = f21127b) == null) {
            return;
        }
        try {
            File fileA = f.a(context);
            if (fileA == null || fileA.getParentFile() == null || TextUtils.isEmpty(fileA.getParentFile().getName())) {
                return;
            }
            e eVar = new e(f21127b);
            String str = new String(Base64.decode(fileA.getParentFile().getName(), 0));
            ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
            byte[] bArrA = null;
            try {
                bArrA = f.a(fileA.getAbsolutePath());
            } catch (Exception unused) {
            }
            if (!eVar.a(bArrA, str, com.umeng.commonsdk.vchannel.a.f21338c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f21336a : "")) {
                ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                return;
            }
            ULog.i("walle", "[stateless] Send envelope file success, delete it.");
            File file = new File(fileA.getAbsolutePath());
            if (!file.delete()) {
                ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                file.delete();
            }
            i = g.a(f21127b);
            if (i != null) {
                i.d();
            }
            b(273);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f21127b, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        if (g != null) {
            BroadcastReceiver broadcastReceiver = j;
            if (broadcastReceiver != null) {
                Context context = f21127b;
                if (context != null) {
                    context.unregisterReceiver(broadcastReceiver);
                }
                j = null;
            }
            g = null;
        }
        HandlerThread handlerThread = f21128c;
        if (handlerThread != null) {
            handlerThread.quit();
            if (f21128c != null) {
                f21128c = null;
            }
            if (f21129d != null) {
                f21129d = null;
            }
        }
    }

    public static void b(int i2) {
        try {
            if (!h || f21129d == null || f21129d.hasMessages(i2)) {
                return;
            }
            ULog.i("walle", "[stateless] sendMsgOnce !!!!");
            Message messageObtainMessage = f21129d.obtainMessage();
            messageObtainMessage.what = i2;
            f21129d.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f21127b, th);
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!h || (handler = f21129d) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        f21129d.sendMessage(messageObtainMessage);
    }

    public static void a() {
        b(512);
    }
}
