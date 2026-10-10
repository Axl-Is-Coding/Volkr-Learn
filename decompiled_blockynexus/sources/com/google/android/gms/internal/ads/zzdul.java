package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzcf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzdul extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdul> CREATOR = new zzduo();

    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzcf.zza zzhnr = null;
    private byte[] zzhns;

    @SafeParcelable.Constructor
    zzdul(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzhns = bArr;
        zzawo();
    }

    private final void zzawo() {
        if (this.zzhnr != null || this.zzhns == null) {
            if (this.zzhnr == null || this.zzhns != null) {
                if (this.zzhnr != null && this.zzhns != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzhnr != null || this.zzhns != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] byteArray = this.zzhns;
        if (byteArray == null) {
            byteArray = this.zzhnr.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, byteArray, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzcf.zza zzawn() {
        if (!(this.zzhnr != null)) {
            try {
                this.zzhnr = zzcf.zza.zza(this.zzhns, zzejm.zzbfu());
                this.zzhns = null;
            } catch (zzekj e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzawo();
        return this.zzhnr;
    }
}
