package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcct implements zzeoy<zzccu> {
    private final zzeph<zzcep> zzfqj;
    private final zzeph<Map<String, zzcta<zzbqu>>> zzfrv;
    private final zzeph<Map<String, zzcta<zzcdx>>> zzfxf;
    private final zzeph<Map<String, zzcvl<zzcdx>>> zzfxg;
    private final zzeph<zzbqp<zzboq>> zzfxh;

    public zzcct(zzeph<Map<String, zzcta<zzbqu>>> zzephVar, zzeph<Map<String, zzcta<zzcdx>>> zzephVar2, zzeph<Map<String, zzcvl<zzcdx>>> zzephVar3, zzeph<zzbqp<zzboq>> zzephVar4, zzeph<zzcep> zzephVar5) {
        this.zzfrv = zzephVar;
        this.zzfxf = zzephVar2;
        this.zzfxg = zzephVar3;
        this.zzfxh = zzephVar4;
        this.zzfqj = zzephVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzccu(this.zzfrv.get(), this.zzfxf.get(), this.zzfxg.get(), this.zzfxh, this.zzfqj.get());
    }
}
