package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwl extends zzwn<zzael> {
    private final /* synthetic */ zzvx zzcij;
    private final /* synthetic */ View zzciu;
    private final /* synthetic */ HashMap zzciv;
    private final /* synthetic */ HashMap zzciw;

    zzwl(zzvx zzvxVar, View view, HashMap map, HashMap map2) {
        this.zzcij = zzvxVar;
        this.zzciu = view;
        this.zzciv = map;
        this.zzciw = map2;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzael zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zza(ObjectWrapper.wrap(this.zzciu), ObjectWrapper.wrap(this.zzciv), ObjectWrapper.wrap(this.zzciw));
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzael zzpp() {
        zzvx.zza(this.zzciu.getContext(), "native_ad_view_holder_delegate");
        return new zzzv();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzael zzpq() throws RemoteException {
        return this.zzcij.zzcir.zzb(this.zzciu, this.zzciv, this.zzciw);
    }
}
