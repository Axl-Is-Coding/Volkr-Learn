package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsLM")
public class CSLeaveMessage extends MessageContent {
    public static final Parcelable.Creator<CSLeaveMessage> CREATOR = new Parcelable.Creator<CSLeaveMessage>() { // from class: io.rong.message.CSLeaveMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSLeaveMessage createFromParcel(Parcel parcel) {
            return new CSLeaveMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSLeaveMessage[] newArray(int i) {
            return new CSLeaveMessage[i];
        }
    };
    private static final String TAG = "CSLeaveMessage";
    private Map<String, String> dataMap;

    public CSLeaveMessage(byte[] bArr) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        for (String str : this.dataMap.keySet()) {
            try {
                jSONObject.put(str, this.dataMap.get(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return new byte[0];
        }
    }

    public void setDataSet(Map<String, String> map) {
        this.dataMap = map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.dataMap);
    }

    public CSLeaveMessage() {
    }

    protected CSLeaveMessage(Parcel parcel) {
        setDataSet(ParcelUtils.readMapFromParcel(parcel));
    }
}
