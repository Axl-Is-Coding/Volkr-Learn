package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
public final class zzaag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaag> CREATOR = new zzaaf();

    @SafeParcelable.Field(id = 15)
    public final String zzbqw;

    public zzaag(SearchAdRequest searchAdRequest) {
        this.zzbqw = searchAdRequest.getQuery();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzbqw, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzaag(@SafeParcelable.Param(id = 15) String str) {
        this.zzbqw = str;
    }
}
