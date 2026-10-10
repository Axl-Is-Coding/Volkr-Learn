package okhttp3;

import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: MultipartBody.java */
/* JADX INFO: loaded from: classes5.dex */
public final class x extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f23484a = w.a("multipart/mixed");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f23485b = w.a("multipart/alternative");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f23486c = w.a("multipart/digest");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f23487d = w.a("multipart/parallel");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w f23488e = w.a("multipart/form-data");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f23489f = {58, 32};
    private static final byte[] g = {ci.k, 10};
    private static final byte[] h = {45, 45};
    private final ByteString i;
    private final w j;
    private final w k;
    private final List<b> l;
    private long m = -1;

    /* JADX INFO: compiled from: MultipartBody.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteString f23490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private w f23491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<b> f23492c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(w wVar) {
            if (wVar == null) {
                throw new NullPointerException("type == null");
            }
            if (wVar.b().equals("multipart")) {
                this.f23491b = wVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + wVar);
        }

        public a(String str) {
            this.f23491b = x.f23484a;
            this.f23492c = new ArrayList();
            this.f23490a = ByteString.encodeUtf8(str);
        }

        public a a(u uVar, G g) {
            a(b.a(uVar, g));
            return this;
        }

        public a a(String str, String str2) {
            a(b.a(str, str2));
            return this;
        }

        public a a(String str, String str2, G g) {
            a(b.a(str, str2, g));
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f23492c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public x a() {
            if (!this.f23492c.isEmpty()) {
                return new x(this.f23490a, this.f23491b, this.f23492c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    x(ByteString byteString, w wVar, List<b> list) {
        this.i = byteString;
        this.j = wVar;
        this.k = w.a(wVar + "; boundary=" + byteString.utf8());
        this.l = okhttp3.a.e.a(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.l.get(i);
            u uVar = bVar.f23493a;
            G g2 = bVar.f23494b;
            bufferedSink.write(h);
            bufferedSink.write(this.i);
            bufferedSink.write(g);
            if (uVar != null) {
                int iB = uVar.b();
                for (int i2 = 0; i2 < iB; i2++) {
                    bufferedSink.writeUtf8(uVar.a(i2)).write(f23489f).writeUtf8(uVar.b(i2)).write(g);
                }
            }
            w wVarContentType = g2.contentType();
            if (wVarContentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(wVarContentType.toString()).write(g);
            }
            long jContentLength = g2.contentLength();
            if (jContentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(g);
            } else if (z) {
                buffer.clear();
                return -1L;
            }
            bufferedSink.write(g);
            if (z) {
                j += jContentLength;
            } else {
                g2.writeTo(bufferedSink);
            }
            bufferedSink.write(g);
        }
        bufferedSink.write(h);
        bufferedSink.write(this.i);
        bufferedSink.write(h);
        bufferedSink.write(g);
        if (!z) {
            return j;
        }
        long size2 = j + buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // okhttp3.G
    public long contentLength() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long jA = a((BufferedSink) null, true);
        this.m = jA;
        return jA;
    }

    @Override // okhttp3.G
    public w contentType() {
        return this.k;
    }

    @Override // okhttp3.G
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        a(bufferedSink, false);
    }

    /* JADX INFO: compiled from: MultipartBody.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final u f23493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final G f23494b;

        private b(u uVar, G g) {
            this.f23493a = uVar;
            this.f23494b = g;
        }

        public static b a(u uVar, G g) {
            if (g == null) {
                throw new NullPointerException("body == null");
            }
            if (uVar != null && uVar.b("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (uVar == null || uVar.b("Content-Length") == null) {
                return new b(uVar, g);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static b a(String str, String str2) {
            return a(str, null, G.create((w) null, str2));
        }

        public static b a(String str, String str2, G g) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                x.a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    x.a(sb, str2);
                }
                return a(u.a("Content-Disposition", sb.toString()), g);
            }
            throw new NullPointerException("name == null");
        }
    }

    static StringBuilder a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }
}
