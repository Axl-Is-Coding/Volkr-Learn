package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes5.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static al f20644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f20645b;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            if (f20644a != null) {
                try {
                    return f20644a.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b(Context context) {
        if (f20644a != null || f20645b) {
            return;
        }
        synchronized (am.class) {
            if (f20644a == null && !f20645b) {
                f20644a = an.a(context);
                f20645b = true;
            }
        }
    }
}
