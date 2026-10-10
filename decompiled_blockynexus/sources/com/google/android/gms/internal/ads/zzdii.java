package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdii implements zzeoy<zzdig> {
    private final zzeph<Context> zzfth;

    public zzdii(zzeph<Context> zzephVar) {
        this.zzfth = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdig(this.zzfth.get());
    }
}
