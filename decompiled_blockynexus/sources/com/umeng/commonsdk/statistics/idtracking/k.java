package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: MacTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21213a = "mac";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21214b;

    public k(Context context) {
        super(f21213a);
        this.f21214b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f21214b);
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                e2.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f21214b, e2);
            return null;
        }
    }
}
