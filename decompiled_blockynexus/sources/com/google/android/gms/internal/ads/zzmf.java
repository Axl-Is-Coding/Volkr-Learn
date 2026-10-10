package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmf implements Parcelable.Creator<zzmg> {
    zzmf() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmg createFromParcel(Parcel parcel) {
        return new zzmg(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmg[] newArray(int i) {
        return new zzmg[i];
    }
}
