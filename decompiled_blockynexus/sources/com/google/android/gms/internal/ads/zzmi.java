package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmi extends zzmj {
    public static final Parcelable.Creator<zzmi> CREATOR = new zzmh();
    public final String description;
    public final String text;
    private final String zzaht;

    public zzmi(String str, String str2, String str3) {
        super("COMM");
        this.zzaht = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmi.class == obj.getClass()) {
            zzmi zzmiVar = (zzmi) obj;
            if (zzpq.zza(this.description, zzmiVar.description) && zzpq.zza(this.zzaht, zzmiVar.zzaht) && zzpq.zza(this.text, zzmiVar.text)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzaht;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagx);
        parcel.writeString(this.zzaht);
        parcel.writeString(this.text);
    }

    zzmi(Parcel parcel) {
        super("COMM");
        this.zzaht = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }
}
