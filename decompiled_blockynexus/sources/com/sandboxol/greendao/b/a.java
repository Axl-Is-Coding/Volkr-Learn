package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.AuthorInfo;

/* JADX INFO: compiled from: AuthorInfoConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements org.greenrobot.greendao.a.a<AuthorInfo, String> {
    public AuthorInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (AuthorInfo) new com.google.gson.j().a(str, AuthorInfo.class);
    }

    public String a(AuthorInfo authorInfo) {
        if (authorInfo == null) {
            return null;
        }
        return new com.google.gson.j().a(authorInfo);
    }
}
