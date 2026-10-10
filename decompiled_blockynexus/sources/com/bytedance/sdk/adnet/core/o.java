package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: VNetLog.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5545b = "VNetLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5544a = Log.isLoggable(f5545b, 2);

    public static void a(String str, Object... objArr) {
        if (f5544a) {
            Log.v(f5545b, e(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f5545b, e(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f5545b, e(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f5545b, e(str, objArr));
    }

    private static String e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + Consts.DOT + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f5545b, e(str, objArr), th);
    }

    /* JADX INFO: compiled from: VNetLog.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f5546a = o.f5544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<C0071a> f5547b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5548c = false;

        /* JADX INFO: renamed from: com.bytedance.sdk.adnet.core.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VNetLog.java */
        private static class C0071a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f5549a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f5550b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f5551c;

            public C0071a(String str, long j, long j2) {
                this.f5549a = str;
                this.f5550b = j;
                this.f5551c = j2;
            }
        }

        a() {
        }

        public synchronized void a(String str, long j) {
            if (this.f5548c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f5547b.add(new C0071a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() throws Throwable {
            if (this.f5548c) {
                return;
            }
            a("Request on the loose");
            o.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.f5548c = true;
            long jA = a();
            if (jA <= 0) {
                return;
            }
            long j = this.f5547b.get(0).f5551c;
            o.b("(%-4d ms) %s", Long.valueOf(jA), str);
            for (C0071a c0071a : this.f5547b) {
                long j2 = c0071a.f5551c;
                o.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0071a.f5550b), c0071a.f5549a);
                j = j2;
            }
        }

        private long a() {
            if (this.f5547b.size() == 0) {
                return 0L;
            }
            return this.f5547b.get(r2.size() - 1).f5551c - this.f5547b.get(0).f5551c;
        }
    }
}
