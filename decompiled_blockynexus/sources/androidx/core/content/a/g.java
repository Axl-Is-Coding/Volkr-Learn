package androidx.core.content.a;

import androidx.core.content.a.h;

/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h.a f1058b;

    g(h.a aVar, int i) {
        this.f1058b = aVar;
        this.f1057a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1058b.a(this.f1057a);
    }
}
