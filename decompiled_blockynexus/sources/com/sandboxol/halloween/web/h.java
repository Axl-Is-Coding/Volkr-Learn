package com.sandboxol.halloween.web;

import android.content.Context;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: HalloweenOnError.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {
    public static void a(Context context, int i) {
        if (i == 8006) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8006);
        }
        if (i == 8007) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8007);
            return;
        }
        switch (i) {
            case 8060:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8060);
                break;
            case 8061:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8061);
                break;
            case 8062:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8062);
                break;
            case 8063:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8063);
                break;
            case 8064:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8064);
                break;
            case 8065:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8065);
                break;
            case 8066:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8066);
                break;
            case 8067:
                AppToastUtils.showShortNegativeTipToast(context, R.string.halloween_error_8067);
                break;
            default:
                ServerOnError.showOnServerError(context, i, h.class.getName());
                break;
        }
    }
}
