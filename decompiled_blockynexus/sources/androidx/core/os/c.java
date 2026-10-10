package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TraceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f1190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f1191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f1192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f1193e;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 18 || i >= 29) {
            return;
        }
        try {
            f1189a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            f1190b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            f1191c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            f1192d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            f1193e = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception e2) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
