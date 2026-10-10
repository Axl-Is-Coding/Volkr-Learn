package com.bytedance.sdk.a.a;

import java.util.Arrays;

/* JADX INFO: compiled from: SegmentedByteString.java */
/* JADX INFO: loaded from: classes.dex */
final class q extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient byte[][] f4892f;
    final transient int[] g;

    q(c cVar, int i) {
        super(null);
        u.a(cVar.f4852b, 0L, i);
        int i2 = 0;
        o oVar = cVar.f4851a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = oVar.f4886c;
            int i6 = oVar.f4885b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            oVar = oVar.f4889f;
        }
        this.f4892f = new byte[i4][];
        this.g = new int[i4 * 2];
        o oVar2 = cVar.f4851a;
        int i7 = 0;
        while (i2 < i) {
            this.f4892f[i7] = oVar2.f4884a;
            i2 += oVar2.f4886c - oVar2.f4885b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i7] = i2;
            iArr[this.f4892f.length + i7] = oVar2.f4885b;
            oVar2.f4887d = true;
            i7++;
            oVar2 = oVar2.f4889f;
        }
    }

    private f i() {
        return new f(h());
    }

    @Override // com.bytedance.sdk.a.a.f
    public String a() {
        return i().a();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String b() {
        return i().b();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f c() {
        return i().c();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f d() {
        return i().d();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String e() {
        return i().e();
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.g() == g() && a(0, fVar, 0, g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.a.a.f
    public f f() {
        return i().f();
    }

    @Override // com.bytedance.sdk.a.a.f
    public int g() {
        return this.g[this.f4892f.length - 1];
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte[] h() {
        int[] iArr = this.g;
        byte[][] bArr = this.f4892f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f4892f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public int hashCode() {
        int i = this.f4857d;
        if (i != 0) {
            return i;
        }
        int length = this.f4892f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f4892f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f4857d = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.a.a.f
    public String toString() {
        return i().toString();
    }

    private int b(int i) {
        int iBinarySearch = Arrays.binarySearch(this.g, 0, this.f4892f.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : iBinarySearch ^ (-1);
    }

    @Override // com.bytedance.sdk.a.a.f
    public f a(int i, int i2) {
        return i().a(i, i2);
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte a(int i) {
        u.a(this.g[this.f4892f.length - 1], i, 1L);
        int iB = b(i);
        int i2 = iB == 0 ? 0 : this.g[iB - 1];
        int[] iArr = this.g;
        byte[][] bArr = this.f4892f;
        return bArr[iB][(i - i2) + iArr[bArr.length + iB]];
    }

    @Override // com.bytedance.sdk.a.a.f
    void a(c cVar) {
        int length = this.f4892f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            o oVar = new o(this.f4892f[i], i3, (i3 + i4) - i2, true, false);
            o oVar2 = cVar.f4851a;
            if (oVar2 == null) {
                oVar.g = oVar;
                oVar.f4889f = oVar;
                cVar.f4851a = oVar;
            } else {
                oVar2.g.a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f4852b += (long) i2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int iB = b(i);
        while (i3 > 0) {
            int i4 = iB == 0 ? 0 : this.g[iB - 1];
            int iMin = Math.min(i3, ((this.g[iB] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr = this.f4892f;
            if (!fVar.a(i2, bArr[iB], (i - i4) + iArr[bArr.length + iB], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iB++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iB = b(i);
        while (i3 > 0) {
            int i4 = iB == 0 ? 0 : this.g[iB - 1];
            int iMin = Math.min(i3, ((this.g[iB] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f4892f;
            if (!u.a(bArr2[iB], (i - i4) + iArr[bArr2.length + iB], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iB++;
        }
        return true;
    }
}
