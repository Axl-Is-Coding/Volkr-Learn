package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaum extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaum> CREATOR = new zzaup();

    @SafeParcelable.Field(id = 3)
    public final String zzbuu;

    @SafeParcelable.Field(id = 2)
    public final zzvg zzdqr;

    @SafeParcelable.Constructor
    public zzaum(@SafeParcelable.Param(id = 2) zzvg zzvgVar, @SafeParcelable.Param(id = 3) String str) {
        this.zzdqr = zzvgVar;
        this.zzbuu = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdqr, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbuu, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
