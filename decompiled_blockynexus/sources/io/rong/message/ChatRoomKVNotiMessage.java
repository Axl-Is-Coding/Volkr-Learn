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
@MessageTag(flag = 0, value = "RC:chrmKVNotiMsg")
public class ChatRoomKVNotiMessage extends MessageContent {
    public static final Parcelable.Creator<ChatRoomKVNotiMessage> CREATOR = new Parcelable.Creator<ChatRoomKVNotiMessage>() { // from class: io.rong.message.ChatRoomKVNotiMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomKVNotiMessage createFromParcel(Parcel parcel) {
            return new ChatRoomKVNotiMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomKVNotiMessage[] newArray(int i) {
            return new ChatRoomKVNotiMessage[i];
        }
    };
    private static final String TAG = "ChatRoomKVNotiMessage";
    public static final int TYPE_DELETE_KEY = 2;
    public static final int TYPE_SET_KEY = 1;
    private String extra;
    private String key;
    private int type;
    private String value;

    public ChatRoomKVNotiMessage(Parcel parcel) {
        this.key = ParcelUtils.readFromParcel(parcel);
        this.value = ParcelUtils.readFromParcel(parcel);
        this.extra = ParcelUtils.readFromParcel(parcel);
        this.type = ParcelUtils.readIntFromParcel(parcel).intValue();
    }

    public static String getTAG() {
        return TAG;
    }

    public static ChatRoomKVNotiMessage obtain(String str, String str2, int i, String str3) {
        ChatRoomKVNotiMessage chatRoomKVNotiMessage = new ChatRoomKVNotiMessage();
        chatRoomKVNotiMessage.key = str;
        chatRoomKVNotiMessage.value = str2;
        chatRoomKVNotiMessage.extra = str3;
        chatRoomKVNotiMessage.type = i;
        return chatRoomKVNotiMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            jSONObject.put("value", this.value);
            jSONObject.put("extra", this.extra);
            jSONObject.put("type", this.type);
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

    public String getKey() {
        return this.key;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.key);
        ParcelUtils.writeToParcel(parcel, this.value);
        ParcelUtils.writeToParcel(parcel, this.extra);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.type));
    }

    public ChatRoomKVNotiMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setKey(jSONObject.optString("key"));
            setValue(jSONObject.optString("value"));
            setExtra(jSONObject.optString("extra"));
            setType(jSONObject.optInt("type"));
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    private ChatRoomKVNotiMessage() {
    }
}
