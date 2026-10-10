package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtv implements zzeoy<Bundle> {
    private final zzbtp zzfuk;

    private zzbtv(zzbtp zzbtpVar) {
        this.zzfuk = zzbtpVar;
    }

    public static zzbtv zzj(zzbtp zzbtpVar) {
        return new zzbtv(zzbtpVar);
    }

    public static Bundle zzk(zzbtp zzbtpVar) {
        return zzbtpVar.zzajt();
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return this.zzfuk.zzajt();
    }
}
