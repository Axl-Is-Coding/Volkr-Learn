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
@MessageTag(flag = 0, value = "RC:CsEnd")
public class CSTerminateMessage extends MessageContent {
    public static final Parcelable.Creator<CSTerminateMessage> CREATOR = new Parcelable.Creator<CSTerminateMessage>() { // from class: io.rong.message.CSTerminateMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSTerminateMessage createFromParcel(Parcel parcel) {
            return new CSTerminateMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSTerminateMessage[] newArray(int i) {
            return new CSTerminateMessage[i];
        }
    };
    private static final String TAG = "CSTerminateMessage";
    private int code;
    private String msg;
    private String sid;

    public CSTerminateMessage() {
    }

    public static CSTerminateMessage obtain() {
        return new CSTerminateMessage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getsid() {
        return this.sid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.code));
        ParcelUtils.writeToParcel(parcel, this.msg);
        ParcelUtils.writeToParcel(parcel, this.sid);
    }

    public CSTerminateMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.code = jSONObject.optInt("code");
            this.msg = jSONObject.optString("msg");
            this.sid = jSONObject.optString("sid");
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    public CSTerminateMessage(Parcel parcel) {
        this.code = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.msg = ParcelUtils.readFromParcel(parcel);
        this.sid = ParcelUtils.readFromParcel(parcel);
    }
}
