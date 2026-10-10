package com.sandboxol.center.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class VideoStarConfig implements Parcelable {
    public static final Parcelable.Creator<VideoStarConfig> CREATOR = new Parcelable.Creator<VideoStarConfig>() { // from class: com.sandboxol.center.entity.VideoStarConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoStarConfig createFromParcel(Parcel parcel) {
            return new VideoStarConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoStarConfig[] newArray(int i) {
            return new VideoStarConfig[i];
        }
    };
    private List<VideoStarConfigDescribe> answering;
    private List<VideoStarConfigDescribe> introduce;
    private int quantity;
    private double rate;

    public VideoStarConfig() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<VideoStarConfigDescribe> getAnswering() {
        return this.answering;
    }

    public List<VideoStarConfigDescribe> getIntroduce() {
        return this.introduce;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getRate() {
        return this.rate;
    }

    public void setAnswering(List<VideoStarConfigDescribe> list) {
        this.answering = list;
    }

    public void setIntroduce(List<VideoStarConfigDescribe> list) {
        this.introduce = list;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setRate(double d2) {
        this.rate = d2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.rate);
        parcel.writeInt(this.quantity);
        parcel.writeTypedList(this.introduce);
        parcel.writeTypedList(this.answering);
    }

    protected VideoStarConfig(Parcel parcel) {
        this.rate = parcel.readDouble();
        this.quantity = parcel.readInt();
        this.introduce = parcel.createTypedArrayList(VideoStarConfigDescribe.CREATOR);
        this.answering = parcel.createTypedArrayList(VideoStarConfigDescribe.CREATOR);
    }
}
