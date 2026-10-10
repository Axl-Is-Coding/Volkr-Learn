package io.rong.imlib.location.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, value = "RC:RLStart")
public class RealTimeLocationStartMessage extends MessageContent {
    public static final Parcelable.Creator<RealTimeLocationStartMessage> CREATOR = new Parcelable.Creator<RealTimeLocationStartMessage>() { // from class: io.rong.imlib.location.message.RealTimeLocationStartMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationStartMessage createFromParcel(Parcel parcel) {
            return new RealTimeLocationStartMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationStartMessage[] newArray(int i) {
            return new RealTimeLocationStartMessage[i];
        }
    };
    private static final String TAG = "RealTimeLocationStartMessage";
    private String content;
    private String extra;

    public static RealTimeLocationStartMessage obtain(String str) {
        return new RealTimeLocationStartMessage(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", this.content);
            if (this.extra != null) {
                jSONObject.put("extra", this.extra);
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "encode JSONException", e2);
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "encode JSONException", e3);
            return new byte[0];
        }
    }

    public String getContent() {
        return this.content;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.content);
        parcel.writeString(this.extra);
    }

    public RealTimeLocationStartMessage(String str) {
        this.content = "";
        this.extra = "";
        this.content = str;
    }

    public RealTimeLocationStartMessage(byte[] bArr) {
        String str;
        this.content = "";
        this.extra = "";
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, TAG, e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
            }
            if (jSONObject.has("extra")) {
                this.extra = jSONObject.getString("extra");
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    private RealTimeLocationStartMessage(Parcel parcel) {
        this.content = "";
        this.extra = "";
        this.content = parcel.readString();
        this.extra = parcel.readString();
    }
}
