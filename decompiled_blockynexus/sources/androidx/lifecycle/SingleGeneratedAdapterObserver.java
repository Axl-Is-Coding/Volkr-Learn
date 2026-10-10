package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
class SingleGeneratedAdapterObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1595a;

    SingleGeneratedAdapterObserver(c cVar) {
        this.f1595a = cVar;
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        this.f1595a.a(gVar, event, false, null);
        this.f1595a.a(gVar, event, true, null);
    }
}
