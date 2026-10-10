package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "ExceptionParcelCreator")
public final class zzazy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazy> CREATOR = new zzbaa();

    @SafeParcelable.Field(id = 2)
    public final int errorCode;

    @SafeParcelable.Field(id = 1)
    public final String zzacm;

    @SafeParcelable.Constructor
    zzazy(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i) {
        this.zzacm = str == null ? "" : str;
        this.errorCode = i;
    }

    public static zzazy zzc(Throwable th) {
        zzva zzvaVarZzh = zzdpe.zzh(th);
        return new zzazy(zzdwf.zzas(th.getMessage()) ? zzvaVarZzh.zzcgw : th.getMessage(), zzvaVarZzh.errorCode);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacm, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
