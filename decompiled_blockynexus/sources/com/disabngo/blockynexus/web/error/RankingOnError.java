package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RankingOnError {
    public static void showErrorTip(Context context, int i) {
        switch (i) {
            case IntConstant.LINE_SIGN_IN /* 8001 */:
            case 8002:
            case 8003:
            case 8004:
                break;
            default:
                AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, i));
                break;
        }
    }

    public static void showOnServerError(Context context, int i) {
        AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, i));
    }
}
