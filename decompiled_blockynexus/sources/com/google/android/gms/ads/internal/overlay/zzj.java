package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ads.zzayl;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzj extends zzayl {
    final /* synthetic */ zze zzdph;

    private zzj(zze zzeVar) {
        this.zzdph = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzvb() {
        Bitmap bitmapZza = com.google.android.gms.ads.internal.zzp.zzlk().zza(Integer.valueOf(this.zzdph.zzdoo.zzdpt.zzbpa));
        if (bitmapZza != null) {
            zzazd zzazdVarZzkt = com.google.android.gms.ads.internal.zzp.zzkt();
            zze zzeVar = this.zzdph;
            Activity activity = zzeVar.zzaas;
            com.google.android.gms.ads.internal.zzi zziVar = zzeVar.zzdoo.zzdpt;
            final Drawable drawableZza = zzazdVarZzkt.zza(activity, bitmapZza, zziVar.zzboy, zziVar.zzboz);
            zzayu.zzeba.post(new Runnable(this, drawableZza) { // from class: com.google.android.gms.ads.internal.overlay.zzm
                private final zzj zzdpj;
                private final Drawable zzdpk;

                {
                    this.zzdpj = this;
                    this.zzdpk = drawableZza;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzj zzjVar = this.zzdpj;
                    zzjVar.zzdph.zzaas.getWindow().setBackgroundDrawable(this.zzdpk);
                }
            });
        }
    }
}
