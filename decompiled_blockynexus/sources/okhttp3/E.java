package okhttp3;

import java.io.IOException;
import okio.BufferedSink;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes5.dex */
class E extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f23026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ byte[] f23028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f23029d;

    E(w wVar, int i, byte[] bArr, int i2) {
        this.f23026a = wVar;
        this.f23027b = i;
        this.f23028c = bArr;
        this.f23029d = i2;
    }

    @Override // okhttp3.G
    public long contentLength() {
        return this.f23027b;
    }

    @Override // okhttp3.G
    public w contentType() {
        return this.f23026a;
    }

    @Override // okhttp3.G
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        bufferedSink.write(this.f23028c, this.f23029d, this.f23027b);
    }
}
