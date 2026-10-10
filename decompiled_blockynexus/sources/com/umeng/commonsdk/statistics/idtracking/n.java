package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: OaidTracking.java */
/* JADX INFO: loaded from: classes5.dex */
public class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21219a = "umeng_sp_oaid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21220b = "key_umeng_sp_oaid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21221c = "key_umeng_sp_oaid_required_time";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f21222d = "oaid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f21223e;

    public n(Context context) {
        super(f21222d);
        this.f21223e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            SharedPreferences sharedPreferences = this.f21223e.getSharedPreferences(f21219a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f21220b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
