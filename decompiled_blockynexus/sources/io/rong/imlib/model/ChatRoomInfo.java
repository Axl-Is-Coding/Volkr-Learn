package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ChatRoomInfo implements Parcelable {
    public static final Parcelable.Creator<ChatRoomInfo> CREATOR = new Parcelable.Creator<ChatRoomInfo>() { // from class: io.rong.imlib.model.ChatRoomInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomInfo createFromParcel(Parcel parcel) {
            return new ChatRoomInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomInfo[] newArray(int i) {
            return new ChatRoomInfo[i];
        }
    };
    private String chatRoomId;
    private List<ChatRoomMemberInfo> memberInfo;
    private ChatRoomMemberOrder order;
    private int totalMemberCount;

    public enum ChatRoomMemberOrder {
        RC_CHAT_ROOM_MEMBER_ASC(1),
        RC_CHAT_ROOM_MEMBER_DESC(2);

        int value;

        ChatRoomMemberOrder(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public ChatRoomInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getChatRoomId() {
        return this.chatRoomId;
    }

    public List<ChatRoomMemberInfo> getMemberInfo() {
        return this.memberInfo;
    }

    public ChatRoomMemberOrder getMemberOrder() {
        return this.order;
    }

    public int getTotalMemberCount() {
        return this.totalMemberCount;
    }

    public void setChatRoomId(String str) {
        this.chatRoomId = str;
    }

    public void setMemberInfo(List<ChatRoomMemberInfo> list) {
        this.memberInfo = list;
    }

    public void setMemberOrder(ChatRoomMemberOrder chatRoomMemberOrder) {
        this.order = chatRoomMemberOrder;
    }

    public void setTotalMemberCount(int i) {
        this.totalMemberCount = i;
    }

    public void setUsers(List<ChatRoomMemberInfo> list) {
        this.memberInfo = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.chatRoomId);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.totalMemberCount));
        ParcelUtils.writeToParcel(parcel, this.memberInfo);
    }

    public ChatRoomInfo(Parcel parcel) {
        this.chatRoomId = ParcelUtils.readFromParcel(parcel);
        this.totalMemberCount = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.memberInfo = ParcelUtils.readListFromParcel(parcel, ChatRoomMemberInfo.class);
    }
}
