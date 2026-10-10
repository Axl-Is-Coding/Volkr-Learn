package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: FragmentState.java */
/* JADX INFO: loaded from: classes.dex */
class B implements Parcelable.Creator<C> {
    B() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C createFromParcel(Parcel parcel) {
        return new C(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C[] newArray(int i) {
        return new C[i];
    }
}
