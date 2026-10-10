package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.r;
import io.grpc.internal.GrpcUtil;
import java.net.URL;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s f5339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f5340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final r f5341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final z f5342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Object f5343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile d f5344f;

    /* JADX INFO: compiled from: Request.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        s f5345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        r.a f5347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        z f5348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f5349e;

        public a() {
            this.f5346b = "GET";
            this.f5347c = new r.a();
        }

        public a a(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f5345a = sVar;
            return this;
        }

        public a b(String str, String str2) {
            this.f5347c.a(str, str2);
            return this;
        }

        public a c() {
            return b(com.bytedance.sdk.a.b.a.c.f4967d);
        }

        public a d(z zVar) {
            return a("PATCH", zVar);
        }

        public a b(String str) {
            this.f5347c.b(str);
            return this;
        }

        public a c(z zVar) {
            return a("PUT", zVar);
        }

        public y d() {
            if (this.f5345a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                s sVarE = s.e(str);
                if (sVarE != null) {
                    return a(sVarE);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public a b() {
            return a("HEAD", (z) null);
        }

        a(y yVar) {
            this.f5345a = yVar.f5339a;
            this.f5346b = yVar.f5340b;
            this.f5348d = yVar.f5342d;
            this.f5349e = yVar.f5343e;
            this.f5347c = yVar.f5341c.b();
        }

        public a b(z zVar) {
            return a("DELETE", zVar);
        }

        public a a(URL url) {
            if (url != null) {
                s sVarA = s.a(url);
                if (sVarA != null) {
                    return a(sVarA);
                }
                throw new IllegalArgumentException("unexpected url: " + url);
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str, String str2) {
            this.f5347c.c(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f5347c = rVar.b();
            return this;
        }

        public a a() {
            return a("GET", (z) null);
        }

        public a a(z zVar) {
            return a(GrpcUtil.HTTP_METHOD, zVar);
        }

        public a a(String str, z zVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (zVar != null && !com.bytedance.sdk.a.b.a.c.f.c(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (zVar == null && com.bytedance.sdk.a.b.a.c.f.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.f5346b = str;
                    this.f5348d = zVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }
    }

    y(a aVar) {
        this.f5339a = aVar.f5345a;
        this.f5340b = aVar.f5346b;
        this.f5341c = aVar.f5347c.a();
        this.f5342d = aVar.f5348d;
        Object obj = aVar.f5349e;
        this.f5343e = obj == null ? this : obj;
    }

    public s a() {
        return this.f5339a;
    }

    public String b() {
        return this.f5340b;
    }

    public r c() {
        return this.f5341c;
    }

    public z d() {
        return this.f5342d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f5344f;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f5341c);
        this.f5344f = dVarA;
        return dVarA;
    }

    public boolean g() {
        return this.f5339a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f5340b);
        sb.append(", url=");
        sb.append(this.f5339a);
        sb.append(", tag=");
        Object obj = this.f5343e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public String a(String str) {
        return this.f5341c.a(str);
    }
}
