package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.s;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Hpack.java */
/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c[] f5031a = {new c(c.f5030f, ""), new c(c.f5027c, "GET"), new c(c.f5027c, GrpcUtil.HTTP_METHOD), new c(c.f5028d, "/"), new c(c.f5028d, "/index.html"), new c(c.f5029e, "http"), new c(c.f5029e, "https"), new c(c.f5026b, "200"), new c(c.f5026b, "204"), new c(c.f5026b, "206"), new c(c.f5026b, "304"), new c(c.f5026b, "400"), new c(c.f5026b, "404"), new c(c.f5026b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Map<com.bytedance.sdk.a.a.f, Integer> f5032b = a();

    /* JADX INFO: compiled from: Hpack.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c[] f5033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<c> f5037e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.bytedance.sdk.a.a.e f5038f;
        private final int g;
        private int h;

        a(int i, s sVar) {
            this(i, i, sVar);
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f5033a.length;
                while (true) {
                    length--;
                    if (length < this.f5034b || i <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f5033a;
                    i -= cVarArr[length].i;
                    this.f5036d -= cVarArr[length].i;
                    this.f5035c--;
                    i2++;
                }
                c[] cVarArr2 = this.f5033a;
                int i3 = this.f5034b;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i2, this.f5035c);
                this.f5034b += i2;
            }
            return i2;
        }

        private int c(int i) {
            return this.f5034b + 1 + i;
        }

        private void d() {
            int i = this.h;
            int i2 = this.f5036d;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    a(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f5033a, (Object) null);
            this.f5034b = this.f5033a.length - 1;
            this.f5035c = 0;
            this.f5036d = 0;
        }

        private void f() throws IOException {
            com.bytedance.sdk.a.a.f fVarC = c();
            d.a(fVarC);
            this.f5037e.add(new c(fVarC, c()));
        }

        private void g() throws IOException {
            com.bytedance.sdk.a.a.f fVarC = c();
            d.a(fVarC);
            a(-1, new c(fVarC, c()));
        }

        private int h() throws IOException {
            return this.f5038f.h() & 255;
        }

        public List<c> b() {
            ArrayList arrayList = new ArrayList(this.f5037e);
            this.f5037e.clear();
            return arrayList;
        }

        a(int i, int i2, s sVar) {
            this.f5037e = new ArrayList();
            this.f5033a = new c[8];
            this.f5034b = this.f5033a.length - 1;
            this.f5035c = 0;
            this.f5036d = 0;
            this.g = i;
            this.h = i2;
            this.f5038f = com.bytedance.sdk.a.a.l.a(sVar);
        }

        com.bytedance.sdk.a.a.f c() throws IOException {
            int iH = h();
            boolean z = (iH & 128) == 128;
            int iA = a(iH, 127);
            return z ? com.bytedance.sdk.a.a.f.a(k.a().a(this.f5038f.g(iA))) : this.f5038f.c(iA);
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.f5037e.add(d.f5031a[i]);
                return;
            }
            int iC = c(i - d.f5031a.length);
            if (iC >= 0) {
                c[] cVarArr = this.f5033a;
                if (iC <= cVarArr.length - 1) {
                    this.f5037e.add(cVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void d(int i) throws IOException {
            this.f5037e.add(new c(f(i), c()));
        }

        private com.bytedance.sdk.a.a.f f(int i) {
            if (g(i)) {
                return d.f5031a[i].g;
            }
            return this.f5033a[c(i - d.f5031a.length)].g;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.f5031a.length - 1;
        }

        private void e(int i) throws IOException {
            a(-1, new c(f(i), c()));
        }

        void a() throws IOException {
            while (!this.f5038f.e()) {
                int iH = this.f5038f.h() & 255;
                if (iH == 128) {
                    throw new IOException("index == 0");
                }
                if ((iH & 128) == 128) {
                    b(a(iH, 127) - 1);
                } else if (iH == 64) {
                    g();
                } else if ((iH & 64) == 64) {
                    e(a(iH, 63) - 1);
                } else if ((iH & 32) == 32) {
                    this.h = a(iH, 31);
                    int i = this.h;
                    if (i >= 0 && i <= this.g) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                } else if (iH != 16 && iH != 0) {
                    d(a(iH, 15) - 1);
                } else {
                    f();
                }
            }
        }

        private void a(int i, c cVar) {
            this.f5037e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.f5033a[c(i)].i;
            }
            int i3 = this.h;
            if (i2 > i3) {
                e();
                return;
            }
            int iA = a((this.f5036d + i2) - i3);
            if (i == -1) {
                int i4 = this.f5035c + 1;
                c[] cVarArr = this.f5033a;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f5034b = this.f5033a.length - 1;
                    this.f5033a = cVarArr2;
                }
                int i5 = this.f5034b;
                this.f5034b = i5 - 1;
                this.f5033a[i5] = cVar;
                this.f5035c++;
            } else {
                this.f5033a[i + c(i) + iA] = cVar;
            }
            this.f5036d += i2;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iH = h();
                if ((iH & 128) == 0) {
                    return i2 + (iH << i4);
                }
                i2 += (iH & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* JADX INFO: compiled from: Hpack.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c[] f5041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5044f;
        private final com.bytedance.sdk.a.a.c g;
        private final boolean h;
        private int i;
        private boolean j;

        b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            Arrays.fill(this.f5041c, (Object) null);
            this.f5042d = this.f5041c.length - 1;
            this.f5043e = 0;
            this.f5044f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f5041c.length;
                while (true) {
                    length--;
                    if (length < this.f5042d || i <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f5041c;
                    i -= cVarArr[length].i;
                    this.f5044f -= cVarArr[length].i;
                    this.f5043e--;
                    i2++;
                }
                c[] cVarArr2 = this.f5041c;
                int i3 = this.f5042d;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i2, this.f5043e);
                c[] cVarArr3 = this.f5041c;
                int i4 = this.f5042d;
                Arrays.fill(cVarArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.f5042d += i2;
            }
            return i2;
        }

        b(int i, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.i = Integer.MAX_VALUE;
            this.f5041c = new c[8];
            this.f5042d = this.f5041c.length - 1;
            this.f5043e = 0;
            this.f5044f = 0;
            this.f5039a = i;
            this.f5040b = i;
            this.h = z;
            this.g = cVar;
        }

        private void a(c cVar) {
            int i = cVar.i;
            int i2 = this.f5040b;
            if (i > i2) {
                a();
                return;
            }
            b((this.f5044f + i) - i2);
            int i3 = this.f5043e + 1;
            c[] cVarArr = this.f5041c;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f5042d = this.f5041c.length - 1;
                this.f5041c = cVarArr2;
            }
            int i4 = this.f5042d;
            this.f5042d = i4 - 1;
            this.f5041c[i4] = cVar;
            this.f5043e++;
            this.f5044f += i;
        }

        private void b() {
            int i = this.f5040b;
            int i2 = this.f5044f;
            if (i < i2) {
                if (i == 0) {
                    a();
                } else {
                    b(i2 - i);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a(java.util.List<com.bytedance.sdk.a.b.a.e.c> r14) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.e.d.b.a(java.util.List):void");
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.g.i(i | i3);
                return;
            }
            this.g.i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.g.i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.g.i(i4);
        }

        void a(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.h && k.a().a(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.a().a(fVar, cVar);
                com.bytedance.sdk.a.a.f fVarN = cVar.n();
                a(fVarN.g(), 127, 128);
                this.g.a(fVarN);
                return;
            }
            a(fVar.g(), 127, 0);
            this.g.a(fVar);
        }

        void a(int i) {
            this.f5039a = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f5040b;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.i = Math.min(this.i, iMin);
            }
            this.j = true;
            this.f5040b = iMin;
            b();
        }
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f5031a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = f5031a;
            if (i >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i].g)) {
                linkedHashMap.put(f5031a[i].g, Integer.valueOf(i));
            }
            i++;
        }
    }

    static com.bytedance.sdk.a.a.f a(com.bytedance.sdk.a.a.f fVar) throws IOException {
        int iG = fVar.g();
        for (int i = 0; i < iG; i++) {
            byte bA = fVar.a(i);
            if (bA >= 65 && bA <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
