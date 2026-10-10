package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteModelWrap implements Parcelable {
    public static final Parcelable.Creator<RemoteModelWrap> CREATOR = new Parcelable.Creator<RemoteModelWrap>() { // from class: io.rong.imlib.model.RemoteModelWrap.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteModelWrap createFromParcel(Parcel parcel) {
            return new RemoteModelWrap(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteModelWrap[] newArray(int i) {
            return new RemoteModelWrap[i];
        }
    };
    private static final String TAG = "RemoteModelWrap";
    Parcelable model;

    public RemoteModelWrap() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends Parcelable> T getContent() {
        return (T) this.model;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.model.getClass().getName());
        ParcelUtils.writeToParcel(parcel, this.model);
    }

    public RemoteModelWrap(Parcelable parcelable) {
        this.model = parcelable;
    }

    public RemoteModelWrap(Parcel parcel) {
        Class<?> cls;
        try {
            cls = Class.forName(ParcelUtils.readFromParcel(parcel));
        } catch (ClassNotFoundException e2) {
            RLog.e(TAG, "RemoteModelWrap constructor", e2);
            cls = null;
        }
        if (cls != null) {
            this.model = ParcelUtils.readFromParcel(parcel, cls);
        }
    }
}
