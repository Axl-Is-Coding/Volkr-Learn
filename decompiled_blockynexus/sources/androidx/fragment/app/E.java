package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentTabHost;

/* JADX INFO: compiled from: FragmentTabHost.java */
/* JADX INFO: loaded from: classes.dex */
class E implements Parcelable.Creator<FragmentTabHost.b> {
    E() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentTabHost.b createFromParcel(Parcel parcel) {
        return new FragmentTabHost.b(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentTabHost.b[] newArray(int i) {
        return new FragmentTabHost.b[i];
    }
}
