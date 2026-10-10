package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmm extends zzmj {
    public static final Parcelable.Creator<zzmm> CREATOR = new zzml();
    private final String description;
    private final String value;

    public zzmm(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmm.class == obj.getClass()) {
            zzmm zzmmVar = (zzmm) obj;
            if (this.zzagx.equals(zzmmVar.zzagx) && zzpq.zza(this.description, zzmmVar.description) && zzpq.zza(this.value, zzmmVar.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.zzagx.hashCode() + 527) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagx);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }

    zzmm(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }
}
