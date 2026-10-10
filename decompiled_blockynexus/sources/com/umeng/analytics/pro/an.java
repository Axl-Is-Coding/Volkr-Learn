package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: DeviceIdSupplier.java */
/* JADX INFO: loaded from: classes5.dex */
public class an {
    public static al a(Context context) {
        String str = Build.BRAND;
        at.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new ao();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米")) {
            return new as();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new ar();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus")) {
            return new aq();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new ap();
        }
        return null;
    }
}
