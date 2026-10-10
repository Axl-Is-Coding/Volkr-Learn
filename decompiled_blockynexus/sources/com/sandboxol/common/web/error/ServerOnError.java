package com.sandboxol.common.web.error;

import android.content.Context;
import com.sandboxol.common.R;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ServerOnError {
    public static void showOnServerError(Context context, int i) {
        AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, i));
        if (context.getResources().getString(R.string.connect_error_code, Integer.valueOf(i)).equals(HttpUtils.getHttpErrorMsg(context, i))) {
            ReportDataAdapter.onEvent(context, "Unknown Error Code", "onServerError_" + i);
        }
    }

    public static void showOnServerError(Context context, int i, String str) {
        showOnServerError(context, i);
        if (context.getResources().getString(R.string.connect_error_code, Integer.valueOf(i)).equals(HttpUtils.getHttpErrorMsg(context, i))) {
            ReportDataAdapter.onEvent(context, "Unknown Error Code", "onServerError_" + str + "_" + i);
        }
    }
}
