package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sandboxol.center.config.StringConstant;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsCha")
public class CSChangeModeMessage extends MessageContent {
    public static final Parcelable.Creator<CSChangeModeMessage> CREATOR = new Parcelable.Creator<CSChangeModeMessage>() { // from class: io.rong.message.CSChangeModeMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSChangeModeMessage createFromParcel(Parcel parcel) {
            return new CSChangeModeMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSChangeModeMessage[] newArray(int i) {
            return new CSChangeModeMessage[i];
        }
    };
    private static final String TAG = "CSChangeModeMessage";
    private String groupid;
    private String pid;
    private String sid;
    private String uid;

    public CSChangeModeMessage() {
    }

    public static CSChangeModeMessage obtain(String str, String str2, String str3, String str4) {
        CSChangeModeMessage cSChangeModeMessage = new CSChangeModeMessage();
        cSChangeModeMessage.sid = str;
        cSChangeModeMessage.uid = str2;
        cSChangeModeMessage.pid = str3;
        cSChangeModeMessage.groupid = str4;
        return cSChangeModeMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(StringConstant.UID, this.uid);
            jSONObject.put("sid", this.sid);
            jSONObject.put("pid", this.pid);
            if (!TextUtils.isEmpty(this.groupid)) {
                jSONObject.put("groupid", this.groupid);
            }
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.sid);
        ParcelUtils.writeToParcel(parcel, this.uid);
        ParcelUtils.writeToParcel(parcel, this.pid);
        ParcelUtils.writeToParcel(parcel, this.groupid);
    }

    public CSChangeModeMessage(byte[] bArr) {
    }

    public CSChangeModeMessage(Parcel parcel) {
        this.sid = ParcelUtils.readFromParcel(parcel);
        this.uid = ParcelUtils.readFromParcel(parcel);
        this.pid = ParcelUtils.readFromParcel(parcel);
        this.groupid = ParcelUtils.readFromParcel(parcel);
    }
}
