package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c[] f1573a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f1573a = cVarArr;
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        l lVar = new l();
        for (c cVar : this.f1573a) {
            cVar.a(gVar, event, false, lVar);
        }
        for (c cVar2 : this.f1573a) {
            cVar2.a(gVar, event, true, lVar);
        }
    }
}
