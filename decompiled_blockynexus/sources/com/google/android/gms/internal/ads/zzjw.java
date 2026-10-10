package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjw implements zzjy {
    private static final byte[] zzaor = new byte[4096];
    private long position;
    private final zzom zzaos;
    private final long zzaot;
    private byte[] zzaou = new byte[65536];
    private int zzaov;
    private int zzaow;

    public zzjw(zzom zzomVar, long j, long j2) {
        this.zzaos = zzomVar;
        this.position = j;
        this.zzaot = j2;
    }

    private final int zzak(int i) {
        int iMin = Math.min(this.zzaow, i);
        zzal(iMin);
        return iMin;
    }

    private final void zzal(int i) {
        this.zzaow -= i;
        this.zzaov = 0;
        byte[] bArr = this.zzaou;
        int i2 = this.zzaow;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.zzaou, i, bArr, 0, this.zzaow);
        this.zzaou = bArr;
    }

    private final void zzam(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzaow;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.zzaou, 0, bArr, i, iMin);
        zzal(iMin);
        return iMin;
    }

    private final boolean zzd(int i, boolean z) throws InterruptedException, IOException {
        int i2 = this.zzaov + i;
        byte[] bArr = this.zzaou;
        if (i2 > bArr.length) {
            this.zzaou = Arrays.copyOf(this.zzaou, zzpq.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int iMin = Math.min(this.zzaow - this.zzaov, i);
        while (iMin < i) {
            iMin = zza(this.zzaou, this.zzaov, i, iMin, false);
            if (iMin == -1) {
                return false;
            }
        }
        this.zzaov += i;
        this.zzaow = Math.max(this.zzaow, this.zzaov);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final long getLength() {
        return this.zzaot;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final long getPosition() {
        return this.position;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final int read(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        int iZzb = zzb(bArr, i, i2);
        if (iZzb == 0) {
            iZzb = zza(bArr, i, i2, 0, true);
        }
        zzam(iZzb);
        return iZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void readFully(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException {
        int iZzb = zzb(bArr, i, i2);
        while (iZzb < i2 && iZzb != -1) {
            iZzb = zza(bArr, i, i2, iZzb, z);
        }
        zzam(iZzb);
        return iZzb != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final int zzah(int i) throws InterruptedException, IOException {
        int iZzak = zzak(i);
        if (iZzak == 0) {
            byte[] bArr = zzaor;
            iZzak = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzam(iZzak);
        return iZzak;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzai(int i) throws InterruptedException, IOException {
        int iZzak = zzak(i);
        while (iZzak < i && iZzak != -1) {
            byte[] bArr = zzaor;
            iZzak = zza(bArr, -iZzak, Math.min(i, bArr.length + iZzak), iZzak, false);
        }
        zzam(iZzak);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzaj(int i) throws InterruptedException, IOException {
        zzd(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzgq() {
        this.zzaov = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zza(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzaou, this.zzaov - i2, bArr, i, i2);
        }
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int i4 = this.zzaos.read(bArr, i + i3, i2 - i3);
            if (i4 != -1) {
                return i3 + i4;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }
}
