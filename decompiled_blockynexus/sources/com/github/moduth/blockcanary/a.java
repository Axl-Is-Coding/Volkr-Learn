package com.github.moduth.blockcanary;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: BlockCanary.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f12524a;

    private a() {
    }

    public static a a(Context context, b bVar) {
        b.a(context, bVar);
        return a();
    }

    public void b() {
        Log.i("BlockCanary-no-op", "start");
    }

    public static a a() {
        if (f12524a == null) {
            synchronized (a.class) {
                if (f12524a == null) {
                    f12524a = new a();
                }
            }
        }
        return f12524a;
    }
}
