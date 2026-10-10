package com.sandboxol.center.router.moduleApi;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface INewSandboxReportService extends IBaseService {
    int getReportInternal();

    void onAppEvent(String str, String str2);

    void onCreate(Context context);

    void onDestroy();

    void onGameEvent(String str, String str2, String str3);

    void setReportInternal(int i);
}
