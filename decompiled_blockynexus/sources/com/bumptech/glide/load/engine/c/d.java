package com.bumptech.glide.load.engine.c;

import android.util.Log;
import com.bumptech.glide.load.engine.c.a;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class d implements a.c {
    d() {
    }

    @Override // com.bumptech.glide.load.engine.c.a.c
    public void a(Throwable th) {
        if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
            return;
        }
        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
    }
}
