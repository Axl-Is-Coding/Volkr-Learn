package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "MediationConfigurationParcelCreator")
public final class zzaja extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaja> CREATOR = new zzaiz();

    @SafeParcelable.Field(id = 2)
    public final Bundle extras;

    @SafeParcelable.Field(id = 1)
    public final String zzdge;

    @SafeParcelable.Constructor
    public zzaja(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzdge = str;
        this.extras = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdge, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.extras, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
