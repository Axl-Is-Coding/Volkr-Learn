package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.googlepay.view.fragment.recharge.k;

/* JADX INFO: loaded from: classes3.dex */
public class GroupOnError {
    public static void showErrorTip(final Context context, int i) {
        if (i == 1002) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_1002);
        }
        if (i == 5006) {
            new TwoButtonDialog(context).setTitleText(context.getString(R.string.group_notice_tip)).setDetailText(context.getString(R.string.good_diamonds_not_enough)).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.web.error.a
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    Context context2 = context;
                    TemplateUtils.startTemplate(context2, k.class, context2.getString(R.string.me_recharge));
                }
            }).show();
            return;
        }
        if (i == 8100) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.group_limit_tip);
            return;
        }
        switch (i) {
            case 8102:
                AppToastUtils.showShortNegativeTipToast(context, R.string.group_no_exist_tip);
                break;
            case 8103:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8103);
                break;
            case 8104:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8014);
                break;
            case 8105:
                AppToastUtils.showShortPositiveTipToast(context, R.string.new_group_error_8105);
                break;
            case 8106:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8106);
                break;
            case 8107:
                AppToastUtils.showShortPositiveTipToast(context, R.string.new_group_error_8107);
                break;
            case 8108:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8108);
                break;
            case 8109:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8109);
                break;
            case 8110:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8110);
                break;
            case 8111:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8111);
                break;
            case 8112:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8112);
                break;
            case 8113:
                AppToastUtils.showShortNegativeTipToast(context, R.string.new_group_error_8113);
                break;
            default:
                ServerOnError.showOnServerError(context, i, GroupOnError.class.getName());
                break;
        }
    }
}
