package androidx.core.app;

import androidx.core.app.g;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g.a f969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f970b;

    d(g.a aVar, Object obj) {
        this.f969a = aVar;
        this.f970b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f969a.f981a = this.f970b;
    }
}
