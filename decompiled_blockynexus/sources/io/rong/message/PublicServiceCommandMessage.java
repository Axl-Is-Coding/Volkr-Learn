package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceMenuItem;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:PSCmd")
public class PublicServiceCommandMessage extends MessageContent {
    public static final Parcelable.Creator<PublicServiceCommandMessage> CREATOR = new Parcelable.Creator<PublicServiceCommandMessage>() { // from class: io.rong.message.PublicServiceCommandMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceCommandMessage createFromParcel(Parcel parcel) {
            return new PublicServiceCommandMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceCommandMessage[] newArray(int i) {
            return new PublicServiceCommandMessage[i];
        }
    };
    private static final String TAG = "PublicServiceCommandMessage";
    private String command;
    private String data;
    protected String extra;

    public PublicServiceCommandMessage() {
    }

    public static PublicServiceCommandMessage obtain(PublicServiceMenuItem publicServiceMenuItem) {
        PublicServiceCommandMessage publicServiceCommandMessage = new PublicServiceCommandMessage();
        if (publicServiceMenuItem.getType() != null) {
            publicServiceCommandMessage.command = publicServiceMenuItem.getType().getMessage();
            publicServiceCommandMessage.data = publicServiceMenuItem.getId();
        }
        return publicServiceCommandMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", this.command);
            jSONObject.put("data", this.data);
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

    public String getExtra() {
        return this.extra;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.command);
        ParcelUtils.writeToParcel(parcel, this.data);
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    public PublicServiceCommandMessage(byte[] bArr) {
    }

    public PublicServiceCommandMessage(Parcel parcel) {
        this.command = ParcelUtils.readFromParcel(parcel);
        this.data = ParcelUtils.readFromParcel(parcel);
        setExtra(ParcelUtils.readFromParcel(parcel));
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }
}
