package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.m;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f20574a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CoreProtocol f20575a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f20574a == null && context != null) {
            f20574a = context.getApplicationContext();
        }
        return a.f20575a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        m.a(f20574a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        m.a(f20574a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        m.a(f20574a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return m.a(f20574a).a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        m.a(f20574a).a(obj, i);
    }

    private CoreProtocol() {
    }
}
