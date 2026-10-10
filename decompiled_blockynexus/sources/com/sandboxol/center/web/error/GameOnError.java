package com.sandboxol.center.web.error;

import android.content.Context;
import com.sandboxol.center.R;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class GameOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 7) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_game_detail_appreciation_not_login);
            return;
        }
        if (i == 2002) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_game_detail_appreciation_game_not_exist);
            return;
        }
        if (i == 2005) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_game_detail_appreciation_game_has_appreciation);
            return;
        }
        if (i == 2008) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_game_detail_appreciation_game_not_play);
            return;
        }
        if (i == 7012) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.sign_in_has_get);
            return;
        }
        if (i == 2022) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_ads_not_expired);
        } else if (i != 2023) {
            ServerOnError.showOnServerError(context, i, GameOnError.class.getName());
        } else {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_turntable_get_max);
        }
    }
}
