package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: VolleyLog.java */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4028a = "Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4029b = Log.isLoggable(f4028a, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4030c = p.class.getName();

    public static void a(String str, Object... objArr) {
        Log.d(f4028a, e(str, objArr));
    }

    public static void b(String str, Object... objArr) {
        Log.e(f4028a, e(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        if (f4029b) {
            Log.v(f4028a, e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f4028a, e(str, objArr));
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
            if (!stackTrace[i].getClassName().equals(f4030c)) {
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
        Log.e(f4028a, e(str, objArr), th);
    }

    /* JADX INFO: compiled from: VolleyLog.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f4031a = p.f4029b;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<C0050a> f4032b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4033c = false;

        /* JADX INFO: renamed from: com.android.volley.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VolleyLog.java */
        private static class C0050a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f4034a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f4035b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f4036c;

            public C0050a(String str, long j, long j2) {
                this.f4034a = str;
                this.f4035b = j;
                this.f4036c = j2;
            }
        }

        a() {
        }

        public synchronized void a(String str, long j) {
            if (this.f4033c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f4032b.add(new C0050a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() throws Throwable {
            if (this.f4033c) {
                return;
            }
            a("Request on the loose");
            p.b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.f4033c = true;
            long jA = a();
            if (jA <= 0) {
                return;
            }
            long j = this.f4032b.get(0).f4036c;
            p.a("(%-4d ms) %s", Long.valueOf(jA), str);
            for (C0050a c0050a : this.f4032b) {
                long j2 = c0050a.f4036c;
                p.a("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0050a.f4035b), c0050a.f4034a);
                j = j2;
            }
        }

        private long a() {
            if (this.f4032b.size() == 0) {
                return 0L;
            }
            return this.f4032b.get(r2.size() - 1).f4036c - this.f4032b.get(0).f4036c;
        }
    }
}
