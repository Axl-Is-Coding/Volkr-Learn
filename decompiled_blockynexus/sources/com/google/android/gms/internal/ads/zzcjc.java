package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcjc extends VideoController.VideoLifecycleCallbacks {
    private final zzcei zzfxu;

    public zzcjc(zzcei zzceiVar) {
        this.zzfxu = zzceiVar;
    }

    private static zzyt zza(zzcei zzceiVar) {
        zzyo videoController = zzceiVar.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzqm();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzyt zzytVarZza = zza(this.zzfxu);
        if (zzytVarZza == null) {
            return;
        }
        try {
            zzytVarZza.onVideoEnd();
        } catch (RemoteException e2) {
            zzbbq.zzd("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzyt zzytVarZza = zza(this.zzfxu);
        if (zzytVarZza == null) {
            return;
        }
        try {
            zzytVarZza.onVideoPause();
        } catch (RemoteException e2) {
            zzbbq.zzd("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzyt zzytVarZza = zza(this.zzfxu);
        if (zzytVarZza == null) {
            return;
        }
        try {
            zzytVarZza.onVideoStart();
        } catch (RemoteException e2) {
            zzbbq.zzd("Unable to call onVideoEnd()", e2);
        }
    }
}
