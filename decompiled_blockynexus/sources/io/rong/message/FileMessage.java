package io.rong.message;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.FileInfo;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.UserInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, value = "RC:FileMsg")
public class FileMessage extends MediaMessageContent {
    public static final Parcelable.Creator<FileMessage> CREATOR = new Parcelable.Creator<FileMessage>() { // from class: io.rong.message.FileMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileMessage createFromParcel(Parcel parcel) {
            return new FileMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileMessage[] newArray(int i) {
            return new FileMessage[i];
        }
    };
    private static final String TAG = "FileMessage";
    private long mSize;
    private String mType;
    public int progress;

    public FileMessage(byte[] bArr) {
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
            if (jSONObject.has("size")) {
                setSize(jSONObject.getLong("size"));
            }
            if (jSONObject.has("type")) {
                setType(jSONObject.optString("type"));
            }
            if (jSONObject.has("localPath")) {
                setLocalPath(Uri.parse(jSONObject.optString("localPath")));
            }
            if (jSONObject.has("fileUrl")) {
                setFileUrl(Uri.parse(jSONObject.optString("fileUrl")));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    @Deprecated
    public static FileMessage obtain(Uri uri) {
        if (uri == null) {
            RLog.e(TAG, "url is null");
            return null;
        }
        if (!FileUtils.uriStartWithFile(uri)) {
            if (!FileUtils.uriStartWithContent(uri)) {
                return new FileMessage(new File(uri.toString()), uri);
            }
            RLog.e(TAG, "url is content scheme");
            return null;
        }
        File file = new File(uri.toString().substring(7));
        if (file.exists() && file.isFile()) {
            return new FileMessage(file, uri);
        }
        RLog.e(TAG, "file is not exists, url is " + uri);
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
            if (!TextUtils.isEmpty(getName())) {
                jSONObject.put("name", getName());
            }
            jSONObject.put("size", this.mSize);
            if (!TextUtils.isEmpty(this.mType)) {
                jSONObject.put("type", this.mType);
            }
            if (getLocalPath() != null) {
                jSONObject.put("localPath", getLocalPath().toString());
            }
            if (getMediaUrl() != null) {
                jSONObject.put("fileUrl", getMediaUrl().toString());
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
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

    public Uri getFileUrl() {
        return getMediaUrl();
    }

    @Override // io.rong.imlib.model.MessageContent
    public List<String> getSearchableWord() {
        ArrayList arrayList = new ArrayList();
        if (getName() != null) {
            arrayList.add(getName());
        }
        return arrayList;
    }

    public long getSize() {
        return this.mSize;
    }

    public String getType() {
        return this.mType;
    }

    public void setFileUrl(Uri uri) {
        setMediaUrl(uri);
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public void setType(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mType = "bin";
        } else {
            this.mType = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getSize()));
        ParcelUtils.writeToParcel(parcel, getType());
        ParcelUtils.writeToParcel(parcel, getLocalPath());
        ParcelUtils.writeToParcel(parcel, getFileUrl());
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    public static FileMessage obtain(Context context, Uri uri) {
        if (uri != null && context != null) {
            FileInfo fileInfoByUri = FileUtils.getFileInfoByUri(context, uri);
            if (fileInfoByUri != null) {
                return new FileMessage(fileInfoByUri, uri);
            }
            return new FileMessage(new File(uri.toString()), uri);
        }
        RLog.e(TAG, "url or context is null");
        return null;
    }

    private FileMessage() {
    }

    private FileMessage(FileInfo fileInfo, Uri uri) {
        setLocalPath(uri);
        setName(fileInfo.getName());
        setSize(fileInfo.getSize());
        setType(fileInfo.getType());
    }

    private FileMessage(File file, Uri uri) {
        if (uri.toString().startsWith(LibStorageUtils.FILE)) {
            setLocalPath(uri);
        } else {
            setMediaUrl(uri);
        }
        setName(file.getName());
        setSize(file.length());
    }

    public FileMessage(Parcel parcel) {
        setExtra(ParcelUtils.readFromParcel(parcel));
        setName(ParcelUtils.readFromParcel(parcel));
        setSize(ParcelUtils.readLongFromParcel(parcel).longValue());
        setType(ParcelUtils.readFromParcel(parcel));
        setLocalPath((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setFileUrl((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }
}
