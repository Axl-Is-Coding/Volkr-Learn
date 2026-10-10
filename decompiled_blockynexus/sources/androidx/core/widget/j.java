package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: NestedScrollView.java */
/* JADX INFO: loaded from: classes.dex */
class j implements Parcelable.Creator<NestedScrollView.c> {
    j() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NestedScrollView.c createFromParcel(Parcel parcel) {
        return new NestedScrollView.c(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NestedScrollView.c[] newArray(int i) {
        return new NestedScrollView.c[i];
    }
}
