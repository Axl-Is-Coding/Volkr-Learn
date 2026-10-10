package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
public final class zzaiq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiq> CREATOR = new zzaip();

    @SafeParcelable.Field(id = 4)
    public final String description;

    @SafeParcelable.Field(id = 1)
    public final String zzdfz;

    @SafeParcelable.Field(id = 2)
    public final boolean zzdga;

    @SafeParcelable.Field(id = 3)
    public final int zzdgb;

    @SafeParcelable.Constructor
    public zzaiq(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) String str2) {
        this.zzdfz = str;
        this.zzdga = z;
        this.zzdgb = i;
        this.description = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdfz, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdga);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdgb);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
