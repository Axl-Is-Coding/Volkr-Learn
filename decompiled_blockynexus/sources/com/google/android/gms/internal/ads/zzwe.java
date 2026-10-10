package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwe extends zzwn<zzxc> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvn zzcig;
    private final /* synthetic */ String zzcih;
    private final /* synthetic */ zzvx zzcij;

    zzwe(zzvx zzvxVar, Context context, zzvn zzvnVar, String str) {
        this.zzcij = zzvxVar;
        this.val$context = context;
        this.zzcig = zzvnVar;
        this.zzcih = str;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxc zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcig, this.zzcih, 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxc zzpp() {
        zzvx.zza(this.val$context, "search");
        return new zzzs();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxc zzpq() throws RemoteException {
        return this.zzcij.zzcik.zza(this.val$context, this.zzcig, this.zzcih, null, 3);
    }
}
