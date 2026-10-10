package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmh implements Parcelable.Creator<zzmi> {
    zzmh() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmi createFromParcel(Parcel parcel) {
        return new zzmi(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmi[] newArray(int i) {
        return new zzmi[i];
    }
}
