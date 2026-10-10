package c.t.m.g;

import c.t.m.g.ec;

/* JADX INFO: renamed from: c.t.m.g.qb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0459qb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ ec f3355a;

    RunnableC0459qb(ec ecVar) {
        this.f3355a = ecVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3355a.Q = ec.b.f3163b;
            ec ecVar = this.f3355a;
            C0423eb unused = this.f3355a.w;
            ecVar.a(C0423eb.f().getLooper());
        } catch (Throwable unused2) {
        }
    }
}
