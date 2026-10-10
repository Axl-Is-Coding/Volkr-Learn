package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlh {
    public final zzkg zzasq;
    public final zzlp zzayl = new zzlp();
    public zzln zzaym;
    public zzlb zzayn;
    public int zzayo;
    public int zzayp;
    public int zzayq;
    public zzkf zzayr;
    public zzlq zzays;

    public zzlh(zzkg zzkgVar) {
        this.zzasq = zzkgVar;
    }

    public final void reset() {
        zzlp zzlpVar = this.zzayl;
        zzlpVar.zzban = 0;
        zzlpVar.zzbba = 0L;
        zzlpVar.zzbau = false;
        zzlpVar.zzbaz = false;
        zzlpVar.zzbaw = null;
        this.zzayo = 0;
        this.zzayq = 0;
        this.zzayp = 0;
        this.zzayr = null;
        this.zzays = null;
    }

    public final void zza(zzln zzlnVar, zzlb zzlbVar) {
        zzoz.checkNotNull(zzlnVar);
        this.zzaym = zzlnVar;
        zzoz.checkNotNull(zzlbVar);
        this.zzayn = zzlbVar;
        this.zzasq.zze(zzlnVar.zzahx);
        reset();
    }
}
