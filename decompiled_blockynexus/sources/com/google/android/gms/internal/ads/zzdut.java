package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "ProgramRequestCreator")
public final class zzdut extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdut> CREATOR = new zzduw();

    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 3)
    private final String zzhmn;

    @SafeParcelable.Field(id = 4)
    private final String zzhmo;

    @SafeParcelable.Field(id = 2)
    private final int zzhmp;

    @SafeParcelable.Field(id = 5)
    private final int zzhod;

    @SafeParcelable.Constructor
    zzdut(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.versionCode = i;
        this.zzhmp = i2;
        this.zzhmn = str;
        this.zzhmo = str2;
        this.zzhod = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhmp);
        SafeParcelWriter.writeString(parcel, 3, this.zzhmn, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhmo, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhod);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzdut(int i, zzgo zzgoVar, String str, String str2) {
        this(1, i, zzgoVar.zzv(), str, str2);
    }
}
