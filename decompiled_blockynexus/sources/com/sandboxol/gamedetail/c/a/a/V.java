package com.sandboxol.gamedetail.c.a.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyGameResponse;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.center.utils.ARouterUtils;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class V extends OnResponseListener<BuyGameResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f17950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f17951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f17952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Context f17953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ObservableField f17954f;
    final /* synthetic */ Z g;

    V(Z z, Game game, ObservableField observableField, ObservableField observableField2, ObservableField observableField3, Context context, ObservableField observableField4) {
        this.g = z;
        this.f17949a = game;
        this.f17950b = observableField;
        this.f17951c = observableField2;
        this.f17952d = observableField3;
        this.f17953e = context;
        this.f17954f = observableField4;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyGameResponse buyGameResponse) {
        this.f17949a.setIsPay(0);
        this.f17949a.setGamePayInfo(null);
        this.g.a(this.f17950b, this.f17951c, this.f17952d, this.f17949a);
        AppToastUtils.showShortPositiveTipToast(this.f17953e, R.string.good_buy_success);
        this.f17954f.set(true);
        AccountCenter.newInstance().diamonds.set(Long.valueOf(buyGameResponse.getDiamonds()));
        AccountCenter.newInstance().gDiamonds.set(Long.valueOf(buyGameResponse.getgDiamonds()));
        AccountCenter.newInstance().golds.set(Long.valueOf(buyGameResponse.getGolds()));
        ReportDataAdapter.onEvent(this.f17953e, EventConstant.BUY_GAME_SUCCESS);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        switch (i) {
            case 5002:
                new OneButtonDialog(this.f17953e).setDetailText(R.string.good_invalid_good_id).show();
                break;
            case 5003:
            case 5005:
            default:
                Context context = this.f17953e;
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.connect_error_code, Integer.valueOf(i)));
                break;
            case 5004:
                new OneButtonDialog(this.f17953e).setDetailText(R.string.good_is_sell_out).show();
                break;
            case 5006:
                TwoButtonDialog detailText = new TwoButtonDialog(this.f17953e).setRightButtonText(R.string.gamedetail_good_goto_recharge).setDetailText(R.string.good_diamonds_not_enough);
                final Context context2 = this.f17953e;
                detailText.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.g
                    @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                    public final void onClick() {
                        Context context3 = context2;
                        ARouterUtils.startTemplate(context3, RouterFragmentPath.RechargeModule.PAGER_RECHARGE, context3.getString(R.string.gamedetail_good_goto_recharge), R.mipmap.ic_recharge_history);
                    }
                }).show();
                break;
            case 5007:
                AppToastUtils.showShortNegativeTipToast(this.f17953e, R.string.gold_not_enough);
                break;
            case 5008:
                new OneButtonDialog(this.f17953e).setDetailText(R.string.good_have_clothes).show();
                break;
        }
        this.f17954f.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17953e, i);
        this.f17954f.set(true);
    }
}
