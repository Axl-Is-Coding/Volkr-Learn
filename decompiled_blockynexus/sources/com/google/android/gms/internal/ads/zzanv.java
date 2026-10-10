package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzanv extends zzyr {
    private final Object lock = new Object();
    private volatile zzyt zzdle;

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getCurrentTime() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getDuration() throws RemoteException {
        throw new RemoteException();
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
            this.zzdle = zzytVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyt zzqm() throws RemoteException {
        zzyt zzytVar;
        synchronized (this.lock) {
            zzytVar = this.zzdle;
        }
        return zzytVar;
    }
}
