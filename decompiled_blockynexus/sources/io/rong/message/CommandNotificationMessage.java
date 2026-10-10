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
@MessageTag(flag = 1, value = "RC:CmdNtf")
public class CommandNotificationMessage extends MessageContent {
    public static final Parcelable.Creator<CommandNotificationMessage> CREATOR = new Parcelable.Creator<CommandNotificationMessage>() { // from class: io.rong.message.CommandNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommandNotificationMessage createFromParcel(Parcel parcel) {
            return new CommandNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommandNotificationMessage[] newArray(int i) {
            return new CommandNotificationMessage[i];
        }
    };
    private static final String TAG = "CommandNotificationMessage";
    private String data;
    private String name;

    public CommandNotificationMessage(Parcel parcel) {
        this.name = ParcelUtils.readFromParcel(parcel);
        this.data = ParcelUtils.readFromParcel(parcel);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public static CommandNotificationMessage obtain(String str, String str2) {
        CommandNotificationMessage commandNotificationMessage = new CommandNotificationMessage();
        commandNotificationMessage.name = str;
        commandNotificationMessage.data = str2;
        return commandNotificationMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            if (!TextUtils.isEmpty(this.data)) {
                jSONObject.put("data", this.data);
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

    public String getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.name);
        ParcelUtils.writeToParcel(parcel, this.data);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    private CommandNotificationMessage() {
    }

    public CommandNotificationMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setName(jSONObject.optString("name"));
            setData(jSONObject.optString("data"));
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }
}
