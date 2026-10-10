package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzejc extends zzeja {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzifi;
    private int zzifj;
    private int zzifk;
    private int zzifl;
    private int zzifm;

    private zzejc(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzifm = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzifk = this.pos;
        this.zzifi = z;
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
            int r1 = r5.limit
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejc.zzbfh():int");
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
            int r1 = r11.limit
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejc.zzbfi():long");
    }

    private final int zzbfj() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzekj.zzbgx();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzbfk() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzekj.zzbgx();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzbfl() {
        this.limit += this.zzifj;
        int i = this.limit;
        int i2 = i - this.zzifk;
        int i3 = this.zzifm;
        if (i2 <= i3) {
            this.zzifj = 0;
        } else {
            this.zzifj = i2 - i3;
            this.limit = i - this.zzifj;
        }
    }

    private final byte zzbfm() throws IOException {
        int i = this.pos;
        if (i == this.limit) {
            throw zzekj.zzbgx();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzgd(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzekj.zzbgx();
        }
        throw zzekj.zzbgy();
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
            int i = this.limit;
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
        if (iZzbfh < 0) {
            throw zzekj.zzbgy();
        }
        throw zzekj.zzbgx();
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
        int iZzbfh = zzbfh();
        if (iZzbfh > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (iZzbfh <= i - i2) {
                String strZzo = zzeng.zzo(this.buffer, i2, iZzbfh);
                this.pos += iZzbfh;
                return strZzo;
            }
        }
        if (iZzbfh == 0) {
            return "";
        }
        if (iZzbfh <= 0) {
            throw zzekj.zzbgy();
        }
        throw zzekj.zzbgx();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    @Override // com.google.android.gms.internal.ads.zzeja
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzeip zzbex() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.zzbfh()
            if (r0 <= 0) goto L19
            int r1 = r3.limit
            int r2 = r3.pos
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.buffer
            com.google.android.gms.internal.ads.zzeip r1 = com.google.android.gms.internal.ads.zzeip.zzi(r1, r2, r0)
            int r2 = r3.pos
            int r2 = r2 + r0
            r3.pos = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.ads.zzeip r0 = com.google.android.gms.internal.ads.zzeip.zzier
            return r0
        L1e:
            if (r0 <= 0) goto L33
            int r1 = r3.limit
            int r2 = r3.pos
            int r1 = r1 - r2
            if (r0 > r1) goto L33
            int r0 = r0 + r2
            r3.pos = r0
            byte[] r0 = r3.buffer
            int r1 = r3.pos
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r2, r1)
            goto L39
        L33:
            if (r0 > 0) goto L43
            if (r0 != 0) goto L3e
            byte[] r0 = com.google.android.gms.internal.ads.zzekb.zziex
        L39:
            com.google.android.gms.internal.ads.zzeip r0 = com.google.android.gms.internal.ads.zzeip.zzv(r0)
            return r0
        L3e:
            com.google.android.gms.internal.ads.zzekj r0 = com.google.android.gms.internal.ads.zzekj.zzbgy()
            throw r0
        L43:
            com.google.android.gms.internal.ads.zzekj r0 = com.google.android.gms.internal.ads.zzekj.zzbgx()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejc.zzbex():com.google.android.gms.internal.ads.zzeip");
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
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final int zzbfg() {
        return this.pos - this.zzifk;
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
            if (this.limit - this.pos < 10) {
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
        int iZzbfg = i + zzbfg();
        int i2 = this.zzifm;
        if (iZzbfg > i2) {
            throw zzekj.zzbgx();
        }
        this.zzifm = iZzbfg;
        zzbfl();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeja
    public final void zzgb(int i) {
        this.zzifm = i;
        zzbfl();
    }
}
