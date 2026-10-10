package c.t.m.g;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.map.geolocation.TencentLocation;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class Nb implements Parcelable.Creator<TencentLocation> {
    Nb() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TencentLocation createFromParcel(Parcel parcel) {
        Ob ob = new Ob(parcel.readInt(), (byte) 0);
        Jb jb = new Jb();
        Vb vb = new Vb();
        Lb lb = new Lb();
        vb.f3028c = lb;
        ob.i = parcel.readString();
        jb.f2936a = parcel.readDouble();
        jb.f2937b = parcel.readDouble();
        jb.f2939d = parcel.readFloat();
        jb.f2938c = parcel.readDouble();
        jb.f2941f = parcel.readString();
        lb.f2955b = parcel.readString();
        lb.f2959f = parcel.readString();
        lb.g = parcel.readString();
        lb.h = parcel.readString();
        lb.k = parcel.readString();
        lb.l = parcel.readString();
        lb.f2956c = parcel.readString();
        ob.f2970b = jb;
        ob.g = vb;
        ob.l = parcel.readLong();
        Bundle bundle = parcel.readBundle();
        if (bundle != null) {
            ob.h.putAll(bundle);
        }
        return ob;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ TencentLocation[] newArray(int i) {
        return new TencentLocation[i];
    }
}
