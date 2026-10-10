package com.android.volley.toolbox;

import android.os.Looper;

/* JADX INFO: compiled from: Threads.java */
/* JADX INFO: loaded from: classes.dex */
final class r {
    static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }
}
