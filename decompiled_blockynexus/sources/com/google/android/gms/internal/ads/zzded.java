package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzded implements zzeoy<zzddz> {
    private final zzeph<zzams> zzetv;
    private final zzeph<zzayr> zzevu;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<ApplicationInfo> zzgjm;

    private zzded(zzeph<zzams> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<zzayr> zzephVar3, zzeph<ApplicationInfo> zzephVar4, zzeph<zzdok> zzephVar5) {
        this.zzetv = zzephVar;
        this.zzfnm = zzephVar2;
        this.zzevu = zzephVar3;
        this.zzgjm = zzephVar4;
        this.zzfqr = zzephVar5;
    }

    public static zzded zzh(zzeph<zzams> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<zzayr> zzephVar3, zzeph<ApplicationInfo> zzephVar4, zzeph<zzdok> zzephVar5) {
        return new zzded(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzddz(this.zzetv.get(), this.zzfnm.get(), this.zzevu.get(), this.zzgjm.get(), this.zzfqr.get());
    }
}
