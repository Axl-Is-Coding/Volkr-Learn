package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.s;

/* JADX INFO: compiled from: OAuthResponse.java */
/* JADX INFO: loaded from: classes5.dex */
public class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f20204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20206c;

    /* synthetic */ l(Parcel parcel, k kVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "authToken=" + this.f20204a + ",userName=" + this.f20205b + ",userId=" + this.f20206c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f20204a, i);
        parcel.writeString(this.f20205b);
        parcel.writeLong(this.f20206c);
    }

    public l(s sVar, String str, long j) {
        this.f20204a = sVar;
        this.f20205b = str;
        this.f20206c = j;
    }

    private l(Parcel parcel) {
        this.f20204a = (s) parcel.readParcelable(s.class.getClassLoader());
        this.f20205b = parcel.readString();
        this.f20206c = parcel.readLong();
    }
}
