package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: OppoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes5.dex */
public class aq implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f20655a = false;

    @Override // com.umeng.analytics.pro.al
    public String a(Context context) {
        if (context != null && !this.f20655a) {
            try {
                Class<?> cls = Class.forName("com.heytap.openid.sdk.OpenIDSDK");
                if (cls != null) {
                    cls.getMethod("init", Context.class).invoke(null, context);
                    this.f20655a = true;
                    boolean zBooleanValue = ((Boolean) cls.getMethod("isSupported", new Class[0]).invoke(null, new Object[0])).booleanValue();
                    at.a("getOAID", "isSupported", Boolean.valueOf(zBooleanValue));
                    if (zBooleanValue) {
                        return (String) cls.getMethod("getOAID", Context.class).invoke(null, context);
                    }
                    UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                    return null;
                }
            } catch (Exception unused) {
                UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            }
        }
        return null;
    }
}
