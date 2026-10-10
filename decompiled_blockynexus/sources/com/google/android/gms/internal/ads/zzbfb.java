package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfb implements zzom {
    private Uri uri;
    private final zzom zzele;
    private final long zzelf;
    private final zzom zzelg;
    private long zzelh;

    zzbfb(zzom zzomVar, int i, zzom zzomVar2) {
        this.zzele = zzomVar;
        this.zzelf = i;
        this.zzelg = zzomVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final void close() throws IOException {
        this.zzele.close();
        this.zzelg.close();
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzelh;
        long j2 = this.zzelf;
        if (j < j2) {
            i3 = this.zzele.read(bArr, i, (int) Math.min(i2, j2 - j));
            this.zzelh += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzelh < this.zzelf) {
            return i3;
        }
        int i4 = this.zzelg.read(bArr, i + i3, i2 - i3);
        int i5 = i3 + i4;
        this.zzelh += (long) i4;
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzonVar) throws IOException {
        zzon zzonVar2;
        zzon zzonVar3;
        this.uri = zzonVar.uri;
        long j = zzonVar.position;
        long j2 = this.zzelf;
        if (j >= j2) {
            zzonVar2 = null;
        } else {
            long j3 = zzonVar.zzcp;
            zzonVar2 = new zzon(zzonVar.uri, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, null);
        }
        long j4 = zzonVar.zzcp;
        if (j4 == -1 || zzonVar.position + j4 > this.zzelf) {
            long jMax = Math.max(this.zzelf, zzonVar.position);
            long j5 = zzonVar.zzcp;
            zzonVar3 = new zzon(zzonVar.uri, jMax, j5 != -1 ? Math.min(j5, (zzonVar.position + j5) - this.zzelf) : -1L, null);
        } else {
            zzonVar3 = null;
        }
        long jZza = zzonVar2 != null ? this.zzele.zza(zzonVar2) : 0L;
        long jZza2 = zzonVar3 != null ? this.zzelg.zza(zzonVar3) : 0L;
        this.zzelh = zzonVar.position;
        if (jZza == -1 || jZza2 == -1) {
            return -1L;
        }
        return jZza + jZza2;
    }
}
