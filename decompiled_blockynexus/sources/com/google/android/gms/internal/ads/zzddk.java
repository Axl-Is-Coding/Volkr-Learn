package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddk implements zzdgx<zzdgu<Bundle>> {
    private final zzdlf zzgwe;

    zzddk(zzdlf zzdlfVar) {
        this.zzgwe = zzdlfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        zzdlf zzdlfVar = this.zzgwe;
        return zzdyq.zzaf((zzdlfVar == null || zzdlfVar.zzasz() == null || this.zzgwe.zzasz().isEmpty()) ? null : new zzdgu(this) { // from class: com.google.android.gms.internal.ads.zzddn
            private final zzddk zzgwf;

            {
                this.zzgwf = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj) {
                this.zzgwf.zzp((Bundle) obj);
            }
        });
    }

    final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("key_schema", this.zzgwe.zzasz());
    }
}
