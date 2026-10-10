package com.scwang.smartrefresh.layout.constant;

/* JADX INFO: compiled from: DimensionStatus.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19143a = new a(0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19144b = new a(1, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19145c = new a(2, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19146d = new a(3, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f19147e = new a(4, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f19148f = new a(5, true);
    public static final a g = new a(6, false);
    public static final a h = new a(7, true);
    public static final a i = new a(8, false);
    public static final a j = new a(9, true);
    public static final a k = new a(10, false);
    public static final a l = new a(10, true);
    public static final a[] m = {f19143a, f19144b, f19145c, f19146d, f19147e, f19148f, g, h, i, j, k, l};
    public final int n;
    public final boolean o;

    private a(int i2, boolean z) {
        this.n = i2;
        this.o = z;
    }

    public a a() {
        return !this.o ? m[this.n + 1] : this;
    }

    public a b() {
        if (!this.o) {
            return this;
        }
        a aVar = m[this.n - 1];
        return !aVar.o ? aVar : f19143a;
    }

    public boolean a(a aVar) {
        return this.n < aVar.n || ((!this.o || j == this) && this.n == aVar.n);
    }
}
