package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AppOpenAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzvs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvs> CREATOR = new zzvv();

    @AppOpenAd.AppOpenAdOrientation
    @SafeParcelable.Field(id = 2)
    public final int orientation;

    @SafeParcelable.Constructor
    public zzvs(@SafeParcelable.Param(id = 2) @AppOpenAd.AppOpenAdOrientation int i) {
        this.orientation = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.orientation);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
