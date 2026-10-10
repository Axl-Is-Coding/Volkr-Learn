package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ChatRoomMemberInfo implements Parcelable {
    public static final Parcelable.Creator<ChatRoomMemberInfo> CREATOR = new Parcelable.Creator<ChatRoomMemberInfo>() { // from class: io.rong.imlib.model.ChatRoomMemberInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomMemberInfo createFromParcel(Parcel parcel) {
            return new ChatRoomMemberInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomMemberInfo[] newArray(int i) {
            return new ChatRoomMemberInfo[i];
        }
    };
    private String id;
    private long joinTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public String getUserId() {
        if (TextUtils.isEmpty(this.id)) {
            throw new NullPointerException("userId  is null");
        }
        return this.id;
    }

    public void setJoinTime(long j) {
        this.joinTime = j;
    }

    public void setUserId(String str) {
        this.id = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getUserId());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.joinTime));
    }

    public ChatRoomMemberInfo() {
    }

    private ChatRoomMemberInfo(Parcel parcel) {
        setUserId(ParcelUtils.readFromParcel(parcel));
        setJoinTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }
}
