package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfv implements zzdgx<zzdgu<Bundle>> {
    private final String zzfui;
    private final Context zzvr;

    zzdfv(Context context, String str) {
        this.zzvr = context;
        this.zzfui = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        return zzdyq.zzaf(this.zzfui == null ? null : new zzdgu(this) { // from class: com.google.android.gms.internal.ads.zzdfu
            private final zzdfv zzgxg;

            {
                this.zzgxg = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj) {
                this.zzgxg.zzq((Bundle) obj);
            }
        });
    }

    final /* synthetic */ void zzq(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzvr.getPackageName());
    }
}
