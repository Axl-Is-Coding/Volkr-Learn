package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AndroidConfig implements Parcelable {
    public static final Parcelable.Creator<AndroidConfig> CREATOR = new Parcelable.Creator<AndroidConfig>() { // from class: io.rong.imlib.model.AndroidConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AndroidConfig createFromParcel(Parcel parcel) {
            return new AndroidConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AndroidConfig[] newArray(int i) {
            return new AndroidConfig[i];
        }
    };
    public static final String OPERATE = "0";
    public static final String SYSTEM = "1";
    private String channelIdHW;
    private String channelIdMi;
    private String channelIdOPPO;
    private String notificationId;
    private String typeVivo;

    public static class Builder {
        private String channelIdHW;
        private String channelIdMi;
        private String channelIdOPPO;
        private String notificationId;
        private String typeVivo;

        public AndroidConfig build() {
            AndroidConfig androidConfig = new AndroidConfig();
            androidConfig.setNotificationId(this.notificationId);
            androidConfig.setChannelIdHW(this.channelIdHW);
            androidConfig.setChannelIdMi(this.channelIdMi);
            androidConfig.setChannelIdOPPO(this.channelIdOPPO);
            androidConfig.setTypeVivo(this.typeVivo);
            return androidConfig;
        }

        public Builder setChannelIdHW(String str) {
            this.channelIdHW = str;
            return this;
        }

        public Builder setChannelIdMi(String str) {
            this.channelIdMi = str;
            return this;
        }

        public Builder setChannelIdOPPO(String str) {
            this.channelIdOPPO = str;
            return this;
        }

        public Builder setNotificationId(String str) {
            this.notificationId = str;
            return this;
        }

        public Builder setTypeVivo(String str) {
            this.typeVivo = str;
            return this;
        }
    }

    public enum ChannelKey {
        HW("HW"),
        MI("MI"),
        OPPO("OPPO"),
        VIVO("VIVO");

        private String key;

        ChannelKey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }
    }

    public AndroidConfig() {
    }

    private JSONObject getChannelJson(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (str.equals(ChannelKey.VIVO.getKey())) {
                jSONObject2.put("classification", str2);
            } else {
                jSONObject2.put("channelId", str2);
            }
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getChannelIdHW() {
        return this.channelIdHW;
    }

    public String getChannelIdMi() {
        return this.channelIdMi;
    }

    public String getChannelIdOPPO() {
        return this.channelIdOPPO;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public String getTypeVivo() {
        return this.typeVivo;
    }

    public void setChannelIdHW(String str) {
        this.channelIdHW = str;
    }

    public void setChannelIdMi(String str) {
        this.channelIdMi = str;
    }

    public void setChannelIdOPPO(String str) {
        this.channelIdOPPO = str;
    }

    public void setNotificationId(String str) {
        this.notificationId = str;
    }

    public void setTypeVivo(String str) {
        this.typeVivo = str;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(getChannelIdHW())) {
            jSONArray.put(getChannelJson(ChannelKey.HW.getKey(), getChannelIdHW()));
        }
        if (!TextUtils.isEmpty(getChannelIdMi())) {
            jSONArray.put(getChannelJson(ChannelKey.MI.getKey(), getChannelIdMi()));
        }
        if (!TextUtils.isEmpty(getChannelIdOPPO())) {
            jSONArray.put(getChannelJson(ChannelKey.OPPO.getKey(), getChannelIdOPPO()));
        }
        if (!TextUtils.isEmpty(getTypeVivo())) {
            jSONArray.put(getChannelJson(ChannelKey.VIVO.getKey(), getTypeVivo()));
        }
        return jSONArray;
    }

    public String toString() {
        return "AndroidConfig{channelIdMi='" + this.channelIdMi + "', channelIdHW='" + this.channelIdHW + "', channelIdOPPO='" + this.channelIdOPPO + "', typeVivo='" + this.typeVivo + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.notificationId);
        parcel.writeString(this.channelIdMi);
        parcel.writeString(this.channelIdHW);
        parcel.writeString(this.channelIdOPPO);
        parcel.writeString(this.typeVivo);
    }

    protected AndroidConfig(Parcel parcel) {
        this.notificationId = parcel.readString();
        this.channelIdMi = parcel.readString();
        this.channelIdHW = parcel.readString();
        this.channelIdOPPO = parcel.readString();
        this.typeVivo = parcel.readString();
    }
}
