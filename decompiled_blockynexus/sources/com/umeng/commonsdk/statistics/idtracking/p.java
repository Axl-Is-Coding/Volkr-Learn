package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: SerialTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21228a = "serial";

    public p() {
        super(f21228a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getSerial();
    }
}
