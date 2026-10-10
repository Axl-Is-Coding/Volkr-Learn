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
@MessageTag(flag = 1, value = "RC:ProfileNtf")
public class ProfileNotificationMessage extends MessageContent {
    public static final Parcelable.Creator<ProfileNotificationMessage> CREATOR = new Parcelable.Creator<ProfileNotificationMessage>() { // from class: io.rong.message.ProfileNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProfileNotificationMessage createFromParcel(Parcel parcel) {
            return new ProfileNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProfileNotificationMessage[] newArray(int i) {
            return new ProfileNotificationMessage[i];
        }
    };
    private static final String TAG = "ProfileNotificationMessage";
    private String data;
    private String extra;
    private String operation;

    public ProfileNotificationMessage(Parcel parcel) {
        this.operation = ParcelUtils.readFromParcel(parcel);
        this.data = ParcelUtils.readFromParcel(parcel);
        this.extra = ParcelUtils.readFromParcel(parcel);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public static ProfileNotificationMessage obtain(String str, String str2) {
        ProfileNotificationMessage profileNotificationMessage = new ProfileNotificationMessage();
        profileNotificationMessage.operation = str;
        profileNotificationMessage.data = str2;
        return profileNotificationMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", this.operation);
            if (!TextUtils.isEmpty(this.data)) {
                jSONObject.put("data", this.data);
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
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return null;
        }
    }

    public String getData() {
        return this.data;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.operation);
        ParcelUtils.writeToParcel(parcel, this.data);
        ParcelUtils.writeToParcel(parcel, this.extra);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    private ProfileNotificationMessage() {
    }

    public ProfileNotificationMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setOperation(jSONObject.optString("operation"));
            setData(jSONObject.optString("data"));
            setExtra(jSONObject.optString("extra"));
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }
}
