package com.sandboxol.decorate.web;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DecorationOnError.java */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    public static void a(Context context, int i) {
        if (i == 7) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_not_login);
        }
        if (i == 4007) {
            AppToastUtils.showShortNegativeTipToast(context, "DECORATION_IS_EXIST");
            return;
        }
        if (i == 6001) {
            new TwoButtonDialog(context).setDetailText(context.getString(R.string.decorate_vip_level_not_enough)).setRightButtonText(R.string.decorate_vip_pay_title).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.web.l
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_VIP_RECHARGE);
                }
            }).show();
            return;
        }
        if (i == 7006) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_tribe_not_wear_no_clan);
            return;
        }
        if (i == 7008) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_tribe_no_level);
            return;
        }
        switch (i) {
            case 4001:
                AppToastUtils.showShortNegativeTipToast(context, "PARENT_TYPE_ID_NOT_EXIST");
                break;
            case 4002:
                AppToastUtils.showShortNegativeTipToast(context, "DECORATION_TYPE_ID_NOT_EXIST");
                break;
            case 4003:
                AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_tribe_no_dress_info);
                break;
            case 4004:
                AppToastUtils.showShortNegativeTipToast(context, "DECORATION_DETAILS_NOT_EXIST");
                break;
            case 4005:
                AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_user_no_dress_info);
                break;
            default:
                switch (i) {
                    case 4010:
                        AppToastUtils.showShortNegativeTipToast(context, "SUIT_DECORATION_NOT_EXIST");
                        break;
                    case 4011:
                        AppToastUtils.showShortNegativeTipToast(context, "SUIT_DECORATION_DETAILS_NOT_EXIST");
                        break;
                    case 4012:
                        AppToastUtils.showShortNegativeTipToast(context, "SUIT_DETAILS_LANGUAGE_IS_EXIST");
                        break;
                    case 4013:
                        AppToastUtils.showShortNegativeTipToast(context, "RECOMMEND_DECORATION_NOT_EXIST");
                        break;
                    default:
                        ServerOnError.showOnServerError(context, i, u.class.getName());
                        break;
                }
                break;
        }
    }
}
