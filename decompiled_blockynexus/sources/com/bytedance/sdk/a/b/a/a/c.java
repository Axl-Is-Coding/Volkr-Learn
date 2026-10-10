package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f4911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa f4912b;

    c(y yVar, aa aaVar) {
        this.f4911a = yVar;
        this.f4912b = aaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.j().d() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.bytedance.sdk.a.b.aa r3, com.bytedance.sdk.a.b.y r4) {
        /*
            int r0 = r3.c()
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
            com.bytedance.sdk.a.b.d r0 = r3.j()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L5a
            com.bytedance.sdk.a.b.d r0 = r3.j()
            boolean r0 = r0.e()
            if (r0 != 0) goto L5a
            com.bytedance.sdk.a.b.d r0 = r3.j()
            boolean r0 = r0.d()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.bytedance.sdk.a.b.d r3 = r3.j()
            boolean r3 = r3.b()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.a.b.d r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.a.c.a(com.bytedance.sdk.a.b.aa, com.bytedance.sdk.a.b.y):boolean");
    }

    /* JADX INFO: compiled from: CacheStrategy.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f4913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final y f4914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final aa f4915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f4916d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f4917e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f4918f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, y yVar, aa aaVar) {
            this.l = -1;
            this.f4913a = j;
            this.f4914b = yVar;
            this.f4915c = aaVar;
            if (aaVar != null) {
                this.i = aaVar.k();
                this.j = aaVar.l();
                r rVarF = aaVar.f();
                int iA = rVarF.a();
                for (int i = 0; i < iA; i++) {
                    String strA = rVarF.a(i);
                    String strB = rVarF.b(i);
                    if ("Date".equalsIgnoreCase(strA)) {
                        this.f4916d = com.bytedance.sdk.a.b.a.c.d.a(strB);
                        this.f4917e = strB;
                    } else if ("Expires".equalsIgnoreCase(strA)) {
                        this.h = com.bytedance.sdk.a.b.a.c.d.a(strB);
                    } else if ("Last-Modified".equalsIgnoreCase(strA)) {
                        this.f4918f = com.bytedance.sdk.a.b.a.c.d.a(strB);
                        this.g = strB;
                    } else if ("ETag".equalsIgnoreCase(strA)) {
                        this.k = strB;
                    } else if ("Age".equalsIgnoreCase(strA)) {
                        this.l = com.bytedance.sdk.a.b.a.c.e.b(strB, -1);
                    }
                }
            }
        }

        private c b() {
            if (this.f4915c == null) {
                return new c(this.f4914b, null);
            }
            if (this.f4914b.g() && this.f4915c.e() == null) {
                return new c(this.f4914b, null);
            }
            if (!c.a(this.f4915c, this.f4914b)) {
                return new c(this.f4914b, null);
            }
            com.bytedance.sdk.a.b.d dVarF = this.f4914b.f();
            if (dVarF.a() || a(this.f4914b)) {
                return new c(this.f4914b, null);
            }
            com.bytedance.sdk.a.b.d dVarJ = this.f4915c.j();
            if (dVarJ.j()) {
                return new c(null, this.f4915c);
            }
            long jD = d();
            long jC = c();
            if (dVarF.c() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(dVarF.c()));
            }
            long millis = 0;
            long millis2 = dVarF.h() != -1 ? TimeUnit.SECONDS.toMillis(dVarF.h()) : 0L;
            if (!dVarJ.f() && dVarF.g() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarF.g());
            }
            if (!dVarJ.a()) {
                long j = millis2 + jD;
                if (j < millis + jC) {
                    aa.a aVarH = this.f4915c.h();
                    if (j >= jC) {
                        aVarH.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jD > 86400000 && e()) {
                        aVarH.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, aVarH.a());
                }
            }
            String str = this.k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f4918f != null) {
                str = this.g;
            } else {
                if (this.f4916d == null) {
                    return new c(this.f4914b, null);
                }
                str = this.f4917e;
            }
            r.a aVarB = this.f4914b.c().b();
            com.bytedance.sdk.a.b.a.a.f4904a.a(aVarB, str2, str);
            return new c(this.f4914b.e().a(aVarB.a()).d(), this.f4915c);
        }

        private long c() {
            if (this.f4915c.j().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.h != null) {
                Date date = this.f4916d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f4918f == null || this.f4915c.a().a().k() != null) {
                return 0L;
            }
            Date date2 = this.f4916d;
            long time2 = (date2 != null ? date2.getTime() : this.i) - this.f4918f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long d() {
            Date date = this.f4916d;
            long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return jMax + (j - this.i) + (this.f4913a - j);
        }

        private boolean e() {
            return this.f4915c.j().c() == -1 && this.h == null;
        }

        public c a() {
            c cVarB = b();
            return (cVarB.f4911a == null || !this.f4914b.f().i()) ? cVarB : new c(null, null);
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
