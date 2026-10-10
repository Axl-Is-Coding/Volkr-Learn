package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdbw implements zzdya {
    static final zzdya zzboo = new zzdbw();

    private zzdbw() {
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final zzdzc zzf(Object obj) {
        final String str = (String) obj;
        return zzdyq.zzaf(new zzdgu(str) { // from class: com.google.android.gms.internal.ads.zzdbz
            private final String zzdgt;

            {
                this.zzdgt = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj2) {
                ((Bundle) obj2).putString("ms", this.zzdgt);
            }
        });
    }
}
