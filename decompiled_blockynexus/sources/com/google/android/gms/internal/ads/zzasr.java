package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzasr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasr> CREATOR = new zzasq();

    @SafeParcelable.Field(id = 2)
    public final boolean zzdtr;

    @SafeParcelable.Field(id = 3)
    public final List<String> zzdts;

    public zzasr() {
        this(false, Collections.emptyList());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdtr);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdts, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzasr(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) List<String> list) {
        this.zzdtr = z;
        this.zzdts = list;
    }
}
