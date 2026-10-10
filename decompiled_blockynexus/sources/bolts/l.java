package bolts;

/* JADX INFO: Add missing generic type declarations: [TContinuationResult, TResult] */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
class l<TContinuationResult, TResult> implements i<TResult, p<TContinuationResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f2843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f2844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f2845c;

    l(p pVar, h hVar, i iVar) {
        this.f2845c = pVar;
        this.f2843a = hVar;
        this.f2844b = iVar;
    }

    @Override // bolts.i
    public p<TContinuationResult> then(p<TResult> pVar) {
        h hVar = this.f2843a;
        if (hVar == null) {
            return pVar.h() ? p.a(pVar.c()) : pVar.f() ? p.a() : pVar.a((i) this.f2844b);
        }
        hVar.a();
        throw null;
    }
}
