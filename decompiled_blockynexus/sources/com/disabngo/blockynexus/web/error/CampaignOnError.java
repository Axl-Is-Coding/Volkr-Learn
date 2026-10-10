package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class CampaignOnError {
    public static void showErrorTip(Context context, int i) {
        switch (i) {
            case IntConstant.LINE_SIGN_IN /* 8001 */:
                DialogUtils.newsInstant().showCampaignOneButtonDialog(context, R.string.campaign_has_bet);
                break;
            case 8002:
                DialogUtils.newsInstant().showCampaignOneButtonDialog(context, R.string.campaign_not_enough_integral);
                break;
            case 8003:
                AppToastUtils.showShortNegativeTipToast(context, R.string.campaign_task_not_complete);
                break;
            case 8004:
                DialogUtils.newsInstant().showCampaignOneButtonDialog(context, R.string.campaign_task_received);
                break;
            case 8005:
                DialogUtils.newsInstant().showCampaignOneButtonDialog(context, R.string.campaign_reward_received);
                break;
            case 8006:
                AppToastUtils.showShortNegativeTipToast(context, R.string.activity_over);
                break;
            default:
                switch (i) {
                    case 8019:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.activity_has_sign_in_today);
                        break;
                    case 8020:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.activity_all_sign_in);
                        break;
                    case 8021:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.activity_not_get_reward);
                        break;
                    case 8022:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.campaign_reward_received);
                        break;
                    default:
                        ServerOnError.showOnServerError(context, i, CampaignOnError.class.getName());
                        break;
                }
                break;
        }
    }
}
