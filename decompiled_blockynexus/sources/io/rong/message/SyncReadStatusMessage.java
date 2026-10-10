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
@MessageTag(flag = 0, value = "RC:SRSMsg")
public class SyncReadStatusMessage extends MessageContent {
    public static final Parcelable.Creator<SyncReadStatusMessage> CREATOR = new Parcelable.Creator<SyncReadStatusMessage>() { // from class: io.rong.message.SyncReadStatusMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncReadStatusMessage createFromParcel(Parcel parcel) {
            return new SyncReadStatusMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncReadStatusMessage[] newArray(int i) {
            return new SyncReadStatusMessage[i];
        }
    };
    private static final String TAG = "SyncReadStatusMessage";
    private long lastMessageSendTime;

    public SyncReadStatusMessage(long j) {
        this.lastMessageSendTime = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastMessageSendTime", this.lastMessageSendTime);
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.lastMessageSendTime));
    }

    public SyncReadStatusMessage(Parcel parcel) {
        this.lastMessageSendTime = ParcelUtils.readLongFromParcel(parcel).longValue();
    }

    public SyncReadStatusMessage(byte[] bArr) {
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
                this.lastMessageSendTime = jSONObject.getLong("lastMessageSendTime");
            }
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }
}
