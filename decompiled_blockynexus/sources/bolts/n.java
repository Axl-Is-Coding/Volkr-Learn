package bolts;

/* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
class n<TContinuationResult> implements i<TContinuationResult, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f2850a;

    n(o oVar) {
        this.f2850a = oVar;
    }

    @Override // bolts.i
    public Void then(p<TContinuationResult> pVar) {
        h hVar = this.f2850a.f2851a;
        if (hVar != null) {
            hVar.a();
            throw null;
        }
        if (pVar.f()) {
            this.f2850a.f2852b.b();
        } else if (pVar.h()) {
            this.f2850a.f2852b.a(pVar.c());
        } else {
            this.f2850a.f2852b.a(pVar.d());
        }
        return null;
    }
}
