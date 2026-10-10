package com.bumptech.glide.load.engine.c;

import android.os.Process;
import android.os.StrictMode;
import com.bumptech.glide.load.engine.c.a;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.b f4554a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(a.b bVar, Runnable runnable, String str) {
        super(runnable, str);
        this.f4554a = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(9);
        if (this.f4554a.f4548c) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            this.f4554a.f4547b.a(th);
        }
    }
}
