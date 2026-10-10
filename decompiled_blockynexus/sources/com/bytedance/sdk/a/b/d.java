package com.bytedance.sdk.a.b;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CacheControl.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5224a = new a().a().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f5225b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f5226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f5228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5229f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    /* JADX INFO: compiled from: CacheControl.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5232c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5233d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5234e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f5235f;
        boolean g;
        boolean h;

        public a a() {
            this.f5230a = true;
            return this;
        }

        public a b() {
            this.f5235f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f5233d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }
    }

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f5227d = z;
        this.f5228e = z2;
        this.f5229f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.f5226c = str;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.f5227d) {
            sb.append("no-cache, ");
        }
        if (this.f5228e) {
            sb.append("no-store, ");
        }
        if (this.f5229f != -1) {
            sb.append("max-age=");
            sb.append(this.f5229f);
            sb.append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=");
            sb.append(this.g);
            sb.append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=");
            sb.append(this.l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f5227d;
    }

    public boolean b() {
        return this.f5228e;
    }

    public int c() {
        return this.f5229f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public boolean j() {
        return this.o;
    }

    public String toString() {
        String str = this.f5226c;
        if (str != null) {
            return str;
        }
        String strK = k();
        this.f5226c = strK;
        return strK;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.a.b.d a(com.bytedance.sdk.a.b.r r22) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.d.a(com.bytedance.sdk.a.b.r):com.bytedance.sdk.a.b.d");
    }

    d(a aVar) {
        this.f5227d = aVar.f5230a;
        this.f5228e = aVar.f5231b;
        this.f5229f = aVar.f5232c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.f5233d;
        this.l = aVar.f5234e;
        this.m = aVar.f5235f;
        this.n = aVar.g;
        this.o = aVar.h;
    }
}
