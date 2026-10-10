package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 1, value = "RC:DizNtf")
public class DiscussionNotificationMessage extends NotificationMessage {
    public static final Parcelable.Creator<DiscussionNotificationMessage> CREATOR = new Parcelable.Creator<DiscussionNotificationMessage>() { // from class: io.rong.message.DiscussionNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiscussionNotificationMessage createFromParcel(Parcel parcel) {
            return new DiscussionNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiscussionNotificationMessage[] newArray(int i) {
            return new DiscussionNotificationMessage[i];
        }
    };
    private static final String TAG = "DiscussionNotificationMessage";
    private String extension;
    private boolean hasReceived;
    private String operator;
    private int type;

    public DiscussionNotificationMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put(ShareConstants.MEDIA_EXTENSION, this.extension);
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException", e3);
            return null;
        }
    }

    public String getExtension() {
        return this.extension;
    }

    public String getOperator() {
        return this.operator;
    }

    public int getType() {
        return this.type;
    }

    public boolean isHasReceived() {
        return this.hasReceived;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setHasReceived(boolean z) {
        this.hasReceived = z;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.type));
        ParcelUtils.writeToParcel(parcel, this.extension);
        ParcelUtils.writeToParcel(parcel, this.operator);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    public DiscussionNotificationMessage(Parcel parcel) {
        this.type = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.extension = ParcelUtils.readFromParcel(parcel);
        this.operator = ParcelUtils.readFromParcel(parcel);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public DiscussionNotificationMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setType(jSONObject.optInt("type"));
            setExtension(jSONObject.optString(ShareConstants.MEDIA_EXTENSION));
            setOperator(jSONObject.optString("operator"));
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e3) {
            Log.e("JSONException", e3.getMessage());
        }
    }
}
