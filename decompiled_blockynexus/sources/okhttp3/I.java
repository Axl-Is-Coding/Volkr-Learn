package okhttp3;

import okio.BufferedSource;

/* JADX INFO: compiled from: ResponseBody.java */
/* JADX INFO: loaded from: classes5.dex */
class I extends J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f23045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f23046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BufferedSource f23047c;

    I(w wVar, long j, BufferedSource bufferedSource) {
        this.f23045a = wVar;
        this.f23046b = j;
        this.f23047c = bufferedSource;
    }

    @Override // okhttp3.J
    public long contentLength() {
        return this.f23046b;
    }

    @Override // okhttp3.J
    public w contentType() {
        return this.f23045a;
    }

    @Override // okhttp3.J
    public BufferedSource source() {
        return this.f23047c;
    }
}
