package okhttp3.internal.http;

import okhttp3.J;
import okhttp3.w;
import okio.BufferedSource;

/* JADX INFO: compiled from: RealResponseBody.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f23248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BufferedSource f23249c;

    public h(String str, long j, BufferedSource bufferedSource) {
        this.f23247a = str;
        this.f23248b = j;
        this.f23249c = bufferedSource;
    }

    @Override // okhttp3.J
    public long contentLength() {
        return this.f23248b;
    }

    @Override // okhttp3.J
    public w contentType() {
        String str = this.f23247a;
        if (str != null) {
            return w.b(str);
        }
        return null;
    }

    @Override // okhttp3.J
    public BufferedSource source() {
        return this.f23249c;
    }
}
