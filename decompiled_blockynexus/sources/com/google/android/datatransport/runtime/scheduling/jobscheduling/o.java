package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* JADX INFO: compiled from: WorkInitializer.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f13014a;

    private o(q qVar) {
        this.f13014a = qVar;
    }

    public static Runnable a(q qVar) {
        return new o(qVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        q qVar = this.f13014a;
        qVar.f13019d.a(p.a(qVar));
    }
}
