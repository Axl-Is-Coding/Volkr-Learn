package bolts;

import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
class k<TResult> implements i<TResult, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f2838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f2839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Executor f2840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f2841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ p f2842e;

    k(p pVar, q qVar, i iVar, Executor executor, h hVar) {
        this.f2842e = pVar;
        this.f2838a = qVar;
        this.f2839b = iVar;
        this.f2840c = executor;
        this.f2841d = hVar;
    }

    @Override // bolts.i
    public Void then(p<TResult> pVar) {
        p.c(this.f2838a, this.f2839b, pVar, this.f2840c, this.f2841d);
        return null;
    }
}
