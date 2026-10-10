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
@MessageTag(flag = 0, value = "RC:CsPullEva")
public class CSPullEvaluateMessage extends MessageContent {
    public static final Parcelable.Creator<CSPullEvaluateMessage> CREATOR = new Parcelable.Creator<CSPullEvaluateMessage>() { // from class: io.rong.message.CSPullEvaluateMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSPullEvaluateMessage createFromParcel(Parcel parcel) {
            return new CSPullEvaluateMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSPullEvaluateMessage[] newArray(int i) {
            return new CSPullEvaluateMessage[i];
        }
    };
    private static final String TAG = "CSPullEvaluateMessage";
    private String msgId;

    public CSPullEvaluateMessage() {
    }

    public static CSPullEvaluateMessage obtain() {
        return new CSPullEvaluateMessage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return null;
    }

    public String getMsgId() {
        return this.msgId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.msgId);
    }

    public CSPullEvaluateMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            this.msgId = new JSONObject(str).getString("msgId");
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException" + e3.getMessage());
        }
    }

    public CSPullEvaluateMessage(Parcel parcel) {
        this.msgId = ParcelUtils.readFromParcel(parcel);
    }
}
