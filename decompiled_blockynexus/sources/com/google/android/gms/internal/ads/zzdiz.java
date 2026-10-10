package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdiz implements zzeoy<zzdix> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzarg> zzetv;
    private final zzeph<ScheduledExecutorService> zzfnm;

    public zzdiz(zzeph<zzarg> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<Context> zzephVar3) {
        this.zzetv = zzephVar;
        this.zzfnm = zzephVar2;
        this.zzesu = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdix(this.zzetv.get(), this.zzfnm.get(), this.zzesu.get());
    }
}
