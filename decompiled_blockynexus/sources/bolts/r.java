package bolts;

import bolts.p;

/* JADX INFO: compiled from: UnobservedErrorNotifier.java */
/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p<?> f2863a;

    public r(p<?> pVar) {
        this.f2863a = pVar;
    }

    public void a() {
        this.f2863a = null;
    }

    protected void finalize() throws Throwable {
        p.b bVarE;
        try {
            p<?> pVar = this.f2863a;
            if (pVar != null && (bVarE = p.e()) != null) {
                bVarE.a(pVar, new UnobservedTaskException(pVar.c()));
            }
        } finally {
            super.finalize();
        }
    }
}
