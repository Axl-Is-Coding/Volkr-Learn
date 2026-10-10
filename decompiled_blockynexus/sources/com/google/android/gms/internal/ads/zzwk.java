package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwk extends zzwn<zzaud> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzanb zzcii;
    private final /* synthetic */ zzvx zzcij;

    zzwk(zzvx zzvxVar, Context context, zzanb zzanbVar) {
        this.zzcij = zzvxVar;
        this.val$context = context;
        this.zzcii = zzanbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaud zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcii, 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzaud zzpp() {
        zzvx.zza(this.val$context, "rewarded_video");
        return new zzaaa();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaud zzpq() throws RemoteException {
        return this.zzcij.zzcio.zzc(this.val$context, this.zzcii);
    }
}
