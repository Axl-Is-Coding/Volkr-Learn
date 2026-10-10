package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzanf extends zzgt implements zzang {
    public zzanf() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzanh zzanjVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvn zzvnVar = (zzvn) zzgw.zza(parcel, zzvn.CREATOR);
                zzvg zzvgVar = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface : new zzanj(strongBinder);
                }
                zza(iObjectWrapperAsInterface, zzvnVar, zzvgVar, string, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperZzts = zzts();
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzts);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvg zzvgVar2 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface2 instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface2 : new zzanj(strongBinder2);
                }
                zza(iObjectWrapperAsInterface2, zzvgVar2, string2, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvn zzvnVar2 = (zzvn) zzgw.zza(parcel, zzvn.CREATOR);
                zzvg zzvgVar3 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface3 instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface3 : new zzanj(strongBinder3);
                }
                zza(iObjectWrapperAsInterface3, zzvnVar2, zzvgVar3, string3, string4, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvg zzvgVar4 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface4 instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface4 : new zzanj(strongBinder4);
                }
                zza(iObjectWrapperAsInterface4, zzvgVar4, string5, string6, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvg) zzgw.zza(parcel, zzvg.CREATOR), parcel.readString(), zzauq.zzap(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza((zzvg) zzgw.zza(parcel, zzvg.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zIsInitialized = isInitialized();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zIsInitialized);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvg zzvgVar5 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface5 instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface5 : new zzanj(strongBinder5);
                }
                zza(iObjectWrapperAsInterface5, zzvgVar5, string7, string8, zzanjVar, (zzadu) zzgw.zza(parcel, zzadu.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzano zzanoVarZztt = zztt();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzanoVarZztt);
                return true;
            case 16:
                zzanp zzanpVarZztu = zztu();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzanpVarZztu);
                return true;
            case 17:
                Bundle bundleZztv = zztv();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, bundleZztv);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle bundleZztw = zztw();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, bundleZztw);
                return true;
            case 20:
                zza((zzvg) zzgw.zza(parcel, zzvg.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzs(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zZztx = zztx();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zZztx);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzauq.zzap(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzafa zzafaVarZzty = zzty();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzafaVarZzty);
                return true;
            case 25:
                setImmersiveMode(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzyo videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 27:
                zzanu zzanuVarZztz = zztz();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzanuVarZztz);
                return true;
            case 28:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvg zzvgVar6 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string9 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface6 instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface6 : new zzanj(strongBinder6);
                }
                zzb(iObjectWrapperAsInterface6, zzvgVar6, string9, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                zzt(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzair.zzz(parcel.readStrongBinder()), parcel.createTypedArrayList(zzaja.CREATOR));
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvg zzvgVar7 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                String string10 = parcel.readString();
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzanjVar = iInterfaceQueryLocalInterface7 instanceof zzanh ? (zzanh) iInterfaceQueryLocalInterface7 : new zzanj(strongBinder7);
                }
                zzc(iObjectWrapperAsInterface7, zzvgVar7, string10, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzapv zzapvVarZzua = zzua();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zzapvVarZzua);
                return true;
            case 34:
                zzapv zzapvVarZzub = zzub();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zzapvVarZzub);
                return true;
        }
    }
}
