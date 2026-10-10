package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
public final class zzadu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzadu> CREATOR = new zzadt();

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 3)
    public final int zzbnn;

    @SafeParcelable.Field(id = 8)
    public final int zzbno;

    @SafeParcelable.Field(id = 4)
    public final boolean zzbnp;

    @SafeParcelable.Field(id = 5)
    public final int zzbnq;

    @SafeParcelable.Field(id = 7)
    public final boolean zzbns;

    @SafeParcelable.Field(id = 2)
    public final boolean zzddm;

    @SafeParcelable.Field(id = 6)
    public final zzaak zzddn;

    public zzadu(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaak(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjt(), nativeAdOptions.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzddm);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbnn);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbnp);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbnq);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzddn, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbns);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbno);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzadu(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) zzaak zzaakVar, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) int i4) {
        this.versionCode = i;
        this.zzddm = z;
        this.zzbnn = i2;
        this.zzbnp = z2;
        this.zzbnq = i3;
        this.zzddn = zzaakVar;
        this.zzbns = z3;
        this.zzbno = i4;
    }
}
