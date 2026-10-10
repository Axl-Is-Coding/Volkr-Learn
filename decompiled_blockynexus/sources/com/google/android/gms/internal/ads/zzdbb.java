package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdbb implements zzdyr<Uri> {
    private final /* synthetic */ zzart zzguo;

    zzdbb(zzdaq zzdaqVar, zzart zzartVar) {
        this.zzguo = zzartVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Uri uri) {
        try {
            this.zzguo.onSuccess(Collections.singletonList(uri));
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
