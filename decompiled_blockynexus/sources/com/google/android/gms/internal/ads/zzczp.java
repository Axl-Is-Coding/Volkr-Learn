package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczp implements zzux {
    private zzwo zzgtf;

    @Override // com.google.android.gms.internal.ads.zzux
    public final synchronized void onAdClicked() {
        if (this.zzgtf != null) {
            try {
                this.zzgtf.onAdClicked();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdClicked.", e2);
            }
        }
    }

    public final synchronized void zzb(zzwo zzwoVar) {
        this.zzgtf = zzwoVar;
    }
}
