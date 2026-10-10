package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f12987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f12990d;

    private h(m mVar, com.google.android.datatransport.runtime.q qVar, int i, Runnable runnable) {
        this.f12987a = mVar;
        this.f12988b = qVar;
        this.f12989c = i;
        this.f12990d = runnable;
    }

    public static Runnable a(m mVar, com.google.android.datatransport.runtime.q qVar, int i, Runnable runnable) {
        return new h(mVar, qVar, i, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(this.f12987a, this.f12988b, this.f12989c, this.f12990d);
    }
}
