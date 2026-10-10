package io.rong.message;

import android.net.Uri;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MediaMessageContent extends MessageContent {
    private String mExtra;
    private Uri mLocalPath;
    private Uri mMediaUrl;
    private String mName;

    public String getExtra() {
        return this.mExtra;
    }

    public Uri getLocalPath() {
        return this.mLocalPath;
    }

    public Uri getMediaUrl() {
        return this.mMediaUrl;
    }

    public String getName() {
        return this.mName;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public void setLocalPath(Uri uri) {
        this.mLocalPath = uri;
    }

    public void setMediaUrl(Uri uri) {
        this.mMediaUrl = uri;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
