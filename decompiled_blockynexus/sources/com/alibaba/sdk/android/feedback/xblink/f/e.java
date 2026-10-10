package com.alibaba.sdk.android.feedback.xblink.f;

/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f3849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f3851c;

    e(d dVar, f fVar, String str) {
        this.f3851c = dVar;
        this.f3849a = fVar;
        this.f3850b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3851c.a(this.f3849a, this.f3850b);
    }
}
