package androidx.customview.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: AbsSavedState.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parcelable f1311b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1310a = new a();
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* synthetic */ c(a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.f1311b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1311b, i);
    }

    private c() {
        this.f1311b = null;
    }

    protected c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1311b = parcelable == f1310a ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f1311b = parcelable == null ? f1310a : parcelable;
    }
}
