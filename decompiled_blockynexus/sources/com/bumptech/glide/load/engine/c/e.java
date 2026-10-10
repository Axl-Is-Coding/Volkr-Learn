package com.bumptech.glide.load.engine.c;

import com.bumptech.glide.load.engine.c.a;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class e implements a.c {
    e() {
    }

    @Override // com.bumptech.glide.load.engine.c.a.c
    public void a(Throwable th) {
        if (th != null) {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
