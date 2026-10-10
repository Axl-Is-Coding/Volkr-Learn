package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdErrorParcelCreator")
public final class zzva extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzva> CREATOR = new zzvd();

    @SafeParcelable.Field(id = 1)
    public final int errorCode;

    @SafeParcelable.Field(id = 2)
    public final String zzcgw;

    @SafeParcelable.Field(id = 3)
    public final String zzcgx;

    @SafeParcelable.Field(id = 4)
    public zzva zzcgy;

    @SafeParcelable.Field(id = 5, type = "android.os.IBinder")
    public IBinder zzcgz;

    @SafeParcelable.Constructor
    public zzva(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzva zzvaVar, @SafeParcelable.Param(id = 5) IBinder iBinder) {
        this.errorCode = i;
        this.zzcgw = str;
        this.zzcgx = str2;
        this.zzcgy = zzvaVar;
        this.zzcgz = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.errorCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgw, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcgx, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcgy, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzcgz, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final AdError zzph() {
        zzva zzvaVar = this.zzcgy;
        return new AdError(this.errorCode, this.zzcgw, this.zzcgx, zzvaVar == null ? null : new AdError(zzvaVar.errorCode, zzvaVar.zzcgw, zzvaVar.zzcgx));
    }

    public final LoadAdError zzpi() {
        zzva zzvaVar = this.zzcgy;
        zzyn zzypVar = null;
        AdError adError = zzvaVar == null ? null : new AdError(zzvaVar.errorCode, zzvaVar.zzcgw, zzvaVar.zzcgx);
        int i = this.errorCode;
        String str = this.zzcgw;
        String str2 = this.zzcgx;
        IBinder iBinder = this.zzcgz;
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzypVar = iInterfaceQueryLocalInterface instanceof zzyn ? (zzyn) iInterfaceQueryLocalInterface : new zzyp(iBinder);
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zza(zzypVar));
    }
}
