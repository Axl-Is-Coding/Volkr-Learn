package com.sandboxol.greendao.b;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: MapConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements org.greenrobot.greendao.a.a<Map<String, String>, String> {
    public Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (Map) new com.google.gson.j().a(str, new j(this).getType());
    }

    public String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new com.google.gson.j().a(map);
    }
}
