package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzyr extends zzgt implements zzyo {
    public zzyr() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzyo zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return iInterfaceQueryLocalInterface instanceof zzyo ? (zzyo) iInterfaceQueryLocalInterface : new zzyq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzyt zzyvVar;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                mute(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zIsMuted = isMuted();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsMuted);
                return true;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                return true;
            case 6:
                float duration = getDuration();
                parcel2.writeNoException();
                parcel2.writeFloat(duration);
                return true;
            case 7:
                float currentTime = getCurrentTime();
                parcel2.writeNoException();
                parcel2.writeFloat(currentTime);
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzyvVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzyvVar = iInterfaceQueryLocalInterface instanceof zzyt ? (zzyt) iInterfaceQueryLocalInterface : new zzyv(strongBinder);
                }
                zza(zzyvVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 10:
                boolean zIsCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsCustomControlsEnabled);
                return true;
            case 11:
                zzyt zzytVarZzqm = zzqm();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzytVarZzqm);
                return true;
            case 12:
                boolean zIsClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsClickToExpandEnabled);
                return true;
            case 13:
                stop();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
