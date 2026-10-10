package com.squareup.picasso;

/* JADX INFO: renamed from: com.squareup.picasso.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2751f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StringBuilder f19285a;

    RunnableC2751f(StringBuilder sb) {
        this.f19285a = sb;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new NullPointerException(this.f19285a.toString());
    }
}
