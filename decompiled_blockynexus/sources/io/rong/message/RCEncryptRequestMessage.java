package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:EncryptRequestMsg")
public class RCEncryptRequestMessage extends MessageContent {
    public static final Parcelable.Creator<RCEncryptRequestMessage> CREATOR = new Parcelable.Creator<RCEncryptRequestMessage>() { // from class: io.rong.message.RCEncryptRequestMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptRequestMessage createFromParcel(Parcel parcel) {
            return new RCEncryptRequestMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptRequestMessage[] newArray(int i) {
            return new RCEncryptRequestMessage[i];
        }
    };
    private String TAG = RCEncryptRequestMessage.class.getName();
    private String requesterEncId;
    private String requesterKey;

    public RCEncryptRequestMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getRequesterEncId())) {
                jSONObject.put("requesterEncId", getRequesterEncId());
            }
            if (!TextUtils.isEmpty(getRequesterKey())) {
                jSONObject.put("requesterKey", getRequesterKey());
            }
        } catch (JSONException e2) {
            RLog.e(this.TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(this.TAG, "encode", e3);
            return null;
        }
    }

    public String getRequesterEncId() {
        return this.requesterEncId;
    }

    public String getRequesterKey() {
        return this.requesterKey;
    }

    public void setRequesterEncId(String str) {
        this.requesterEncId = str;
    }

    public void setRequesterKey(String str) {
        this.requesterKey = str;
    }

    public String toString() {
        return "RCEncryptRequestMessage{requesterEncId='" + this.requesterEncId + "', requesterKey='" + this.requesterKey + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requesterEncId);
        parcel.writeString(this.requesterKey);
    }

    public RCEncryptRequestMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("requesterEncId")) {
                setRequesterEncId(jSONObject.optString("requesterEncId"));
            }
            if (jSONObject.has("requesterKey")) {
                setRequesterKey(jSONObject.optString("requesterKey"));
            }
        } catch (JSONException e3) {
            RLog.e(this.TAG, "JSONException " + e3.getMessage());
            e3.printStackTrace();
        }
    }

    protected RCEncryptRequestMessage(Parcel parcel) {
        this.requesterEncId = parcel.readString();
        this.requesterKey = parcel.readString();
    }
}
