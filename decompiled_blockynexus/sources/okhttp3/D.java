package okhttp3;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes5.dex */
class D extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f23018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ByteString f23019b;

    D(w wVar, ByteString byteString) {
        this.f23018a = wVar;
        this.f23019b = byteString;
    }

    @Override // okhttp3.G
    public long contentLength() throws IOException {
        return this.f23019b.size();
    }

    @Override // okhttp3.G
    public w contentType() {
        return this.f23018a;
    }

    @Override // okhttp3.G
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        bufferedSink.write(this.f23019b);
    }
}
