package io.rong.message;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import io.rong.common.FileInfo;
import io.rong.common.FileUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.UserInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DestructionTag(destructionFlag = 0)
@MessageTag(flag = 3, messageHandler = SightMessageHandler.class, value = "RC:SightMsg")
public class SightMessage extends MediaMessageContent {
    public static final Parcelable.Creator<SightMessage> CREATOR = new Parcelable.Creator<SightMessage>() { // from class: io.rong.message.SightMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SightMessage createFromParcel(Parcel parcel) {
            return new SightMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SightMessage[] newArray(int i) {
            return new SightMessage[i];
        }
    };
    private static final String TAG = "SightMessage";
    private String mBase64;
    private int mDuration;
    private long mSize;
    private Uri mThumbUri;

    public SightMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("name")) {
                setName(jSONObject.optString("name"));
            }
            if (jSONObject.has("size")) {
                setSize(jSONObject.getLong("size"));
            }
            if (jSONObject.has("content")) {
                setBase64(jSONObject.optString("content"));
            }
            if (jSONObject.has("localPath")) {
                setLocalPath(Uri.parse(jSONObject.optString("localPath")));
            }
            if (jSONObject.has("sightUrl")) {
                setMediaUrl(Uri.parse(jSONObject.optString("sightUrl")));
            }
            if (jSONObject.has("duration")) {
                setDuration(jSONObject.optInt("duration"));
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
        } catch (JSONException e3) {
            Log.e("JSONException", e3.getMessage());
        }
    }

    @Deprecated
    public static SightMessage obtain(Uri uri, Uri uri2, int i) {
        if (FileUtils.uriStartWithFile(uri2)) {
            File file = new File(uri2.toString().substring(7));
            if (file.exists() && file.isFile()) {
                return new SightMessage(file, uri, uri2, i);
            }
        }
        RLog.e(TAG, "localUri is not file scheme");
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
            if (TextUtils.isEmpty(this.mBase64)) {
                Log.d(TAG, "base64 is null");
            } else {
                jSONObject.put("content", this.mBase64);
            }
            if (!TextUtils.isEmpty(getName())) {
                jSONObject.put("name", getName());
            }
            jSONObject.put("size", this.mSize);
            if (getLocalPath() != null) {
                jSONObject.put("localPath", getLocalPath().toString());
            }
            if (getMediaUrl() != null) {
                jSONObject.put("sightUrl", getMediaUrl().toString());
            }
            jSONObject.put("duration", getDuration());
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "encode", e3);
            return null;
        }
    }

    public String getBase64() {
        return this.mBase64;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public long getSize() {
        return this.mSize;
    }

    public Uri getThumbUri() {
        return this.mThumbUri;
    }

    public void setBase64(String str) {
        this.mBase64 = str;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public void setThumbUri(Uri uri) {
        this.mThumbUri = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.mThumbUri);
        ParcelUtils.writeToParcel(parcel, getLocalPath());
        ParcelUtils.writeToParcel(parcel, getMediaUrl());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getDuration()));
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getSize()));
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDestruct() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDestructTime()));
    }

    public static SightMessage obtain(Uri uri, int i) {
        if (FileUtils.uriStartWithFile(uri)) {
            File file = new File(uri.toString().substring(7));
            if (file.exists() && file.isFile()) {
                return new SightMessage(file, (Uri) null, uri, i);
            }
        }
        RLog.e(TAG, "localUri is not file scheme");
        return null;
    }

    public static SightMessage obtain(Context context, Uri uri, int i) {
        if (context != null && uri != null) {
            FileInfo fileInfoByUri = FileUtils.getFileInfoByUri(context, uri);
            if (fileInfoByUri != null) {
                return new SightMessage(fileInfoByUri, (Uri) null, uri, i);
            }
            RLog.e(TAG, "localUri is not file or content scheme");
            return null;
        }
        RLog.e(TAG, "url or context is null");
        return null;
    }

    public static SightMessage obtain(Context context, Uri uri, Uri uri2, int i) {
        if (context != null && uri2 != null) {
            FileInfo fileInfoByUri = FileUtils.getFileInfoByUri(context, uri2);
            if (fileInfoByUri != null) {
                return new SightMessage(fileInfoByUri, uri, uri2, i);
            }
            RLog.e(TAG, "localUri is not file or content scheme");
            return null;
        }
        RLog.e(TAG, "url or context is null");
        return null;
    }

    public SightMessage() {
    }

    private SightMessage(File file, Uri uri, Uri uri2, int i) {
        this.mThumbUri = uri;
        setLocalPath(uri2);
        setDuration(i);
        setName(file.getName());
        setSize(file.length());
    }

    private SightMessage(FileInfo fileInfo, Uri uri, Uri uri2, int i) {
        this.mThumbUri = uri;
        setLocalPath(uri2);
        setDuration(i);
        setName(fileInfo.getName());
        setSize(fileInfo.getSize());
    }

    public SightMessage(Parcel parcel) {
        this.mThumbUri = (Uri) ParcelUtils.readFromParcel(parcel, Uri.class);
        setLocalPath((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setMediaUrl((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setDuration(ParcelUtils.readIntFromParcel(parcel).intValue());
        setName(ParcelUtils.readFromParcel(parcel));
        setSize(ParcelUtils.readLongFromParcel(parcel).longValue());
        setExtra(ParcelUtils.readFromParcel(parcel));
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setDestruct(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDestructTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }
}
