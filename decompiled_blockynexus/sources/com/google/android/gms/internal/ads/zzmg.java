package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmg extends zzmj {
    public static final Parcelable.Creator<zzmg> CREATOR = new zzmf();
    private final String description;
    private final String mimeType;
    private final int zzbdh;
    private final byte[] zzbdi;

    public zzmg(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzbdh = 3;
        this.zzbdi = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmg.class == obj.getClass()) {
            zzmg zzmgVar = (zzmg) obj;
            if (this.zzbdh == zzmgVar.zzbdh && zzpq.zza(this.mimeType, zzmgVar.mimeType) && zzpq.zza(this.description, zzmgVar.description) && Arrays.equals(this.zzbdi, zzmgVar.zzbdi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.zzbdh + 527) * 31;
        String str = this.mimeType;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzbdi);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbdh);
        parcel.writeByteArray(this.zzbdi);
    }

    zzmg(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbdh = parcel.readInt();
        this.zzbdi = parcel.createByteArray();
    }
}
