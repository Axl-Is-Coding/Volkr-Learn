package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface UMLogDataProtocol {

    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j);

    void workEvent(Object obj, int i);
}
