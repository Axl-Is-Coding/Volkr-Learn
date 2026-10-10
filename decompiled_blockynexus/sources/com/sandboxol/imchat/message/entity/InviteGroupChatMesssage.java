package com.sandboxol.imchat.message.entity;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@MessageTag(flag = 3, value = "app:groupChatCard")
public class InviteGroupChatMesssage extends MessageContent {
    public static final Parcelable.Creator<InviteGroupChatMesssage> CREATOR = new Parcelable.Creator<InviteGroupChatMesssage>() { // from class: com.sandboxol.imchat.message.entity.InviteGroupChatMesssage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InviteGroupChatMesssage createFromParcel(Parcel parcel) {
            return new InviteGroupChatMesssage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InviteGroupChatMesssage[] newArray(int i) {
            return new InviteGroupChatMesssage[i];
        }
    };
    private long groupId;
    private String groupPic;
    private String msg;
    private long userId;

    public InviteGroupChatMesssage(long j, long j2, String str, String str2) {
        this.userId = j;
        this.groupId = j2;
        this.msg = str;
        this.groupPic = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.userId);
            jSONObject.put("groupId", this.groupId);
            jSONObject.put("msg", this.msg);
            jSONObject.put("groupPic", this.groupPic);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupPic() {
        return this.groupPic;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupPic(String str) {
        this.groupPic = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "InviteGroupChatMesssage{userId=" + this.userId + ", groupId=" + this.groupId + ", msg='" + this.msg + "', groupPic='" + this.groupPic + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.userId));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.groupId));
        ParcelUtils.writeToParcel(parcel, this.msg);
        ParcelUtils.writeToParcel(parcel, this.groupPic);
    }

    public InviteGroupChatMesssage() {
    }

    public InviteGroupChatMesssage(Parcel parcel) {
        this.userId = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.groupId = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.msg = ParcelUtils.readFromParcel(parcel);
        this.groupPic = ParcelUtils.readFromParcel(parcel);
    }

    public InviteGroupChatMesssage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("userId")) {
                this.userId = jSONObject.optLong("userId");
            }
            if (jSONObject.has("groupId")) {
                this.groupId = jSONObject.optLong("groupId");
            }
            if (jSONObject.has("msg")) {
                this.msg = jSONObject.optString("msg");
            }
            if (jSONObject.has("groupPic")) {
                this.groupPic = jSONObject.optString("groupPic");
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
