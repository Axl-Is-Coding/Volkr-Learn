package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfigEx;

/* JADX INFO: compiled from: AndroidIdTrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21185a = "android_id";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21186b;

    public c(Context context) {
        super(f21185a);
        this.f21186b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfigEx.getAndroidId(this.f21186b);
    }
}
