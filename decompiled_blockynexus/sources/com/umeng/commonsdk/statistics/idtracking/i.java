package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: ImeiTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21209a = "imei";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21210b;

    public i(Context context) {
        super(f21209a);
        this.f21210b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f21210b);
    }
}
