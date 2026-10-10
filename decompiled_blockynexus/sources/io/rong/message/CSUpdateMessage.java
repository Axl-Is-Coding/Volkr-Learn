package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsUpdate")
public class CSUpdateMessage extends MessageContent {
    public static final Parcelable.Creator<CSUpdateMessage> CREATOR = new Parcelable.Creator<CSUpdateMessage>() { // from class: io.rong.message.CSUpdateMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSUpdateMessage createFromParcel(Parcel parcel) {
            return new CSUpdateMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSUpdateMessage[] newArray(int i) {
            return new CSUpdateMessage[i];
        }
    };
    private static final String TAG = "CSUpdateMessage";
    private String serviceStatus;
    private String sid;

    public CSUpdateMessage() {
    }

    public static CSUpdateMessage obtain(String str, String str2) {
        CSUpdateMessage cSUpdateMessage = new CSUpdateMessage();
        cSUpdateMessage.sid = str;
        cSUpdateMessage.serviceStatus = str2;
        return cSUpdateMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", this.sid);
            jSONObject.put("serviceStatus", this.serviceStatus);
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException", e3);
            return null;
        }
    }

    public String getServiceStatus() {
        return this.serviceStatus;
    }

    public String getSid() {
        return this.sid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.sid);
        ParcelUtils.writeToParcel(parcel, this.serviceStatus);
    }

    public CSUpdateMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.sid = jSONObject.optString("sid");
            this.serviceStatus = jSONObject.optString("serviceStatus");
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    public CSUpdateMessage(Parcel parcel) {
        this.sid = ParcelUtils.readFromParcel(parcel);
        this.serviceStatus = ParcelUtils.readFromParcel(parcel);
    }
}
