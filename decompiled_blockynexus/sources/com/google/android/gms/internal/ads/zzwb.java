package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwb extends zzwn<zzaxl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzanb zzcii;

    zzwb(zzvx zzvxVar, Context context, zzanb zzanbVar) {
        this.val$context = context;
        this.zzcii = zzanbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzwn
    /* JADX INFO: renamed from: zzpr, reason: merged with bridge method [inline-methods] */
    public final zzaxl zzpq() {
        try {
            return ((zzaxm) zzbbt.zza(this.val$context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzwa.zzbxx)).zze(ObjectWrapper.wrap(this.val$context), this.zzcii, 202510000);
        } catch (RemoteException | zzbbv | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaxl zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zzb(ObjectWrapper.wrap(this.val$context), this.zzcii, 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* bridge */ /* synthetic */ zzaxl zzpp() {
        return null;
    }
}
