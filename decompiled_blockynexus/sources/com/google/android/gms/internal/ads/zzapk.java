package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzapk extends zzgt implements zzaph {
    public zzapk() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzaph zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzaph ? (zzaph) iInterfaceQueryLocalInterface : new zzapj(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.google.android.gms.internal.ads.zzapg] */
    /* JADX WARN: Type inference failed for: r11v7, types: [com.google.android.gms.internal.ads.zzapg] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.google.android.gms.internal.ads.zzaph, com.google.android.gms.internal.ads.zzapk] */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.google.android.gms.internal.ads.zzaov] */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.google.android.gms.internal.ads.zzapa] */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.google.android.gms.internal.ads.zzapb] */
    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzapm zzapoVar;
        IInterface zzaoxVar = null;
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            Bundle bundle = (Bundle) zzgw.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzgw.zza(parcel, Bundle.CREATOR);
            zzvn zzvnVar = (zzvn) zzgw.zza(parcel, zzvn.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzapoVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzapoVar = iInterfaceQueryLocalInterface instanceof zzapm ? (zzapm) iInterfaceQueryLocalInterface : new zzapo(strongBinder);
            }
            zza(iObjectWrapperAsInterface, string, bundle, bundle2, zzvnVar, zzapoVar);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzapv zzapvVarZzua = zzua();
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zzapvVarZzua);
        } else if (i == 3) {
            zzapv zzapvVarZzub = zzub();
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zzapvVarZzub);
        } else if (i == 5) {
            zzyo videoController = getVideoController();
            parcel2.writeNoException();
            zzgw.zza(parcel2, videoController);
        } else if (i == 10) {
            zzy(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    zzvg zzvgVar = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzaoxVar = iInterfaceQueryLocalInterface2 instanceof zzaov ? (zzaov) iInterfaceQueryLocalInterface2 : new zzaox(strongBinder2);
                    }
                    zza(string2, string3, zzvgVar, iObjectWrapperAsInterface2, zzaoxVar, zzank.zzad(parcel.readStrongBinder()), (zzvn) zzgw.zza(parcel, zzvn.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    zzvg zzvgVar2 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzaoxVar = iInterfaceQueryLocalInterface3 instanceof zzapa ? (zzapa) iInterfaceQueryLocalInterface3 : new zzapc(strongBinder3);
                    }
                    zza(string4, string5, zzvgVar2, iObjectWrapperAsInterface3, zzaoxVar, zzank.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 15:
                    boolean zZzz = zzz(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgw.writeBoolean(parcel2, zZzz);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    zzvg zzvgVar3 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzaoxVar = iInterfaceQueryLocalInterface4 instanceof zzapg ? (zzapg) iInterfaceQueryLocalInterface4 : new zzapi(strongBinder4);
                    }
                    zza(string6, string7, zzvgVar3, iObjectWrapperAsInterface4, zzaoxVar, zzank.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 17:
                    boolean zZzaa = zzaa(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgw.writeBoolean(parcel2, zZzaa);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    zzvg zzvgVar4 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzaoxVar = iInterfaceQueryLocalInterface5 instanceof zzapb ? (zzapb) iInterfaceQueryLocalInterface5 : new zzapd(strongBinder5);
                    }
                    zza(string8, string9, zzvgVar4, iObjectWrapperAsInterface5, zzaoxVar, zzank.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 19:
                    zzdr(parcel.readString());
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string10 = parcel.readString();
                    String string11 = parcel.readString();
                    zzvg zzvgVar5 = (zzvg) zzgw.zza(parcel, zzvg.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzaoxVar = iInterfaceQueryLocalInterface6 instanceof zzapg ? (zzapg) iInterfaceQueryLocalInterface6 : new zzapi(strongBinder6);
                    }
                    zzb(string10, string11, zzvgVar5, iObjectWrapperAsInterface6, zzaoxVar, zzank.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
        } else {
            zza(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
            parcel2.writeNoException();
        }
        return true;
    }
}
