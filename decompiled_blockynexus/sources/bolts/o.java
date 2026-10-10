package bolts;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f2851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f2852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f2853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f2854d;

    o(h hVar, q qVar, i iVar, p pVar) {
        this.f2851a = hVar;
        this.f2852b = qVar;
        this.f2853c = iVar;
        this.f2854d = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = this.f2851a;
        if (hVar != null) {
            hVar.a();
            throw null;
        }
        try {
            p pVar = (p) this.f2853c.then(this.f2854d);
            if (pVar == null) {
                this.f2852b.a((Object) null);
            } else {
                pVar.a((i) new n(this));
            }
        } catch (CancellationException unused) {
            this.f2852b.b();
        } catch (Exception e2) {
            this.f2852b.a(e2);
        }
    }
}
