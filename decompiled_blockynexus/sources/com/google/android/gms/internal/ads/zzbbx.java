package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbbx> CREATOR = new zzbbw();

    @SafeParcelable.Field(id = 2)
    public String zzbre;

    @SafeParcelable.Field(id = 3)
    public int zzeel;

    @SafeParcelable.Field(id = 4)
    public int zzeem;

    @SafeParcelable.Field(id = 5)
    public boolean zzeen;

    @SafeParcelable.Field(id = 6)
    public boolean zzeeo;

    public zzbbx(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public static zzbbx zzyv() {
        return new zzbbx(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbre, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzeel);
        SafeParcelWriter.writeInt(parcel, 4, this.zzeem);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzeen);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzeeo);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzbbx(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    private zzbbx(int i, int i2, boolean z, boolean z2, boolean z3) {
        String str = z ? "0" : "1";
        StringBuilder sb = new StringBuilder(str.length() + 36);
        sb.append("afma-sdk-a-v");
        sb.append(i);
        sb.append(Consts.DOT);
        sb.append(i2);
        sb.append(Consts.DOT);
        sb.append(str);
        this(sb.toString(), i, i2, z, false);
    }

    @SafeParcelable.Constructor
    zzbbx(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2) {
        this.zzbre = str;
        this.zzeel = i;
        this.zzeem = i2;
        this.zzeen = z;
        this.zzeeo = z2;
    }
}
