package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: SymbolInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final k[] f14463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static k[] f14464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f14467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14468f;
    public final int g;
    private final int h;
    private final int i;
    private final int j;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f14463a = kVarArr;
        f14464b = kVarArr;
    }

    public k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    public static k a(int i, SymbolShapeHint symbolShapeHint, com.google.zxing.a aVar, com.google.zxing.a aVar2, boolean z) {
        for (k kVar : f14464b) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.f14465c) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.f14465c) && ((aVar == null || (kVar.g() >= aVar.b() && kVar.f() >= aVar.a())) && ((aVar2 == null || (kVar.g() <= aVar2.b() && kVar.f() <= aVar2.a())) && i <= kVar.f14466d)))) {
                return kVar;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
        }
        return null;
    }

    private int h() {
        int i = this.h;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 4) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    private int i() {
        int i = this.h;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final int b() {
        return this.f14467e;
    }

    public int c() {
        return this.f14466d / this.i;
    }

    public final int d() {
        return i() * this.g;
    }

    public final int e() {
        return h() * this.f14468f;
    }

    public final int f() {
        return d() + (i() << 1);
    }

    public final int g() {
        return e() + (h() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14465c ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f14468f);
        sb.append('x');
        sb.append(this.g);
        sb.append(", symbol size ");
        sb.append(g());
        sb.append('x');
        sb.append(f());
        sb.append(", symbol data size ");
        sb.append(e());
        sb.append('x');
        sb.append(d());
        sb.append(", codewords ");
        sb.append(this.f14466d);
        sb.append('+');
        sb.append(this.f14467e);
        return sb.toString();
    }

    k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f14465c = z;
        this.f14466d = i;
        this.f14467e = i2;
        this.f14468f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = i7;
    }

    public final int b(int i) {
        return this.j;
    }

    public final int a() {
        return this.f14466d;
    }

    public int a(int i) {
        return this.i;
    }
}
