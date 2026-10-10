package com.ut.mini.core.appstatus;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.c;
import com.tendcloud.tenddata.ab;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class UTMCAppBackgroundTimeoutDetector implements UTMCAppStatusCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTMCAppBackgroundTimeoutDetector f21355a;
    private long B = 0;

    private UTMCAppBackgroundTimeoutDetector() {
    }

    public static synchronized UTMCAppBackgroundTimeoutDetector getInstance() {
        if (f21355a == null) {
            f21355a = new UTMCAppBackgroundTimeoutDetector();
        }
        return f21355a;
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        this.B = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        if (0 != this.B && SystemClock.elapsedRealtime() - this.B > ab.R) {
            c.a().c(new HashMap());
        }
        this.B = 0L;
    }
}
