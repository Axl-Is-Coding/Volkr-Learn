package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcef extends zzyr {
    private final Object lock = new Object();
    private zzyo zzfzo;
    private final zzanu zzfzp;

    public zzcef(zzyo zzyoVar, zzanu zzanuVar) {
        this.zzfzo = zzyoVar;
        this.zzfzp = zzanuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getCurrentTime() throws RemoteException {
        zzanu zzanuVar = this.zzfzp;
        return zzanuVar != null ? zzanuVar.getVideoCurrentTime() : WheelView.DividerConfig.FILL;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getDuration() throws RemoteException {
        zzanu zzanuVar = this.zzfzp;
        return zzanuVar != null ? zzanuVar.getVideoDuration() : WheelView.DividerConfig.FILL;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zza(zzyt zzytVar) throws RemoteException {
        synchronized (this.lock) {
            if (this.zzfzo != null) {
                this.zzfzo.zza(zzytVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyt zzqm() throws RemoteException {
        synchronized (this.lock) {
            if (this.zzfzo == null) {
                return null;
            }
            return this.zzfzo.zzqm();
        }
    }
}
