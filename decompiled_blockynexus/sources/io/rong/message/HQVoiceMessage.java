package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DestructionTag(destructionFlag = 0)
@MessageTag(flag = 3, messageHandler = HQVoiceMessageHandler.class, value = "RC:HQVCMsg")
public class HQVoiceMessage extends MediaMessageContent {
    public static final Parcelable.Creator<HQVoiceMessage> CREATOR = new Parcelable.Creator<HQVoiceMessage>() { // from class: io.rong.message.HQVoiceMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HQVoiceMessage createFromParcel(Parcel parcel) {
            return new HQVoiceMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HQVoiceMessage[] newArray(int i) {
            return new HQVoiceMessage[i];
        }
    };
    private static final String TAG = "HQVoiceMessage";
    private int mDuration;

    public HQVoiceMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("name")) {
                setName(jSONObject.optString("name"));
            }
            if (jSONObject.has("localPath")) {
                setLocalPath(Uri.parse(jSONObject.optString("localPath")));
            }
            if (jSONObject.has("remoteUrl")) {
                setFileUrl(Uri.parse(jSONObject.optString("remoteUrl")));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("duration")) {
                setDuration(jSONObject.optInt("duration"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            if (jSONObject.has("isBurnAfterRead")) {
                setDestruct(jSONObject.getBoolean("isBurnAfterRead"));
            }
            if (jSONObject.has("burnDuration")) {
                setDestructTime(jSONObject.getLong("burnDuration"));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    public static HQVoiceMessage obtain(Uri uri, int i) {
        return new HQVoiceMessage(uri, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getName())) {
                jSONObject.put("name", getName());
            }
            if (getLocalPath() != null) {
                jSONObject.put("localPath", getLocalPath().toString());
            }
            if (getMediaUrl() != null) {
                jSONObject.put("remoteUrl", getMediaUrl().toString());
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            jSONObject.put("duration", this.mDuration);
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException", e3);
            return null;
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public Uri getFileUrl() {
        return getMediaUrl();
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setFileUrl(Uri uri) {
        setMediaUrl(uri);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, getLocalPath());
        ParcelUtils.writeToParcel(parcel, getFileUrl());
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getDuration()));
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDestruct() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDestructTime()));
    }

    private HQVoiceMessage(Uri uri, int i) {
        setLocalPath(uri);
        this.mDuration = i;
    }

    public HQVoiceMessage(Parcel parcel) {
        setName(ParcelUtils.readFromParcel(parcel));
        setLocalPath((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setFileUrl((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setExtra(ParcelUtils.readFromParcel(parcel));
        setDuration(ParcelUtils.readIntFromParcel(parcel).intValue());
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setDestruct(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDestructTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }
}
