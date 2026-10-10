package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.sandboxol.center.config.StringConstant;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsEva")
public class CSEvaluateMessage extends MessageContent {
    public static final Parcelable.Creator<CSEvaluateMessage> CREATOR = new Parcelable.Creator<CSEvaluateMessage>() { // from class: io.rong.message.CSEvaluateMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSEvaluateMessage createFromParcel(Parcel parcel) {
            return new CSEvaluateMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSEvaluateMessage[] newArray(int i) {
            return new CSEvaluateMessage[i];
        }
    };
    private static final String TAG = "CSEvaluateMessage";
    private String extra;
    private String pid;
    private String sid;
    private int source;
    private int status;
    private String suggest;
    private String tablets;
    private int type;
    private String uid;

    public static class Builder {
        private String extra;
        private String pid;
        private String sid;
        private int solveStatus = -1;
        private int source;
        private String suggest;
        private String tablets;
        private int type;
        private String uid;

        public CSEvaluateMessage build() {
            CSEvaluateMessage cSEvaluateMessage = new CSEvaluateMessage();
            cSEvaluateMessage.sid = this.sid;
            cSEvaluateMessage.pid = this.pid;
            cSEvaluateMessage.uid = this.uid;
            cSEvaluateMessage.source = this.source;
            cSEvaluateMessage.suggest = this.suggest;
            cSEvaluateMessage.status = this.solveStatus;
            cSEvaluateMessage.type = this.type;
            cSEvaluateMessage.tablets = this.tablets;
            cSEvaluateMessage.extra = this.extra;
            return cSEvaluateMessage;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }

        public Builder pid(String str) {
            this.pid = str;
            return this;
        }

        public Builder setSolveStatus(int i) {
            this.solveStatus = i;
            return this;
        }

        public Builder sid(String str) {
            this.sid = str;
            return this;
        }

        public Builder source(int i) {
            this.source = i;
            return this;
        }

        public Builder suggest(String str) {
            this.suggest = str;
            return this;
        }

        public Builder tablets(String str) {
            this.tablets = str;
            return this;
        }

        public Builder type(int i) {
            this.type = i;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(StringConstant.UID, this.uid);
            jSONObject.put("sid", this.sid);
            jSONObject.put("pid", this.pid);
            jSONObject.put("source", this.source);
            jSONObject.put("suggest", this.suggest);
            jSONObject.put("isresolve", this.status);
            jSONObject.put("type", this.type);
            jSONObject.put("tag", this.tablets);
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.sid);
        ParcelUtils.writeToParcel(parcel, this.uid);
        ParcelUtils.writeToParcel(parcel, this.pid);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.source));
        ParcelUtils.writeToParcel(parcel, this.suggest);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.status));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.type));
        ParcelUtils.writeToParcel(parcel, this.tablets);
        ParcelUtils.writeToParcel(parcel, this.extra);
    }

    private CSEvaluateMessage() {
        this.status = -1;
    }

    public CSEvaluateMessage(byte[] bArr) {
        this.status = -1;
    }

    public CSEvaluateMessage(Parcel parcel) {
        this.status = -1;
        this.sid = ParcelUtils.readFromParcel(parcel);
        this.uid = ParcelUtils.readFromParcel(parcel);
        this.pid = ParcelUtils.readFromParcel(parcel);
        this.source = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.suggest = ParcelUtils.readFromParcel(parcel);
        this.status = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.type = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.tablets = ParcelUtils.readFromParcel(parcel);
        this.extra = ParcelUtils.readFromParcel(parcel);
    }
}
