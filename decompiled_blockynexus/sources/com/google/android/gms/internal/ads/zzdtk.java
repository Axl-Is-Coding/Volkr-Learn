package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdtk extends zzdtg {
    private String zzhmg;
    private Boolean zzhmh;
    private Boolean zzhmi;

    zzdtk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    public final zzdtd zzavw() {
        String strConcat = this.zzhmg == null ? "".concat(" clientVersion") : "";
        if (this.zzhmh == null) {
            strConcat = String.valueOf(strConcat).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhmi == null) {
            strConcat = String.valueOf(strConcat).concat(" isGooglePlayServicesAvailable");
        }
        if (strConcat.isEmpty()) {
            return new zzdti(this.zzhmg, this.zzhmh.booleanValue(), this.zzhmi.booleanValue());
        }
        String strValueOf = String.valueOf(strConcat);
        throw new IllegalStateException(strValueOf.length() != 0 ? "Missing required properties:".concat(strValueOf) : new String("Missing required properties:"));
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    public final zzdtg zzbq(boolean z) {
        this.zzhmh = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    public final zzdtg zzbr(boolean z) {
        this.zzhmi = true;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    public final zzdtg zzhb(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.zzhmg = str;
        return this;
    }
}
