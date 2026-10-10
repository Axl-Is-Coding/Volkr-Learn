package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbox implements zzeoy<View> {
    private final zzbot zzfqp;

    public zzbox(zzbot zzbotVar) {
        this.zzfqp = zzbotVar;
    }

    public static View zza(zzbot zzbotVar) {
        View viewZzahx = zzbotVar.zzahx();
        zzepe.zza(viewZzahx, "Cannot return null from a non-@Nullable @Provides method");
        return viewZzahx;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqp);
    }
}
