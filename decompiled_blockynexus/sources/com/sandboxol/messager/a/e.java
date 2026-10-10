package com.sandboxol.messager.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SanboxMessage.java */
/* JADX INFO: loaded from: classes4.dex */
class e implements Parcelable.Creator<f> {
    e() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public f createFromParcel(Parcel parcel) {
        return new f(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public f[] newArray(int i) {
        return new f[i];
    }
}
