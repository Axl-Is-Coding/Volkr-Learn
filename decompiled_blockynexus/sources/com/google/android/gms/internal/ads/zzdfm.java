package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfm implements zzdgu<Bundle> {
    private final Bundle zzfuh;

    public zzdfm(Bundle bundle) {
        this.zzfuh = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.zzfuh;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
