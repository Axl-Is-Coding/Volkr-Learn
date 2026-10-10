package com.squareup.picasso;

/* JADX INFO: renamed from: com.squareup.picasso.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2753h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f19287a;

    RunnableC2753h(L l) {
        this.f19287a = l;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new IllegalStateException("Transformation " + this.f19287a.a() + " mutated input Bitmap but failed to recycle the original.");
    }
}
