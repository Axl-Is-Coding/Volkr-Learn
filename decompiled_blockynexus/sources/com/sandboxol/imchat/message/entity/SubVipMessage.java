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
@MessageTag(flag = 3, value = "cu:SubNotify")
public class SubVipMessage extends MessageContent {
    public static final Parcelable.Creator<SubVipMessage> CREATOR = new Parcelable.Creator<SubVipMessage>() { // from class: com.sandboxol.imchat.message.entity.SubVipMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubVipMessage createFromParcel(Parcel parcel) {
            return new SubVipMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubVipMessage[] newArray(int i) {
            return new SubVipMessage[i];
        }
    };
    private String appType;
    private String notifyType;

    public SubVipMessage(String str, String str2) {
        this.notifyType = str;
        this.appType = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notifyType", this.notifyType);
            jSONObject.put("appType", this.appType);
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

    public String getAppType() {
        return this.appType;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public String toString() {
        return "SubVipMessage{notifyType=" + this.notifyType + ", appType=" + this.appType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.notifyType);
        ParcelUtils.writeToParcel(parcel, this.appType);
    }

    public SubVipMessage() {
    }

    public SubVipMessage(Parcel parcel) {
        this.notifyType = ParcelUtils.readFromParcel(parcel);
        this.appType = ParcelUtils.readFromParcel(parcel);
    }

    public SubVipMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("notifyType")) {
                this.notifyType = jSONObject.optString("notifyType");
            }
            if (jSONObject.has("appType")) {
                this.appType = jSONObject.optString("appType");
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
