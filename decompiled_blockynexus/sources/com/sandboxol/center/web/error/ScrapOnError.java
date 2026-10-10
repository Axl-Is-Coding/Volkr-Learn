package com.sandboxol.center.web.error;

import android.content.Context;
import com.sandboxol.center.R;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 10100) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_config_error);
        }
        if (i == 10113) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_scrap_not_vip_can_t_receive);
            return;
        }
        switch (i) {
            case 10104:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_user_without_scrap);
                break;
            case 10105:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_scarp_amount_invalid);
                break;
            case 10106:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_scrap_no_enough);
                break;
            case 10107:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_card_not_exist);
                break;
            case 10108:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_box_already_open);
                break;
            case 10109:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_scarp_no_exist);
                break;
            case 10110:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_no_friend);
                break;
            case 10111:
                AppToastUtils.showShortNegativeTipToast(context, "decoration error");
                break;
            default:
                ServerOnError.showOnServerError(context, i, ScrapOnError.class.getName());
                break;
        }
    }
}
