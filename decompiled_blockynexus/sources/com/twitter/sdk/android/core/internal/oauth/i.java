package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: OAuth2Token.java */
/* JADX INFO: loaded from: classes5.dex */
class i implements Parcelable.Creator<j> {
    i() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public j createFromParcel(Parcel parcel) {
        return new j(parcel, (i) null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public j[] newArray(int i) {
        return new j[i];
    }
}
