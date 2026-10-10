package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjm implements Parcelable.Creator<zzjn> {
    zzjm() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn createFromParcel(Parcel parcel) {
        return new zzjn(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn[] newArray(int i) {
        return new zzjn[i];
    }
}
