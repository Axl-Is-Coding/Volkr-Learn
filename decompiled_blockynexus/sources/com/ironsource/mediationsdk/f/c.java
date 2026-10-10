package com.ironsource.mediationsdk.f;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: Server.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static void b(String str, boolean z, int i) {
        Thread thread = new Thread(new b(str, z, i), "callAsyncRequestURL");
        thread.setUncaughtExceptionHandler(new g());
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, boolean z, int i) {
        try {
            new JSONObject(a.a(d.a(str, z, i)));
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.NETWORK, "callRequestURL(reqUrl:" + str + ", hit:" + z + ")", 1);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("callRequestURL(reqUrl:");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", hit:");
            sb.append(z);
            sb.append(")");
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.NETWORK, sb.toString() + ", e:" + Log.getStackTraceString(th), 0);
        }
    }
}
