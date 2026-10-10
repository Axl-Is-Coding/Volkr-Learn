package com.google.android.ads.mediationtestsuite.dataobjects;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;

/* JADX INFO: loaded from: classes.dex */
public class Country implements Parcelable {
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.Country.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Country[] newArray(int i) {
            return new Country[i];
        }
    };

    @c("code")
    private String code;

    @c("name")
    private String name;

    public static Country allCountry() {
        return new Country("ALL", "All Countries");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
    }

    public Country() {
    }

    public Country(String str, String str2) {
        this.code = str;
        this.name = str2;
    }

    private Country(Parcel parcel) {
        this.code = parcel.readString();
        this.name = parcel.readString();
    }
}
