package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkp {
    private final zzpk zzaps = new zzpk(8);
    private int zzarl;

    private final long zzc(zzjy zzjyVar) throws InterruptedException, IOException {
        int i = 0;
        zzjyVar.zza(this.zzaps.data, 0, 1);
        int i2 = this.zzaps.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (i3 ^ (-1));
        zzjyVar.zza(this.zzaps.data, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.zzaps.data[i] & 255) + (i5 << 8);
        }
        this.zzarl += i4 + 1;
        return i5;
    }

    public final boolean zza(zzjy zzjyVar) throws InterruptedException, IOException {
        long length = zzjyVar.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        zzjyVar.zza(this.zzaps.data, 0, 4);
        long jZzjc = this.zzaps.zzjc();
        this.zzarl = 4;
        while (jZzjc != 440786851) {
            int i2 = this.zzarl + 1;
            this.zzarl = i2;
            if (i2 == i) {
                return false;
            }
            zzjyVar.zza(this.zzaps.data, 0, 1);
            jZzjc = ((jZzjc << 8) & (-256)) | ((long) (this.zzaps.data[0] & 255));
        }
        long jZzc = zzc(zzjyVar);
        long j2 = this.zzarl;
        if (jZzc != Long.MIN_VALUE && (length == -1 || j2 + jZzc < length)) {
            while (true) {
                int i3 = this.zzarl;
                long j3 = j2 + jZzc;
                if (i3 < j3) {
                    if (zzc(zzjyVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jZzc2 = zzc(zzjyVar);
                    if (jZzc2 < 0 || jZzc2 > 2147483647L) {
                        break;
                    }
                    if (jZzc2 != 0) {
                        zzjyVar.zzaj((int) jZzc2);
                        this.zzarl = (int) (((long) this.zzarl) + jZzc2);
                    }
                } else if (i3 == j3) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
