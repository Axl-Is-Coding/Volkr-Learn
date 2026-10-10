package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcv implements zzdgx<Object> {
    private static final Object lock = new Object();
    private final String zzcja;
    private final String zzdqu;
    private final zzdok zzfsk;
    private final zzbsa zzgvu;
    private final zzdpj zzgvv;

    public zzdcv(String str, String str2, zzbsa zzbsaVar, zzdpj zzdpjVar, zzdok zzdokVar) {
        this.zzdqu = str;
        this.zzcja = str2;
        this.zzgvu = zzbsaVar;
        this.zzgvv = zzdpjVar;
        this.zzfsk = zzdokVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<Object> zzarj() {
        final Bundle bundle = new Bundle();
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcve)).booleanValue()) {
            this.zzgvu.zzf(this.zzfsk.zzhfa);
            bundle.putAll(this.zzgvv.zzatu());
        }
        return zzdyq.zzaf(new zzdgu(this, bundle) { // from class: com.google.android.gms.internal.ads.zzdcu
            private final Bundle zzdyd;
            private final zzdcv zzgvt;

            {
                this.zzgvt = this;
                this.zzdyd = bundle;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj) {
                this.zzgvt.zzb(this.zzdyd, (Bundle) obj);
            }
        });
    }

    final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcve)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvd)).booleanValue()) {
                synchronized (lock) {
                    this.zzgvu.zzf(this.zzfsk.zzhfa);
                    bundle2.putBundle("quality_signals", this.zzgvv.zzatu());
                }
            } else {
                this.zzgvu.zzf(this.zzfsk.zzhfa);
                bundle2.putBundle("quality_signals", this.zzgvv.zzatu());
            }
        }
        bundle2.putString("seq_num", this.zzdqu);
        bundle2.putString("session_id", this.zzcja);
    }
}
