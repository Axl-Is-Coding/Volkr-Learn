package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzvy extends zzwn<zzaqy> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzvx zzcij;

    zzvy(zzvx zzvxVar, Activity activity) {
        this.zzcij = zzvxVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaqy zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zzb(ObjectWrapper.wrap(this.val$activity));
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzaqy zzpp() {
        zzvx.zza(this.val$activity, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaqy zzpq() throws RemoteException {
        return this.zzcij.zzciq.zzc(this.val$activity);
    }
}
