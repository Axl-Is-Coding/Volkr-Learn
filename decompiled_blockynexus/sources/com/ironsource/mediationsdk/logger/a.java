package com.ironsource.mediationsdk.logger;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: compiled from: ConsoleLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends IronSourceLogger {
    public a(int i) {
        super("console", i);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        b(ironSourceTag, str + ":stacktrace[" + Log.getStackTraceString(th) + "]", 3);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void b(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (i == 0) {
            Log.v("ironSourceSDK: " + ironSourceTag, str);
            return;
        }
        if (i == 1) {
            Log.i("ironSourceSDK: " + ironSourceTag, str);
            return;
        }
        if (i == 2) {
            Log.w("ironSourceSDK: " + ironSourceTag, str);
            return;
        }
        if (i != 3) {
            return;
        }
        Log.e("ironSourceSDK: " + ironSourceTag, str);
    }
}
