package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
class C implements Parcelable.Creator<AppCompatSpinner.c> {
    C() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AppCompatSpinner.c createFromParcel(Parcel parcel) {
        return new AppCompatSpinner.c(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AppCompatSpinner.c[] newArray(int i) {
        return new AppCompatSpinner.c[i];
    }
}
