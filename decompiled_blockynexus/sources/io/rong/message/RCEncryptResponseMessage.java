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
@MessageTag(flag = 0, value = "RC:EncryptResponseMsg")
public class RCEncryptResponseMessage extends MessageContent {
    public static final Parcelable.Creator<RCEncryptResponseMessage> CREATOR = new Parcelable.Creator<RCEncryptResponseMessage>() { // from class: io.rong.message.RCEncryptResponseMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptResponseMessage createFromParcel(Parcel parcel) {
            return new RCEncryptResponseMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptResponseMessage[] newArray(int i) {
            return new RCEncryptResponseMessage[i];
        }
    };
    private static final String TAG = "io.rong.message.RCEncryptResponseMessage";
    private String requesterEncId;
    private String responserEncId;
    private String responserKey;

    public RCEncryptResponseMessage() {
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
            if (!TextUtils.isEmpty(getResponserEncId())) {
                jSONObject.putOpt("responserEncId", getResponserEncId());
            }
            if (!TextUtils.isEmpty(getResponserKey())) {
                jSONObject.putOpt("responserKey", getResponserKey());
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "encode", e3);
            return null;
        }
    }

    public String getRequesterEncId() {
        return this.requesterEncId;
    }

    public String getResponserEncId() {
        return this.responserEncId;
    }

    public String getResponserKey() {
        return this.responserKey;
    }

    public void setRequesterEncId(String str) {
        this.requesterEncId = str;
    }

    public void setResponserEncId(String str) {
        this.responserEncId = str;
    }

    public void setResponserKey(String str) {
        this.responserKey = str;
    }

    public String toString() {
        return "RCEncryptResponseMessage{requesterEncId='" + this.requesterEncId + "', responserEncId='" + this.responserEncId + "', responserKey='" + this.responserKey + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requesterEncId);
        parcel.writeString(this.responserEncId);
        parcel.writeString(this.responserKey);
    }

    public RCEncryptResponseMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "RCEncryptResponseMessage", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("requesterEncId")) {
                setRequesterEncId(jSONObject.optString("requesterEncId"));
            }
            if (jSONObject.has("responserEncId")) {
                setResponserEncId(jSONObject.optString("responserEncId"));
            }
            if (jSONObject.has("responserKey")) {
                setResponserKey(jSONObject.optString("responserKey"));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    protected RCEncryptResponseMessage(Parcel parcel) {
        this.requesterEncId = parcel.readString();
        this.responserEncId = parcel.readString();
        this.responserKey = parcel.readString();
    }
}
