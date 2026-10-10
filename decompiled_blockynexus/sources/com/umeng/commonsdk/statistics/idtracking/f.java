package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: IDMD5Tracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21191a = "idmd5";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21192b;

    public f(Context context) {
        super("idmd5");
        this.f21192b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f21192b);
    }
}
