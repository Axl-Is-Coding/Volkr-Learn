package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: compiled from: LinearLayoutManager.java */
/* JADX INFO: loaded from: classes.dex */
class D implements Parcelable.Creator<LinearLayoutManager.d> {
    D() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LinearLayoutManager.d createFromParcel(Parcel parcel) {
        return new LinearLayoutManager.d(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LinearLayoutManager.d[] newArray(int i) {
        return new LinearLayoutManager.d[i];
    }
}
