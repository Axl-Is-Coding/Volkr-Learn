package com.google.android.gms.internal.ads;

import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbre {
    private final String zzcib;
    private final zzdog zzevd;
    private final zzdnv zzfmx;

    public zzbre(zzdog zzdogVar, zzdnv zzdnvVar, String str) {
        this.zzevd = zzdogVar;
        this.zzfmx = zzdnvVar;
        this.zzcib = str == null ? AdUnit.GOOGLE_ADAPTER_CLASS : str;
    }

    public final zzdog zzajc() {
        return this.zzevd;
    }

    public final zzdnv zzajd() {
        return this.zzfmx;
    }

    public final zzdnw zzaje() {
        return this.zzevd.zzhew.zzeou;
    }

    public final String zzajf() {
        return this.zzcib;
    }
}
