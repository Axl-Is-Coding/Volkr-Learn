package com.sandboxol.center.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class VideoStarConfigDescribe implements Parcelable {
    public static final Parcelable.Creator<VideoStarConfigDescribe> CREATOR = new Parcelable.Creator<VideoStarConfigDescribe>() { // from class: com.sandboxol.center.entity.VideoStarConfigDescribe.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoStarConfigDescribe createFromParcel(Parcel parcel) {
            return new VideoStarConfigDescribe(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoStarConfigDescribe[] newArray(int i) {
            return new VideoStarConfigDescribe[i];
        }
    };
    private String des;
    private String title;

    public VideoStarConfigDescribe(String str, String str2) {
        this.title = str;
        this.des = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDes() {
        return this.des;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.des);
    }

    protected VideoStarConfigDescribe(Parcel parcel) {
        this.title = parcel.readString();
        this.des = parcel.readString();
    }
}
