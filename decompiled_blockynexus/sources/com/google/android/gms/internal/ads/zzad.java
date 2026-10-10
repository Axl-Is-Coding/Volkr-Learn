package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzad implements Runnable {
    private final /* synthetic */ String zzbd;
    private final /* synthetic */ long zzbe;
    private final /* synthetic */ zzaa zzbf;

    zzad(zzaa zzaaVar, String str, long j) {
        this.zzbf = zzaaVar;
        this.zzbd = str;
        this.zzbe = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbf.zzap.zza(this.zzbd, this.zzbe);
        this.zzbf.zzap.zzd(this.zzbf.toString());
    }
}
