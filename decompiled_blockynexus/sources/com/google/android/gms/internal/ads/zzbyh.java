package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyh implements zzeoy<zzbyf> {
    private final zzeph<Set<zzcab<AppEventListener>>> zzfqq;

    private zzbyh(zzeph<Set<zzcab<AppEventListener>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbyh zzr(zzeph<Set<zzcab<AppEventListener>>> zzephVar) {
        return new zzbyh(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbyf(this.zzfqq.get());
    }
}
