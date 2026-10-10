package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbj implements zzeoy<View> {
    private final zzcbf zzfwx;

    private zzcbj(zzcbf zzcbfVar) {
        this.zzfwx = zzcbfVar;
    }

    public static zzcbj zza(zzcbf zzcbfVar) {
        return new zzcbj(zzcbfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return this.zzfwx.zzalb();
    }
}
