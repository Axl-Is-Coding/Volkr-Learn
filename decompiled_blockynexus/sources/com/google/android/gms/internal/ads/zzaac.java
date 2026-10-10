package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaac extends zzyg {
    private final OnAdMetadataChangedListener zzcld;

    public zzaac(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzcld = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzcld;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
