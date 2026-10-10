package com.sandboxol.decorate.web;

import android.content.Context;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.view.dialog.DiamondNotEnoughButtonDialog;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.R;
import com.sandboxol.greendao.entity.BuyDressResponse;

/* JADX INFO: compiled from: ShopOnError.java */
/* JADX INFO: loaded from: classes3.dex */
public class x {
    public static void a(Context context, int i) {
        if (i == 2014) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_goods_already_buy);
        }
        if (i == 5002) {
            new OneButtonDialog(context).setDetailText(R.string.decorate_good_invalid_good_id).show();
            return;
        }
        if (i == 5004) {
            new OneButtonDialog(context).setDetailText(R.string.decorate_good_is_sell_out).show();
            return;
        }
        if (i == 5015) {
            new DiamondNotEnoughButtonDialog(context).setRightButtonText(R.string.decorate_good_goto_recharge).setDetailText(R.string.decorate_not_enough_gold_diamond).isShowVideoAds(false).setListener(new DiamondNotEnoughButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.web.r
                @Override // com.sandboxol.center.view.dialog.DiamondNotEnoughButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_RECHARGE);
                }
            }).show();
            return;
        }
        if (i == 5016) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_new_dress_guide_not_receive);
            return;
        }
        switch (i) {
            case 5006:
                AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_not_enough_diamond);
                break;
            case 5007:
                AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_gold_not_enough);
                break;
            case 5008:
                new OneButtonDialog(context).setDetailText(R.string.decorate_good_have_clothes).show();
                break;
            default:
                ServerOnError.showOnServerError(context, i, x.class.getName());
                break;
        }
    }

    public static void a(Context context, int i, String str, BuyDressResponse buyDressResponse) {
        switch (i) {
            case 5002:
                new OneButtonDialog(context).setDetailText(R.string.decorate_good_invalid_good_id).show();
                ReportDataAdapter.onEvent(context, EventConstant.BUY_DRESS_FAILED, context.getString(R.string.decorate_good_invalid_good_id));
                break;
            case 5003:
            case 5005:
            default:
                ServerOnError.showOnServerError(context, i, x.class.getName());
                ReportDataAdapter.onEvent(context, EventConstant.BUY_DRESS_FAILED, str);
                break;
            case 5004:
                new OneButtonDialog(context).setDetailText(R.string.decorate_good_is_sell_out).show();
                ReportDataAdapter.onEvent(context, EventConstant.BUY_DRESS_FAILED, context.getString(R.string.decorate_good_is_sell_out));
                break;
            case 5006:
                long goldsNeed = buyDressResponse.getGoldsNeed();
                long diamondsNeed = buyDressResponse.getDiamondsNeed();
                if (goldsNeed <= 0 && diamondsNeed > 0) {
                    new DiamondNotEnoughButtonDialog(context).setRightButtonText(R.string.decorate_good_goto_recharge).setDetailText(R.string.decorate_not_enough_gold_diamond).isShowVideoAds(false).setListener(new DiamondNotEnoughButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.web.s
                        @Override // com.sandboxol.center.view.dialog.DiamondNotEnoughButtonDialog.OnTwoButtonDialogClickListener
                        public final void onClick() {
                            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_RECHARGE);
                        }
                    }).show();
                } else if (goldsNeed > 0 && diamondsNeed <= 0) {
                    AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_gold_not_enough);
                }
                ReportDataAdapter.onEvent(context, EventConstant.BUY_DRESS_FAILED, context.getString(R.string.decorate_good_diamonds_not_enough));
                break;
            case 5007:
                AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_gold_not_enough);
                ReportDataAdapter.onEvent(context, EventConstant.BUY_DRESS_FAILED, context.getString(R.string.decorate_gold_not_enough));
                break;
            case 5008:
                new OneButtonDialog(context).setDetailText(R.string.decorate_good_have_clothes).show();
                ReportDataAdapter.onEvent(context, EventConstant.BUY_DRESS_FAILED, context.getString(R.string.decorate_good_have_clothes));
                break;
        }
    }
}
