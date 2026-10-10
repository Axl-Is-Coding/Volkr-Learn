package okhttp3;

import com.just.agentweb.DefaultWebClient;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.C;
import okhttp3.H;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.cache.g;
import okhttp3.internal.io.FileSystem;
import okhttp3.u;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: renamed from: okhttp3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2940e implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InternalCache f23123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final okhttp3.internal.cache.g f23124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f23125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f23126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23128f;
    private int g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: okhttp3.e$a */
    /* JADX INFO: compiled from: Cache.java */
    final class a implements CacheRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g.a f23129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Sink f23130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Sink f23131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f23132d;

        a(g.a aVar) {
            this.f23129a = aVar;
            this.f23130b = aVar.a(1);
            this.f23131c = new C2939d(this, this.f23130b, C2940e.this, aVar);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (C2940e.this) {
                if (this.f23132d) {
                    return;
                }
                this.f23132d = true;
                C2940e.this.f23126d++;
                okhttp3.a.e.a(this.f23130b);
                try {
                    this.f23129a.a();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.f23131c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: okhttp3.e$b */
    /* JADX INFO: compiled from: Cache.java */
    static class b extends J {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g.c f23134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedSource f23135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f23136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f23137d;

        b(g.c cVar, String str, String str2) {
            this.f23134a = cVar;
            this.f23136c = str;
            this.f23137d = str2;
            this.f23135b = Okio.buffer(new C2941f(this, cVar.a(1), cVar));
        }

        @Override // okhttp3.J
        public long contentLength() {
            try {
                if (this.f23137d != null) {
                    return Long.parseLong(this.f23137d);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.J
        public w contentType() {
            String str = this.f23136c;
            if (str != null) {
                return w.b(str);
            }
            return null;
        }

        @Override // okhttp3.J
        public BufferedSource source() {
            return this.f23135b;
        }
    }

    public C2940e(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    public static String a(v vVar) {
        return ByteString.encodeUtf8(vVar.toString()).md5().hex();
    }

    void b(C c2) throws IOException {
        this.f23124b.d(a(c2.g()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23124b.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f23124b.flush();
    }

    C2940e(File file, long j, FileSystem fileSystem) {
        this.f23123a = new C2938c(this);
        this.f23124b = okhttp3.internal.cache.g.a(fileSystem, file, 201105, 2, j);
    }

    H a(C c2) {
        try {
            g.c cVarC = this.f23124b.c(a(c2.g()));
            if (cVarC == null) {
                return null;
            }
            try {
                c cVar = new c(cVarC.a(0));
                H hA = cVar.a(cVarC);
                if (cVar.a(c2, hA)) {
                    return hA;
                }
                okhttp3.a.e.a(hA.b());
                return null;
            } catch (IOException unused) {
                okhttp3.a.e.a(cVarC);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    synchronized void b() {
        this.f23128f++;
    }

    CacheRequest a(H h) {
        g.a aVarA;
        String strE = h.y().e();
        if (okhttp3.internal.http.f.a(h.y().e())) {
            try {
                b(h.y());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!strE.equals("GET") || okhttp3.internal.http.e.c(h)) {
            return null;
        }
        c cVar = new c(h);
        try {
            aVarA = this.f23124b.a(a(h.y().g()));
            if (aVarA == null) {
                return null;
            }
            try {
                cVar.a(aVarA);
                return new a(aVarA);
            } catch (IOException unused2) {
                a(aVarA);
                return null;
            }
        } catch (IOException unused3) {
            aVarA = null;
        }
    }

    void a(H h, H h2) {
        g.a aVarB;
        c cVar = new c(h2);
        try {
            aVarB = ((b) h.b()).f23134a.b();
            if (aVarB != null) {
                try {
                    cVar.a(aVarB);
                    aVarB.b();
                } catch (IOException unused) {
                    a(aVarB);
                }
            }
        } catch (IOException unused2) {
            aVarB = null;
        }
    }

    private void a(g.a aVar) {
        if (aVar != null) {
            try {
                aVar.a();
            } catch (IOException unused) {
            }
        }
    }

    synchronized void a(okhttp3.internal.cache.c cVar) {
        this.g++;
        if (cVar.f23172a != null) {
            this.f23127e++;
        } else if (cVar.f23173b != null) {
            this.f23128f++;
        }
    }

    static int a(BufferedSource bufferedSource) throws IOException {
        try {
            long decimalLong = bufferedSource.readDecimalLong();
            String utf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (decimalLong >= 0 && decimalLong <= 2147483647L && utf8LineStrict.isEmpty()) {
                return (int) decimalLong;
            }
            throw new IOException("expected an int but was \"" + decimalLong + utf8LineStrict + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: okhttp3.e$c */
    /* JADX INFO: compiled from: Cache.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f23138a = okhttp3.a.b.f.a().b() + "-Sent-Millis";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f23139b = okhttp3.a.b.f.a().b() + "-Received-Millis";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f23140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final u f23141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f23142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Protocol f23143f;
        private final int g;
        private final String h;
        private final u i;
        private final t j;
        private final long k;
        private final long l;

        c(Source source) throws IOException {
            try {
                BufferedSource bufferedSourceBuffer = Okio.buffer(source);
                this.f23140c = bufferedSourceBuffer.readUtf8LineStrict();
                this.f23142e = bufferedSourceBuffer.readUtf8LineStrict();
                u.a aVar = new u.a();
                int iA = C2940e.a(bufferedSourceBuffer);
                for (int i = 0; i < iA; i++) {
                    aVar.a(bufferedSourceBuffer.readUtf8LineStrict());
                }
                this.f23141d = aVar.a();
                okhttp3.internal.http.k kVarA = okhttp3.internal.http.k.a(bufferedSourceBuffer.readUtf8LineStrict());
                this.f23143f = kVarA.f23255a;
                this.g = kVarA.f23256b;
                this.h = kVarA.f23257c;
                u.a aVar2 = new u.a();
                int iA2 = C2940e.a(bufferedSourceBuffer);
                for (int i2 = 0; i2 < iA2; i2++) {
                    aVar2.a(bufferedSourceBuffer.readUtf8LineStrict());
                }
                String strB = aVar2.b(f23138a);
                String strB2 = aVar2.b(f23139b);
                aVar2.c(f23138a);
                aVar2.c(f23139b);
                this.k = strB != null ? Long.parseLong(strB) : 0L;
                this.l = strB2 != null ? Long.parseLong(strB2) : 0L;
                this.i = aVar2.a();
                if (a()) {
                    String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
                    if (utf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + utf8LineStrict + "\"");
                    }
                    this.j = t.a(!bufferedSourceBuffer.exhausted() ? TlsVersion.forJavaName(bufferedSourceBuffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, C2945j.a(bufferedSourceBuffer.readUtf8LineStrict()), a(bufferedSourceBuffer), a(bufferedSourceBuffer));
                } else {
                    this.j = null;
                }
            } finally {
                source.close();
            }
        }

        public void a(g.a aVar) throws IOException {
            BufferedSink bufferedSinkBuffer = Okio.buffer(aVar.a(0));
            bufferedSinkBuffer.writeUtf8(this.f23140c).writeByte(10);
            bufferedSinkBuffer.writeUtf8(this.f23142e).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.f23141d.b()).writeByte(10);
            int iB = this.f23141d.b();
            for (int i = 0; i < iB; i++) {
                bufferedSinkBuffer.writeUtf8(this.f23141d.a(i)).writeUtf8(": ").writeUtf8(this.f23141d.b(i)).writeByte(10);
            }
            bufferedSinkBuffer.writeUtf8(new okhttp3.internal.http.k(this.f23143f, this.g, this.h).toString()).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.i.b() + 2).writeByte(10);
            int iB2 = this.i.b();
            for (int i2 = 0; i2 < iB2; i2++) {
                bufferedSinkBuffer.writeUtf8(this.i.a(i2)).writeUtf8(": ").writeUtf8(this.i.b(i2)).writeByte(10);
            }
            bufferedSinkBuffer.writeUtf8(f23138a).writeUtf8(": ").writeDecimalLong(this.k).writeByte(10);
            bufferedSinkBuffer.writeUtf8(f23139b).writeUtf8(": ").writeDecimalLong(this.l).writeByte(10);
            if (a()) {
                bufferedSinkBuffer.writeByte(10);
                bufferedSinkBuffer.writeUtf8(this.j.a().a()).writeByte(10);
                a(bufferedSinkBuffer, this.j.c());
                a(bufferedSinkBuffer, this.j.b());
                bufferedSinkBuffer.writeUtf8(this.j.d().javaName()).writeByte(10);
            }
            bufferedSinkBuffer.close();
        }

        private boolean a() {
            return this.f23140c.startsWith(DefaultWebClient.HTTPS_SCHEME);
        }

        c(H h) {
            this.f23140c = h.y().g().toString();
            this.f23141d = okhttp3.internal.http.e.d(h);
            this.f23142e = h.y().e();
            this.f23143f = h.w();
            this.g = h.g();
            this.h = h.r();
            this.i = h.o();
            this.j = h.n();
            this.k = h.z();
            this.l = h.x();
        }

        private List<Certificate> a(BufferedSource bufferedSource) throws IOException {
            int iA = C2940e.a(bufferedSource);
            if (iA == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iA);
                for (int i = 0; i < iA; i++) {
                    String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(utf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean a(C c2, H h) {
            return this.f23140c.equals(c2.g().toString()) && this.f23142e.equals(c2.e()) && okhttp3.internal.http.e.a(h, this.f23141d, c2);
        }

        public H a(g.c cVar) {
            String strB = this.i.b("Content-Type");
            String strB2 = this.i.b("Content-Length");
            C.a aVar = new C.a();
            aVar.b(this.f23140c);
            aVar.a(this.f23142e, (G) null);
            aVar.a(this.f23141d);
            C cA = aVar.a();
            H.a aVar2 = new H.a();
            aVar2.a(cA);
            aVar2.a(this.f23143f);
            aVar2.a(this.g);
            aVar2.a(this.h);
            aVar2.a(this.i);
            aVar2.a(new b(cVar, strB, strB2));
            aVar2.a(this.j);
            aVar2.b(this.k);
            aVar2.a(this.l);
            return aVar2.a();
        }
    }
}
