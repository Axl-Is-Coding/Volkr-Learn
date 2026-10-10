package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdti extends zzdtd {
    private final String zzhmg;
    private final boolean zzxj;
    private final boolean zzzf;

    private zzdti(String str, boolean z, boolean z2) {
        this.zzhmg = str;
        this.zzxj = z;
        this.zzzf = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdtd) {
            zzdtd zzdtdVar = (zzdtd) obj;
            if (this.zzhmg.equals(zzdtdVar.zzavt()) && this.zzxj == zzdtdVar.zzavu() && this.zzzf == zzdtdVar.zzcm()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzhmg.hashCode() ^ 1000003) * 1000003) ^ (this.zzxj ? 1231 : 1237)) * 1000003) ^ (this.zzzf ? 1231 : 1237);
    }

    public final String toString() {
        String str = this.zzhmg;
        boolean z = this.zzxj;
        boolean z2 = this.zzzf;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdtd
    public final String zzavt() {
        return this.zzhmg;
    }

    @Override // com.google.android.gms.internal.ads.zzdtd
    public final boolean zzavu() {
        return this.zzxj;
    }

    @Override // com.google.android.gms.internal.ads.zzdtd
    public final boolean zzcm() {
        return this.zzzf;
    }
}
