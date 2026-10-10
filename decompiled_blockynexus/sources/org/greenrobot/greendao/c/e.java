package org.greenrobot.greendao.c;

/* JADX INFO: compiled from: TableStatements.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.greenrobot.greendao.b.a f23586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f23588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f23589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private org.greenrobot.greendao.b.c f23590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private org.greenrobot.greendao.b.c f23591f;
    private org.greenrobot.greendao.b.c g;
    private org.greenrobot.greendao.b.c h;
    private org.greenrobot.greendao.b.c i;
    private volatile String j;
    private volatile String k;
    private volatile String l;

    public e(org.greenrobot.greendao.b.a aVar, String str, String[] strArr, String[] strArr2) {
        this.f23586a = aVar;
        this.f23587b = str;
        this.f23588c = strArr;
        this.f23589d = strArr2;
    }

    public org.greenrobot.greendao.b.c a() {
        if (this.i == null) {
            this.i = this.f23586a.b(d.a(this.f23587b));
        }
        return this.i;
    }

    public org.greenrobot.greendao.b.c b() {
        if (this.h == null) {
            org.greenrobot.greendao.b.c cVarB = this.f23586a.b(d.a(this.f23587b, this.f23589d));
            synchronized (this) {
                if (this.h == null) {
                    this.h = cVarB;
                }
            }
            if (this.h != cVarB) {
                cVarB.close();
            }
        }
        return this.h;
    }

    public org.greenrobot.greendao.b.c c() {
        if (this.f23591f == null) {
            org.greenrobot.greendao.b.c cVarB = this.f23586a.b(d.a("INSERT OR REPLACE INTO ", this.f23587b, this.f23588c));
            synchronized (this) {
                if (this.f23591f == null) {
                    this.f23591f = cVarB;
                }
            }
            if (this.f23591f != cVarB) {
                cVarB.close();
            }
        }
        return this.f23591f;
    }

    public org.greenrobot.greendao.b.c d() {
        if (this.f23590e == null) {
            org.greenrobot.greendao.b.c cVarB = this.f23586a.b(d.a("INSERT INTO ", this.f23587b, this.f23588c));
            synchronized (this) {
                if (this.f23590e == null) {
                    this.f23590e = cVarB;
                }
            }
            if (this.f23590e != cVarB) {
                cVarB.close();
            }
        }
        return this.f23590e;
    }

    public String e() {
        if (this.j == null) {
            this.j = d.a(this.f23587b, "T", this.f23588c, false);
        }
        return this.j;
    }

    public String f() {
        if (this.k == null) {
            StringBuilder sb = new StringBuilder(e());
            sb.append("WHERE ");
            d.b(sb, "T", this.f23589d);
            this.k = sb.toString();
        }
        return this.k;
    }

    public String g() {
        if (this.l == null) {
            this.l = e() + "WHERE ROWID=?";
        }
        return this.l;
    }

    public org.greenrobot.greendao.b.c h() {
        if (this.g == null) {
            org.greenrobot.greendao.b.c cVarB = this.f23586a.b(d.a(this.f23587b, this.f23588c, this.f23589d));
            synchronized (this) {
                if (this.g == null) {
                    this.g = cVarB;
                }
            }
            if (this.g != cVarB) {
                cVarB.close();
            }
        }
        return this.g;
    }
}
