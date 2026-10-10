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
@MessageTag(flag = 0, value = "RC:EncryptTerminateMsg")
public class RCEncryptTerminateMessage extends MessageContent {
    public static final Parcelable.Creator<RCEncryptTerminateMessage> CREATOR = new Parcelable.Creator<RCEncryptTerminateMessage>() { // from class: io.rong.message.RCEncryptTerminateMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptTerminateMessage createFromParcel(Parcel parcel) {
            return new RCEncryptTerminateMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptTerminateMessage[] newArray(int i) {
            return new RCEncryptTerminateMessage[i];
        }
    };
    private static final String TAG = "io.rong.message.RCEncryptTerminateMessage";
    private String receiverEncId;
    private String senderEncId;

    public RCEncryptTerminateMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getSenderEncId())) {
                jSONObject.put("senderEncId", getSenderEncId());
            }
            if (!TextUtils.isEmpty(getReceiverEncId())) {
                jSONObject.put("receiverEncId", getReceiverEncId());
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

    public String getReceiverEncId() {
        return this.receiverEncId;
    }

    public String getSenderEncId() {
        return this.senderEncId;
    }

    public void setReceiverEncId(String str) {
        this.receiverEncId = str;
    }

    public void setSenderEncId(String str) {
        this.senderEncId = str;
    }

    public String toString() {
        return "RCEncryptTerminateMessage{senderEncId='" + this.senderEncId + "', receiverEncId='" + this.receiverEncId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.senderEncId);
        parcel.writeString(this.receiverEncId);
    }

    public RCEncryptTerminateMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "RCEncryptTerminateMessage", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("senderEncId")) {
                setSenderEncId(jSONObject.optString("senderEncId"));
            }
            if (jSONObject.has("receiverEncId")) {
                setReceiverEncId(jSONObject.optString("receiverEncId"));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    protected RCEncryptTerminateMessage(Parcel parcel) {
        this.senderEncId = parcel.readString();
        this.receiverEncId = parcel.readString();
    }
}
