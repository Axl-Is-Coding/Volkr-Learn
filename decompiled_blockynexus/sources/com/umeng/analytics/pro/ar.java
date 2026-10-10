package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: VivoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes5.dex */
class ar implements al {
    ar() {
    }

    @Override // com.umeng.analytics.pro.al
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.vivo.identifier.IdentifierManager");
            if (cls != null) {
                boolean zBooleanValue = ((Boolean) cls.getMethod("isSupported", Context.class).invoke(null, context)).booleanValue();
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
        return null;
    }
}
