package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrz implements zzeoy<zzbsa> {
    private final zzeph<Clock> zzfok;
    private final zzeph<zzaxw> zzfta;

    private zzbrz(zzeph<Clock> zzephVar, zzeph<zzaxw> zzephVar2) {
        this.zzfok = zzephVar;
        this.zzfta = zzephVar2;
    }

    public static zzbrz zzd(zzeph<Clock> zzephVar, zzeph<zzaxw> zzephVar2) {
        return new zzbrz(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbsa(this.zzfok.get(), this.zzfta.get());
    }
}
