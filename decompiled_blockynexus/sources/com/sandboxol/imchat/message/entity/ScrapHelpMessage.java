package com.sandboxol.imchat.message.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.sandboxol.center.entity.XScrapCardInfo;
import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@MessageTag(flag = 3, value = "app:scrapHelp")
public class ScrapHelpMessage extends MessageContent {
    public static final Parcelable.Creator<ScrapHelpMessage> CREATOR = new Parcelable.Creator<ScrapHelpMessage>() { // from class: com.sandboxol.imchat.message.entity.ScrapHelpMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScrapHelpMessage createFromParcel(Parcel parcel) {
            return new ScrapHelpMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScrapHelpMessage[] newArray(int i) {
            return new ScrapHelpMessage[i];
        }
    };
    private String scrapDesc;
    private String scrapId;
    private int scrapLevel;
    private String scrapName;
    private int scrapNum;
    private String scrapUrl;
    private int scrapValue;
    private long senderId;
    private String senderName;
    private String uuid;

    public ScrapHelpMessage() {
        this.scrapLevel = 1;
        this.scrapNum = 1;
    }

    public static ScrapHelpMessage getInstanceFromXScrapCardInfo(XScrapCardInfo xScrapCardInfo) {
        return new ScrapHelpMessage(xScrapCardInfo.getSenderId(), xScrapCardInfo.getSenderName(), xScrapCardInfo.getScrapId(), xScrapCardInfo.getScrapName(), xScrapCardInfo.getScrapUrl(), xScrapCardInfo.getScrapLevel(), xScrapCardInfo.getScrapNum(), xScrapCardInfo.getUuid(), xScrapCardInfo.getScrapDesc(), xScrapCardInfo.getScrapValue());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("senderId", this.senderId);
            jSONObject.put("senderName", this.senderName);
            jSONObject.put("scrapId", this.scrapId);
            jSONObject.put("scrapName", this.scrapName);
            jSONObject.put("scrapUrl", this.scrapUrl);
            jSONObject.put("scrapLevel", this.scrapLevel);
            jSONObject.put("scrapNum", this.scrapNum);
            jSONObject.put("uuid", this.uuid);
            jSONObject.put("scrapDesc", this.scrapDesc);
            jSONObject.put("scrapValue", this.scrapValue);
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

    public String getScrapDesc() {
        return this.scrapDesc;
    }

    public String getScrapId() {
        return this.scrapId;
    }

    public int getScrapLevel() {
        return this.scrapLevel;
    }

    public String getScrapName() {
        return this.scrapName;
    }

    public int getScrapNum() {
        return this.scrapNum;
    }

    public String getScrapUrl() {
        return this.scrapUrl;
    }

    public int getScrapValue() {
        return this.scrapValue;
    }

    public long getSenderId() {
        return this.senderId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setScrapDesc(String str) {
        this.scrapDesc = str;
    }

    public void setScrapId(String str) {
        this.scrapId = str;
    }

    public void setScrapLevel(int i) {
        this.scrapLevel = i;
    }

    public void setScrapName(String str) {
        this.scrapName = str;
    }

    public void setScrapNum(int i) {
        this.scrapNum = i;
    }

    public void setScrapUrl(String str) {
        this.scrapUrl = str;
    }

    public void setScrapValue(int i) {
        this.scrapValue = i;
    }

    public void setSenderId(long j) {
        this.senderId = j;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.senderId));
        ParcelUtils.writeToParcel(parcel, this.senderName);
        ParcelUtils.writeToParcel(parcel, this.scrapId);
        ParcelUtils.writeToParcel(parcel, this.scrapName);
        ParcelUtils.writeToParcel(parcel, this.scrapUrl);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.scrapLevel));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.scrapNum));
        ParcelUtils.writeToParcel(parcel, this.uuid);
        ParcelUtils.writeToParcel(parcel, this.scrapDesc);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.scrapValue));
    }

    public ScrapHelpMessage(long j, String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3) {
        this.scrapLevel = 1;
        this.scrapNum = 1;
        this.senderId = j;
        this.senderName = str;
        this.scrapId = str2;
        this.scrapName = str3;
        this.scrapUrl = str4;
        this.scrapLevel = i;
        this.scrapNum = i2;
        this.uuid = str5;
        this.scrapDesc = str6;
        this.scrapValue = i3;
    }

    public ScrapHelpMessage(Parcel parcel) {
        this.scrapLevel = 1;
        this.scrapNum = 1;
        this.senderId = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.senderName = ParcelUtils.readFromParcel(parcel);
        this.scrapId = ParcelUtils.readFromParcel(parcel);
        this.scrapName = ParcelUtils.readFromParcel(parcel);
        this.scrapUrl = ParcelUtils.readFromParcel(parcel);
        this.scrapLevel = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.scrapNum = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.uuid = ParcelUtils.readFromParcel(parcel);
        this.scrapDesc = ParcelUtils.readFromParcel(parcel);
        this.scrapValue = ParcelUtils.readIntFromParcel(parcel).intValue();
    }

    public ScrapHelpMessage(byte[] bArr) {
        String str;
        this.scrapLevel = 1;
        this.scrapNum = 1;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("senderId")) {
                this.senderId = jSONObject.optLong("senderId");
            }
            if (jSONObject.has("senderName")) {
                this.senderName = jSONObject.optString("senderName");
            }
            if (jSONObject.has("scrapId")) {
                this.scrapId = jSONObject.optString("scrapId");
            }
            if (jSONObject.has("scrapName")) {
                this.scrapName = jSONObject.optString("scrapName");
            }
            if (jSONObject.has("scrapUrl")) {
                this.scrapUrl = jSONObject.optString("scrapUrl");
            }
            if (jSONObject.has("scrapLevel")) {
                this.scrapLevel = jSONObject.optInt("scrapLevel");
            }
            if (jSONObject.has("scrapNum")) {
                this.scrapNum = jSONObject.optInt("scrapNum");
            }
            if (jSONObject.has("uuid")) {
                this.uuid = jSONObject.optString("uuid");
            }
            if (jSONObject.has("scrapDesc")) {
                this.scrapDesc = jSONObject.optString("scrapDesc");
            }
            if (jSONObject.has("scrapValue")) {
                this.scrapValue = jSONObject.optInt("scrapValue");
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
