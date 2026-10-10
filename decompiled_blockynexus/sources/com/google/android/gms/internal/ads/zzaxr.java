package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
public final class zzaxr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaxr> CREATOR = new zzaxq();

    @SafeParcelable.Field(id = 2)
    public final String zzbrb;

    @SafeParcelable.Field(id = 1)
    @Deprecated
    public final String zzbuu;

    @SafeParcelable.Field(id = 3)
    @Deprecated
    public final zzvn zzdye;

    @SafeParcelable.Field(id = 4)
    public final zzvg zzdyf;

    @SafeParcelable.Constructor
    public zzaxr(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzvn zzvnVar, @SafeParcelable.Param(id = 4) zzvg zzvgVar) {
        this.zzbuu = str;
        this.zzbrb = str2;
        this.zzdye = zzvnVar;
        this.zzdyf = zzvgVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbuu, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbrb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdye, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdyf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
