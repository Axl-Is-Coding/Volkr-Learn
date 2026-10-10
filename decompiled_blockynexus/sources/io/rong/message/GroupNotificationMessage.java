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
@MessageTag(flag = 1, value = "RC:GrpNtf")
public class GroupNotificationMessage extends MessageContent {
    public static final Parcelable.Creator<GroupNotificationMessage> CREATOR = new Parcelable.Creator<GroupNotificationMessage>() { // from class: io.rong.message.GroupNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupNotificationMessage createFromParcel(Parcel parcel) {
            return new GroupNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupNotificationMessage[] newArray(int i) {
            return new GroupNotificationMessage[i];
        }
    };
    public static final String GROUP_OPERATION_ADD = "Add";
    public static final String GROUP_OPERATION_BULLETIN = "Bulletin";
    public static final String GROUP_OPERATION_CREATE = "Create";
    public static final String GROUP_OPERATION_DISMISS = "Dismiss";
    public static final String GROUP_OPERATION_KICKED = "Kicked";
    public static final String GROUP_OPERATION_QUIT = "Quit";
    public static final String GROUP_OPERATION_RENAME = "Rename";
    private static final String TAG = "GroupNotificationMessage";
    private String data;
    private String extra;
    private String message;
    private String operation;
    private String operatorUserId;

    public GroupNotificationMessage(Parcel parcel) {
        this.operatorUserId = ParcelUtils.readFromParcel(parcel);
        this.operation = ParcelUtils.readFromParcel(parcel);
        this.data = ParcelUtils.readFromParcel(parcel);
        this.message = ParcelUtils.readFromParcel(parcel);
        this.extra = ParcelUtils.readFromParcel(parcel);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public static GroupNotificationMessage obtain(String str, String str2, String str3, String str4) {
        GroupNotificationMessage groupNotificationMessage = new GroupNotificationMessage();
        groupNotificationMessage.operatorUserId = str;
        groupNotificationMessage.operation = str2;
        groupNotificationMessage.data = str3;
        groupNotificationMessage.message = str4;
        return groupNotificationMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operatorUserId", this.operatorUserId);
            jSONObject.put("operation", this.operation);
            if (!TextUtils.isEmpty(this.data)) {
                jSONObject.put("data", this.data);
            }
            if (!TextUtils.isEmpty(this.message)) {
                jSONObject.put("message", this.message);
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

    public String getMessage() {
        return this.message;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getOperatorUserId() {
        return this.operatorUserId;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public void setOperatorUserId(String str) {
        this.operatorUserId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.operatorUserId);
        ParcelUtils.writeToParcel(parcel, this.operation);
        ParcelUtils.writeToParcel(parcel, this.data);
        ParcelUtils.writeToParcel(parcel, this.message);
        ParcelUtils.writeToParcel(parcel, this.extra);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    private GroupNotificationMessage() {
    }

    public GroupNotificationMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setOperatorUserId(jSONObject.optString("operatorUserId"));
            setOperation(jSONObject.optString("operation"));
            setData(jSONObject.optString("data"));
            setMessage(jSONObject.optString("message"));
            setExtra(jSONObject.optString("extra"));
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }
}
