package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
public final class zzaie extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaie> CREATOR = new zzaid();

    @SafeParcelable.Field(id = 4)
    public final byte[] data;

    @SafeParcelable.Field(id = 3)
    public final int statusCode;

    @SafeParcelable.Field(id = 7)
    public final boolean zzan;

    @SafeParcelable.Field(id = 8)
    public final long zzao;

    @SafeParcelable.Field(id = 2)
    public final String zzcgw;

    @SafeParcelable.Field(id = 5)
    public final String[] zzdft;

    @SafeParcelable.Field(id = 6)
    public final String[] zzdfu;

    @SafeParcelable.Field(id = 1)
    public final boolean zzdfv;

    @SafeParcelable.Constructor
    zzaie(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) String[] strArr2, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) long j) {
        this.zzdfv = z;
        this.zzcgw = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdft = strArr;
        this.zzdfu = strArr2;
        this.zzan = z2;
        this.zzao = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdfv);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgw, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdft, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdfu, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzan);
        SafeParcelWriter.writeLong(parcel, 8, this.zzao);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
