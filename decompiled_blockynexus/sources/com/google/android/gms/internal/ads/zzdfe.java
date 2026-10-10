package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfe implements zzdgu<Bundle> {
    private final String zzgxb;

    public zzdfe(String str) {
        this.zzgxb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) || set.contains("banner");
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        zzdot.zza(bundle, "omid_v", this.zzgxb);
    }
}
