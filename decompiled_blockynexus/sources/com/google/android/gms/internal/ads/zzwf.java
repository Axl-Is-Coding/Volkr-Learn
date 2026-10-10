package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwf extends zzwn<zzxc> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvn zzcig;
    private final /* synthetic */ String zzcih;
    private final /* synthetic */ zzanb zzcii;
    private final /* synthetic */ zzvx zzcij;

    zzwf(zzvx zzvxVar, Context context, zzvn zzvnVar, String str, zzanb zzanbVar) {
        this.zzcij = zzvxVar;
        this.val$context = context;
        this.zzcig = zzvnVar;
        this.zzcih = str;
        this.zzcii = zzanbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxc zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zzc(ObjectWrapper.wrap(this.val$context), this.zzcig, this.zzcih, this.zzcii, 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxc zzpp() {
        zzvx.zza(this.val$context, FirebaseAnalytics.Event.APP_OPEN);
        return new zzzs();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzxc zzpq() throws RemoteException {
        return this.zzcij.zzcik.zza(this.val$context, this.zzcig, this.zzcih, this.zzcii, 4);
    }
}
