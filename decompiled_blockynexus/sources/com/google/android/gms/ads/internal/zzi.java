package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();

    @SafeParcelable.Field(id = 2)
    public final boolean zzbov;

    @SafeParcelable.Field(id = 3)
    public final boolean zzbow;

    @SafeParcelable.Field(id = 4)
    private final String zzbox;

    @SafeParcelable.Field(id = 5)
    public final boolean zzboy;

    @SafeParcelable.Field(id = 6)
    public final float zzboz;

    @SafeParcelable.Field(id = 7)
    public final int zzbpa;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbpb;

    @SafeParcelable.Field(id = 9)
    public final boolean zzbpc;

    @SafeParcelable.Field(id = 10)
    public final boolean zzbpd;

    public zzi(boolean z, boolean z2, boolean z3, float f2, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, false, WheelView.DividerConfig.FILL, -1, z4, z5, z6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbov);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbow);
        SafeParcelWriter.writeString(parcel, 4, this.zzbox, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzboy);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzboz);
        SafeParcelWriter.writeInt(parcel, 7, this.zzbpa);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbpb);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbpc);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbpd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzi(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) float f2, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) boolean z5, @SafeParcelable.Param(id = 10) boolean z6) {
        this.zzbov = z;
        this.zzbow = z2;
        this.zzbox = str;
        this.zzboy = z3;
        this.zzboz = f2;
        this.zzbpa = i;
        this.zzbpb = z4;
        this.zzbpc = z5;
        this.zzbpd = z6;
    }
}
