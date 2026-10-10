package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:LogCmdMsg")
public class LogCmdMessage extends MessageContent {
    public static final Parcelable.Creator<LogCmdMessage> CREATOR = new Parcelable.Creator<LogCmdMessage>() { // from class: io.rong.message.LogCmdMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LogCmdMessage createFromParcel(Parcel parcel) {
            return new LogCmdMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LogCmdMessage[] newArray(int i) {
            return new LogCmdMessage[i];
        }
    };
    private long endTime;
    private String logId;
    private String packageName;
    private String platform;
    private long startTime;
    private String uri;

    public LogCmdMessage(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            this.uri = jSONObject.optString(ShareConstants.MEDIA_URI);
            this.logId = jSONObject.optString("logId");
            this.platform = jSONObject.optString("platform");
            this.packageName = jSONObject.optString("packageName");
            this.startTime = jSONObject.optLong("startTime");
            this.endTime = jSONObject.optLong("endTime");
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
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
            String uri = getUri();
            if (uri != null) {
                jSONObject.put(ShareConstants.MEDIA_URI, uri);
            }
            String logId = getLogId();
            if (logId != null) {
                jSONObject.put("logId", logId);
            }
            String platform = getPlatform();
            if (platform != null) {
                jSONObject.put("platform", platform);
            }
            String packageName = getPackageName();
            if (packageName != null) {
                jSONObject.put("packageName", packageName);
            }
            jSONObject.put("startTime", getStartTime());
            jSONObject.put("endTime", this.endTime);
        } catch (JSONException e2) {
            RLog.e("JSONException", e2.getMessage());
        }
        return jSONObject.toString().getBytes();
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getLogId() {
        return this.logId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPlatform() {
        return this.platform;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getUri());
        ParcelUtils.writeToParcel(parcel, getLogId());
        ParcelUtils.writeToParcel(parcel, getPlatform());
        ParcelUtils.writeToParcel(parcel, getPackageName());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getStartTime()));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getEndTime()));
    }

    public LogCmdMessage(Parcel parcel) {
        this.uri = ParcelUtils.readFromParcel(parcel);
        this.logId = ParcelUtils.readFromParcel(parcel);
        this.platform = ParcelUtils.readFromParcel(parcel);
        this.packageName = ParcelUtils.readFromParcel(parcel);
        this.startTime = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.endTime = ParcelUtils.readLongFromParcel(parcel).longValue();
    }
}
