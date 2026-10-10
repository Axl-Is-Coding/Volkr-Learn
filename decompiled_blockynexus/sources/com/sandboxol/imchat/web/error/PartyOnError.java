package com.sandboxol.imchat.web.error;

import android.content.Context;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class PartyOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 2) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.team_num_is_full);
            return;
        }
        if (i == 3) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.party_create_party_room_other_error);
        } else if (i == 4) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.team_not_exist);
        } else {
            if (i != 5) {
                return;
            }
            AppToastUtils.showShortNegativeTipToast(context, R.string.party_create_party_room_member_not_exist_error);
        }
    }

    public static void showServerError(Context context, int i) {
        showErrorTip(context, i);
    }
}
