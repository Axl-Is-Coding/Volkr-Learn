package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.a;
import com.umeng.analytics.pro.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: StandardGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4201a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f4202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f4203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a.InterfaceC0055a f4204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f4205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f4206f;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    public e(a.InterfaceC0055a interfaceC0055a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0055a);
        a(cVar, byteBuffer, i);
    }

    private Bitmap h() {
        Boolean bool = this.t;
        Bitmap bitmapA = this.f4204d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int i() {
        int iJ = j();
        if (iJ <= 0) {
            return iJ;
        }
        ByteBuffer byteBuffer = this.f4205e;
        byteBuffer.get(this.f4206f, 0, Math.min(iJ, byteBuffer.remaining()));
        return iJ;
    }

    private int j() {
        return this.f4205e.get() & 255;
    }

    public int a(int i) {
        if (i >= 0) {
            c cVar = this.m;
            if (i < cVar.f4193c) {
                return cVar.f4195e.get(i).i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void advance() {
        this.l = (this.l + 1) % this.m.f4193c;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public int b() {
        return this.m.f4193c;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public int c() {
        int i = this.m.m;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void clear() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f4204d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f4204d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f4204d.a(bitmap);
        }
        this.n = null;
        this.f4205e = null;
        this.t = null;
        byte[] bArr2 = this.f4206f;
        if (bArr2 != null) {
            this.f4204d.a(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public int d() {
        int i;
        if (this.m.f4193c <= 0 || (i = this.l) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void e() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public int f() {
        return this.l;
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public int g() {
        return this.f4205e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public ByteBuffer getData() {
        return this.f4205e;
    }

    private void b(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.k;
        int i = bVar2.f4188d;
        int i2 = bVar2.f4186b;
        int i3 = bVar2.f4187c;
        int i4 = bVar2.f4185a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f4202b;
        int i6 = 0;
        byte b2 = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.f4187c * i6;
            for (int i12 = i8; i12 < i9; i12++) {
                byte b3 = bArr[i11];
                int i13 = b3 & 255;
                if (i13 != b2) {
                    int i14 = iArr2[i13];
                    if (i14 != 0) {
                        iArr[i12] = i14;
                    } else {
                        b2 = b3;
                    }
                }
                i11++;
            }
            i6++;
            bVar2 = bVar;
        }
        Boolean bool = this.t;
        this.t = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.t == null && z && b2 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v17, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    private void c(b bVar) {
        int i;
        int i2;
        int i3;
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.f4205e.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = eVar.m;
            i = cVar.f4196f;
            i2 = cVar.g;
        } else {
            i = bVar.f4187c;
            i2 = bVar.f4188d;
        }
        int i4 = i * i2;
        byte[] bArr = eVar.j;
        if (bArr == null || bArr.length < i4) {
            eVar.j = eVar.f4204d.a(i4);
        }
        byte[] bArr2 = eVar.j;
        if (eVar.g == null) {
            eVar.g = new short[4096];
        }
        short[] sArr = eVar.g;
        if (eVar.h == null) {
            eVar.h = new byte[4096];
        }
        byte[] bArr3 = eVar.h;
        if (eVar.i == null) {
            eVar.i = new byte[m.a.f20899a];
        }
        byte[] bArr4 = eVar.i;
        int iJ = j();
        int i5 = 1 << iJ;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iJ + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = eVar.f4206f;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (i15 == 0) {
                i15 = i();
                if (i15 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i18 = 0;
            }
            i17 += (bArr5[i18] & 255) << i16;
            i18++;
            i15--;
            int i23 = i16 + 8;
            int i24 = i20;
            int i25 = i21;
            int i26 = i13;
            int i27 = i19;
            int i28 = i10;
            int i29 = i12;
            while (true) {
                if (i23 < i29) {
                    i12 = i29;
                    i21 = i25;
                    i10 = i28;
                    i19 = i27;
                    i16 = i23;
                    i13 = i26;
                    i20 = i24;
                    eVar = this;
                    break;
                }
                int i30 = i17 & i14;
                i17 >>= i29;
                i23 -= i29;
                if (i30 == i5) {
                    i29 = i8;
                    i26 = i7;
                    i14 = i9;
                    i24 = -1;
                } else {
                    if (i30 == i6) {
                        i16 = i23;
                        i12 = i29;
                        i10 = i28;
                        i19 = i27;
                        i13 = i26;
                        i21 = i25;
                        i20 = i24;
                        break;
                    }
                    if (i24 == -1) {
                        bArr2[i27] = bArr3[i30];
                        i27++;
                        i28++;
                        eVar = this;
                        i24 = i30;
                        i25 = i24;
                    } else {
                        int i31 = i26;
                        if (i30 >= i31) {
                            i3 = i23;
                            bArr4[i22] = (byte) i25;
                            i22++;
                            s = i24;
                        } else {
                            i3 = i23;
                            s = i30;
                        }
                        while (s >= i5) {
                            bArr4[i22] = bArr3[s];
                            i22++;
                            s = sArr[s];
                        }
                        int i32 = bArr3[s] & 255;
                        int i33 = i8;
                        byte b2 = (byte) i32;
                        bArr2[i27] = b2;
                        while (true) {
                            i27++;
                            i28++;
                            if (i22 <= 0) {
                                break;
                            }
                            i22--;
                            bArr2[i27] = bArr4[i22];
                        }
                        if (i31 < 4096) {
                            sArr[i31] = (short) i24;
                            bArr3[i31] = b2;
                            i31++;
                            if ((i31 & i14) == 0 && i31 < 4096) {
                                i29++;
                                i14 += i31;
                            }
                        }
                        i24 = i30;
                        i23 = i3;
                        i8 = i33;
                        i25 = i32;
                        i26 = i31;
                        eVar = this;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i19, i4, (byte) 0);
    }

    public e(a.InterfaceC0055a interfaceC0055a) {
        this.f4203c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f4204d = interfaceC0055a;
        this.m = new c();
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public synchronized Bitmap a() {
        if (this.m.f4193c <= 0 || this.l < 0) {
            if (Log.isLoggable(f4201a, 3)) {
                Log.d(f4201a, "Unable to decode frame, frameCount=" + this.m.f4193c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        if (this.p != 1 && this.p != 2) {
            this.p = 0;
            if (this.f4206f == null) {
                this.f4206f = this.f4204d.a(255);
            }
            b bVar = this.m.f4195e.get(this.l);
            int i = this.l - 1;
            b bVar2 = i >= 0 ? this.m.f4195e.get(i) : null;
            this.f4202b = bVar.k != null ? bVar.k : this.m.f4191a;
            if (this.f4202b == null) {
                if (Log.isLoggable(f4201a, 3)) {
                    Log.d(f4201a, "No valid color table found for frame #" + this.l);
                }
                this.p = 1;
                return null;
            }
            if (bVar.f4190f) {
                System.arraycopy(this.f4202b, 0, this.f4203c, 0, this.f4202b.length);
                this.f4202b = this.f4203c;
                this.f4202b[bVar.h] = 0;
                if (bVar.g == 2 && this.l == 0) {
                    this.t = true;
                }
            }
            return a(bVar, bVar2);
        }
        if (Log.isLoggable(f4201a, 3)) {
            Log.d(f4201a, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int iHighestOneBit = Integer.highestOneBit(i);
            this.p = 0;
            this.m = cVar;
            this.l = -1;
            this.f4205e = byteBuffer.asReadOnlyBuffer();
            this.f4205e.position(0);
            this.f4205e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<b> it = cVar.f4195e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().g == 3) {
                    this.o = true;
                    break;
                }
            }
            this.q = iHighestOneBit;
            this.s = cVar.f4196f / iHighestOneBit;
            this.r = cVar.g / iHighestOneBit;
            this.j = this.f4204d.a(cVar.f4196f * cVar.g);
            this.k = this.f4204d.b(this.s * this.r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.a
    public void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.u = config;
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.k;
        int i3 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f4204d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i2 = bVar2.g) > 0) {
            if (i2 == 2) {
                if (!bVar.f4190f) {
                    c cVar = this.m;
                    int i4 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.h) {
                        i3 = i4;
                    }
                }
                int i5 = bVar2.f4188d;
                int i6 = this.q;
                int i7 = i5 / i6;
                int i8 = bVar2.f4186b / i6;
                int i9 = bVar2.f4187c / i6;
                int i10 = bVar2.f4185a / i6;
                int i11 = this.s;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.s;
                }
            } else if (i2 == 3 && (bitmap = this.n) != null) {
                int i16 = this.s;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.r);
            }
        }
        c(bVar);
        if (!bVar.f4189e && this.q == 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.o && ((i = bVar.g) == 0 || i == 1)) {
            if (this.n == null) {
                this.n = h();
            }
            Bitmap bitmap3 = this.n;
            int i17 = this.s;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.r);
        }
        Bitmap bitmapH = h();
        int i18 = this.s;
        bitmapH.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
        return bitmapH;
    }

    private void a(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.k;
        int i6 = bVar.f4188d;
        int i7 = this.q;
        int i8 = i6 / i7;
        int i9 = bVar.f4186b / i7;
        int i10 = bVar.f4187c / i7;
        int i11 = bVar.f4185a / i7;
        Boolean bool = true;
        boolean z = this.l == 0;
        int i12 = this.q;
        int i13 = this.s;
        int i14 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f4202b;
        Boolean bool2 = this.t;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        int i18 = 8;
        while (i15 < i8) {
            Boolean bool3 = bool;
            if (bVar.f4189e) {
                if (i16 >= i8) {
                    i = i8;
                    i5 = i17 + 1;
                    if (i5 == 2) {
                        i16 = 4;
                    } else if (i5 == 3) {
                        i16 = 2;
                        i18 = 4;
                    } else if (i5 == 4) {
                        i16 = 1;
                        i18 = 2;
                    }
                } else {
                    i = i8;
                    i5 = i17;
                }
                i2 = i16 + i18;
                i17 = i5;
            } else {
                i = i8;
                i2 = i16;
                i16 = i15;
            }
            int i19 = i16 + i9;
            boolean z2 = i12 == 1;
            if (i19 < i14) {
                int i20 = i19 * i13;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i13;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i9;
                int i24 = i15 * i12 * bVar.f4187c;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i10;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i24 += i12;
                        i25++;
                        i10 = i26;
                    }
                } else {
                    i4 = i10;
                    int i28 = ((i22 - i21) * i12) + i24;
                    int i29 = i21;
                    while (i29 < i22) {
                        int i30 = i22;
                        int iA = a(i24, i28, bVar.f4187c);
                        if (iA != 0) {
                            iArr[i29] = iA;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i24 += i12;
                        i29++;
                        i22 = i30;
                    }
                    i15++;
                    i16 = i2;
                    i10 = i4;
                    bool = bool3;
                    i8 = i;
                    i9 = i3;
                }
            } else {
                i3 = i9;
            }
            i4 = i10;
            i15++;
            i16 = i2;
            i10 = i4;
            bool = bool3;
            i8 = i;
            i9 = i3;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool2 == null ? false : bool2.booleanValue());
        }
    }

    private int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.q + i; i9++) {
            byte[] bArr = this.j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f4202b[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.q + i11; i12++) {
            byte[] bArr2 = this.j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f4202b[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }
}
