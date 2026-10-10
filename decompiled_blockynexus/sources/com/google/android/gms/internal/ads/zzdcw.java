package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcw implements zzdgu<Bundle> {
    private final boolean zzgvw = false;
    private final boolean zzgvx = false;
    private final boolean zzgvy;

    public zzdcw(boolean z, boolean z2, boolean z3) {
        this.zzgvy = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("c_pcbg", this.zzgvw);
        bundle2.putBoolean("c_phbg", this.zzgvx);
        bundle2.putBoolean("ar_lr", this.zzgvy);
    }
}
