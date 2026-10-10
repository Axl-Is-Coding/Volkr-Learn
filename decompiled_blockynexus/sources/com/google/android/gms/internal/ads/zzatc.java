package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
public final class zzatc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatc> CREATOR = new zzatf();

    @SafeParcelable.Field(id = 3)
    public final ApplicationInfo applicationInfo;

    @SafeParcelable.Field(id = 4)
    public final String packageName;

    @SafeParcelable.Field(id = 2)
    public final zzbbx zzdqm;

    @SafeParcelable.Field(id = 6)
    public final PackageInfo zzdqs;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzdrc;

    @SafeParcelable.Field(id = 7)
    public final String zzdrm;

    @SafeParcelable.Field(id = 1)
    public final Bundle zzdty;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdtz;

    @SafeParcelable.Field(id = 9)
    public final String zzdua;

    @SafeParcelable.Field(id = 10)
    public zzdqg zzdub;

    @SafeParcelable.Field(id = 11)
    public String zzduc;

    @SafeParcelable.Constructor
    public zzatc(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzbbx zzbbxVar, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) zzdqg zzdqgVar, @SafeParcelable.Param(id = 11) String str4) {
        this.zzdty = bundle;
        this.zzdqm = zzbbxVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzdrc = list;
        this.zzdqs = packageInfo;
        this.zzdrm = str2;
        this.zzdtz = z;
        this.zzdua = str3;
        this.zzdub = zzdqgVar;
        this.zzduc = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdty, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdqm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdrc, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdqs, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdrm, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdtz);
        SafeParcelWriter.writeString(parcel, 9, this.zzdua, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdub, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzduc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
