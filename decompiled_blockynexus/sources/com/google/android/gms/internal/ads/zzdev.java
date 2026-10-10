package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdev implements zzdgu<Bundle> {
    private final zzdnt zzfmt;

    public zzdev(zzdnt zzdntVar) {
        this.zzfmt = zzdntVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdnt zzdntVar = this.zzfmt;
        if (zzdntVar != null) {
            bundle2.putBoolean("render_in_browser", zzdntVar.zzate());
            bundle2.putBoolean("disable_ml", this.zzfmt.zzatf());
        }
    }
}
