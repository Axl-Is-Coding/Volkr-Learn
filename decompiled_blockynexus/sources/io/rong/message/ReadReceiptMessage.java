package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:ReadNtf")
public class ReadReceiptMessage extends MessageContent {
    public static final Parcelable.Creator<ReadReceiptMessage> CREATOR = new Parcelable.Creator<ReadReceiptMessage>() { // from class: io.rong.message.ReadReceiptMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptMessage createFromParcel(Parcel parcel) {
            return new ReadReceiptMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptMessage[] newArray(int i) {
            return new ReadReceiptMessage[i];
        }
    };
    private static final String TAG = "ReadReceiptMessage";
    private long lastMessageSendTime;
    private String messageUId;
    private ReadReceiptType type;

    public enum ReadReceiptType {
        SEND_TIME(1),
        UID(2);

        private int value;

        ReadReceiptType(int i) {
            this.value = i;
        }

        public static ReadReceiptType setValue(int i) {
            for (ReadReceiptType readReceiptType : values()) {
                if (i == readReceiptType.getValue()) {
                    return readReceiptType;
                }
            }
            return SEND_TIME;
        }

        public int getValue() {
            return this.value;
        }
    }

    public ReadReceiptMessage(long j) {
        setLastMessageSendTime(j);
        setType(ReadReceiptType.SEND_TIME);
    }

    public static ReadReceiptMessage obtain(long j) {
        ReadReceiptMessage readReceiptMessage = new ReadReceiptMessage();
        readReceiptMessage.setLastMessageSendTime(j);
        readReceiptMessage.setType(ReadReceiptType.SEND_TIME);
        return readReceiptMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastMessageSendTime", getLastMessageSendTime());
            if (!TextUtils.isEmpty(getMessageUId())) {
                jSONObject.put("messageUId", getMessageUId());
            }
            if (getType() != null) {
                jSONObject.put("type", getType().getValue());
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

    public long getLastMessageSendTime() {
        return this.lastMessageSendTime;
    }

    public String getMessageUId() {
        return this.messageUId;
    }

    public ReadReceiptType getType() {
        return this.type;
    }

    public void setLastMessageSendTime(long j) {
        this.lastMessageSendTime = j;
    }

    public void setMessageUId(String str) {
        this.messageUId = str;
    }

    public void setType(ReadReceiptType readReceiptType) {
        this.type = readReceiptType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getLastMessageSendTime()));
        ParcelUtils.writeToParcel(parcel, getMessageUId());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getType() != null ? getType().getValue() : 0));
    }

    public ReadReceiptMessage(String str) {
        setMessageUId(str);
        setType(ReadReceiptType.UID);
    }

    public ReadReceiptMessage(long j, String str, ReadReceiptType readReceiptType) {
        setLastMessageSendTime(j);
        setMessageUId(str);
        setType(readReceiptType);
    }

    public ReadReceiptMessage(Parcel parcel) {
        setLastMessageSendTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setMessageUId(ParcelUtils.readFromParcel(parcel));
        setType(ReadReceiptType.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
    }

    public ReadReceiptMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, e2.getMessage());
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lastMessageSendTime")) {
                setLastMessageSendTime(jSONObject.getLong("lastMessageSendTime"));
            }
            if (jSONObject.has("messageUId")) {
                setMessageUId(jSONObject.getString("messageUId"));
            }
            if (jSONObject.has("type")) {
                setType(ReadReceiptType.setValue(jSONObject.getInt("type")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }

    private ReadReceiptMessage() {
    }
}
