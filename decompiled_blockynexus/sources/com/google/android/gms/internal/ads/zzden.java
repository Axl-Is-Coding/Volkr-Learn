package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzden implements zzdgu<Bundle> {
    private final String zzdrr;
    private final boolean zzdrt;

    public zzden(String str, boolean z) {
        this.zzdrr = str;
        this.zzdrt = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("gct", this.zzdrr);
        if (this.zzdrt) {
            bundle2.putString("de", "1");
        }
    }
}
