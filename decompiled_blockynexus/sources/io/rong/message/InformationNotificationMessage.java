package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 1, value = "RC:InfoNtf")
public class InformationNotificationMessage extends MessageContent {
    public static final Parcelable.Creator<InformationNotificationMessage> CREATOR = new Parcelable.Creator<InformationNotificationMessage>() { // from class: io.rong.message.InformationNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InformationNotificationMessage createFromParcel(Parcel parcel) {
            return new InformationNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InformationNotificationMessage[] newArray(int i) {
            return new InformationNotificationMessage[i];
        }
    };
    private static final String TAG = "InformationNotificationMessage";
    protected String extra;
    private String message;

    protected InformationNotificationMessage() {
    }

    public static InformationNotificationMessage obtain(String str) {
        InformationNotificationMessage informationNotificationMessage = new InformationNotificationMessage();
        informationNotificationMessage.setMessage(str);
        return informationNotificationMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getMessage())) {
                jSONObject.put("message", getMessage());
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
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

    public String getExtra() {
        return this.extra;
    }

    public String getMessage() {
        return this.message;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getMessage());
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    public InformationNotificationMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("message")) {
                setMessage(jSONObject.optString("message"));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    public InformationNotificationMessage(Parcel parcel) {
        setMessage(ParcelUtils.readFromParcel(parcel));
        setExtra(ParcelUtils.readFromParcel(parcel));
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public InformationNotificationMessage(String str) {
        setMessage(str);
    }
}
