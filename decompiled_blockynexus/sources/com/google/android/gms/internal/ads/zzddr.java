package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddr implements zzdgu<Bundle> {
    private final String zzguw;

    public zzddr(String str) {
        this.zzguw = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (TextUtils.isEmpty(this.zzguw)) {
            return;
        }
        bundle2.putString("fwd_cld", this.zzguw);
    }
}
