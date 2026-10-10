package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpj {
    private byte[] data;
    private int zzbjy;
    private int zzbjz = 0;
    private int zzbka;

    public zzpj(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbjy = i;
        this.zzbka = i2;
        zziz();
    }

    private final boolean zzbm(int i) {
        if (2 > i || i >= this.zzbka) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    private final int zziy() {
        int i = 0;
        while (!zziv()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zzbk(i) : 0);
    }

    private final void zziz() {
        int i;
        int i2;
        int i3 = this.zzbjy;
        zzoz.checkState(i3 >= 0 && (i = this.zzbjz) >= 0 && i < 8 && (i3 < (i2 = this.zzbka) || (i3 == i2 && i == 0)));
    }

    public final int zzbk(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = zzbm(this.zzbjy + 1) ? this.zzbjy + 2 : this.zzbjy + 1;
            int i8 = this.zzbjz;
            if (i8 != 0) {
                byte[] bArr = this.data;
                i3 = ((bArr[i7] & 255) >>> (8 - i8)) | ((bArr[this.zzbjy] & 255) << i8);
            } else {
                i3 = this.data[this.zzbjy];
            }
            i -= 8;
            i5 |= (255 & i3) << i;
            this.zzbjy = i7;
        }
        if (i > 0) {
            int i9 = this.zzbjz + i;
            byte b2 = (byte) (255 >> (8 - i));
            int i10 = zzbm(this.zzbjy + 1) ? this.zzbjy + 2 : this.zzbjy + 1;
            if (i9 > 8) {
                byte[] bArr2 = this.data;
                i2 = (b2 & (((255 & bArr2[i10]) >> (16 - i9)) | ((bArr2[this.zzbjy] & 255) << (i9 - 8)))) | i5;
                this.zzbjy = i10;
            } else {
                i2 = (b2 & ((255 & this.data[this.zzbjy]) >> (8 - i9))) | i5;
                if (i9 == 8) {
                    this.zzbjy = i10;
                }
            }
            i5 = i2;
            this.zzbjz = i9 % 8;
        }
        zziz();
        return i5;
    }

    public final void zzbl(int i) {
        int i2 = this.zzbjy;
        this.zzbjy = (i / 8) + i2;
        this.zzbjz += i % 8;
        int i3 = this.zzbjz;
        if (i3 > 7) {
            this.zzbjy++;
            this.zzbjz = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbjy) {
                zziz();
                return;
            } else if (zzbm(i2)) {
                this.zzbjy++;
                i2 += 2;
            }
        }
    }

    public final boolean zziv() {
        return zzbk(1) == 1;
    }

    public final int zziw() {
        return zziy();
    }

    public final int zzix() {
        int iZziy = zziy();
        return (iZziy % 2 == 0 ? -1 : 1) * ((iZziy + 1) / 2);
    }
}
