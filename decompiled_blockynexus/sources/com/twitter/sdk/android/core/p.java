package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: TwitterAuthConfig.java */
/* JADX INFO: loaded from: classes5.dex */
class p implements Parcelable.Creator<q> {
    p() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public q createFromParcel(Parcel parcel) {
        return new q(parcel, (p) null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public q[] newArray(int i) {
        return new q[i];
    }
}
