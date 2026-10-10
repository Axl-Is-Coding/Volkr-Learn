package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class k implements Parcelable.Creator {
    k() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j createFromParcel(Parcel parcel) {
        return new j(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j[] newArray(int i) {
        return new j[i];
    }
}
