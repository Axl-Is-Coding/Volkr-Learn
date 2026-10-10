package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import io.rong.common.ParcelUtils;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DestructionTag(destructionFlag = 0)
@MessageTag(flag = 3, messageHandler = VoiceMessageHandler.class, value = "RC:VcMsg")
public class VoiceMessage extends MessageContent {
    public static final Parcelable.Creator<VoiceMessage> CREATOR = new Parcelable.Creator<VoiceMessage>() { // from class: io.rong.message.VoiceMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceMessage createFromParcel(Parcel parcel) {
            return new VoiceMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceMessage[] newArray(int i) {
            return new VoiceMessage[i];
        }
    };
    protected String extra;
    private String mBase64;
    private int mDuration;
    private Uri mUri;

    public VoiceMessage(Parcel parcel) {
        setExtra(ParcelUtils.readFromParcel(parcel));
        this.mUri = (Uri) ParcelUtils.readFromParcel(parcel, Uri.class);
        this.mDuration = ParcelUtils.readIntFromParcel(parcel).intValue();
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setDestruct(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDestructTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }

    public static VoiceMessage obtain(Uri uri, int i) {
        return new VoiceMessage(uri, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", this.mBase64);
            jSONObject.put("duration", this.mDuration);
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", this.extra);
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        this.mBase64 = null;
        return jSONObject.toString().getBytes();
    }

    public String getBase64() {
        return this.mBase64;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getExtra() {
        return this.extra;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void setBase64(String str) {
        this.mBase64 = str;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.extra);
        ParcelUtils.writeToParcel(parcel, this.mUri);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.mDuration));
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDestruct() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDestructTime()));
    }

    public VoiceMessage(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("duration")) {
                setDuration(jSONObject.optInt("duration"));
            }
            if (jSONObject.has("content")) {
                setBase64(jSONObject.optString("content"));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
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
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
    }

    private VoiceMessage(Uri uri, int i) {
        this.mUri = uri;
        this.mDuration = i;
    }
}
