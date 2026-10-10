package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
public final class zzaae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaae> CREATOR = new zzaad();

    @SafeParcelable.Field(id = 1)
    private final int zzadm;

    @SafeParcelable.Field(id = 2)
    private final int zzadn;

    @SafeParcelable.Constructor
    public zzaae(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzadm = i;
        this.zzadn = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzadm);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadn);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzaae(RequestConfiguration requestConfiguration) {
        this.zzadm = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzadn = requestConfiguration.getTagForUnderAgeOfConsent();
    }
}
