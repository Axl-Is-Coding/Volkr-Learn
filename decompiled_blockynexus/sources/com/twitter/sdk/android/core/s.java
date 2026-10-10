package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.common.RongLibConst;

/* JADX INFO: compiled from: TwitterAuthToken.java */
/* JADX INFO: loaded from: classes5.dex */
public class s extends b implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new C2762r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.a.c(RongLibConst.KEY_TOKEN)
    public final String f20267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.a.c("secret")
    public final String f20268c;

    /* synthetic */ s(Parcel parcel, C2762r c2762r) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        String str = this.f20268c;
        if (str == null ? sVar.f20268c != null : !str.equals(sVar.f20268c)) {
            return false;
        }
        String str2 = this.f20267b;
        return str2 == null ? sVar.f20267b == null : str2.equals(sVar.f20267b);
    }

    public int hashCode() {
        String str = this.f20267b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20268c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "token=" + this.f20267b + ",secret=" + this.f20268c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20267b);
        parcel.writeString(this.f20268c);
    }

    public s(String str, String str2) {
        this.f20267b = str;
        this.f20268c = str2;
    }

    private s(Parcel parcel) {
        this.f20267b = parcel.readString();
        this.f20268c = parcel.readString();
    }
}
