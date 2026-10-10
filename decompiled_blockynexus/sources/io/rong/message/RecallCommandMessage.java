package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:RcCmd")
public class RecallCommandMessage extends MessageContent {
    public static final Parcelable.Creator<RecallCommandMessage> CREATOR = new Parcelable.Creator<RecallCommandMessage>() { // from class: io.rong.message.RecallCommandMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecallCommandMessage createFromParcel(Parcel parcel) {
            return new RecallCommandMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecallCommandMessage[] newArray(int i) {
            return new RecallCommandMessage[i];
        }
    };
    private static final String TAG = "RecallCommandMessage";
    private int conversationType;
    private String extra;
    private boolean isAdmin;
    private boolean isDelete;
    private String messageUId;
    private long sentTime;
    private String targetId;

    public RecallCommandMessage(String str) {
        setMessageUId(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            if (!TextUtils.isEmpty(getMessageUId())) {
                jSONObject.put("messageUId", getMessageUId());
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (!TextUtils.isEmpty(getTargetId())) {
                jSONObject.put("targetId", getTargetId());
            }
            jSONObject.put("isAdmin", isAdmin());
            jSONObject.put("isDelete", isDelete());
            jSONObject.put("conversationType", getConversationType());
            jSONObject.put("sentTime", getSentTime());
        } catch (JSONException e2) {
            RLog.e(TAG, e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return null;
        }
    }

    public int getConversationType() {
        return this.conversationType;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getMessageUId() {
        return this.messageUId;
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void setAdmin(boolean z) {
        this.isAdmin = z;
    }

    public void setConversationType(int i) {
        this.conversationType = i;
    }

    public void setDelete(boolean z) {
        this.isDelete = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMessageUId(String str) {
        this.messageUId = str;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, getMessageUId());
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getTargetId());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getConversationType()));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getSentTime()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isAdmin ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isDelete ? 1 : 0));
    }

    public RecallCommandMessage(String str, String str2) {
        setMessageUId(str);
        setExtra(str2);
    }

    public RecallCommandMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, e2.getMessage());
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            setMessageUId(jSONObject.optString("messageUId"));
            setExtra(jSONObject.optString("extra"));
            setTargetId(jSONObject.optString("targetId"));
            setConversationType(jSONObject.optInt("conversationType"));
            setSentTime(jSONObject.optLong("sentTime"));
            setAdmin(jSONObject.optBoolean("isAdmin"));
            setDelete(jSONObject.optBoolean("isDelete"));
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }

    public RecallCommandMessage(Parcel parcel) {
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setMessageUId(ParcelUtils.readFromParcel(parcel));
        setExtra(ParcelUtils.readFromParcel(parcel));
        setTargetId(ParcelUtils.readFromParcel(parcel));
        setConversationType(ParcelUtils.readIntFromParcel(parcel).intValue());
        setSentTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setAdmin(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDelete(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
    }
}
