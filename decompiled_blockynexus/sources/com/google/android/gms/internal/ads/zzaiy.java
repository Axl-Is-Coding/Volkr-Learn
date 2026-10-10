package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaiy implements AdapterStatus {
    private final String description;
    private final int zzdgb;
    private final AdapterStatus.State zzdgd;

    public zzaiy(AdapterStatus.State state, String str, int i) {
        this.zzdgd = state;
        this.description = str;
        this.zzdgb = i;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State getInitializationState() {
        return this.zzdgd;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzdgb;
    }
}
