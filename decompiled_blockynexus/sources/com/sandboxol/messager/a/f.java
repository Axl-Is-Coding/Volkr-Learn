package com.sandboxol.messager.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: compiled from: SanboxMessage.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bundle f18798e;

    public f() {
        this.f18798e = new Bundle();
    }

    public void a(ClassLoader classLoader) {
        Bundle bundle = this.f18798e;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
    }

    public void b(String str, String str2) {
        if (this.f18798e == null) {
            this.f18798e = new Bundle();
        }
        this.f18798e.putString(str, str2);
    }

    public String c(String str) {
        return a(str, "");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f18794a);
        parcel.writeInt(this.f18795b);
        parcel.writeInt(this.f18796c);
        parcel.writeString(this.f18797d);
        parcel.writeBundle(this.f18798e);
    }

    protected f(Parcel parcel) {
        this.f18794a = parcel.readInt();
        this.f18795b = parcel.readInt();
        this.f18796c = parcel.readInt();
        this.f18797d = parcel.readString();
        this.f18798e = parcel.readBundle();
    }

    public String a(String str, String str2) {
        Bundle bundle = this.f18798e;
        return bundle != null ? bundle.getString(str, str2) : "";
    }

    public void b(String str, int i) {
        if (this.f18798e == null) {
            this.f18798e = new Bundle();
        }
        this.f18798e.putInt(str, i);
    }

    public void a(Bundle bundle) {
        this.f18798e = bundle;
    }

    public int a(String str, int i) {
        Bundle bundle = this.f18798e;
        if (bundle != null) {
            return bundle.getInt(str, i);
        }
        return 0;
    }

    public void b(String str, long j) {
        if (this.f18798e == null) {
            this.f18798e = new Bundle();
        }
        this.f18798e.putLong(str, j);
    }

    public long a(String str, long j) {
        Bundle bundle = this.f18798e;
        if (bundle != null) {
            return bundle.getLong(str, j);
        }
        return 0L;
    }

    public boolean a(String str, boolean z) {
        Bundle bundle = this.f18798e;
        if (bundle != null) {
            return bundle.getBoolean(str, z);
        }
        return false;
    }

    public void b(String str, boolean z) {
        if (this.f18798e == null) {
            this.f18798e = new Bundle();
        }
        this.f18798e.putBoolean(str, z);
    }

    public void a(String str, Serializable serializable) {
        if (this.f18798e == null) {
            this.f18798e = new Bundle();
        }
        this.f18798e.putSerializable(str, serializable);
    }

    public Serializable b(String str) {
        Bundle bundle = this.f18798e;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public <T extends Parcelable> T a(String str) {
        Bundle bundle = this.f18798e;
        if (bundle == null) {
            return null;
        }
        return (T) bundle.getParcelable(str);
    }

    public void a(String str, Parcelable parcelable) {
        if (this.f18798e == null) {
            this.f18798e = new Bundle();
        }
        this.f18798e.putParcelable(str, parcelable);
    }

    public Bundle a() {
        return this.f18798e;
    }
}
