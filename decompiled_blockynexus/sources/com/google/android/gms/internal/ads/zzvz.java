package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzvz extends zzwn<zzauy> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcih;
    private final /* synthetic */ zzanb zzcii;
    private final /* synthetic */ zzvx zzcij;

    zzvz(zzvx zzvxVar, Context context, String str, zzanb zzanbVar) {
        this.zzcij = zzvxVar;
        this.val$context = context;
        this.zzcih = str;
        this.zzcii = zzanbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzauy zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zzb(ObjectWrapper.wrap(this.val$context), this.zzcih, this.zzcii, 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzauy zzpp() {
        zzvx.zza(this.val$context, "rewarded");
        return new zzzy();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzauy zzpq() throws RemoteException {
        return zzavo.zzd(this.val$context, this.zzcih, this.zzcii);
    }
}
