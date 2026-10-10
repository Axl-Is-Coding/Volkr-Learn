package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f3940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f81a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3941b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Map<String, String> f82b = new HashMap();

    AlicloudTracker(c cVar, String str, String str2) {
        this.f3940a = cVar;
        this.f81a = str;
        this.f3941b = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f82b.containsKey(str)) {
            Log.e("AlicloudTracker", "key is null or key is empty,please check it!");
        } else {
            this.f82b.remove(str);
        }
    }

    public void sendCustomHit(String str, long j, Map<String, String> map) {
        try {
            if (this.f3940a == null) {
                Log.e("AlicloudTracker", "dataTracker is null, can not sendCustomHit");
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f82b);
            map.put("sdkId", this.f81a);
            map.put("sdkVersion", this.f3941b);
            this.f3940a.sendCustomHit(this.f81a + "_" + str, j, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            Log.e("AlicloudTracker", "key is null or key is empty or value is null,please check it!");
            return;
        }
        if (this.f82b.containsKey(str)) {
            this.f82b.remove(str);
        }
        this.f82b.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
