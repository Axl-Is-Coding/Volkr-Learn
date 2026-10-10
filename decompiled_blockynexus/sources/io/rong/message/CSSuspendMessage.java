package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.sandboxol.center.config.StringConstant;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsSp")
public class CSSuspendMessage extends MessageContent {
    public static final Parcelable.Creator<CSSuspendMessage> CREATOR = new Parcelable.Creator<CSSuspendMessage>() { // from class: io.rong.message.CSSuspendMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSSuspendMessage createFromParcel(Parcel parcel) {
            return new CSSuspendMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSSuspendMessage[] newArray(int i) {
            return new CSSuspendMessage[i];
        }
    };
    private static final String TAG = "CSSuspendMessage";
    private String pid;
    private String sid;
    private String uid;

    public CSSuspendMessage() {
    }

    public static CSSuspendMessage obtain(String str, String str2, String str3) {
        CSSuspendMessage cSSuspendMessage = new CSSuspendMessage();
        cSSuspendMessage.sid = str;
        cSSuspendMessage.uid = str2;
        cSSuspendMessage.pid = str3;
        return cSSuspendMessage;
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
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException " + e3);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.sid);
        ParcelUtils.writeToParcel(parcel, this.uid);
        ParcelUtils.writeToParcel(parcel, this.pid);
    }

    public CSSuspendMessage(byte[] bArr) {
    }

    public CSSuspendMessage(Parcel parcel) {
        this.sid = ParcelUtils.readFromParcel(parcel);
        this.uid = ParcelUtils.readFromParcel(parcel);
        this.pid = ParcelUtils.readFromParcel(parcel);
    }
}
