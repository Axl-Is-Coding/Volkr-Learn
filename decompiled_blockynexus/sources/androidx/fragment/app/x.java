package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentManagerState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class x implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<C> f1552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<String> f1553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    C0325c[] f1554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f1555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1556e;

    public x() {
        this.f1555d = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f1552a);
        parcel.writeStringList(this.f1553b);
        parcel.writeTypedArray(this.f1554c, i);
        parcel.writeString(this.f1555d);
        parcel.writeInt(this.f1556e);
    }

    public x(Parcel parcel) {
        this.f1555d = null;
        this.f1552a = parcel.createTypedArrayList(C.CREATOR);
        this.f1553b = parcel.createStringArrayList();
        this.f1554c = (C0325c[]) parcel.createTypedArray(C0325c.CREATOR);
        this.f1555d = parcel.readString();
        this.f1556e = parcel.readInt();
    }
}
