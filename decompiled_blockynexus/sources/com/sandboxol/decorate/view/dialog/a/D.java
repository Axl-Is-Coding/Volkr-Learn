package com.sandboxol.decorate.view.dialog.a;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.BuyDecorationListBean;
import com.sandboxol.center.entity.BuySuitListBean;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.web.response.DataOnResponseListener;
import com.sandboxol.decorate.R;
import com.sandboxol.greendao.entity.BuyDressResponse;
import com.sandboxol.messager.MessagerClient;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressBuyDialog.java */
/* JADX INFO: loaded from: classes3.dex */
class D extends DataOnResponseListener<BuyDressResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f17308a;

    D(E e2) {
        this.f17308a = e2;
    }

    public /* synthetic */ void a() {
        if (this.f17308a.isShowing()) {
            this.f17308a.c();
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_BUY_ACTION_FINISH);
        BillingManager.getInstance().updateUserMoney(((FullScreenDialog) this.f17308a).context, true);
    }

    public /* synthetic */ void b() {
        com.sandboxol.decorate.manager.j.c().f();
        com.sandboxol.decorate.manager.j.c().h();
        if (this.f17308a.isShowing()) {
            this.f17308a.c();
        }
        BillingManager.getInstance().updateUserMoney(((FullScreenDialog) this.f17308a).context, true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.decorate.web.x.a(((FullScreenDialog) this.f17308a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f17308a).context, EventConstant.BUY_DRESS_FAILED, String.valueOf(i));
        ServerOnError.showOnServerError(((FullScreenDialog) this.f17308a).context, i);
    }

    @Override // com.sandboxol.common.web.response.DataOnResponseListener
    public void onErrorWithData(int i, String str, BuyDressResponse buyDressResponse) {
        com.sandboxol.decorate.web.x.a(((FullScreenDialog) this.f17308a).context, i, str, buyDressResponse);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(BuyDressResponse buyDressResponse) {
        this.f17308a.k();
        new TwoButtonDialog(((FullScreenDialog) this.f17308a).context).setDetailText(R.string.decorate_good_buy_success).setLeftButtonText(R.string.decorate_back).setRightButtonText(R.string.decorate_good_goto_dress).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.a
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f17333a.a();
            }
        }).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.b
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
            public final void onLeftClick() {
                this.f17334a.b();
            }
        }).show();
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLEAR_DRESS_SHOP_CAR);
        MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_DRESS_REFRESH_LIST);
        com.sandboxol.decorate.manager.j.c().a(true);
        if (this.f17308a.h.get().longValue() > 0) {
            ReportDataAdapter.onEvent(((FullScreenDialog) this.f17308a).context, EventConstant.BUY_DRESS_CUBE, String.valueOf(this.f17308a.h.get()));
            SandboxReportManager.onEvent(ReportEvent.USER_CLICK_DECORATE, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
            SandboxReportManager.onEvent(ReportEvent.USER_PAY_DECORATE, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
        }
        Observable.from(this.f17308a.f17312d).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17335a.a((BuySuitListBean) obj);
            }
        });
        Observable.from(this.f17308a.f17311c).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17336a.a((BuyDecorationListBean) obj);
            }
        });
    }

    public /* synthetic */ void a(BuySuitListBean buySuitListBean) {
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f17308a).context, EventConstant.BUY_DRESS_SUC, String.valueOf(buySuitListBean.getSuitId()));
    }

    public /* synthetic */ void a(BuyDecorationListBean buyDecorationListBean) {
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f17308a).context, EventConstant.BUY_DRESS_SUC, String.valueOf(buyDecorationListBean.getDecorationId()));
    }
}
