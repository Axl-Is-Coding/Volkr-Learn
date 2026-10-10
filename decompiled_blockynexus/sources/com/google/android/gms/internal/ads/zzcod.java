package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcod extends zzair {
    private final /* synthetic */ zzcnu zzgis;
    private final /* synthetic */ Object zzgit;
    private final /* synthetic */ String zzgiu;
    private final /* synthetic */ long zzgiv;
    private final /* synthetic */ zzbcg zzgiw;

    zzcod(zzcnu zzcnuVar, Object obj, String str, long j, zzbcg zzbcgVar) {
        this.zzgis = zzcnuVar;
        this.zzgit = obj;
        this.zzgiu = str;
        this.zzgiv = j;
        this.zzgiw = zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void onInitializationFailed(String str) {
        synchronized (this.zzgit) {
            this.zzgis.zza(this.zzgiu, false, str, (int) (com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgiv));
            this.zzgis.zzgik.zzs(this.zzgiu, "error");
            this.zzgiw.set(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void onInitializationSucceeded() {
        synchronized (this.zzgit) {
            this.zzgis.zza(this.zzgiu, true, "", (int) (com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgiv));
            this.zzgis.zzgik.zzgk(this.zzgiu);
            this.zzgiw.set(true);
        }
    }
}
