package com.sandboxol.file.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class Progress implements Parcelable {
    public static final Parcelable.Creator<Progress> CREATOR = new Parcelable.Creator<Progress>() { // from class: com.sandboxol.file.entity.Progress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Progress createFromParcel(Parcel parcel) {
            return new Progress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Progress[] newArray(int i) {
            return new Progress[i];
        }
    };
    private double downloadRate;
    private long downloadSize;
    private long downloadTime;
    private String gameId;
    private boolean isSuccess = true;
    private String name;
    private long totalSize;
    private String url;

    public Progress() {
    }

    private String formatSize(Long l) {
        double dDoubleValue = l.doubleValue();
        double d2 = dDoubleValue / 1024.0d;
        double d3 = d2 / 1024.0d;
        double d4 = d3 / 1024.0d;
        double d5 = d4 / 1024.0d;
        if (d5 >= 1.0d) {
            return new BigDecimal(d5).setScale(2, 4).doubleValue() + " TB";
        }
        if (d4 >= 1.0d) {
            return new BigDecimal(d4).setScale(2, 4).doubleValue() + " GB";
        }
        if (d3 >= 1.0d) {
            return new BigDecimal(d3).setScale(2, 4).doubleValue() + " MB";
        }
        if (d2 >= 1.0d) {
            return new BigDecimal(d2).setScale(2, 4).doubleValue() + " KB";
        }
        return new BigDecimal(dDoubleValue).setScale(2, 4).doubleValue() + " B";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String downloadSizeStr() {
        return formatSize(Long.valueOf(this.downloadSize));
    }

    public String formatString() {
        long j = this.downloadSize;
        long j2 = this.totalSize;
        if (j > j2) {
            this.downloadSize = j2;
        }
        return formatSize(Long.valueOf(this.downloadSize)) + "/" + formatSize(Long.valueOf(this.totalSize));
    }

    public double getDownloadRate() {
        return this.downloadRate;
    }

    public Long getDownloadSize() {
        return Long.valueOf(this.downloadSize);
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getName() {
        return this.url;
    }

    public Long getTotalSize() {
        return Long.valueOf(this.totalSize);
    }

    public String getUrl() {
        return this.name;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public Double percent() {
        long j = this.totalSize;
        if (j <= 0) {
            return Double.valueOf(0.0d);
        }
        if (this.downloadSize > j) {
            this.downloadSize = j;
        }
        double d2 = this.downloadSize;
        Double.isNaN(d2);
        BigDecimal bigDecimal = new BigDecimal(d2 * 100.0d);
        double d3 = this.totalSize;
        Double.isNaN(d3);
        return Double.valueOf(bigDecimal.divide(new BigDecimal(d3 * 1.0d), 2, 4).doubleValue());
    }

    public String percentStr() {
        return percent() + "%";
    }

    public void readFromParcel(Parcel parcel) {
        this.url = parcel.readString();
        this.name = parcel.readString();
        this.downloadSize = parcel.readLong();
        this.totalSize = parcel.readLong();
        this.isSuccess = parcel.readByte() != 0;
        this.downloadTime = parcel.readLong();
        this.downloadRate = parcel.readDouble();
        this.gameId = parcel.readString();
    }

    public Progress setDownloadRate(double d2) {
        this.downloadRate = d2;
        return this;
    }

    public Progress setDownloadSize(Long l) {
        this.downloadSize = l.longValue();
        return this;
    }

    public Progress setDownloadTime(long j) {
        this.downloadTime = j;
        return this;
    }

    public Progress setGameId(String str) {
        this.gameId = str;
        return this;
    }

    public Progress setName(String str) {
        this.url = str;
        return this;
    }

    public Progress setSize(Long l, Long l2) {
        this.downloadSize = l.longValue();
        this.totalSize = l2.longValue();
        return this;
    }

    public Progress setSuccess(boolean z) {
        this.isSuccess = z;
        return this;
    }

    public Progress setTotalSize(Long l) {
        this.totalSize = l.longValue();
        return this;
    }

    public Progress setUrl(String str) {
        this.name = str;
        return this;
    }

    public String totalSizeStr() {
        return formatSize(Long.valueOf(this.totalSize));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.name);
        parcel.writeLong(this.downloadSize);
        parcel.writeLong(this.totalSize);
        parcel.writeByte(this.isSuccess ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.downloadTime);
        parcel.writeDouble(this.downloadRate);
        parcel.writeString(this.gameId);
    }

    protected Progress(Parcel parcel) {
        readFromParcel(parcel);
    }
}
