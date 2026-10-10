package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcfy implements zzahq {
    static final zzahq zzdfl = new zzcfy();

    private zzcfy() {
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map map) {
        zzbbq.zzef("Show native ad policy validator overlay.");
        ((zzbgj) obj).getView().setVisibility(0);
    }
}
