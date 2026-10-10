package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.C2942g;
import okhttp3.H;
import okhttp3.u;

/* JADX INFO: compiled from: CacheStrategy.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f23172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H f23173b;

    c(C c2, H h) {
        this.f23172a = c2;
        this.f23173b = h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.d().a() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(okhttp3.H r3, okhttp3.C r4) {
        /*
            int r0 = r3.g()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L5a
            okhttp3.g r0 = r3.d()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.g r0 = r3.d()
            boolean r0 = r0.b()
            if (r0 != 0) goto L5a
            okhttp3.g r0 = r3.d()
            boolean r0 = r0.a()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.g r3 = r3.d()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            okhttp3.g r3 = r4.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.c.a(okhttp3.H, okhttp3.C):boolean");
    }

    /* JADX INFO: compiled from: CacheStrategy.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f23174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C f23175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final H f23176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f23177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f23178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f23179f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, C c2, H h) {
            this.l = -1;
            this.f23174a = j;
            this.f23175b = c2;
            this.f23176c = h;
            if (h != null) {
                this.i = h.z();
                this.j = h.x();
                u uVarO = h.o();
                int iB = uVarO.b();
                for (int i = 0; i < iB; i++) {
                    String strA = uVarO.a(i);
                    String strB = uVarO.b(i);
                    if ("Date".equalsIgnoreCase(strA)) {
                        this.f23177d = okhttp3.internal.http.d.a(strB);
                        this.f23178e = strB;
                    } else if ("Expires".equalsIgnoreCase(strA)) {
                        this.h = okhttp3.internal.http.d.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f23179f = okhttp3.internal.http.d.a(strB);
                        this.g = strB;
                    } else if ("ETag".equalsIgnoreCase(strA)) {
                        this.k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.l = okhttp3.internal.http.e.a(strB, -1);
                    }
                }
            }
        }

        private long b() {
            Date date = this.f23177d;
            long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return jMax + (j - this.i) + (this.f23174a - j);
        }

        private long c() {
            if (this.f23176c.d().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.h != null) {
                Date date = this.f23177d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f23179f == null || this.f23176c.y().g().l() != null) {
                return 0L;
            }
            Date date2 = this.f23177d;
            long time2 = (date2 != null ? date2.getTime() : this.i) - this.f23179f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private c d() {
            if (this.f23176c == null) {
                return new c(this.f23175b, null);
            }
            if (this.f23175b.d() && this.f23176c.n() == null) {
                return new c(this.f23175b, null);
            }
            if (!c.a(this.f23176c, this.f23175b)) {
                return new c(this.f23175b, null);
            }
            C2942g c2942gB = this.f23175b.b();
            if (c2942gB.g() || a(this.f23175b)) {
                return new c(this.f23175b, null);
            }
            C2942g c2942gD = this.f23176c.d();
            long jB = b();
            long jC = c();
            if (c2942gB.c() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(c2942gB.c()));
            }
            long millis = 0;
            long millis2 = c2942gB.e() != -1 ? TimeUnit.SECONDS.toMillis(c2942gB.e()) : 0L;
            if (!c2942gD.f() && c2942gB.d() != -1) {
                millis = TimeUnit.SECONDS.toMillis(c2942gB.d());
            }
            if (!c2942gD.g()) {
                long j = millis2 + jB;
                if (j < millis + jC) {
                    H.a aVarT = this.f23176c.t();
                    if (j >= jC) {
                        aVarT.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jB > 86400000 && e()) {
                        aVarT.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, aVarT.a());
                }
            }
            String str = this.k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f23179f != null) {
                str = this.g;
            } else {
                if (this.f23177d == null) {
                    return new c(this.f23175b, null);
                }
                str = this.f23178e;
            }
            u.a aVarA = this.f23175b.c().a();
            okhttp3.a.a.f23061a.a(aVarA, str2, str);
            C.a aVarF = this.f23175b.f();
            aVarF.a(aVarA.a());
            return new c(aVarF.a(), this.f23176c);
        }

        private boolean e() {
            return this.f23176c.d().c() == -1 && this.h == null;
        }

        public c a() {
            c cVarD = d();
            return (cVarD.f23172a == null || !this.f23175b.b().i()) ? cVarD : new c(null, null);
        }

        private static boolean a(C c2) {
            return (c2.a("If-Modified-Since") == null && c2.a("If-None-Match") == null) ? false : true;
        }
    }
}
