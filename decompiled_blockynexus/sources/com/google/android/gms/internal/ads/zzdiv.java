package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdiv implements zzeoy<zzdit> {
    private final zzeph<zzams> zzetv;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<ApplicationInfo> zzgjm;
    private final zzeph<Boolean> zzgzn;

    public zzdiv(zzeph<zzams> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<Boolean> zzephVar3, zzeph<ApplicationInfo> zzephVar4) {
        this.zzetv = zzephVar;
        this.zzfnm = zzephVar2;
        this.zzgzn = zzephVar3;
        this.zzgjm = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdit(this.zzetv.get(), this.zzfnm.get(), this.zzgzn.get().booleanValue(), this.zzgjm.get());
    }
}
