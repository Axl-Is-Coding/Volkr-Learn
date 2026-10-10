package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsChaR")
public class CSChangeModeResponseMessage extends MessageContent {
    public static final Parcelable.Creator<CSChangeModeResponseMessage> CREATOR = new Parcelable.Creator<CSChangeModeResponseMessage>() { // from class: io.rong.message.CSChangeModeResponseMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSChangeModeResponseMessage createFromParcel(Parcel parcel) {
            return new CSChangeModeResponseMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSChangeModeResponseMessage[] newArray(int i) {
            return new CSChangeModeResponseMessage[i];
        }
    };
    private static final String TAG = "CSChangeModeResponseMessage";
    private int code;
    private String errMsg;
    private String evaluation;
    private int status;

    public CSChangeModeResponseMessage() {
    }

    public static CSChangeModeResponseMessage obtain() {
        return new CSChangeModeResponseMessage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return null;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getEvaluation() {
        return this.evaluation;
    }

    public int getResult() {
        return this.code;
    }

    public int getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.code));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.status));
        ParcelUtils.writeToParcel(parcel, this.errMsg);
        ParcelUtils.writeToParcel(parcel, this.evaluation);
    }

    public CSChangeModeResponseMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.code = jSONObject.optInt("code");
            this.errMsg = jSONObject.optString("msg");
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                this.status = jSONObject2.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                if (jSONObject2.has("satisfaction")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("satisfaction");
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("satisfaction", jSONArray);
                    jSONObject3.put("evaluation", jSONObject4);
                    this.evaluation = jSONObject3.toString();
                }
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public CSChangeModeResponseMessage(Parcel parcel) {
        this.code = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.status = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.errMsg = ParcelUtils.readFromParcel(parcel);
        this.evaluation = ParcelUtils.readFromParcel(parcel);
    }
}
