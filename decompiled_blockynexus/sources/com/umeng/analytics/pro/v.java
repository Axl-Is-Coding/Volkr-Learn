package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: SessionIdGenerateServiceImpl.java */
/* JADX INFO: loaded from: classes5.dex */
class v implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f20944a = AnalyticsConfig.kContinueSessionMillis;

    v() {
    }

    @Override // com.umeng.analytics.pro.u
    public void a(long j) {
        this.f20944a = j;
    }

    @Override // com.umeng.analytics.pro.u
    public long a() {
        return this.f20944a;
    }

    @Override // com.umeng.analytics.pro.u
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(jCurrentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.u
    public boolean a(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (j == 0 || jCurrentTimeMillis - j >= this.f20944a) && j2 > 0 && jCurrentTimeMillis - j2 > this.f20944a;
    }

    @Override // com.umeng.analytics.pro.u
    public void a(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString("session_id", str);
            editorEdit.putLong(s.f20932b, 0L);
            editorEdit.putLong(s.f20935e, jCurrentTimeMillis);
            editorEdit.putLong(s.f20936f, 0L);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }
}
