package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: TwitterAuthConfig.java */
/* JADX INFO: loaded from: classes5.dex */
public class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20266b;

    /* synthetic */ q(Parcel parcel, p pVar) {
        this(parcel);
    }

    public String a() {
        return this.f20265a;
    }

    public String b() {
        return this.f20266b;
    }

    public int c() {
        return 140;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20265a);
        parcel.writeString(this.f20266b);
    }

    public q(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
        }
        this.f20265a = a(str);
        this.f20266b = a(str2);
    }

    static String a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    private q(Parcel parcel) {
        this.f20265a = parcel.readString();
        this.f20266b = parcel.readString();
    }
}
