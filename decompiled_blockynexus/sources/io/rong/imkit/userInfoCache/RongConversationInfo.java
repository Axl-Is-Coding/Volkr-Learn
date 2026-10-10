package io.rong.imkit.userInfoCache;

import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public class RongConversationInfo {
    private String conversationType;
    private String id;
    private String name;
    private Uri uri;

    public RongConversationInfo(String str, String str2, String str3, Uri uri) {
        this.conversationType = str;
        this.id = str2;
        this.name = str3;
        this.uri = uri;
    }

    public String getConversationType() {
        return this.conversationType;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setConversationType(String str) {
        this.conversationType = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
