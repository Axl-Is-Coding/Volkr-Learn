package bolts;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f2846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f2847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f2848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f2849d;

    m(h hVar, q qVar, i iVar, p pVar) {
        this.f2846a = hVar;
        this.f2847b = qVar;
        this.f2848c = iVar;
        this.f2849d = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = this.f2846a;
        if (hVar != null) {
            hVar.a();
            throw null;
        }
        try {
            this.f2847b.a(this.f2848c.then(this.f2849d));
        } catch (CancellationException unused) {
            this.f2847b.b();
        } catch (Exception e2) {
            this.f2847b.a(e2);
        }
    }
}
