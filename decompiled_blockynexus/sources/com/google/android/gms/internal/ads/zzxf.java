package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzxf extends zzgt implements zzxc {
    public zzxf() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzxc zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof zzxc ? (zzxc) iInterfaceQueryLocalInterface : new zzxe(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwt zzwvVar = null;
        zzyi zzykVar = null;
        zzxj zzxlVar = null;
        zzxq zzxtVar = null;
        zzwo zzwqVar = null;
        zzxk zzxmVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperZzke = zzke();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzke);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zIsReady = isReady();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsReady);
                return true;
            case 4:
                boolean zZza = zza((zzvg) zzgw.zza(parcel, zzvg.CREATOR));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zZza);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzwvVar = iInterfaceQueryLocalInterface instanceof zzwt ? (zzwt) iInterfaceQueryLocalInterface : new zzwv(strongBinder);
                }
                zza(zzwvVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzxmVar = iInterfaceQueryLocalInterface2 instanceof zzxk ? (zzxk) iInterfaceQueryLocalInterface2 : new zzxm(strongBinder2);
                }
                zza(zzxmVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzkf();
                parcel2.writeNoException();
                return true;
            case 12:
                zzvn zzvnVarZzkg = zzkg();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zzvnVarZzkg);
                return true;
            case 13:
                zza((zzvn) zzgw.zza(parcel, zzvn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzarl.zzaj(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzarr.zzal(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzabx.zzl(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzwqVar = iInterfaceQueryLocalInterface3 instanceof zzwo ? (zzwo) iInterfaceQueryLocalInterface3 : new zzwq(strongBinder3);
                }
                zza(zzwqVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzxtVar = iInterfaceQueryLocalInterface4 instanceof zzxq ? (zzxq) iInterfaceQueryLocalInterface4 : new zzxt(strongBinder4);
                }
                zza(zzxtVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zIsLoading = isLoading();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsLoading);
                return true;
            case 24:
                zza(zzauj.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzaak) zzgw.zza(parcel, zzaak.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzyu) zzgw.zza(parcel, zzyu.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzxk zzxkVarZzkj = zzkj();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzxkVarZzkj);
                return true;
            case 33:
                zzwt zzwtVarZzkk = zzkk();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzwtVarZzkk);
                return true;
            case 34:
                setImmersiveMode(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String strZzkh = zzkh();
                parcel2.writeNoException();
                parcel2.writeString(strZzkh);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzxlVar = iInterfaceQueryLocalInterface5 instanceof zzxj ? (zzxj) iInterfaceQueryLocalInterface5 : new zzxl(strongBinder5);
                }
                zza(zzxlVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, adMetadata);
                return true;
            case 38:
                zzbp(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                zza((zzvs) zzgw.zza(parcel, zzvs.CREATOR));
                parcel2.writeNoException();
                return true;
            case 40:
                zza(zzsk.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 41:
                zzyn zzynVarZzki = zzki();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzynVarZzki);
                return true;
            case 42:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    zzykVar = iInterfaceQueryLocalInterface6 instanceof zzyi ? (zzyi) iInterfaceQueryLocalInterface6 : new zzyk(strongBinder6);
                }
                zza(zzykVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
