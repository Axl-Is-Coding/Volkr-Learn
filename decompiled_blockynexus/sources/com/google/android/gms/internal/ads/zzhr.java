package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhr implements Parcelable.Creator<zzho> {
    zzhr() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzho createFromParcel(Parcel parcel) {
        return new zzho(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzho[] newArray(int i) {
        return new zzho[i];
    }
}
