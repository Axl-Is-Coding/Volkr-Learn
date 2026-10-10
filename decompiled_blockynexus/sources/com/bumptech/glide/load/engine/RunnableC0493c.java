package com.bumptech.glide.load.engine;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0493c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActiveResources f4536a;

    RunnableC0493c(ActiveResources activeResources) {
        this.f4536a = activeResources;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4536a.a();
    }
}
