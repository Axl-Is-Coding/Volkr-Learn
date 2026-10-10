package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdapterResponseInfoParcelCreator")
public final class zzvr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvr> CREATOR = new zzvq();

    @SafeParcelable.Field(id = 1)
    public String zzcib;

    @SafeParcelable.Field(id = 2)
    public long zzcic;

    @SafeParcelable.Field(id = 3)
    public zzva zzcid;

    @SafeParcelable.Field(id = 4)
    public Bundle zzcie;

    @SafeParcelable.Constructor
    public zzvr(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) zzva zzvaVar, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.zzcib = str;
        this.zzcic = j;
        this.zzcid = zzvaVar;
        this.zzcie = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcib, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcic);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzcid, i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzcie, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
