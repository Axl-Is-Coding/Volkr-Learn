package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdec implements zzdgx<zzdeh> {
    private final Context zzaai;
    private final zzdzb zzgcz;

    zzdec(Context context, zzdzb zzdzbVar) {
        this.zzaai = context;
        this.zzgcz = zzdzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdeh> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdef
            private final zzdec zzgwr;

            {
                this.zzgwr = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwr.zzarq();
            }
        });
    }

    final /* synthetic */ zzdeh zzarq() throws Exception {
        com.google.android.gms.ads.internal.zzp.zzkr();
        String strZzba = zzayu.zzba(this.zzaai);
        String string = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcwf)).booleanValue() ? this.zzaai.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.zzp.zzkr();
        return new zzdeh(strZzba, string, zzayu.zzbb(this.zzaai));
    }
}
