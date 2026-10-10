package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfx implements zzeoy<zzdfv> {
    private final zzeph<Context> zzesu;
    private final zzeph<String> zzevh;

    private zzdfx(zzeph<Context> zzephVar, zzeph<String> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzevh = zzephVar2;
    }

    public static zzdfx zzbe(zzeph<Context> zzephVar, zzeph<String> zzephVar2) {
        return new zzdfx(zzephVar, zzephVar2);
    }

    public static zzdfv zzu(Context context, String str) {
        return new zzdfv(context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzu(this.zzesu.get(), this.zzevh.get());
    }
}
