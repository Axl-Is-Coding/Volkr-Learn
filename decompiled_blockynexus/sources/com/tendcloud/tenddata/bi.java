package com.tendcloud.tenddata;

import android.util.Log;
import com.tendcloud.tenddata.zz;
import java.lang.Thread;
import java.util.HashMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bi f19859a;

    /* JADX INFO: compiled from: td */
    static class a implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler appDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (ab.f19751e) {
                bi.a(th, String.valueOf(System.currentTimeMillis()), com.tendcloud.tenddata.a.APP, true);
                Log.w(ab.u, "UncaughtException in Thread " + thread.getName(), th);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.appDefaultHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bi() {
        b();
    }

    public static bi a() {
        if (f19859a == null) {
            synchronized (bi.class) {
                if (f19859a == null) {
                    f19859a = new bi();
                }
            }
        }
        return f19859a;
    }

    private static void b() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new a());
        } catch (Throwable unused) {
        }
    }

    public final void onTDEBEventError(zz.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.paraMap != null && Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) == 3) {
                    a(aVar.paraMap);
                }
            } catch (Throwable unused) {
            }
        }
    }

    void a(HashMap<String, Object> map) {
        try {
            com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) map.get("service");
            if (map.containsKey("throwable") && map.containsKey("occurTime")) {
                a((Throwable) map.get("throwable"), String.valueOf(map.get("occurTime")), aVar, false);
            }
        } catch (Throwable unused) {
        }
    }

    static void a(Throwable th, String str, com.tendcloud.tenddata.a aVar, boolean z) {
        if (ab.g == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = str.trim().isEmpty() ? System.currentTimeMillis() : Long.parseLong(str);
            if (z && ab.F) {
                n.c(jCurrentTimeMillis, aVar);
            }
        } catch (Throwable unused) {
        }
        Throwable cause = th;
        while (cause.getCause() != null) {
            try {
                cause = cause.getCause();
            } catch (Throwable unused2) {
                return;
            }
        }
        StackTraceElement[] stackTrace = cause.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(cause.getClass().getName());
        sb.append(":");
        String packageName = ab.g.getPackageName();
        int i = 0;
        for (int i2 = 0; i < 3 && i2 < stackTrace.length; i2++) {
            String className = stackTrace[i2].getClassName();
            if ((!className.startsWith("java.") || packageName.startsWith("java.")) && ((!className.startsWith("javax.") || packageName.startsWith("javax.")) && ((!className.startsWith("android.") || packageName.startsWith("android.")) && (!className.startsWith("com.android.") || packageName.startsWith("com.android."))))) {
                sb.append(stackTrace[i2].toString());
                sb.append(":");
                i++;
            }
        }
        bx bxVar = new bx();
        bxVar.f19906b = "apm";
        bxVar.f19907c = "error";
        TreeMap treeMap = new TreeMap();
        treeMap.put("msg", a(th));
        treeMap.put("type", cause.getClass().getName());
        bxVar.f19908d = treeMap;
        bxVar.f19905a = com.tendcloud.tenddata.a.APP;
        ag.a().post(bxVar);
    }

    private static final String a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString());
        sb.append("\r\n");
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = 50;
            if (stackTrace.length <= 50) {
                length = stackTrace.length;
            }
            for (int i = 0; i < length; i++) {
                sb.append("\tat ");
                sb.append(stackTrace[i]);
                sb.append("\r\n");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(sb, stackTrace, cause, 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static final void a(StringBuilder sb, StackTraceElement[] stackTraceElementArr, Throwable th, int i) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length - 1;
            for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementArr[length2]); length2--) {
                length--;
            }
            int i2 = 50;
            if (length <= 50) {
                i2 = length;
            }
            sb.append("Caused by : ");
            sb.append(th);
            sb.append("\r\n");
            for (int i3 = 0; i3 <= i2; i3++) {
                sb.append("\t");
                sb.append(stackTrace[i3]);
                sb.append("\r\n");
            }
            if (i < 5 && th.getCause() != null) {
                a(sb, stackTrace, th, i + 1);
            }
        } catch (Throwable unused) {
        }
    }
}
