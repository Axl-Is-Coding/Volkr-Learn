package bolts;

import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
class j<TResult> implements i<TResult, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f2833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f2834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Executor f2835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f2836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ p f2837e;

    j(p pVar, q qVar, i iVar, Executor executor, h hVar) {
        this.f2837e = pVar;
        this.f2833a = qVar;
        this.f2834b = iVar;
        this.f2835c = executor;
        this.f2836d = hVar;
    }

    @Override // bolts.i
    public Void then(p<TResult> pVar) {
        p.d(this.f2833a, this.f2834b, pVar, this.f2835c, this.f2836d);
        return null;
    }
}
