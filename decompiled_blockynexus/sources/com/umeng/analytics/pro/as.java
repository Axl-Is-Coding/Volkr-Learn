package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: XiaomiDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes5.dex */
class as implements al {
    as() {
    }

    @Override // com.umeng.analytics.pro.al
    public String a(Context context) {
        Class<?> cls;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.miui.deviceid.IdentifierManager");
        } catch (Exception unused) {
        }
        if (cls == null) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
        boolean zBooleanValue = ((Boolean) cls.getMethod("isSupported", new Class[0]).invoke(null, new Object[0])).booleanValue();
        at.a("getOAID", "isSupported", Boolean.valueOf(zBooleanValue));
        if (zBooleanValue) {
            return (String) cls.getMethod("getOAID", Context.class).invoke(null, context);
        }
        UMLog.mutlInfo(2, "当前设备不支持获取OAID");
        return null;
    }
}
