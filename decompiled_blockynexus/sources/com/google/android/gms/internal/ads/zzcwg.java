package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwg implements zzeoy<zzcwd> {
    private final zzeph<zzbwk> zzftr;
    private final zzeph<zzbix> zzfxn;
    private final zzeph<zzbtp.zza> zzfxo;
    private final zzeph<zzbys> zzfxp;
    private final zzeph<zzccw> zzfxq;
    private final zzeph<zzcyn> zzgpv;
    private final zzeph<ViewGroup> zzgpw;

    public zzcwg(zzeph<zzbix> zzephVar, zzeph<zzbtp.zza> zzephVar2, zzeph<zzcyn> zzephVar3, zzeph<zzbys> zzephVar4, zzeph<zzccw> zzephVar5, zzeph<zzbwk> zzephVar6, zzeph<ViewGroup> zzephVar7) {
        this.zzfxn = zzephVar;
        this.zzfxo = zzephVar2;
        this.zzgpv = zzephVar3;
        this.zzfxp = zzephVar4;
        this.zzfxq = zzephVar5;
        this.zzftr = zzephVar6;
        this.zzgpw = zzephVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcwd(this.zzfxn.get(), this.zzfxo.get(), this.zzgpv.get(), this.zzfxp.get(), this.zzfxq.get(), this.zzftr.get(), this.zzgpw.get());
    }
}
