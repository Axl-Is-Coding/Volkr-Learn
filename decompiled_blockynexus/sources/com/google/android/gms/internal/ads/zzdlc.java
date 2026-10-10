package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdlc<R> implements zzdqy {
    public final Executor executor;
    public final String zzbuu;
    public final zzvg zzdqr;
    public final zzvs zzgvr;
    public final zzdlx<R> zzhbq;
    public final zzdlw zzhbr;
    private final zzdqj zzhbs;

    public zzdlc(zzdlx<R> zzdlxVar, zzdlw zzdlwVar, zzvg zzvgVar, String str, Executor executor, zzvs zzvsVar, zzdqj zzdqjVar) {
        this.zzhbq = zzdlxVar;
        this.zzhbr = zzdlwVar;
        this.zzdqr = zzvgVar;
        this.zzbuu = str;
        this.executor = executor;
        this.zzgvr = zzvsVar;
        this.zzhbs = zzdqjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdqy
    public final Executor getExecutor() {
        return this.executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdqy
    public final zzdqj zzasx() {
        return this.zzhbs;
    }

    @Override // com.google.android.gms.internal.ads.zzdqy
    public final zzdqy zzasy() {
        return new zzdlc(this.zzhbq, this.zzhbr, this.zzdqr, this.zzbuu, this.executor, this.zzgvr, this.zzhbs);
    }
}
