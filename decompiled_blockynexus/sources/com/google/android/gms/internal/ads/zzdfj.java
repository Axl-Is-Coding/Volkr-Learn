package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfj implements zzeoy<zzdfh> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdzb> zzgvb;
    private final zzeph<Set<String>> zzgvo;

    private zzdfj(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2, zzeph<Set<String>> zzephVar3) {
        this.zzgvb = zzephVar;
        this.zzesu = zzephVar2;
        this.zzgvo = zzephVar3;
    }

    public static zzdfj zzu(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2, zzeph<Set<String>> zzephVar3) {
        return new zzdfj(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdfh(this.zzgvb.get(), this.zzesu.get(), this.zzgvo.get());
    }
}
