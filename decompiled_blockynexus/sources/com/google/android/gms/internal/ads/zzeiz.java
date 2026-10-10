package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzeiz extends zzeiw {
    protected final byte[] zzifc;

    zzeiz(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzifc = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeip) || size() != ((zzeip) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzeiz)) {
            return obj.equals(this);
        }
        zzeiz zzeizVar = (zzeiz) obj;
        int iZzbel = zzbel();
        int iZzbel2 = zzeizVar.zzbel();
        if (iZzbel == 0 || iZzbel2 == 0 || iZzbel == iZzbel2) {
            return zza(zzeizVar, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public int size() {
        return this.zzifc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    final void zza(zzeim zzeimVar) throws IOException {
        zzeimVar.zzh(this.zzifc, zzbem(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzifc, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final boolean zzbeg() {
        int iZzbem = zzbem();
        return zzeng.zzm(this.zzifc, iZzbem, size() + iZzbem);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeja zzbeh() {
        return zzeja.zzb(this.zzifc, zzbem(), size(), true);
    }

    protected int zzbem() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public byte zzfu(int i) {
        return this.zzifc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    byte zzfv(int i) {
        return this.zzifc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final int zzg(int i, int i2, int i3) {
        int iZzbem = zzbem() + i2;
        return zzeng.zzb(i, this.zzifc, iZzbem, i3 + iZzbem);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final int zzh(int i, int i2, int i3) {
        return zzekb.zza(i, this.zzifc, zzbem() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeip zzz(int i, int i2) {
        int iZzi = zzeip.zzi(i, i2, size());
        return iZzi == 0 ? zzeip.zzier : new zzeis(this.zzifc, zzbem() + i, iZzi);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final String zza(Charset charset) {
        return new String(this.zzifc, zzbem(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzeiw
    final boolean zza(zzeip zzeipVar, int i, int i2) {
        if (i2 <= zzeipVar.size()) {
            int i3 = i + i2;
            if (i3 <= zzeipVar.size()) {
                if (zzeipVar instanceof zzeiz) {
                    zzeiz zzeizVar = (zzeiz) zzeipVar;
                    byte[] bArr = this.zzifc;
                    byte[] bArr2 = zzeizVar.zzifc;
                    int iZzbem = zzbem() + i2;
                    int iZzbem2 = zzbem();
                    int iZzbem3 = zzeizVar.zzbem() + i;
                    while (iZzbem2 < iZzbem) {
                        if (bArr[iZzbem2] != bArr2[iZzbem3]) {
                            return false;
                        }
                        iZzbem2++;
                        iZzbem3++;
                    }
                    return true;
                }
                return zzeipVar.zzz(i, i3).equals(zzz(0, i2));
            }
            int size = zzeipVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }
}
