package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: OAuthResponse.java */
/* JADX INFO: loaded from: classes5.dex */
class k implements Parcelable.Creator<l> {
    k() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public l createFromParcel(Parcel parcel) {
        return new l(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public l[] newArray(int i) {
        return new l[i];
    }
}
