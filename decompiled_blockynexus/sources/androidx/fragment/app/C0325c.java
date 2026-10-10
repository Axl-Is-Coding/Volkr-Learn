package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.F;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BackStackState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class C0325c implements Parcelable {
    public static final Parcelable.Creator<C0325c> CREATOR = new C0324b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f1497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<String> f1498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int[] f1499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f1500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f1501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f1502f;
    final String g;
    final int h;
    final int i;
    final CharSequence j;
    final int k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    public C0325c(C0323a c0323a) {
        int size = c0323a.f1416a.size();
        this.f1497a = new int[size * 5];
        if (!c0323a.h) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1498b = new ArrayList<>(size);
        this.f1499c = new int[size];
        this.f1500d = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            F.a aVar = c0323a.f1416a.get(i);
            int i3 = i2 + 1;
            this.f1497a[i2] = aVar.f1422a;
            ArrayList<String> arrayList = this.f1498b;
            Fragment fragment = aVar.f1423b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f1497a;
            int i4 = i3 + 1;
            iArr[i3] = aVar.f1424c;
            int i5 = i4 + 1;
            iArr[i4] = aVar.f1425d;
            int i6 = i5 + 1;
            iArr[i5] = aVar.f1426e;
            iArr[i6] = aVar.f1427f;
            this.f1499c[i] = aVar.g.ordinal();
            this.f1500d[i] = aVar.h.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.f1501e = c0323a.f1421f;
        this.f1502f = c0323a.g;
        this.g = c0323a.j;
        this.h = c0323a.u;
        this.i = c0323a.k;
        this.j = c0323a.l;
        this.k = c0323a.m;
        this.l = c0323a.n;
        this.m = c0323a.o;
        this.n = c0323a.p;
        this.o = c0323a.q;
    }

    public C0323a a(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v) {
        C0323a c0323a = new C0323a(layoutInflaterFactory2C0343v);
        int i = 0;
        int i2 = 0;
        while (i < this.f1497a.length) {
            F.a aVar = new F.a();
            int i3 = i + 1;
            aVar.f1422a = this.f1497a[i];
            if (LayoutInflaterFactory2C0343v.f1531c) {
                Log.v("FragmentManager", "Instantiate " + c0323a + " op #" + i2 + " base fragment #" + this.f1497a[i3]);
            }
            String str = this.f1498b.get(i2);
            if (str != null) {
                aVar.f1423b = layoutInflaterFactory2C0343v.j.get(str);
            } else {
                aVar.f1423b = null;
            }
            aVar.g = Lifecycle.State.values()[this.f1499c[i2]];
            aVar.h = Lifecycle.State.values()[this.f1500d[i2]];
            int[] iArr = this.f1497a;
            int i4 = i3 + 1;
            aVar.f1424c = iArr[i3];
            int i5 = i4 + 1;
            aVar.f1425d = iArr[i4];
            int i6 = i5 + 1;
            aVar.f1426e = iArr[i5];
            aVar.f1427f = iArr[i6];
            c0323a.f1417b = aVar.f1424c;
            c0323a.f1418c = aVar.f1425d;
            c0323a.f1419d = aVar.f1426e;
            c0323a.f1420e = aVar.f1427f;
            c0323a.a(aVar);
            i2++;
            i = i6 + 1;
        }
        c0323a.f1421f = this.f1501e;
        c0323a.g = this.f1502f;
        c0323a.j = this.g;
        c0323a.u = this.h;
        c0323a.h = true;
        c0323a.k = this.i;
        c0323a.l = this.j;
        c0323a.m = this.k;
        c0323a.n = this.l;
        c0323a.o = this.m;
        c0323a.p = this.n;
        c0323a.q = this.o;
        c0323a.b(1);
        return c0323a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1497a);
        parcel.writeStringList(this.f1498b);
        parcel.writeIntArray(this.f1499c);
        parcel.writeIntArray(this.f1500d);
        parcel.writeInt(this.f1501e);
        parcel.writeInt(this.f1502f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public C0325c(Parcel parcel) {
        this.f1497a = parcel.createIntArray();
        this.f1498b = parcel.createStringArrayList();
        this.f1499c = parcel.createIntArray();
        this.f1500d = parcel.createIntArray();
        this.f1501e = parcel.readInt();
        this.f1502f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
