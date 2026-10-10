package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class IOSConfig implements Parcelable {
    public static final Parcelable.Creator<IOSConfig> CREATOR = new Parcelable.Creator<IOSConfig>() { // from class: io.rong.imlib.model.IOSConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IOSConfig createFromParcel(Parcel parcel) {
            return new IOSConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IOSConfig[] newArray(int i) {
            return new IOSConfig[i];
        }
    };
    public static final String ChannelKey = "APNS";
    private String apns_collapse_id;
    private String thread_id;

    public IOSConfig() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApns_collapse_id() {
        return this.apns_collapse_id;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public void setApns_collapse_id(String str) {
        this.apns_collapse_id = str;
    }

    public void setThread_id(String str) {
        this.thread_id = str;
    }

    public JSONObject toJson() {
        if (TextUtils.isEmpty(getThread_id()) && TextUtils.isEmpty(getApns_collapse_id())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("thread-id", getThread_id());
            jSONObject2.put("apns-collapse-id", getApns_collapse_id());
            jSONObject.put(ChannelKey, jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "IOSConfig{thread_id='" + this.thread_id + "', apns_collapse_id='" + this.apns_collapse_id + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.thread_id);
        parcel.writeString(this.apns_collapse_id);
    }

    public IOSConfig(String str, String str2) {
        this.thread_id = str;
        this.apns_collapse_id = str2;
    }

    protected IOSConfig(Parcel parcel) {
        this.thread_id = parcel.readString();
        this.apns_collapse_id = parcel.readString();
    }
}
