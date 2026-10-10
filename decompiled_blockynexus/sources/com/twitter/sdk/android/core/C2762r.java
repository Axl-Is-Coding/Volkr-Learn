package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.twitter.sdk.android.core.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TwitterAuthToken.java */
/* JADX INFO: loaded from: classes5.dex */
class C2762r implements Parcelable.Creator<s> {
    C2762r() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public s createFromParcel(Parcel parcel) {
        return new s(parcel, (C2762r) null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public s[] newArray(int i) {
        return new s[i];
    }
}
