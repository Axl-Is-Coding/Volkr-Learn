package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfigEx;

/* JADX INFO: compiled from: ImeiTrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21211a = "imei";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21212b;

    public j(Context context) {
        super(f21211a);
        this.f21212b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfigEx.getImeiNew(this.f21212b);
    }
}
