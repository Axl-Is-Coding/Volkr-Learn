package com.sandboxol.center.router.moduleApi;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface ISandboxReportService extends IBaseService {
    int getReportInternal();

    void onCreate(Context context, String str);

    void onDestroy();

    void onEvent(String str);

    void onEvent(String str, String str2);

    void onEvent(String str, String str2, String str3);

    void onEvent(String str, String str2, String str3, String str4);

    void setReportInternal(int i);
}
