package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzgz extends zzha {
    protected final byte[] zzb;

    zzgz(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgp) || zza() != ((zzgp) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzgz)) {
            return obj.equals(this);
        }
        zzgz zzgzVar = (zzgz) obj;
        int iZzd = zzd();
        int iZzd2 = zzgzVar.zzd();
        if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
            return zza(zzgzVar, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public final boolean zzc() {
        int iZze = zze();
        return zzlb.zza(this.zzb, iZze, zza() + iZze);
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public final zzgp zza(int i, int i2) {
        int iZzb = zzgp.zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzgp.zza;
        }
        return new zzgw(this.zzb, zze(), iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    final void zza(zzgq zzgqVar) throws IOException {
        zzgqVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzha
    final boolean zza(zzgp zzgpVar, int i, int i2) {
        if (i2 <= zzgpVar.zza()) {
            if (i2 <= zzgpVar.zza()) {
                if (zzgpVar instanceof zzgz) {
                    zzgz zzgzVar = (zzgz) zzgpVar;
                    byte[] bArr = this.zzb;
                    byte[] bArr2 = zzgzVar.zzb;
                    int iZze = zze() + i2;
                    int iZze2 = zze();
                    int iZze3 = zzgzVar.zze();
                    while (iZze2 < iZze) {
                        if (bArr[iZze2] != bArr2[iZze3]) {
                            return false;
                        }
                        iZze2++;
                        iZze3++;
                    }
                    return true;
                }
                return zzgpVar.zza(0, i2).equals(zza(0, i2));
            }
            int iZza = zzgpVar.zza();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i2);
            sb.append(", ");
            sb.append(iZza);
            throw new IllegalArgumentException(sb.toString());
        }
        int iZza2 = zza();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(iZza2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    protected final int zza(int i, int i2, int i3) {
        return zzia.zza(i, this.zzb, zze(), i3);
    }
}
