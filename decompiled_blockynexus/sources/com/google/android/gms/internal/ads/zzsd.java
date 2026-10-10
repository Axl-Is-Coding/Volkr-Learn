package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsd extends zzsp {
    private final FullScreenContentCallback zzbuq;

    public zzsd(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuq = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAdDismissedFullScreenContent() throws RemoteException {
        this.zzbuq.onAdDismissedFullScreenContent();
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAdShowedFullScreenContent() throws RemoteException {
        this.zzbuq.onAdShowedFullScreenContent();
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zzb(zzva zzvaVar) throws RemoteException {
        this.zzbuq.onAdFailedToShowFullScreenContent(zzvaVar.zzph());
    }
}
