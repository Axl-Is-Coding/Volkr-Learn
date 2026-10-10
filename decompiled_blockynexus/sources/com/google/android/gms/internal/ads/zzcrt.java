package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcrt implements zzeoy<zzcru> {
    private final zzeph<Context> zzesu;

    private zzcrt(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    public static zzcrt zzaf(zzeph<Context> zzephVar) {
        return new zzcrt(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcru(this.zzesu.get());
    }
}
