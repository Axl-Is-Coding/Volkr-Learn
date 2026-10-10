package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManagerEx;

/* JADX INFO: compiled from: IDFATrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21189a = "idfa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21190b;

    public e(Context context) {
        super(f21189a);
        this.f21190b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        String strA = FieldManagerEx.allow(com.umeng.commonsdk.utils.b.w) ? com.umeng.commonsdk.statistics.common.a.a(this.f21190b) : null;
        return strA == null ? "" : strA;
    }
}
