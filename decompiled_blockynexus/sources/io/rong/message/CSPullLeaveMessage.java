package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 1, value = "RC:CsPLM")
public class CSPullLeaveMessage extends MessageContent {
    public static final Parcelable.Creator<CSPullLeaveMessage> CREATOR = new Parcelable.Creator<CSPullLeaveMessage>() { // from class: io.rong.message.CSPullLeaveMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSPullLeaveMessage createFromParcel(Parcel parcel) {
            return new CSPullLeaveMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSPullLeaveMessage[] newArray(int i) {
            return new CSPullLeaveMessage[i];
        }
    };
    private static final String TAG = "CSRequestLeaveMessage";
    private String content;

    public CSPullLeaveMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return new byte[0];
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.content);
    }

    public CSPullLeaveMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            this.content = new JSONObject(str).optString("content");
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    protected CSPullLeaveMessage(Parcel parcel) {
        this.content = parcel.readString();
    }
}
