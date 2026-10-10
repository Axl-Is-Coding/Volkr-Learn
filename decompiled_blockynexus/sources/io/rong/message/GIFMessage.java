package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, messageHandler = GIFMessageHandler.class, value = "RC:GIFMsg")
public class GIFMessage extends MediaMessageContent {
    public static final Parcelable.Creator<GIFMessage> CREATOR = new Parcelable.Creator<GIFMessage>() { // from class: io.rong.message.GIFMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GIFMessage createFromParcel(Parcel parcel) {
            return new GIFMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GIFMessage[] newArray(int i) {
            return new GIFMessage[i];
        }
    };
    private static final String TAG = "GIFMessage";
    private long gifDataSize;
    private int height;
    private boolean mUpLoadExp;
    private int width;

    private GIFMessage(Uri uri) {
        this.mUpLoadExp = false;
        setLocalUri(uri);
    }

    public static GIFMessage obtain(Uri uri) {
        if (FileUtils.isValidateLocalUri(uri)) {
            return new GIFMessage(uri);
        }
        RLog.e(TAG, "localUri error uri is" + uri);
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getMediaUrl() != null) {
                jSONObject.put("remoteUrl", getMediaUrl().toString());
            }
            if (getLocalPath() != null) {
                jSONObject.put("localPath", getLocalPath().toString());
            }
            if (this.mUpLoadExp) {
                jSONObject.put("exp", true);
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            if (!TextUtils.isEmpty(getName())) {
                jSONObject.put("name", getName());
            }
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, getHeight());
            jSONObject.put("gifDataSize", getGifDataSize());
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            RLog.e("JSONException", e2.getMessage());
        }
        return jSONObject.toString().getBytes();
    }

    public long getGifDataSize() {
        return this.gifDataSize;
    }

    public int getHeight() {
        return this.height;
    }

    public Uri getLocalUri() {
        return getLocalPath();
    }

    public Uri getRemoteUri() {
        return getMediaUrl();
    }

    public int getWidth() {
        return this.width;
    }

    void setGifDataSize(long j) {
        this.gifDataSize = j;
    }

    void setHeight(int i) {
        this.height = i;
    }

    public void setLocalUri(Uri uri) {
        setLocalPath(uri);
    }

    public void setRemoteUri(Uri uri) {
        setMediaUrl(uri);
    }

    public void setUpLoadExp(boolean z) {
        this.mUpLoadExp = z;
    }

    void setWidth(int i) {
        this.width = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mUpLoadExp ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.gifDataSize);
        parcel.writeString(getName());
        parcel.writeParcelable(getLocalUri(), i);
        parcel.writeParcelable(getRemoteUri(), i);
        parcel.writeString(getExtra());
        parcel.writeParcelable(getUserInfo(), i);
        parcel.writeParcelable(getMentionedInfo(), i);
        parcel.writeByte(isDestruct() ? (byte) 1 : (byte) 0);
        parcel.writeLong(getDestructTime());
    }

    public GIFMessage(byte[] bArr) {
        this.mUpLoadExp = false;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("remoteUrl")) {
                String strOptString = jSONObject.optString("remoteUrl");
                if (!TextUtils.isEmpty(strOptString)) {
                    setRemoteUri(Uri.parse(strOptString));
                }
            }
            if (jSONObject.has("localPath")) {
                setLocalUri(Uri.parse(jSONObject.optString("localPath")));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("exp")) {
                setUpLoadExp(true);
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
            if (jSONObject.has(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                setWidth(jSONObject.getInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            }
            if (jSONObject.has(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                setHeight(jSONObject.getInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            }
            if (jSONObject.has("gifDataSize")) {
                setGifDataSize(jSONObject.getInt("gifDataSize"));
            }
            if (jSONObject.has("name")) {
                setName(jSONObject.getString("name"));
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
    }

    protected GIFMessage(Parcel parcel) {
        this.mUpLoadExp = false;
        this.mUpLoadExp = parcel.readByte() != 0;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.gifDataSize = parcel.readLong();
        setName(parcel.readString());
        setLocalUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
        setRemoteUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
        setExtra(parcel.readString());
        setUserInfo((UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()));
        setMentionedInfo((MentionedInfo) parcel.readParcelable(MentionedInfo.class.getClassLoader()));
        setDestruct(parcel.readByte() != 0);
        setDestructTime(parcel.readLong());
    }
}
