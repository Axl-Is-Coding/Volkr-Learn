package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.ResourceLatestVersionData;

/* JADX INFO: compiled from: ResourceLatestVersionDataConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements org.greenrobot.greendao.a.a<ResourceLatestVersionData, String> {
    public ResourceLatestVersionData a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ResourceLatestVersionData) new com.google.gson.j().a(str, ResourceLatestVersionData.class);
    }

    public String a(ResourceLatestVersionData resourceLatestVersionData) {
        if (resourceLatestVersionData == null) {
            return null;
        }
        return new com.google.gson.j().a(resourceLatestVersionData);
    }
}
