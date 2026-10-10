package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: OAuth2Token.java */
/* JADX INFO: loaded from: classes5.dex */
public class j extends com.twitter.sdk.android.core.b implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.a.c("token_type")
    private final String f20202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.a.c("access_token")
    private final String f20203c;

    /* synthetic */ j(Parcel parcel, i iVar) {
        this(parcel);
    }

    public String a() {
        return this.f20203c;
    }

    public String b() {
        return this.f20202b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.f20203c;
        if (str == null ? jVar.f20203c != null : !str.equals(jVar.f20203c)) {
            return false;
        }
        String str2 = this.f20202b;
        return str2 == null ? jVar.f20202b == null : str2.equals(jVar.f20202b);
    }

    public int hashCode() {
        String str = this.f20202b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20203c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20202b);
        parcel.writeString(this.f20203c);
    }

    public j(String str, String str2) {
        this.f20202b = str;
        this.f20203c = str2;
    }

    private j(Parcel parcel) {
        this.f20202b = parcel.readString();
        this.f20203c = parcel.readString();
    }
}
