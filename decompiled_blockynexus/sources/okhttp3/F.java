package okhttp3;

import java.io.File;
import java.io.IOException;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes5.dex */
class F extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f23031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f23032b;

    F(w wVar, File file) {
        this.f23031a = wVar;
        this.f23032b = file;
    }

    @Override // okhttp3.G
    public long contentLength() {
        return this.f23032b.length();
    }

    @Override // okhttp3.G
    public w contentType() {
        return this.f23031a;
    }

    @Override // okhttp3.G
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f23032b);
            bufferedSink.writeAll(source);
        } finally {
            okhttp3.a.e.a(source);
        }
    }
}
