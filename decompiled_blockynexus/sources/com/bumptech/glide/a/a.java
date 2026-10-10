package com.bumptech.glide.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f4082a;

    a(b bVar) {
        this.f4082a = bVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        synchronized (this.f4082a) {
            if (this.f4082a.i == null) {
                return null;
            }
            this.f4082a.r();
            if (this.f4082a.g()) {
                this.f4082a.q();
                this.f4082a.k = 0;
            }
            return null;
        }
    }
}
