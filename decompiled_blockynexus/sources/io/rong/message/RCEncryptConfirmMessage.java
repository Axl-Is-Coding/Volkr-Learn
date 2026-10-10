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
@MessageTag(flag = 0, value = "RC:EncryptConfirmMsg")
public class RCEncryptConfirmMessage extends MessageContent {
    public static final Parcelable.Creator<RCEncryptConfirmMessage> CREATOR = new Parcelable.Creator<RCEncryptConfirmMessage>() { // from class: io.rong.message.RCEncryptConfirmMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptConfirmMessage createFromParcel(Parcel parcel) {
            return new RCEncryptConfirmMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptConfirmMessage[] newArray(int i) {
            return new RCEncryptConfirmMessage[i];
        }
    };
    static final String TAG = "io.rong.message.RCEncryptConfirmMessage";
    private String requesterEncId;
    private String responserEncId;

    public RCEncryptConfirmMessage() {
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
                jSONObject.put("responserEncId", getResponserEncId());
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public String getRequesterEncId() {
        return this.requesterEncId;
    }

    public String getResponserEncId() {
        return this.responserEncId;
    }

    public void setRequesterEncId(String str) {
        this.requesterEncId = str;
    }

    public void setResponserEncId(String str) {
        this.responserEncId = str;
    }

    public String toString() {
        return "RCEncryptConfirmMessage{requesterEncId='" + this.requesterEncId + "', responserEncId='" + this.responserEncId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requesterEncId);
        parcel.writeString(this.responserEncId);
    }

    public RCEncryptConfirmMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
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
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    protected RCEncryptConfirmMessage(Parcel parcel) {
        this.requesterEncId = parcel.readString();
        this.responserEncId = parcel.readString();
    }
}
