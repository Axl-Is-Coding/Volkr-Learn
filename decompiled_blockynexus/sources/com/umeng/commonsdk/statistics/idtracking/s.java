package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX INFO: compiled from: UOPTrackerEx.java */
/* JADX INFO: loaded from: classes5.dex */
public class s extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21233a = "uopdta";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f21234b = "uop";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f21235c;

    public s(Context context) {
        super(f21234b);
        this.f21235c = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        SharedPreferences sharedPreferences;
        return (!FieldManagerEx.allow(com.umeng.commonsdk.utils.b.A) || (sharedPreferences = PreferenceWrapper.getDefault(this.f21235c)) == null) ? "" : sharedPreferences.getString("uopdta", "");
    }
}
