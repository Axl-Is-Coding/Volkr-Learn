package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* JADX INFO: compiled from: IDFATracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21187a = "idfa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21188b;

    public d(Context context) {
        super(f21187a);
        this.f21188b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        String strA = com.umeng.commonsdk.statistics.common.a.a(this.f21188b);
        return strA == null ? "" : strA;
    }
}
