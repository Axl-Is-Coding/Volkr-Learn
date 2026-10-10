package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: LenovoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes5.dex */
public class ap implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f20652a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f20653b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20654c = false;

    @Override // com.umeng.analytics.pro.al
    public String a(Context context) {
        if (context != null && !this.f20653b) {
            try {
                Class<?> cls = Class.forName("com.zui.opendeviceidlibrary.OpenDeviceId");
                if (cls != null) {
                    this.f20654c = ((Integer) cls.getMethod("init", Context.class).invoke(null, context)).intValue() == 1;
                    at.a("getOAID", "isSupportedOne", Boolean.valueOf(this.f20654c));
                    this.f20653b = true;
                    boolean zBooleanValue = ((Boolean) cls.getMethod("isSupported", new Class[0]).invoke(null, new Object[0])).booleanValue();
                    at.a("getOAID", "isSupportedTwo", Boolean.valueOf(zBooleanValue));
                    if (this.f20654c && !zBooleanValue) {
                        return (String) cls.getMethod("getOAID", new Class[0]).invoke(null, new Object[0]);
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
