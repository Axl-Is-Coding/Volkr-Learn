package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpi implements zzeoy<Clock> {
    private final zzdpf zzhgk;

    public zzdpi(zzdpf zzdpfVar) {
        this.zzhgk = zzdpfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Clock defaultClock = DefaultClock.getInstance();
        zzepe.zza(defaultClock, "Cannot return null from a non-@Nullable @Provides method");
        return defaultClock;
    }
}
