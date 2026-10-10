package com.alibaba.mtl.appmonitor;

import android.content.Context;
import com.alibaba.mtl.log.d.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SdkMeta {
    public static final String SDK_VERSION = "2.6.4.10_for_bc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, String> f3551d = new HashMap();

    static {
        f3551d.put("sdk-version", SDK_VERSION);
    }

    public static Map<String, String> getSDKMetaData() {
        com.alibaba.mtl.log.a.getContext();
        if (!f3551d.containsKey("sdk-version")) {
            f3551d.put("sdk-version", SDK_VERSION);
        }
        return f3551d;
    }

    public static String getString(Context context, String str) {
        if (context == null) {
            return null;
        }
        int identifier = 0;
        try {
            identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Throwable th) {
            i.a("SdkMeta", "getString Id error", th);
        }
        if (identifier != 0) {
            return context.getString(identifier);
        }
        return null;
    }

    public static void setExtra(Map<String, String> map) {
        if (map != null) {
            f3551d.putAll(map);
        }
    }
}
