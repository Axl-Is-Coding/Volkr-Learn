package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:RRReqMsg")
public class ReadReceiptRequestMessage extends MessageContent {
    public static final Parcelable.Creator<ReadReceiptRequestMessage> CREATOR = new Parcelable.Creator<ReadReceiptRequestMessage>() { // from class: io.rong.message.ReadReceiptRequestMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptRequestMessage createFromParcel(Parcel parcel) {
            return new ReadReceiptRequestMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptRequestMessage[] newArray(int i) {
            return new ReadReceiptRequestMessage[i];
        }
    };
    private static final String TAG = "ReadReceiptRequestMessage";
    private String mMessageUId;

    public ReadReceiptRequestMessage(String str) {
        this.mMessageUId = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.mMessageUId)) {
                jSONObject.put("messageUId", this.mMessageUId);
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return null;
        }
    }

    public String getMessageUId() {
        return this.mMessageUId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.mMessageUId);
    }

    public ReadReceiptRequestMessage(Parcel parcel) {
        this.mMessageUId = ParcelUtils.readFromParcel(parcel);
    }

    public ReadReceiptRequestMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, e2.getMessage());
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("messageUId")) {
                this.mMessageUId = jSONObject.getString("messageUId");
            }
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }
}
