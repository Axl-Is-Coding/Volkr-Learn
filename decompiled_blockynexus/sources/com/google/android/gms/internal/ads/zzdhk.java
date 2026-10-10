package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdhk implements zzdvu {
    static final zzdvu zzdwz = new zzdhk();

    private zzdhk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final Object apply(Object obj) {
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) obj;
        info.getClass();
        return new zzdhi(info, null);
    }
}
