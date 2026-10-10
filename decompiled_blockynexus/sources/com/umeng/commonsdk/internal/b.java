package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: UMInternalData.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f21092b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f21093a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f21094c;

    private b(Context context) {
        this.f21093a = context;
        this.f21094c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (f21092b == null) {
            f21092b = new b(context.getApplicationContext());
        }
        return f21092b;
    }

    public c a() {
        return this.f21094c;
    }
}
