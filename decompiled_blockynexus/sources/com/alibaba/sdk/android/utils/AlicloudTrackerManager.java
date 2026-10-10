package com.alibaba.sdk.android.utils;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTrackerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AlicloudTrackerManager f3942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f83a = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.b f84a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, AlicloudTracker> f3943c;

    private AlicloudTrackerManager(Application application) {
        this.f84a = null;
        HashMap map = new HashMap(4);
        map.put("kVersion", "1.1.4");
        map.put("packageName", application.getPackageName());
        this.f83a.a(application, map);
        this.f3943c = new HashMap();
        this.f84a = com.alibaba.sdk.android.utils.crashdefend.b.a(application, this.f83a);
    }

    public static synchronized AlicloudTrackerManager getInstance(Application application) {
        if (application == null) {
            return null;
        }
        if (f3942a == null) {
            f3942a = new AlicloudTrackerManager(application);
        }
        return f3942a;
    }

    public AlicloudTracker getTracker(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("AlicloudTrackerManager", "sdkId or sdkVersion is null");
            return null;
        }
        String str3 = str + str2;
        if (this.f3943c.containsKey(str3)) {
            return this.f3943c.get(str3);
        }
        AlicloudTracker alicloudTracker = new AlicloudTracker(this.f83a, str, str2);
        this.f3943c.put(str3, alicloudTracker);
        return alicloudTracker;
    }

    public boolean registerCrashDefend(String str, String str2, int i, int i2, SDKMessageCallback sDKMessageCallback) {
        if (this.f84a == null) {
            return false;
        }
        com.alibaba.sdk.android.utils.crashdefend.c cVar = new com.alibaba.sdk.android.utils.crashdefend.c();
        cVar.f93a = str;
        cVar.f95b = str2;
        cVar.f3953a = i;
        cVar.f3954b = i2;
        return this.f84a.m35a(cVar, sDKMessageCallback);
    }

    public void unregisterCrashDefend(String str, String str2) {
        this.f84a.d(str, str2);
    }
}
