package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongListWrap implements Parcelable {
    public static final Parcelable.Creator<RongListWrap> CREATOR = new Parcelable.Creator<RongListWrap>() { // from class: io.rong.imlib.model.RongListWrap.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RongListWrap createFromParcel(Parcel parcel) {
            return new RongListWrap(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RongListWrap[] newArray(int i) {
            return new RongListWrap[i];
        }
    };
    public static Class mClass;
    private List mList;

    public RongListWrap() {
        this.mList = new ArrayList();
    }

    public static RongListWrap obtain(List list, Class cls) {
        return new RongListWrap(list, cls);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List getList() {
        return this.mList;
    }

    public void setList(List list) {
        this.mList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeListToParcel(parcel, this.mList);
    }

    public RongListWrap(List list, Class cls) {
        this.mList = new ArrayList();
        this.mList = list;
        mClass = cls;
    }

    public RongListWrap(Parcel parcel) {
        this.mList = new ArrayList();
        this.mList = ParcelUtils.readListFromParcel(parcel, Message.class);
    }
}
