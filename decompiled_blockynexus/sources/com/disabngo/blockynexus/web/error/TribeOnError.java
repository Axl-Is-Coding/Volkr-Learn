package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.facebook.ads.AdError;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class TribeOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 7) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.not_login);
        }
        if (i == 5002) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_not_goods);
            return;
        }
        if (i == 5004) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.good_is_sell_out);
            return;
        }
        if (i == 7008) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_low_level);
            return;
        }
        if (i == 7020) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.has_illegal_character);
            return;
        }
        if (i == 5006) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_not_enough_diamond);
            return;
        }
        if (i == 5007) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.gold_not_enough);
            return;
        }
        switch (i) {
            case AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE /* 7001 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_joined);
                break;
            case AdError.LOAD_CALLED_WHILE_SHOWING_AD /* 7002 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_name_exist);
                break;
            case AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED /* 7003 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_not_chief);
                break;
            case AdError.INCORRECT_STATE_ERROR /* 7004 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_not_elder);
                break;
            case AdError.MISSING_DEPENDENCIES_ERROR /* 7005 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_full);
                break;
            case AdError.API_NOT_SUPPORTED /* 7006 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_not_joined);
                break;
            default:
                switch (i) {
                    case 7010:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_exceed_elder_count);
                        break;
                    case 7011:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_exceed_max_diamond_or_gold);
                        break;
                    case 7012:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_task_get_reward);
                        break;
                    default:
                        switch (i) {
                            case 7014:
                                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_no_enough_24_hour);
                                break;
                            case 7015:
                                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_member_to_limit);
                                break;
                            case 7016:
                                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_task_get_max_tasks);
                                break;
                            case 7017:
                                AppToastUtils.showShortNegativeTipToast(context, R.string.tribe_not_refresh);
                                break;
                            default:
                                ServerOnError.showOnServerError(context, i, TribeOnError.class.getName());
                                break;
                        }
                        break;
                }
                break;
        }
    }
}
