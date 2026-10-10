package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DestructionTag(destructionFlag = 0)
@MessageTag(flag = 3, messageHandler = ImageMessageHandler.class, value = "RC:ImgMsg")
public class ImageMessage extends MediaMessageContent {
    public static final Parcelable.Creator<ImageMessage> CREATOR = new Parcelable.Creator<ImageMessage>() { // from class: io.rong.message.ImageMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageMessage createFromParcel(Parcel parcel) {
            return new ImageMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageMessage[] newArray(int i) {
            return new ImageMessage[i];
        }
    };
    private String mBase64;
    private boolean mIsFull;
    private Uri mThumUri;
    private boolean mUpLoadExp = false;

    public ImageMessage(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("imageUri")) {
                String strOptString = jSONObject.optString("imageUri");
                if (!TextUtils.isEmpty(strOptString)) {
                    setRemoteUri(Uri.parse(strOptString));
                }
            }
            if (jSONObject.has("localPath")) {
                setLocalPath(Uri.parse(jSONObject.optString("localPath")));
            }
            if (jSONObject.has("content")) {
                setBase64(jSONObject.optString("content"));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("exp")) {
                setUpLoadExp(true);
            }
            if (jSONObject.has("isFull")) {
                setIsFull(jSONObject.optBoolean("isFull"));
            } else if (jSONObject.has(MessengerShareContentUtility.WEBVIEW_RATIO_FULL)) {
                setIsFull(jSONObject.optBoolean(MessengerShareContentUtility.WEBVIEW_RATIO_FULL));
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

    public static ImageMessage obtain(Uri uri, Uri uri2) {
        return new ImageMessage(uri, uri2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(this.mBase64)) {
                RLog.d("ImageMessage", "缩略图为空，请检查构造图片消息的地址");
            } else {
                jSONObject.put("content", this.mBase64);
            }
            if (getMediaUrl() != null) {
                jSONObject.put("imageUri", getMediaUrl().toString());
            }
            if (getLocalUri() != null) {
                jSONObject.put("localPath", getLocalUri().toString());
            }
            if (this.mUpLoadExp) {
                jSONObject.put("exp", true);
            }
            jSONObject.put("isFull", this.mIsFull);
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            RLog.e("JSONException", e2.getMessage());
        }
        this.mBase64 = null;
        return jSONObject.toString().getBytes();
    }

    public String getBase64() {
        return this.mBase64;
    }

    public Uri getLocalUri() {
        return getLocalPath();
    }

    public Uri getRemoteUri() {
        return getMediaUrl();
    }

    public Uri getThumUri() {
        return this.mThumUri;
    }

    public boolean isFull() {
        return this.mIsFull;
    }

    public boolean isUpLoadExp() {
        return this.mUpLoadExp;
    }

    public void setBase64(String str) {
        this.mBase64 = str;
    }

    public void setIsFull(boolean z) {
        this.mIsFull = z;
    }

    public void setLocalUri(Uri uri) {
        setLocalPath(uri);
    }

    public void setRemoteUri(Uri uri) {
        setMediaUrl(uri);
    }

    public void setThumUri(Uri uri) {
        this.mThumUri = uri;
    }

    public void setUpLoadExp(boolean z) {
        this.mUpLoadExp = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getLocalPath());
        ParcelUtils.writeToParcel(parcel, getMediaUrl());
        ParcelUtils.writeToParcel(parcel, this.mThumUri);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.mIsFull ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDestruct() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDestructTime()));
    }

    public static ImageMessage obtain(Uri uri, Uri uri2, boolean z) {
        return new ImageMessage(uri, uri2, z);
    }

    public static ImageMessage obtain() {
        return new ImageMessage();
    }

    public ImageMessage() {
    }

    private ImageMessage(Uri uri, Uri uri2) {
        this.mThumUri = uri;
        setLocalPath(uri2);
    }

    private ImageMessage(Uri uri, Uri uri2, boolean z) {
        this.mThumUri = uri;
        setLocalPath(uri2);
        this.mIsFull = z;
    }

    public ImageMessage(Parcel parcel) {
        setExtra(ParcelUtils.readFromParcel(parcel));
        setLocalPath((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setMediaUrl((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        this.mThumUri = (Uri) ParcelUtils.readFromParcel(parcel, Uri.class);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        this.mIsFull = ParcelUtils.readIntFromParcel(parcel).intValue() == 1;
        setDestruct(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDestructTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }
}
