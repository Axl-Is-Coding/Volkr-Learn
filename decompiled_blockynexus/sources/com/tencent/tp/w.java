package com.tencent.tp;

import android.content.Context;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes5.dex */
public class w {
    private static void a(Context context, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        new x(context, z, z2, z3, z4, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void a(boolean z, boolean z2, boolean z3, boolean z4, String str) {
        Context contextC = v.c();
        if (contextC != null) {
            a(contextC, z, z2, z3, z4, str);
        }
    }
}
