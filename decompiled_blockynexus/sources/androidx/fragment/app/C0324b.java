package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BackStackState.java */
/* JADX INFO: loaded from: classes.dex */
class C0324b implements Parcelable.Creator<C0325c> {
    C0324b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C0325c createFromParcel(Parcel parcel) {
        return new C0325c(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C0325c[] newArray(int i) {
        return new C0325c[i];
    }
}
