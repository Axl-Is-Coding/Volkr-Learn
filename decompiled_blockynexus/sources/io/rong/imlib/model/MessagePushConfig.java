package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.model.AndroidConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class MessagePushConfig implements Parcelable {
    public static final Parcelable.Creator<MessagePushConfig> CREATOR = new Parcelable.Creator<MessagePushConfig>() { // from class: io.rong.imlib.model.MessagePushConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePushConfig createFromParcel(Parcel parcel) {
            return new MessagePushConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePushConfig[] newArray(int i) {
            return new MessagePushConfig[i];
        }
    };
    public static final String TAG = "MessagePushConfig";
    private AndroidConfig androidConfig;
    private boolean disablePushTitle;
    private boolean forceShowDetailContent;
    private IOSConfig iOSConfig;
    private String pushContent;
    private String pushData;
    private String pushTitle;

    public static class Builder {
        private AndroidConfig androidConfig;
        private boolean forceShowDetailContent;
        private IOSConfig iOSConfig;
        private String pushContent;
        private String pushData;
        private String pushTitle;

        public MessagePushConfig build() {
            MessagePushConfig messagePushConfig = new MessagePushConfig();
            messagePushConfig.setPushTitle(this.pushTitle);
            messagePushConfig.setPushContent(this.pushContent);
            messagePushConfig.setPushData(this.pushData);
            messagePushConfig.setForceShowDetailContent(this.forceShowDetailContent);
            messagePushConfig.setIOSConfig(this.iOSConfig);
            messagePushConfig.setAndroidConfig(this.androidConfig);
            return messagePushConfig;
        }

        public Builder setAndroidConfig(AndroidConfig androidConfig) {
            this.androidConfig = androidConfig;
            return this;
        }

        public Builder setForceShowDetailContent(boolean z) {
            this.forceShowDetailContent = z;
            return this;
        }

        public Builder setIOSConfig(IOSConfig iOSConfig) {
            this.iOSConfig = iOSConfig;
            return this;
        }

        public Builder setPushContent(String str) {
            this.pushContent = str;
            return this;
        }

        public Builder setPushData(String str) {
            this.pushData = str;
            return this;
        }

        public Builder setPushTitle(String str) {
            this.pushTitle = str;
            return this;
        }
    }

    public MessagePushConfig() {
    }

    public String channelToJson() {
        JSONObject json;
        JSONArray jSONArray = new JSONArray();
        AndroidConfig androidConfig = this.androidConfig;
        if (androidConfig != null) {
            JSONArray json2 = androidConfig.toJson();
            for (int i = 0; i < json2.length(); i++) {
                try {
                    jSONArray.put(json2.get(i));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        IOSConfig iOSConfig = this.iOSConfig;
        if (iOSConfig != null && (json = iOSConfig.toJson()) != null) {
            jSONArray.put(json);
        }
        return jSONArray.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AndroidConfig getAndroidConfig() {
        return this.androidConfig;
    }

    public IOSConfig getIOSConfig() {
        return this.iOSConfig;
    }

    public String getPushContent() {
        return this.pushContent;
    }

    public String getPushData() {
        return this.pushData;
    }

    public String getPushTitle() {
        return this.pushTitle;
    }

    public boolean isForceShowDetailContent() {
        return this.forceShowDetailContent;
    }

    public void setAndroidConfig(AndroidConfig androidConfig) {
        this.androidConfig = androidConfig;
    }

    public void setChannelFromJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                RLog.e(TAG, "setChannelFromJson jsonStr is null");
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            AndroidConfig androidConfig = new AndroidConfig();
            IOSConfig iOSConfig = new IOSConfig();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(AndroidConfig.ChannelKey.HW.getKey())) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(AndroidConfig.ChannelKey.HW.getKey());
                    if (jSONObject2.has("channelId")) {
                        androidConfig.setChannelIdHW(jSONObject2.getString("channelId"));
                    }
                } else if (jSONObject.has(AndroidConfig.ChannelKey.MI.getKey())) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject(AndroidConfig.ChannelKey.MI.getKey());
                    if (jSONObject3.has("channelId")) {
                        androidConfig.setChannelIdMi(jSONObject3.getString("channelId"));
                    }
                } else if (jSONObject.has(AndroidConfig.ChannelKey.OPPO.getKey())) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject(AndroidConfig.ChannelKey.OPPO.getKey());
                    if (jSONObject4.has("channelId")) {
                        androidConfig.setChannelIdOPPO(jSONObject4.getString("channelId"));
                    }
                } else if (jSONObject.has(AndroidConfig.ChannelKey.VIVO.getKey())) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject(AndroidConfig.ChannelKey.VIVO.getKey());
                    if (jSONObject5.has("classification")) {
                        androidConfig.setTypeVivo(jSONObject5.getString("classification"));
                    }
                } else if (jSONObject.has(IOSConfig.ChannelKey)) {
                    JSONObject jSONObject6 = jSONObject.getJSONObject(IOSConfig.ChannelKey);
                    if (jSONObject6.has("thread-id")) {
                        iOSConfig.setThread_id(jSONObject6.getString("thread-id"));
                    }
                    if (jSONObject6.has("apns-collapse-id")) {
                        iOSConfig.setApns_collapse_id(jSONObject6.getString("apns-collapse-id"));
                    }
                }
            }
            this.androidConfig = androidConfig;
            this.iOSConfig = iOSConfig;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setForceShowDetailContent(boolean z) {
        this.forceShowDetailContent = z;
    }

    public void setIOSConfig(IOSConfig iOSConfig) {
        this.iOSConfig = iOSConfig;
    }

    public void setPushContent(String str) {
        this.pushContent = str;
    }

    public void setPushData(String str) {
        this.pushData = str;
    }

    public void setPushTitle(String str) {
        this.pushTitle = str;
    }

    public String toString() {
        return "MessagePushConfig{ disablePushTitle=" + this.disablePushTitle + ", pushTitle='" + this.pushTitle + "', pushContent='" + this.pushContent + "', pushData='" + this.pushData + "', forceShowDetailContent=" + this.forceShowDetailContent + ", iOSConfig=" + this.iOSConfig + ", androidConfig=" + this.androidConfig + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.disablePushTitle ? (byte) 1 : (byte) 0);
        parcel.writeString(this.pushTitle);
        parcel.writeString(this.pushContent);
        parcel.writeString(this.pushData);
        parcel.writeByte(this.forceShowDetailContent ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.iOSConfig, i);
        parcel.writeParcelable(this.androidConfig, i);
    }

    protected MessagePushConfig(Parcel parcel) {
        this.disablePushTitle = parcel.readByte() != 0;
        this.pushTitle = parcel.readString();
        this.pushContent = parcel.readString();
        this.pushData = parcel.readString();
        this.forceShowDetailContent = parcel.readByte() != 0;
        this.iOSConfig = (IOSConfig) parcel.readParcelable(IOSConfig.class.getClassLoader());
        this.androidConfig = (AndroidConfig) parcel.readParcelable(AndroidConfig.class.getClassLoader());
    }
}
