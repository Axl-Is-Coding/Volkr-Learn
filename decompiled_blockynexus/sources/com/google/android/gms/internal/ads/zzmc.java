package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmc implements Parcelable {
    public static final Parcelable.Creator<zzmc> CREATOR = new zzme();
    private final zza[] zzbde;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public interface zza extends Parcelable {
    }

    public zzmc(List<? extends zza> list) {
        this.zzbde = new zza[list.size()];
        list.toArray(this.zzbde);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzmc.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbde, ((zzmc) obj).zzbde);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzbde);
    }

    public final int length() {
        return this.zzbde.length;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbde.length);
        for (zza zzaVar : this.zzbde) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }

    public final zza zzba(int i) {
        return this.zzbde[i];
    }

    zzmc(Parcel parcel) {
        this.zzbde = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaVarArr = this.zzbde;
            if (i >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i++;
        }
    }
}
