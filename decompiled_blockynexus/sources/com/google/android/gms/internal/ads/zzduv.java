package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "ProgramResponseCreator")
public final class zzduv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzduv> CREATOR = new zzduy();

    @SafeParcelable.Field(id = 3)
    public final int status;

    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 2)
    public final byte[] zzhoe;

    @SafeParcelable.Constructor
    zzduv(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) int i2) {
        this.versionCode = i;
        this.zzhoe = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.status = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhoe, false);
        SafeParcelWriter.writeInt(parcel, 3, this.status);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzduv(byte[] bArr, int i) {
        this(1, null, 1);
    }
}
