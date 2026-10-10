package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.GamingInfo;

/* JADX INFO: compiled from: GamingInfoConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements org.greenrobot.greendao.a.a<GamingInfo, String> {
    public GamingInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (GamingInfo) new com.google.gson.j().a(str, GamingInfo.class);
    }

    public String a(GamingInfo gamingInfo) {
        if (gamingInfo == null) {
            return null;
        }
        return new com.google.gson.j().a(gamingInfo);
    }
}
