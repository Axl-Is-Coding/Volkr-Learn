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
@MessageTag(flag = 3, value = "cu:collectExchange")
public class CollectExchangeMessage extends MessageContent {
    public static final Parcelable.Creator<CollectExchangeMessage> CREATOR = new Parcelable.Creator<CollectExchangeMessage>() { // from class: com.sandboxol.imchat.message.entity.CollectExchangeMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectExchangeMessage createFromParcel(Parcel parcel) {
            return new CollectExchangeMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectExchangeMessage[] newArray(int i) {
            return new CollectExchangeMessage[i];
        }
    };
    private int operation;
    private Long receiveUserId;
    private String scrapId;
    private Long sendUserId;
    private String uuid;

    protected CollectExchangeMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.uuid);
            jSONObject.put("scrapId", this.scrapId);
            jSONObject.put("receiveUserId", this.receiveUserId);
            jSONObject.put("sendUserId", this.sendUserId);
            jSONObject.put("operation", this.operation);
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

    public int getOperation() {
        return this.operation;
    }

    public Long getReceiveUserId() {
        return this.receiveUserId;
    }

    public String getScrapId() {
        return this.scrapId;
    }

    public Long getSendUserId() {
        return this.sendUserId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setOperation(int i) {
        this.operation = i;
    }

    public void setReceiveUserId(Long l) {
        this.receiveUserId = l;
    }

    public void setScrapId(String str) {
        this.scrapId = str;
    }

    public void setSendUserId(Long l) {
        this.sendUserId = l;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.uuid);
        ParcelUtils.writeToParcel(parcel, this.scrapId);
        ParcelUtils.writeToParcel(parcel, this.receiveUserId);
        ParcelUtils.writeToParcel(parcel, this.sendUserId);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.operation));
    }

    public CollectExchangeMessage(String str, String str2, Long l, Long l2, int i) {
        this.uuid = str;
        this.scrapId = str2;
        this.receiveUserId = l;
        this.sendUserId = l2;
        this.operation = i;
    }

    public CollectExchangeMessage(Parcel parcel) {
        this.uuid = ParcelUtils.readFromParcel(parcel);
        this.scrapId = ParcelUtils.readFromParcel(parcel);
        this.receiveUserId = ParcelUtils.readLongFromParcel(parcel);
        this.sendUserId = ParcelUtils.readLongFromParcel(parcel);
        this.operation = ParcelUtils.readIntFromParcel(parcel).intValue();
    }

    public CollectExchangeMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("uuid")) {
                this.uuid = jSONObject.optString("uuid");
            }
            if (jSONObject.has("scrapId")) {
                this.scrapId = jSONObject.optString("scrapId");
            }
            if (jSONObject.has("receiveUserId")) {
                this.receiveUserId = Long.valueOf(jSONObject.optLong("receiveUserId"));
            }
            if (jSONObject.has("sendUserId")) {
                this.sendUserId = Long.valueOf(jSONObject.optLong("sendUserId"));
            }
            if (jSONObject.has("operation")) {
                this.operation = jSONObject.optInt("operation");
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
