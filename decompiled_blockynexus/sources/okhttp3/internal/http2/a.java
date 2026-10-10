package okhttp3.internal.http2;

import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: Hpack.java */
/* JADX INFO: loaded from: classes5.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Header[] f23275a = {new Header(Header.f23263f, ""), new Header(Header.f23260c, "GET"), new Header(Header.f23260c, GrpcUtil.HTTP_METHOD), new Header(Header.f23261d, "/"), new Header(Header.f23261d, "/index.html"), new Header(Header.f23262e, "http"), new Header(Header.f23262e, "https"), new Header(Header.f23259b, "200"), new Header(Header.f23259b, "204"), new Header(Header.f23259b, "206"), new Header(Header.f23259b, "304"), new Header(Header.f23259b, "400"), new Header(Header.f23259b, "404"), new Header(Header.f23259b, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Map<ByteString, Integer> f23276b = a();

    /* JADX INFO: renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Hpack.java */
    static final class C0251a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Header> f23277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedSource f23278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f23279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f23280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Header[] f23281e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f23282f;
        int g;
        int h;

        C0251a(int i, Source source) {
            this(i, i, source);
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f23281e.length;
                while (true) {
                    length--;
                    if (length < this.f23282f || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f23281e;
                    i -= headerArr[length].i;
                    this.h -= headerArr[length].i;
                    this.g--;
                    i2++;
                }
                Header[] headerArr2 = this.f23281e;
                int i3 = this.f23282f;
                System.arraycopy(headerArr2, i3 + 1, headerArr2, i3 + 1 + i2, this.g);
                this.f23282f += i2;
            }
            return i2;
        }

        private void d() {
            int i = this.f23280d;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    b(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f23281e, (Object) null);
            this.f23282f = this.f23281e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private void f(int i) throws IOException {
            a(-1, new Header(c(i), b()));
        }

        private void g(int i) throws IOException {
            this.f23277a.add(new Header(c(i), b()));
        }

        private void h() throws IOException {
            ByteString byteStringB = b();
            a.a(byteStringB);
            this.f23277a.add(new Header(byteStringB, b()));
        }

        public List<Header> a() {
            ArrayList arrayList = new ArrayList(this.f23277a);
            this.f23277a.clear();
            return arrayList;
        }

        void c() throws IOException {
            while (!this.f23278b.exhausted()) {
                int i = this.f23278b.readByte() & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((i & 128) == 128) {
                    e(a(i, 127) - 1);
                } else if (i == 64) {
                    g();
                } else if ((i & 64) == 64) {
                    f(a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.f23280d = a(i, 31);
                    int i2 = this.f23280d;
                    if (i2 < 0 || i2 > this.f23279c) {
                        throw new IOException("Invalid dynamic table size update " + this.f23280d);
                    }
                    d();
                } else if (i == 16 || i == 0) {
                    h();
                } else {
                    g(a(i, 15) - 1);
                }
            }
        }

        C0251a(int i, int i2, Source source) {
            this.f23277a = new ArrayList();
            this.f23281e = new Header[8];
            this.f23282f = this.f23281e.length - 1;
            this.g = 0;
            this.h = 0;
            this.f23279c = i;
            this.f23280d = i2;
            this.f23278b = Okio.buffer(source);
        }

        private int a(int i) {
            return this.f23282f + 1 + i;
        }

        private void a(int i, Header header) {
            this.f23277a.add(header);
            int i2 = header.i;
            if (i != -1) {
                i2 -= this.f23281e[a(i)].i;
            }
            int i3 = this.f23280d;
            if (i2 > i3) {
                e();
                return;
            }
            int iB = b((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                Header[] headerArr = this.f23281e;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f23282f = this.f23281e.length - 1;
                    this.f23281e = headerArr2;
                }
                int i5 = this.f23282f;
                this.f23282f = i5 - 1;
                this.f23281e[i5] = header;
                this.g++;
            } else {
                this.f23281e[i + a(i) + iB] = header;
            }
            this.h += i2;
        }

        private boolean d(int i) {
            return i >= 0 && i <= a.f23275a.length - 1;
        }

        private int f() throws IOException {
            return this.f23278b.readByte() & 255;
        }

        private void g() throws IOException {
            ByteString byteStringB = b();
            a.a(byteStringB);
            a(-1, new Header(byteStringB, b()));
        }

        private void e(int i) throws IOException {
            if (d(i)) {
                this.f23277a.add(a.f23275a[i]);
                return;
            }
            int iA = a(i - a.f23275a.length);
            if (iA >= 0) {
                Header[] headerArr = this.f23281e;
                if (iA < headerArr.length) {
                    this.f23277a.add(headerArr[iA]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        ByteString b() throws IOException {
            int iF = f();
            boolean z = (iF & 128) == 128;
            int iA = a(iF, 127);
            if (z) {
                return ByteString.of(q.a().a(this.f23278b.readByteArray(iA)));
            }
            return this.f23278b.readByteString(iA);
        }

        private ByteString c(int i) throws IOException {
            if (d(i)) {
                return a.f23275a[i].g;
            }
            int iA = a(i - a.f23275a.length);
            if (iA >= 0) {
                Header[] headerArr = this.f23281e;
                if (iA < headerArr.length) {
                    return headerArr[iA].g;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iF = f();
                if ((iF & 128) == 0) {
                    return i2 + (iF << i4);
                }
                i2 += (iF & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* JADX INFO: compiled from: Hpack.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Buffer f23283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f23285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f23286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f23288f;
        Header[] g;
        int h;
        int i;
        int j;

        b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a(Header header) {
            int i = header.i;
            int i2 = this.f23288f;
            if (i > i2) {
                b();
                return;
            }
            b((this.j + i) - i2);
            int i3 = this.i + 1;
            Header[] headerArr = this.g;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.h = this.g.length - 1;
                this.g = headerArr2;
            }
            int i4 = this.h;
            this.h = i4 - 1;
            this.g[i4] = header;
            this.i++;
            this.j += i;
        }

        private void b() {
            Arrays.fill(this.g, (Object) null);
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        b(int i, boolean z, Buffer buffer) {
            this.f23285c = Integer.MAX_VALUE;
            this.g = new Header[8];
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
            this.f23287e = i;
            this.f23288f = i;
            this.f23284b = z;
            this.f23283a = buffer;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.g.length;
                while (true) {
                    length--;
                    if (length < this.h || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.g;
                    i -= headerArr[length].i;
                    this.j -= headerArr[length].i;
                    this.i--;
                    i2++;
                }
                Header[] headerArr2 = this.g;
                int i3 = this.h;
                System.arraycopy(headerArr2, i3 + 1, headerArr2, i3 + 1 + i2, this.i);
                Header[] headerArr3 = this.g;
                int i4 = this.h;
                Arrays.fill(headerArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.h += i2;
            }
            return i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.a.b.a(java.util.List):void");
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.f23283a.writeByte(i | i3);
                return;
            }
            this.f23283a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f23283a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f23283a.writeByte(i4);
        }

        void a(ByteString byteString) throws IOException {
            if (this.f23284b && q.a().a(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                q.a().a(byteString, buffer);
                ByteString byteString2 = buffer.readByteString();
                a(byteString2.size(), 127, 128);
                this.f23283a.write(byteString2);
                return;
            }
            a(byteString.size(), 127, 0);
            this.f23283a.write(byteString);
        }

        void a(int i) {
            this.f23287e = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f23288f;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.f23285c = Math.min(this.f23285c, iMin);
            }
            this.f23286d = true;
            this.f23288f = iMin;
            a();
        }

        private void a() {
            int i = this.f23288f;
            int i2 = this.j;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    b(i2 - i);
                }
            }
        }
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f23275a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = f23275a;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].g)) {
                linkedHashMap.put(f23275a[i].g, Integer.valueOf(i));
            }
            i++;
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
