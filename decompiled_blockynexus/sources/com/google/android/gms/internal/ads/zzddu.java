package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddu implements zzeoy<zzddp<zzdha>> {
    private final zzeph<zzdhd> zzeug;
    private final zzeph<Clock> zzfok;

    public zzddu(zzeph<zzdhd> zzephVar, zzeph<Clock> zzephVar2) {
        this.zzeug = zzephVar;
        this.zzfok = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzddp zzddpVar = new zzddp(this.zzeug.get(), zzaco.zzdam.get().longValue(), this.zzfok.get());
        zzepe.zza(zzddpVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzddpVar;
    }
}
