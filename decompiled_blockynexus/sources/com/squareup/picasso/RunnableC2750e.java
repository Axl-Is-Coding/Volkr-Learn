package com.squareup.picasso;

/* JADX INFO: renamed from: com.squareup.picasso.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2750e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f19283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RuntimeException f19284b;

    RunnableC2750e(L l, RuntimeException runtimeException) {
        this.f19283a = l;
        this.f19284b = runtimeException;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException("Transformation " + this.f19283a.a() + " crashed with exception.", this.f19284b);
    }
}
