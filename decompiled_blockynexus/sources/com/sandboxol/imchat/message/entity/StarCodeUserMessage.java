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
@MessageTag(flag = 3, value = "cu:videoStar")
public class StarCodeUserMessage extends MessageContent {
    public static final Parcelable.Creator<StarCodeUserMessage> CREATOR = new Parcelable.Creator<StarCodeUserMessage>() { // from class: com.sandboxol.imchat.message.entity.StarCodeUserMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StarCodeUserMessage createFromParcel(Parcel parcel) {
            return new StarCodeUserMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StarCodeUserMessage[] newArray(int i) {
            return new StarCodeUserMessage[i];
        }
    };
    private int disable;
    private long id;
    private String nickName;
    private String picUrl;
    private String starCode;
    private long userId;

    public StarCodeUserMessage(int i, long j, String str, String str2, String str3, long j2) {
        this.disable = i;
        this.id = j;
        this.nickName = str;
        this.picUrl = str2;
        this.starCode = str3;
        this.userId = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("disable", this.disable);
            jSONObject.put("id", this.id);
            jSONObject.put("nickName", this.nickName);
            jSONObject.put("picUrl", this.picUrl);
            jSONObject.put("starCode", this.starCode);
            jSONObject.put("userId", this.userId);
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

    public int getDisable() {
        return this.disable;
    }

    public long getId() {
        return this.id;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getStarCode() {
        return this.starCode;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setDisable(int i) {
        this.disable = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setStarCode(String str) {
        this.starCode = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "StarCodeUserMessage{userId=" + this.disable + "id=" + this.id + "nickName=" + this.nickName + ", picUrl=" + this.picUrl + ", starCode='" + this.starCode + "', userId='" + this.userId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.disable));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.id));
        ParcelUtils.writeToParcel(parcel, this.nickName);
        ParcelUtils.writeToParcel(parcel, this.picUrl);
        ParcelUtils.writeToParcel(parcel, this.starCode);
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.userId));
    }

    public StarCodeUserMessage() {
    }

    public StarCodeUserMessage(Parcel parcel) {
        this.disable = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.id = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.nickName = ParcelUtils.readFromParcel(parcel);
        this.picUrl = ParcelUtils.readFromParcel(parcel);
        this.starCode = ParcelUtils.readFromParcel(parcel);
        this.userId = ParcelUtils.readLongFromParcel(parcel).longValue();
    }

    public StarCodeUserMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("disable")) {
                this.disable = jSONObject.optInt("disable");
            }
            if (jSONObject.has("id")) {
                this.id = jSONObject.optLong("id");
            }
            if (jSONObject.has("nickName")) {
                this.nickName = jSONObject.optString("nickName");
            }
            if (jSONObject.has("picUrl")) {
                this.picUrl = jSONObject.optString("picUrl");
            }
            if (jSONObject.has("starCode")) {
                this.starCode = jSONObject.optString("starCode");
            }
            if (jSONObject.has("userId")) {
                this.userId = jSONObject.optLong("userId");
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
