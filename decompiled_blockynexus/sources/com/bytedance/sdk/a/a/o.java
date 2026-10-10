package com.bytedance.sdk.a.a;

/* JADX INFO: compiled from: Segment.java */
/* JADX INFO: loaded from: classes.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f4884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f4887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f4888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    o f4889f;
    o g;

    o() {
        this.f4884a = new byte[8192];
        this.f4888e = true;
        this.f4887d = false;
    }

    final o a() {
        this.f4887d = true;
        return new o(this.f4884a, this.f4885b, this.f4886c, true, false);
    }

    public final o b() {
        o oVar = this.f4889f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.g;
        oVar2.f4889f = this.f4889f;
        this.f4889f.g = oVar2;
        this.f4889f = null;
        this.g = null;
        return oVar;
    }

    public final void c() {
        o oVar = this.g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.f4888e) {
            int i = this.f4886c - this.f4885b;
            if (i > (8192 - oVar.f4886c) + (oVar.f4887d ? 0 : oVar.f4885b)) {
                return;
            }
            a(this.g, i);
            b();
            p.a(this);
        }
    }

    public final o a(o oVar) {
        oVar.g = this;
        oVar.f4889f = this.f4889f;
        this.f4889f.g = oVar;
        this.f4889f = oVar;
        return oVar;
    }

    o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f4884a = bArr;
        this.f4885b = i;
        this.f4886c = i2;
        this.f4887d = z;
        this.f4888e = z2;
    }

    public final o a(int i) {
        o oVarA;
        if (i > 0 && i <= this.f4886c - this.f4885b) {
            if (i >= 1024) {
                oVarA = a();
            } else {
                oVarA = p.a();
                System.arraycopy(this.f4884a, this.f4885b, oVarA.f4884a, 0, i);
            }
            oVarA.f4886c = oVarA.f4885b + i;
            this.f4885b += i;
            this.g.a(oVarA);
            return oVarA;
        }
        throw new IllegalArgumentException();
    }

    public final void a(o oVar, int i) {
        if (oVar.f4888e) {
            int i2 = oVar.f4886c;
            if (i2 + i > 8192) {
                if (!oVar.f4887d) {
                    int i3 = oVar.f4885b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = oVar.f4884a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        oVar.f4886c -= oVar.f4885b;
                        oVar.f4885b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f4884a, this.f4885b, oVar.f4884a, oVar.f4886c, i);
            oVar.f4886c += i;
            this.f4885b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
