package com.bumptech.glide;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f4209a;

    j(k kVar) {
        this.f4209a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar = this.f4209a;
        kVar.lifecycle.b(kVar);
    }
}
