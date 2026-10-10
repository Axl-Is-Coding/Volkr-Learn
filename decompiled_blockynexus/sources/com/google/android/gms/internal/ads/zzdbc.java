package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdbc implements zzdyr<ArrayList<Uri>> {
    private final /* synthetic */ zzart zzguo;

    zzdbc(zzdaq zzdaqVar, zzart zzartVar) {
        this.zzguo = zzartVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(ArrayList<Uri> arrayList) {
        try {
            this.zzguo.onSuccess(arrayList);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        try {
            zzart zzartVar = this.zzguo;
            String strValueOf = String.valueOf(th.getMessage());
            zzartVar.onError(strValueOf.length() != 0 ? "Internal error: ".concat(strValueOf) : new String("Internal error: "));
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
