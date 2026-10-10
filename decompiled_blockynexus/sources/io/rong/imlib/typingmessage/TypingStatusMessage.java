package io.rong.imlib.typingmessage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.message.StatusMessage;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 16, value = "RC:TypSts")
public class TypingStatusMessage extends StatusMessage {
    public static final Parcelable.Creator<TypingStatusMessage> CREATOR = new Parcelable.Creator<TypingStatusMessage>() { // from class: io.rong.imlib.typingmessage.TypingStatusMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TypingStatusMessage createFromParcel(Parcel parcel) {
            return new TypingStatusMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TypingStatusMessage[] newArray(int i) {
            return new TypingStatusMessage[i];
        }
    };
    private static final String TAG = "TypingStatusMessage";
    private String data;
    private String typingContentType;

    public TypingStatusMessage(String str, String str2) {
        setTypingContentType(str);
        setData(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("typingContentType", getTypingContentType());
            if (!TextUtils.isEmpty(getData())) {
                jSONObject.put("data", getData());
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "encode", e3);
            return new byte[0];
        }
    }

    public String getData() {
        return this.data;
    }

    public String getTypingContentType() {
        return this.typingContentType;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setTypingContentType(String str) {
        this.typingContentType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getTypingContentType());
        ParcelUtils.writeToParcel(parcel, getData());
    }

    public TypingStatusMessage(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "TypingStatusMessage " + e2.getMessage());
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("typingContentType")) {
                setTypingContentType(jSONObject.getString("typingContentType"));
            }
            if (jSONObject.has("data")) {
                setData(jSONObject.getString("data"));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "TypingStatusMessage " + e3.getMessage());
        }
    }

    public TypingStatusMessage(Parcel parcel) {
        setTypingContentType(ParcelUtils.readFromParcel(parcel));
        setData(ParcelUtils.readFromParcel(parcel));
    }

    public TypingStatusMessage() {
    }
}
