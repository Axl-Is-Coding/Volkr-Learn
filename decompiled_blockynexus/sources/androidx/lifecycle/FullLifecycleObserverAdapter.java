package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f1575b;

    FullLifecycleObserverAdapter(a aVar, e eVar) {
        this.f1574a = aVar;
        this.f1575b = eVar;
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        switch (b.f1596a[event.ordinal()]) {
            case 1:
                this.f1574a.a(gVar);
                break;
            case 2:
                this.f1574a.f(gVar);
                break;
            case 3:
                this.f1574a.b(gVar);
                break;
            case 4:
                this.f1574a.c(gVar);
                break;
            case 5:
                this.f1574a.d(gVar);
                break;
            case 6:
                this.f1574a.e(gVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f1575b;
        if (eVar != null) {
            eVar.a(gVar, event);
        }
    }
}
