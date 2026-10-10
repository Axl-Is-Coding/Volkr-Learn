package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwg extends zzwn<zzwz> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcih;
    private final /* synthetic */ zzanb zzcii;
    private final /* synthetic */ zzvx zzcij;

    zzwg(zzvx zzvxVar, Context context, String str, zzanb zzanbVar) {
        this.zzcij = zzvxVar;
        this.val$context = context;
        this.zzcih = str;
        this.zzcii = zzanbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzwz zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcih, this.zzcii, 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzwz zzpp() {
        zzvx.zza(this.val$context, "native_ad");
        return new zzzo();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzwz zzpq() throws RemoteException {
        return this.zzcij.zzcil.zza(this.val$context, this.zzcih, this.zzcii);
    }
}
