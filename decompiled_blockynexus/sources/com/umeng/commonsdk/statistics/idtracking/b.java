package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: AndroidIdTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21183a = "android_id";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21184b;

    public b(Context context) {
        super(f21183a);
        this.f21184b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f21184b);
    }
}
