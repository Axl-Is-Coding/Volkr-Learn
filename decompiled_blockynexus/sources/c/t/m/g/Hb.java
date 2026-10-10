package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class Hb implements Parcelable.Creator<Ib> {
    Hb() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Ib createFromParcel(Parcel parcel) {
        Ib ib = new Ib();
        ib.f2926a = parcel.readString();
        ib.f2927b = parcel.readString();
        ib.f2928c = parcel.readString();
        ib.f2929d = parcel.readDouble();
        ib.f2930e = parcel.readDouble();
        ib.f2931f = parcel.readDouble();
        ib.g = parcel.readString();
        ib.h = parcel.readString();
        return ib;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Ib[] newArray(int i) {
        return new Ib[i];
    }
}
