package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfigEx;

/* JADX INFO: compiled from: MacTrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21215a = "mac";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21216b;

    public l(Context context) {
        super(f21215a);
        this.f21216b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfigEx.getMac(this.f21216b);
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                e2.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f21216b, e2);
            return null;
        }
    }
}
