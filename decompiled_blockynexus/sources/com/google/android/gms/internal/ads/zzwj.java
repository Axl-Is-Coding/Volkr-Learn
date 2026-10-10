package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwj extends zzwn<zzxs> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvx zzcij;

    zzwj(zzvx zzvxVar, Context context) {
        this.zzcij = zzvxVar;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxs zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zza(ObjectWrapper.wrap(this.val$context), 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzxs zzpp() {
        zzvx.zza(this.val$context, "mobile_ads_settings");
        return new zzzu();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxs zzpq() throws RemoteException {
        return this.zzcij.zzcim.zzi(this.val$context);
    }
}
