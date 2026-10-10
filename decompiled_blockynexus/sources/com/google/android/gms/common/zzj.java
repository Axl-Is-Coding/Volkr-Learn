package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();

    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    private final zzd zzb;

    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzc;

    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2) {
        this.zza = str;
        this.zzb = zza(iBinder);
        this.zzc = z;
        this.zzd = z2;
    }

    private static zzd zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper iObjectWrapperZzb = com.google.android.gms.common.internal.zzn.zza(iBinder).zzb();
            byte[] bArr = iObjectWrapperZzb == null ? null : (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzb);
            if (bArr != null) {
                return new zzg(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinderAsBinder;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        zzd zzdVar = this.zzb;
        if (zzdVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinderAsBinder = null;
        } else {
            iBinderAsBinder = zzdVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinderAsBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzj(String str, zzd zzdVar, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzdVar;
        this.zzc = z;
        this.zzd = z2;
    }
}
