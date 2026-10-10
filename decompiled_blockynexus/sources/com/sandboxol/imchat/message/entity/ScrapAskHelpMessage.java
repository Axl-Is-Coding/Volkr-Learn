package com.sandboxol.imchat.message.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.sandboxol.center.entity.ScrapMakeSureInfo;
import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@MessageTag(flag = 3, value = "app:scrapAskHelp")
public class ScrapAskHelpMessage extends MessageContent {
    public static final Parcelable.Creator<ScrapAskHelpMessage> CREATOR = new Parcelable.Creator<ScrapAskHelpMessage>() { // from class: com.sandboxol.imchat.message.entity.ScrapAskHelpMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScrapAskHelpMessage createFromParcel(Parcel parcel) {
            return new ScrapAskHelpMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScrapAskHelpMessage[] newArray(int i) {
            return new ScrapAskHelpMessage[i];
        }
    };
    private String scrapDesc;
    private String scrapId;
    private int scrapLevel;
    private String scrapName;
    private int scrapNum;
    private String scrapPic;
    private int scrapValue;
    private long userId;
    private String userName;

    public ScrapAskHelpMessage() {
    }

    public static ScrapMakeSureInfo transToScrapMakeSureInfo(ScrapAskHelpMessage scrapAskHelpMessage) {
        return new ScrapMakeSureInfo(scrapAskHelpMessage.getScrapId(), scrapAskHelpMessage.getScrapName(), scrapAskHelpMessage.getUserName(), scrapAskHelpMessage.getUserId(), scrapAskHelpMessage.getScrapLevel(), scrapAskHelpMessage.getScrapPic(), scrapAskHelpMessage.getScrapNum());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scrapId", this.scrapId);
            jSONObject.put("scrapName", this.scrapName);
            jSONObject.put("userName", this.userName);
            jSONObject.put("userId", this.userId);
            jSONObject.put("scrapLevel", this.scrapLevel);
            jSONObject.put("scrapPic", this.scrapPic);
            jSONObject.put("scrapNum", this.scrapNum);
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

    public String getScrapPic() {
        return this.scrapPic;
    }

    public int getScrapValue() {
        return this.scrapValue;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
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

    public void setScrapPic(String str) {
        this.scrapPic = str;
    }

    public void setScrapValue(int i) {
        this.scrapValue = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.scrapId);
        ParcelUtils.writeToParcel(parcel, this.scrapName);
        ParcelUtils.writeToParcel(parcel, this.userName);
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.userId));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.scrapLevel));
        ParcelUtils.writeToParcel(parcel, this.scrapPic);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.scrapNum));
        ParcelUtils.writeToParcel(parcel, this.scrapDesc);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.scrapValue));
    }

    public ScrapAskHelpMessage(String str, String str2, String str3, long j, int i, String str4, int i2, String str5, int i3) {
        this.scrapId = str;
        this.scrapName = str2;
        this.userName = str3;
        this.userId = j;
        this.scrapLevel = i;
        this.scrapPic = str4;
        this.scrapNum = i2;
        this.scrapDesc = str5;
        this.scrapValue = i3;
    }

    public ScrapAskHelpMessage(Parcel parcel) {
        this.scrapId = ParcelUtils.readFromParcel(parcel);
        this.scrapName = ParcelUtils.readFromParcel(parcel);
        this.userName = ParcelUtils.readFromParcel(parcel);
        this.userId = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.scrapLevel = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.scrapPic = ParcelUtils.readFromParcel(parcel);
        this.scrapNum = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.scrapDesc = ParcelUtils.readFromParcel(parcel);
        this.scrapValue = ParcelUtils.readIntFromParcel(parcel).intValue();
    }

    public ScrapAskHelpMessage(byte[] bArr) {
        String str;
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
            if (jSONObject.has("scrapId")) {
                this.scrapId = jSONObject.optString("scrapId");
            }
            if (jSONObject.has("scrapName")) {
                this.scrapName = jSONObject.optString("scrapName");
            }
            if (jSONObject.has("userName")) {
                this.userName = jSONObject.optString("userName");
            }
            if (jSONObject.has("userId")) {
                this.userId = jSONObject.optLong("userId");
            }
            if (jSONObject.has("scrapLevel")) {
                this.scrapLevel = jSONObject.optInt("scrapLevel");
            }
            if (jSONObject.has("scrapPic")) {
                this.scrapPic = jSONObject.optString("scrapPic");
            }
            if (jSONObject.has("scrapNum")) {
                this.scrapNum = jSONObject.optInt("scrapNum");
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
