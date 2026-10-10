package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
public final class zzajc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajc> CREATOR = new zzajb();

    @SafeParcelable.VersionField(id = 1000)
    public final int versionCode;

    @SafeParcelable.Field(id = 3)
    public final int zzbno;

    @SafeParcelable.Field(id = 1)
    public final int zzdgf;

    @SafeParcelable.Field(id = 2)
    public final String zzdgg;

    public zzajc(zzajo zzajoVar) {
        this(2, 1, zzajoVar.zztf(), zzajoVar.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdgf);
        SafeParcelWriter.writeString(parcel, 2, this.zzdgg, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbno);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzajc(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.versionCode = i;
        this.zzdgf = i2;
        this.zzdgg = str;
        this.zzbno = i3;
    }
}
