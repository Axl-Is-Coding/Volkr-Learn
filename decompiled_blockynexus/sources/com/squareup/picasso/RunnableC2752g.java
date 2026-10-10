package com.squareup.picasso;

/* JADX INFO: renamed from: com.squareup.picasso.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2752g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f19286a;

    RunnableC2752g(L l) {
        this.f19286a = l;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new IllegalStateException("Transformation " + this.f19286a.a() + " returned input Bitmap but recycled it.");
    }
}
