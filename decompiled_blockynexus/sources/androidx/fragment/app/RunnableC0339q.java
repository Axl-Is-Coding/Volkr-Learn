package androidx.fragment.app;

/* JADX INFO: renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0339q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f1518a;

    RunnableC0339q(r rVar) {
        this.f1518a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1518a.f1520b.getAnimatingAway() != null) {
            this.f1518a.f1520b.setAnimatingAway(null);
            r rVar = this.f1518a;
            LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = rVar.f1521c;
            Fragment fragment = rVar.f1520b;
            layoutInflaterFactory2C0343v.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
