package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzme implements Parcelable.Creator<zzmc> {
    zzme() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmc createFromParcel(Parcel parcel) {
        return new zzmc(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmc[] newArray(int i) {
        return new zzmc[0];
    }
}
