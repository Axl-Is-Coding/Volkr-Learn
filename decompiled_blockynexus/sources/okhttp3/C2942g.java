package okhttp3;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: okhttp3.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CacheControl.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2942g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2942g f23146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2942g f23147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f23151f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    String o;

    static {
        a aVar = new a();
        aVar.b();
        f23146a = aVar.a();
        a aVar2 = new a();
        aVar2.c();
        aVar2.a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        f23147b = aVar2.a();
    }

    private C2942g(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f23148c = z;
        this.f23149d = z2;
        this.f23150e = i;
        this.f23151f = i2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = i3;
        this.k = i4;
        this.l = z6;
        this.m = z7;
        this.n = z8;
        this.o = str;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f23148c) {
            sb.append("no-cache, ");
        }
        if (this.f23149d) {
            sb.append("no-store, ");
        }
        if (this.f23150e != -1) {
            sb.append("max-age=");
            sb.append(this.f23150e);
            sb.append(", ");
        }
        if (this.f23151f != -1) {
            sb.append("s-maxage=");
            sb.append(this.f23151f);
            sb.append(", ");
        }
        if (this.g) {
            sb.append("private, ");
        }
        if (this.h) {
            sb.append("public, ");
        }
        if (this.i) {
            sb.append("must-revalidate, ");
        }
        if (this.j != -1) {
            sb.append("max-stale=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k != -1) {
            sb.append("min-fresh=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l) {
            sb.append("only-if-cached, ");
        }
        if (this.m) {
            sb.append("no-transform, ");
        }
        if (this.n) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.g;
    }

    public boolean b() {
        return this.h;
    }

    public int c() {
        return this.f23150e;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public boolean f() {
        return this.i;
    }

    public boolean g() {
        return this.f23148c;
    }

    public boolean h() {
        return this.f23149d;
    }

    public boolean i() {
        return this.l;
    }

    public String toString() {
        String str = this.o;
        if (str != null) {
            return str;
        }
        String strJ = j();
        this.o = strJ;
        return strJ;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okhttp3.C2942g a(okhttp3.u r22) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C2942g.a(okhttp3.u):okhttp3.g");
    }

    /* JADX INFO: renamed from: okhttp3.g$a */
    /* JADX INFO: compiled from: CacheControl.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f23152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f23153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23154c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23155d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23156e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f23157f;
        boolean g;
        boolean h;

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f23155d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a b() {
            this.f23152a = true;
            return this;
        }

        public a c() {
            this.f23157f = true;
            return this;
        }

        public C2942g a() {
            return new C2942g(this);
        }
    }

    C2942g(a aVar) {
        this.f23148c = aVar.f23152a;
        this.f23149d = aVar.f23153b;
        this.f23150e = aVar.f23154c;
        this.f23151f = -1;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = aVar.f23155d;
        this.k = aVar.f23156e;
        this.l = aVar.f23157f;
        this.m = aVar.g;
        this.n = aVar.h;
    }
}
