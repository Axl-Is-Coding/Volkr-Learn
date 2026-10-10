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
@MessageTag(flag = 1, value = "RC:RcNtf")
public class RecallNotificationMessage extends MessageContent {
    public static final Parcelable.Creator<RecallNotificationMessage> CREATOR = new Parcelable.Creator<RecallNotificationMessage>() { // from class: io.rong.message.RecallNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecallNotificationMessage createFromParcel(Parcel parcel) {
            return new RecallNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecallNotificationMessage[] newArray(int i) {
            return new RecallNotificationMessage[i];
        }
    };
    private static final String TAG = "RecallNotificationMessage";
    private boolean mAdmin;
    private boolean mDelete;
    private String mOperatorId;
    private String mOriginalObjectName;
    private long mRecallTime;
    private long recallActionTime;
    private String recallContent;

    public RecallNotificationMessage(String str, long j, String str2, boolean z, boolean z2) {
        this.mOperatorId = str;
        this.mRecallTime = j;
        this.mOriginalObjectName = str2;
        this.mDelete = z2;
        this.mAdmin = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            if (!TextUtils.isEmpty(getOperatorId())) {
                jSONObject.put("operatorId", getOperatorId());
            }
            jSONObject.put("recallTime", getRecallTime());
            if (!TextUtils.isEmpty(getOriginalObjectName())) {
                jSONObject.put("originalObjectName", getOriginalObjectName());
            }
            if (!TextUtils.isEmpty(getRecallContent())) {
                jSONObject.put("recallContent", getRecallContent());
            }
            jSONObject.put("recallActionTime", getRecallActionTime());
            jSONObject.put("admin", isAdmin());
            jSONObject.put("delete", isDelete());
        } catch (JSONException e2) {
            RLog.e(TAG, e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return null;
        }
    }

    public String getOperatorId() {
        return this.mOperatorId;
    }

    public String getOriginalObjectName() {
        return this.mOriginalObjectName;
    }

    public long getRecallActionTime() {
        return this.recallActionTime;
    }

    public String getRecallContent() {
        return this.recallContent;
    }

    public long getRecallTime() {
        return this.mRecallTime;
    }

    public boolean isAdmin() {
        return this.mAdmin;
    }

    public boolean isDelete() {
        return this.mDelete;
    }

    public void setRecallActionTime(long j) {
        this.recallActionTime = j;
    }

    public void setRecallContent(String str) {
        this.recallContent = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, getOperatorId());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getRecallTime()));
        ParcelUtils.writeToParcel(parcel, getOriginalObjectName());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isAdmin() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDelete() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, getRecallContent());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getRecallActionTime()));
    }

    public RecallNotificationMessage(String str, long j, String str2, boolean z, boolean z2, String str3, long j2) {
        this.mOperatorId = str;
        this.mRecallTime = j;
        this.mOriginalObjectName = str2;
        this.mDelete = z2;
        this.mAdmin = z;
        this.recallContent = str3;
        this.recallActionTime = j2;
    }

    public RecallNotificationMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, e2.getMessage());
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            if (jSONObject.has("operatorId")) {
                this.mOperatorId = jSONObject.getString("operatorId");
            }
            if (jSONObject.has("recallTime")) {
                this.mRecallTime = jSONObject.getLong("recallTime");
            }
            if (jSONObject.has("originalObjectName")) {
                this.mOriginalObjectName = jSONObject.getString("originalObjectName");
            }
            if (jSONObject.has("recallContent")) {
                this.recallContent = jSONObject.getString("recallContent");
            }
            if (jSONObject.has("recallActionTime")) {
                this.recallActionTime = jSONObject.getLong("recallActionTime");
            }
            this.mAdmin = jSONObject.getBoolean("admin");
            this.mDelete = jSONObject.getBoolean("delete");
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }

    public RecallNotificationMessage(Parcel parcel) {
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        this.mOperatorId = ParcelUtils.readFromParcel(parcel);
        this.mRecallTime = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.mOriginalObjectName = ParcelUtils.readFromParcel(parcel);
        this.mAdmin = ParcelUtils.readIntFromParcel(parcel).intValue() == 1;
        this.mDelete = ParcelUtils.readIntFromParcel(parcel).intValue() == 1;
        this.recallContent = ParcelUtils.readFromParcel(parcel);
        this.recallActionTime = ParcelUtils.readLongFromParcel(parcel).longValue();
    }
}
