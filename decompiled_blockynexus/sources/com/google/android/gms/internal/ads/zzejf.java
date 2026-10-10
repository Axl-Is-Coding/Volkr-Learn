package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzejf extends zzeja {
    private final byte[] buffer;
    private int pos;
    private int zzakd;
    private int zzifj;
    private int zzifl;
    private int zzifm;
    private final InputStream zzifn;
    private int zzifo;
    private zzeje zzifp;

    private zzejf(InputStream inputStream, int i) {
        super();
        this.zzifm = Integer.MAX_VALUE;
        this.zzifp = null;
        zzekb.zza(inputStream, "input");
        this.zzifn = inputStream;
        this.buffer = new byte[i];
        this.zzakd = 0;
        this.pos = 0;
        this.zzifo = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzbfh() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzakd
            if (r1 == r0) goto L6b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.pos = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.pos = r1
            return r0
        L6b:
            long r0 = r5.zzbfe()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejf.zzbfh():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzbfi() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzakd
            if (r1 == r0) goto Lb5
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto Lb5
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L26
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
        L22:
            long r2 = (long) r0
            r3 = r2
            goto Lb2
        L26:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L37
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto Lb2
        L37:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L45
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L22
        L45:
            long r3 = (long) r0
            int r0 = r1 + 1
            r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L5c
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L58:
            long r1 = r1 ^ r3
            r3 = r1
        L5a:
            r1 = r0
            goto Lb2
        L5c:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L70
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L6e:
            long r3 = r3 ^ r5
            goto Lb2
        L70:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L83
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L58
        L83:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L96
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L6e
        L96:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L5a
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto Lb5
        Lb2:
            r11.pos = r1
            return r3
        Lb5:
            long r0 = r11.zzbfe()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejf.zzbfi():long");
    }

    private final int zzbfj() throws IOException {
        int i = this.pos;
        if (this.zzakd - i < 4) {
            zzge(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzbfk() throws IOException {
        int i = this.pos;
        if (this.zzakd - i < 8) {
            zzge(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzbfl() {
        this.zzakd += this.zzifj;
        int i = this.zzifo;
        int i2 = this.zzakd;
        int i3 = i + i2;
        int i4 = this.zzifm;
        if (i3 <= i4) {
            this.zzifj = 0;
        } else {
            this.zzifj = i3 - i4;
            this.zzakd = i2 - this.zzifj;
        }
    }

    private final byte zzbfm() throws IOException {
        if (this.pos == this.zzakd) {
            zzge(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzg(int i, boolean z) throws IOException {
        byte[] bArrZzgg = zzgg(i);
        if (bArrZzgg != null) {
            return bArrZzgg;
        }
        int i2 = this.pos;
        int i3 = this.zzakd;
        int length = i3 - i2;
        this.zzifo += i3;
        this.pos = 0;
        this.zzakd = 0;
        List<byte[]> listZzgh = zzgh(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, length);
        for (byte[] bArr2 : listZzgh) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    private final void zzgd(int i) throws IOException {
        int i2 = this.zzakd;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzekj.zzbgy();
        }
        int i4 = this.zzifo;
        int i5 = this.pos;
        int i6 = i4 + i5 + i;
        int i7 = this.zzifm;
        if (i6 > i7) {
            zzgd((i7 - i4) - i5);
            throw zzekj.zzbgx();
        }
        this.zzifo = i4 + i5;
        int i8 = this.zzakd - i5;
        this.zzakd = 0;
        this.pos = 0;
        while (i8 < i) {
            try {
                long j = i - i8;
                long jSkip = this.zzifn.skip(j);
                if (jSkip >= 0 && jSkip <= j) {
                    if (jSkip == 0) {
                        break;
                    } else {
                        i8 += (int) jSkip;
                    }
                } else {
                    String strValueOf = String.valueOf(this.zzifn.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 92);
                    sb.append(strValueOf);
                    sb.append("#skip returned invalid result: ");
                    sb.append(jSkip);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                }
            } finally {
                this.zzifo += i8;
                zzbfl();
            }
        }
        if (i8 >= i) {
            return;
        }
        int i9 = this.zzakd;
        int i10 = i9 - this.pos;
        this.pos = i9;
        zzge(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.zzakd;
            if (i11 <= i12) {
                this.pos = i11;
                return;
            } else {
                i10 += i12;
                this.pos = i12;
                zzge(1);
            }
        }
    }

    private final void zzge(int i) throws IOException {
        if (zzgf(i)) {
            return;
        }
        if (i <= (this.zziff - this.zzifo) - this.pos) {
            throw zzekj.zzbgx();
        }
        throw zzekj.zzbhd();
    }

    private final boolean zzgf(int i) throws IOException {
        do {
            int i2 = this.pos;
            int i3 = i2 + i;
            int i4 = this.zzakd;
            if (i3 <= i4) {
                StringBuilder sb = new StringBuilder(77);
                sb.append("refillBuffer() called when ");
                sb.append(i);
                sb.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb.toString());
            }
            int i5 = this.zziff;
            int i6 = this.zzifo;
            if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zzifm) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.zzifo += i2;
                this.zzakd -= i2;
                this.pos = 0;
            }
            InputStream inputStream = this.zzifn;
            byte[] bArr2 = this.buffer;
            int i7 = this.zzakd;
            int i8 = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.zziff - this.zzifo) - i7));
            if (i8 == 0 || i8 < -1 || i8 > this.buffer.length) {
                String strValueOf = String.valueOf(this.zzifn.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 91);
                sb2.append(strValueOf);
                sb2.append("#read(byte[]) returned invalid result: ");
                sb2.append(i8);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i8 <= 0) {
                return false;
            }
            this.zzakd += i8;
            zzbfl();
        } while (this.zzakd < i);
        return true;
    }

    private final byte[] zzgg(int i) throws IOException {
        if (i == 0) {
            return zzekb.zziex;
        }
        if (i < 0) {
            throw zzekj.zzbgy();
        }
        int i2 = this.zzifo;
        int i3 = this.pos;
        int i4 = i2 + i3 + i;
        if (i4 - this.zziff > 0) {
            throw zzekj.zzbhd();
        }
        int i5 = this.zzifm;
        if (i4 > i5) {
            zzgd((i5 - i2) - i3);
            throw zzekj.zzbgx();
        }
        int i6 = this.zzakd - i3;
        int i7 = i - i6;
        if (i7 >= 4096 && i7 > this.zzifn.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, this.pos, bArr, 0, i6);
        this.zzifo += this.zzakd;
        this.pos = 0;
        this.zzakd = 0;
        while (i6 < bArr.length) {
            int i8 = this.zzifn.read(bArr, i6, i - i6);
            if (i8 == -1) {
                throw zzekj.zzbgx();
            }
            this.zzifo += i8;
            i6 += i8;
        }
        return bArr;
    }

    private final List<byte[]> zzgh(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = this.zzifn.read(bArr, i2, bArr.length - i2);
                if (i3 == -1) {
                    throw zzekj.zzbgx();
                }
                this.zzifo += i3;
                i2 += i3;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzbfk());
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzbfj());
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final String readString() throws IOException {
        int iZzbfh = zzbfh();
        if (iZzbfh > 0) {
            int i = this.zzakd;
            int i2 = this.pos;
            if (iZzbfh <= i - i2) {
                String str = new String(this.buffer, i2, iZzbfh, zzekb.UTF_8);
                this.pos += iZzbfh;
                return str;
            }
        }
        if (iZzbfh == 0) {
            return "";
        }
        if (iZzbfh > this.zzakd) {
            return new String(zzg(iZzbfh, false), zzekb.UTF_8);
        }
        zzge(iZzbfh);
        String str2 = new String(this.buffer, this.pos, iZzbfh, zzekb.UTF_8);
        this.pos += iZzbfh;
        return str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbep() throws IOException {
        if (zzbff()) {
            this.zzifl = 0;
            return 0;
        }
        this.zzifl = zzbfh();
        int i = this.zzifl;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzekj.zzbha();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final long zzbeq() throws IOException {
        return zzbfi();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final long zzber() throws IOException {
        return zzbfi();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbes() throws IOException {
        return zzbfh();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final long zzbet() throws IOException {
        return zzbfk();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbeu() throws IOException {
        return zzbfj();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final boolean zzbev() throws IOException {
        return zzbfi() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final String zzbew() throws IOException {
        byte[] bArrZzg;
        int iZzbfh = zzbfh();
        int i = this.pos;
        int i2 = 0;
        if (iZzbfh <= this.zzakd - i && iZzbfh > 0) {
            bArrZzg = this.buffer;
            this.pos = i + iZzbfh;
            i2 = i;
        } else {
            if (iZzbfh == 0) {
                return "";
            }
            if (iZzbfh <= this.zzakd) {
                zzge(iZzbfh);
                bArrZzg = this.buffer;
                this.pos = iZzbfh;
            } else {
                bArrZzg = zzg(iZzbfh, false);
            }
        }
        return zzeng.zzo(bArrZzg, i2, iZzbfh);
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final zzeip zzbex() throws IOException {
        int iZzbfh = zzbfh();
        int i = this.zzakd;
        int i2 = this.pos;
        if (iZzbfh <= i - i2 && iZzbfh > 0) {
            zzeip zzeipVarZzi = zzeip.zzi(this.buffer, i2, iZzbfh);
            this.pos += iZzbfh;
            return zzeipVarZzi;
        }
        if (iZzbfh == 0) {
            return zzeip.zzier;
        }
        byte[] bArrZzgg = zzgg(iZzbfh);
        if (bArrZzgg != null) {
            return zzeip.zzu(bArrZzgg);
        }
        int i3 = this.pos;
        int i4 = this.zzakd;
        int length = i4 - i3;
        this.zzifo += i4;
        this.pos = 0;
        this.zzakd = 0;
        List<byte[]> listZzgh = zzgh(iZzbfh - length);
        byte[] bArr = new byte[iZzbfh];
        System.arraycopy(this.buffer, i3, bArr, 0, length);
        for (byte[] bArr2 : listZzgh) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return zzeip.zzv(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbey() throws IOException {
        return zzbfh();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbez() throws IOException {
        return zzbfh();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbfa() throws IOException {
        return zzbfj();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final long zzbfb() throws IOException {
        return zzbfk();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbfc() throws IOException {
        return zzeja.zzgc(zzbfh());
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final long zzbfd() throws IOException {
        return zzeja.zzfh(zzbfi());
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    final long zzbfe() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzbfm = zzbfm();
            j |= ((long) (bZzbfm & 127)) << i;
            if ((bZzbfm & 128) == 0) {
                return j;
            }
        }
        throw zzekj.zzbgz();
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final boolean zzbff() throws IOException {
        return this.pos == this.zzakd && !zzgf(1);
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbfg() {
        return this.zzifo + this.pos;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final void zzfy(int i) throws zzekj {
        if (this.zzifl != i) {
            throw zzekj.zzbhb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final boolean zzfz(int i) throws IOException {
        int iZzbep;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzakd - this.pos < 10) {
                while (i3 < 10) {
                    if (zzbfm() < 0) {
                        i3++;
                    }
                }
                throw zzekj.zzbgz();
            }
            while (i3 < 10) {
                byte[] bArr = this.buffer;
                int i4 = this.pos;
                this.pos = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzekj.zzbgz();
            return true;
        }
        if (i2 == 1) {
            zzgd(8);
            return true;
        }
        if (i2 == 2) {
            zzgd(zzbfh());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzekj.zzbhc();
            }
            zzgd(4);
            return true;
        }
        do {
            iZzbep = zzbep();
            if (iZzbep == 0) {
                break;
            }
        } while (zzfz(iZzbep));
        zzfy(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzga(int i) throws zzekj {
        if (i < 0) {
            throw zzekj.zzbgy();
        }
        int i2 = i + this.zzifo + this.pos;
        int i3 = this.zzifm;
        if (i2 > i3) {
            throw zzekj.zzbgx();
        }
        this.zzifm = i2;
        zzbfl();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final void zzgb(int i) {
        this.zzifm = i;
        zzbfl();
    }
}
