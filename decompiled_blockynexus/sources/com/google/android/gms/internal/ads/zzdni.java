package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdni extends AdMetadataListener {
    private final /* synthetic */ zzyh zzhcv;
    private final /* synthetic */ zzdnj zzhcw;

    zzdni(zzdnj zzdnjVar, zzyh zzyhVar) {
        this.zzhcw = zzdnjVar;
        this.zzhcv = zzyhVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.zzhcw.zzhcz != null) {
            try {
                this.zzhcv.onAdMetadataChanged();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
