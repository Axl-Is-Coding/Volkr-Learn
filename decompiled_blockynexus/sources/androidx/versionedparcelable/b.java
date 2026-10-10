package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
class b extends VersionedParcel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f2377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f2378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2379f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a.a.b(), new a.a.b(), new a.a.b());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean a(int i) {
        while (this.j < this.g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f2378e.setDataPosition(this.j);
            int i3 = this.f2378e.readInt();
            this.k = this.f2378e.readInt();
            this.j += i3;
        }
        return this.k == i;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void b(int i) {
        a();
        this.i = i;
        this.f2377d.put(i, this.f2378e.dataPosition());
        c(0);
        c(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void c(int i) {
        this.f2378e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean d() {
        return this.f2378e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] e() {
        int i = this.f2378e.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f2378e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence f() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2378e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int g() {
        return this.f2378e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T h() {
        return (T) this.f2378e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String i() {
        return this.f2378e.readString();
    }

    private b(Parcel parcel, int i, int i2, String str, a.a.b<String, Method> bVar, a.a.b<String, Method> bVar2, a.a.b<String, Class> bVar3) {
        super(bVar, bVar2, bVar3);
        this.f2377d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f2378e = parcel;
        this.f2379f = i;
        this.g = i2;
        this.j = this.f2379f;
        this.h = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f2378e;
        int iDataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f2379f) {
            i = this.g;
        }
        return new b(parcel, iDataPosition, i, this.h + "  ", this.f2374a, this.f2375b, this.f2376c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.f2377d.get(i);
            int iDataPosition = this.f2378e.dataPosition();
            this.f2378e.setDataPosition(i2);
            this.f2378e.writeInt(iDataPosition - i2);
            this.f2378e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f2378e.writeInt(bArr.length);
            this.f2378e.writeByteArray(bArr);
        } else {
            this.f2378e.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(String str) {
        this.f2378e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(Parcelable parcelable) {
        this.f2378e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(boolean z) {
        this.f2378e.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2378e, 0);
    }
}
