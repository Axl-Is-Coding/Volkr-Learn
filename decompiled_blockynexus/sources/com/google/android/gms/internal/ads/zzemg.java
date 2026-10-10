package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemg extends InputStream {
    private int mark;
    private final /* synthetic */ zzemc zzimn;
    private zzemd zzimx;
    private zzeiw zzimy;
    private int zzimz;
    private int zzina;
    private int zzinb;

    public zzemg(zzemc zzemcVar) {
        this.zzimn = zzemcVar;
        initialize();
    }

    private final void initialize() {
        this.zzimx = new zzemd(this.zzimn, null);
        this.zzimy = (zzeiw) this.zzimx.next();
        this.zzimz = this.zzimy.size();
        this.zzina = 0;
        this.zzinb = 0;
    }

    private final void zzbig() {
        if (this.zzimy != null) {
            int i = this.zzina;
            int i2 = this.zzimz;
            if (i == i2) {
                this.zzinb += i2;
                this.zzina = 0;
                if (this.zzimx.hasNext()) {
                    this.zzimy = (zzeiw) this.zzimx.next();
                    this.zzimz = this.zzimy.size();
                } else {
                    this.zzimy = null;
                    this.zzimz = 0;
                }
            }
        }
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            zzbig();
            if (this.zzimy == null) {
                break;
            }
            int iMin = Math.min(this.zzimz - this.zzina, i4);
            if (bArr != null) {
                this.zzimy.zza(bArr, this.zzina, i3, iMin);
                i3 += iMin;
            }
            this.zzina += iMin;
            i4 -= iMin;
        }
        return i2 - i4;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.zzimn.size() - (this.zzinb + this.zzina);
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.mark = this.zzinb + this.zzina;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int iZzl = zzl(bArr, i, i2);
        if (iZzl == 0) {
            return -1;
        }
        return iZzl;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        initialize();
        zzl(null, 0, this.mark);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return zzl(null, 0, (int) j);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        zzbig();
        zzeiw zzeiwVar = this.zzimy;
        if (zzeiwVar == null) {
            return -1;
        }
        int i = this.zzina;
        this.zzina = i + 1;
        return zzeiwVar.zzfu(i) & 255;
    }
}
