package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaxu implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbcg zzdyg;

    zzaxu(zzaxv zzaxvVar, Context context, zzbcg zzbcgVar) {
        this.val$context = context;
        this.zzdyg = zzbcgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzdyg.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            this.zzdyg.setException(e2);
            zzbbq.zzc("Exception while getting advertising Id info", e2);
        }
    }
}
