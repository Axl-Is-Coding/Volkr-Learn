package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbqo {
    protected final zzdnv zzeot;
    protected final zzdog zzfmw;
    private final zzbvb zzfrq;
    private final zzbvr zzfrr;
    private final zzdls zzfrs;
    private final zzbty zzfrt;
    private final zzbwv zzfru;

    protected zzbqo(zzbqn zzbqnVar) {
        this.zzfmw = zzbqnVar.zzfmw;
        this.zzeot = zzbqnVar.zzeot;
        this.zzfrq = zzbqnVar.zzfrq;
        this.zzfrr = zzbqnVar.zzfrr;
        this.zzfrs = zzbqnVar.zzfrs;
        this.zzfrt = zzbqnVar.zzfrt;
        this.zzfru = zzbqnVar.zzfru;
    }

    public void destroy() {
        this.zzfrq.zzcc(null);
    }

    public void zzaih() {
        this.zzfrr.onAdLoaded();
    }

    public final zzbvb zzaiw() {
        return this.zzfrq;
    }

    public final zzbty zzaix() {
        return this.zzfrt;
    }

    public final zzdls zzaiy() {
        return this.zzfrs;
    }

    public final zzbxq zzaiz() {
        return this.zzfru.zzaiz();
    }
}
