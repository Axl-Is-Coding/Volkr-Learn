package okhttp3;

import okio.AsyncTimeout;

/* JADX INFO: compiled from: RealCall.java */
/* JADX INFO: loaded from: classes5.dex */
class A extends AsyncTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f22998a;

    A(B b2) {
        this.f22998a = b2;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        this.f22998a.cancel();
    }
}
