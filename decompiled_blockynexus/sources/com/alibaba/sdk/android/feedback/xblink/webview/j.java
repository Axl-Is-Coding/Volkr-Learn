package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class j implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Parcelable.Creator f3916a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3920e;

    public j() {
        this.f3917b = true;
        this.f3918c = false;
        this.f3919d = true;
        this.f3920e = true;
    }

    public j(Parcel parcel) {
        this.f3917b = true;
        this.f3918c = false;
        this.f3919d = true;
        this.f3920e = true;
        this.f3917b = parcel.readInt() == 1;
        this.f3918c = parcel.readInt() == 1;
        this.f3919d = parcel.readInt() == 1;
        this.f3920e = parcel.readInt() == 1;
    }

    public boolean a() {
        return this.f3917b;
    }

    public boolean b() {
        return this.f3920e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3917b ? 1 : 0);
        parcel.writeInt(this.f3918c ? 1 : 0);
        parcel.writeInt(this.f3919d ? 1 : 0);
        parcel.writeInt(this.f3920e ? 1 : 0);
    }
}
