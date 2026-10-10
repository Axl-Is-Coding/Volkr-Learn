package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX INFO: compiled from: UOPTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class r extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21230a = "uopdta";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f21231b = "uop";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f21232c;

    public r(Context context) {
        super(f21231b);
        this.f21232c = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        SharedPreferences sharedPreferences;
        return (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.A) || (sharedPreferences = PreferenceWrapper.getDefault(this.f21232c)) == null) ? "" : sharedPreferences.getString("uopdta", "");
    }
}
