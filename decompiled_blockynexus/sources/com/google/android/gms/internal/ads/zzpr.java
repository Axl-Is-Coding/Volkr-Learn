package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpr implements Parcelable {
    public static final Parcelable.Creator<zzpr> CREATOR = new zzpu();
    private int zzahv;
    public final int zzarw;
    public final int zzarx;
    public final int zzary;
    public final byte[] zzbkr;

    public zzpr(int i, int i2, int i3, byte[] bArr) {
        this.zzarw = i;
        this.zzary = i2;
        this.zzarx = i3;
        this.zzbkr = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzpr.class == obj.getClass()) {
            zzpr zzprVar = (zzpr) obj;
            if (this.zzarw == zzprVar.zzarw && this.zzary == zzprVar.zzary && this.zzarx == zzprVar.zzarx && Arrays.equals(this.zzbkr, zzprVar.zzbkr)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahv == 0) {
            this.zzahv = ((((((this.zzarw + 527) * 31) + this.zzary) * 31) + this.zzarx) * 31) + Arrays.hashCode(this.zzbkr);
        }
        return this.zzahv;
    }

    public final String toString() {
        int i = this.zzarw;
        int i2 = this.zzary;
        int i3 = this.zzarx;
        boolean z = this.zzbkr != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzarw);
        parcel.writeInt(this.zzary);
        parcel.writeInt(this.zzarx);
        parcel.writeInt(this.zzbkr != null ? 1 : 0);
        byte[] bArr = this.zzbkr;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    zzpr(Parcel parcel) {
        this.zzarw = parcel.readInt();
        this.zzary = parcel.readInt();
        this.zzarx = parcel.readInt();
        this.zzbkr = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
