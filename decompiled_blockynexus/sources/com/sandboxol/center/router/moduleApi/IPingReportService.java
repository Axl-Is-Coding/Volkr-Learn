package com.sandboxol.center.router.moduleApi;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IPingReportService extends IBaseService {
    int getReportInternal();

    void initService(Context context);

    void onFpsEvent(String str, int i);

    void onNetPingEvent(String str, int i);

    void onPingEvent(String str, int i);

    void setReportInternal(int i);
}
