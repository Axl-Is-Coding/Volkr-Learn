package com.sandboxol.common.interfaces;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IReportData {
    void init(Context context);

    void onError(Context context, Throwable th);

    void onEvent(Context context, String str);

    void onEvent(Context context, String str, String str2);

    void onEvent(Context context, String str, String str2, Map map);

    void onEvent(Context context, String str, Map map);

    void onPause(Context context);

    void onResume(Context context);
}
