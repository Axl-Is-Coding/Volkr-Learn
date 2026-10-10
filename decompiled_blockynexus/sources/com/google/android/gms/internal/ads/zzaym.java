package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaym extends zzayl {
    private Context zzvr;

    zzaym(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzvb() {
        boolean isAdIdFakeForDebugLogging;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zzvr);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzbbq.zzc("Fail to get isAdIdFakeForDebugLogging", e2);
            isAdIdFakeForDebugLogging = false;
        }
        zzbbk.zzar(isAdIdFakeForDebugLogging);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(isAdIdFakeForDebugLogging);
        zzbbq.zzfe(sb.toString());
    }
}
