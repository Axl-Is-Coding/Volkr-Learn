package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcwm<T> implements zzdyr<T> {
    private final /* synthetic */ zzdnw zzgeq;
    private final /* synthetic */ long zzgqa;
    private final /* synthetic */ String zzgqb;
    private final /* synthetic */ zzdnv zzgqc;
    private final /* synthetic */ zzcwj zzgqd;

    zzcwm(zzcwj zzcwjVar, long j, String str, zzdnv zzdnvVar, zzdnw zzdnwVar) {
        this.zzgqd = zzcwjVar;
        this.zzgqa = j;
        this.zzgqb = str;
        this.zzgqc = zzdnvVar;
        this.zzgeq = zzdnwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void onSuccess(T t) {
        long jElapsedRealtime = this.zzgqd.zzbqa.elapsedRealtime() - this.zzgqa;
        this.zzgqd.zza(this.zzgqb, 0, jElapsedRealtime, this.zzgqc.zzheh);
        if (this.zzgqd.zzgpz) {
            this.zzgqd.zzgpx.zza(this.zzgeq, this.zzgqc, 0, null, jElapsedRealtime);
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue()) {
            this.zzgqd.zzfst.zza(this.zzgqc, jElapsedRealtime, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzva zzvaVar;
        long jElapsedRealtime = this.zzgqd.zzbqa.elapsedRealtime() - this.zzgqa;
        int i = th instanceof TimeoutException ? 2 : th instanceof zzcvz ? 3 : th instanceof CancellationException ? 4 : th instanceof zzdos ? 5 : ((th instanceof zzcof) && zzdpe.zzh(th).errorCode == 3) ? 1 : 6;
        this.zzgqd.zza(this.zzgqb, i, jElapsedRealtime, this.zzgqc.zzheh);
        if (this.zzgqd.zzgpz) {
            this.zzgqd.zzgpx.zza(this.zzgeq, this.zzgqc, i, th instanceof zzcte ? (zzcte) th : null, jElapsedRealtime);
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue()) {
            zzva zzvaVarZzh = zzdpe.zzh(th);
            int i2 = zzvaVarZzh.errorCode;
            if ((i2 == 3 || i2 == 0) && (zzvaVar = zzvaVarZzh.zzcgy) != null && !zzvaVar.zzcgx.equals(MobileAds.ERROR_DOMAIN)) {
                zzvaVarZzh = zzdpe.zzh(new zzcte(zzdpg.MEDIATION_NO_FILL, zzvaVarZzh.zzcgy));
            }
            this.zzgqd.zzfst.zza(this.zzgqc, jElapsedRealtime, zzvaVarZzh);
        }
    }
}
