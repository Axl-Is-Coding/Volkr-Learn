package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ReadReceiptInfo implements Parcelable {
    public static final Parcelable.Creator<ReadReceiptInfo> CREATOR = new Parcelable.Creator<ReadReceiptInfo>() { // from class: io.rong.imlib.model.ReadReceiptInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptInfo createFromParcel(Parcel parcel) {
            return new ReadReceiptInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptInfo[] newArray(int i) {
            return new ReadReceiptInfo[i];
        }
    };
    private static final String TAG = "ReadReceiptInfo";
    private boolean hasRespond;
    private boolean isReadReceiptMessage;
    private HashMap<String, Long> respondUserIdList;

    public ReadReceiptInfo() {
        this.respondUserIdList = new HashMap<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HashMap<String, Long> getRespondUserIdList() {
        return this.respondUserIdList;
    }

    public boolean hasRespond() {
        return this.hasRespond;
    }

    public boolean isReadReceiptMessage() {
        return this.isReadReceiptMessage;
    }

    public void setHasRespond(boolean z) {
        this.hasRespond = z;
    }

    public void setIsReadReceiptMessage(boolean z) {
        this.isReadReceiptMessage = z;
    }

    public void setRespondUserIdList(HashMap<String, Long> map) {
        this.respondUserIdList = map;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isReceiptRequestMessage", this.isReadReceiptMessage);
            jSONObject.put("hasRespond", this.hasRespond);
            if (this.respondUserIdList != null && this.respondUserIdList.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Long> entry : this.respondUserIdList.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue().longValue());
                }
                jSONObject.put("userIdList", jSONObject2);
            }
        } catch (JSONException e2) {
            RLog.e(TAG, e2.getMessage());
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isReadReceiptMessage ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.hasRespond ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, this.respondUserIdList);
    }

    public ReadReceiptInfo(String str) {
        this.respondUserIdList = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("isReceiptRequestMessage")) {
                this.isReadReceiptMessage = jSONObject.optBoolean("isReceiptRequestMessage");
            }
            if (jSONObject.has("hasRespond")) {
                this.hasRespond = jSONObject.optBoolean("hasRespond");
            }
            if (jSONObject.has("userIdList")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("userIdList");
                HashMap<String, Long> map = new HashMap<>();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, Long.valueOf(((Long) jSONObject2.get(next)).longValue()));
                }
                this.respondUserIdList = map;
            }
        } catch (JSONException e2) {
            RLog.e(TAG, e2.getMessage());
        }
    }

    public ReadReceiptInfo(Parcel parcel) {
        this.respondUserIdList = new HashMap<>();
        setIsReadReceiptMessage(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setHasRespond(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setRespondUserIdList((HashMap) ParcelUtils.readMapFromParcel(parcel));
    }
}
