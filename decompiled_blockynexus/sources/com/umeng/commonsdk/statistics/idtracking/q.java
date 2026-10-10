package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfigEx;

/* JADX INFO: compiled from: SerialTrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class q extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21229a = "serial";

    public q() {
        super(f21229a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfigEx.getSerial();
    }
}
