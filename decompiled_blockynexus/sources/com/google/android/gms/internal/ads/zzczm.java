package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzczm implements zzdyr<zzboq> {
    private final /* synthetic */ zzbpm zzgta;
    final /* synthetic */ zzczj zzgtb;

    zzczm(zzczj zzczjVar, zzbpm zzbpmVar) {
        this.zzgtb = zzczjVar;
        this.zzgta = zzbpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzboq zzboqVar) {
        zzboq zzboqVar2 = zzboqVar;
        synchronized (this.zzgtb) {
            zzczj.zza(this.zzgtb, (zzdzc) null);
            if (this.zzgtb.zzgsg != null) {
                this.zzgtb.zzgsg.destroy();
            }
            this.zzgtb.zzgsg = zzboqVar2;
            this.zzgtb.zzfpw.removeAllViews();
            if (zzboqVar2.zzahx() != null) {
                ViewParent parent = zzboqVar2.zzahx().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = this.zzgtb.getMediationAdapterClassName();
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzbbq.zzfe(sb.toString());
                    ((ViewGroup) parent).removeView(zzboqVar2.zzahx());
                }
            }
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcye)).booleanValue()) {
                zzboqVar2.zzaiz().zza(this.zzgtb.zzgsq).zza(this.zzgtb.zzgsr).zza(this.zzgtb.zzgss).zza(this.zzgtb.zzgst);
            }
            this.zzgtb.zzfpw.addView(zzboqVar2.zzahx());
            zzboqVar2.zzaih();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcye)).booleanValue()) {
                Executor executorZzadi = this.zzgtb.zzgpt.zzadi();
                zzczs zzczsVar = this.zzgtb.zzgsq;
                zzczsVar.getClass();
                executorZzadi.execute(zzczl.zzb(zzczsVar));
            }
            this.zzgtb.zzgsu.zzdw(zzboqVar2.zzaig());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        final zzva zzvaVarZze = this.zzgta.zzaev().zze(th);
        synchronized (this.zzgtb) {
            zzczj.zza(this.zzgtb, (zzdzc) null);
            this.zzgta.zzaew().zzk(zzvaVarZze);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcye)).booleanValue()) {
                this.zzgtb.zzgpt.zzadi().execute(new Runnable(this, zzvaVarZze) { // from class: com.google.android.gms.internal.ads.zzczo
                    private final zzczm zzgtd;
                    private final zzva zzgte;

                    {
                        this.zzgtd = this;
                        this.zzgte = zzvaVarZze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzczm zzczmVar = this.zzgtd;
                        zzczmVar.zzgtb.zzgsq.zzk(this.zzgte);
                    }
                });
            }
            this.zzgtb.zzgsu.zzdw(60);
            zzdox.zza(zzvaVarZze.errorCode, th, "BannerAdManagerShim.onFailure");
        }
    }
}
