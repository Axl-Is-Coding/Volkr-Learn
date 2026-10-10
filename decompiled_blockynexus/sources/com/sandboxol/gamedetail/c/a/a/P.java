package com.sandboxol.gamedetail.c.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.CampaignManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.router.moduleInfo.report.NewReportEvent;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.path.RouterFragmentPath;
import com.sandboxol.center.utils.ARouterUtils;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.c.ya;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.User;
import com.sandboxol.messager.MessagerClient;
import com.tendcloud.tenddata.ab;

/* JADX INFO: compiled from: GameDetailFragment.java */
/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterFragmentPath.GameDetailModule.PAGER_GAME_DETAIL)
public class P extends TemplateFragment<ba, com.sandboxol.gamedetail.a.o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Z f17931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ba f17932c;

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_game_detail;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected boolean isClearViewModel() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 10001 || intent == null || this.viewModel == 0) {
            return;
        }
        if (intent.getBooleanExtra(GameConstant.IS_NEXT_GAME, false)) {
            ((ba) this.viewModel).h().a();
        } else if (!intent.getBooleanExtra(GameConstant.IS_GO_PREPAID, false)) {
            CampaignManager.showResultDialog(this.context, intent.getSerializableExtra(GameConstant.CHRISTMAS_LEVEL_INFO), new OnDataListener() { // from class: com.sandboxol.gamedetail.c.a.a.f
                @Override // com.sandboxol.common.interfaces.OnDataListener
                public final void onSuccess(Object obj) {
                    this.f17981a.a(intent, obj);
                }
            });
        } else {
            Context context = this.context;
            ARouterUtils.startTemplate(context, RouterFragmentPath.RechargeModule.PAGER_RECHARGE, context.getString(R.string.gamedetail_me_recharge), R.mipmap.ic_recharge_history);
        }
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f17932c.setClosePage(true);
        ReportDataAdapter.onPause(this.context);
        AdsManager.onPause(this.activity);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
        Messenger.getDefault().send(MessageToken.REMOVE_SURFACE_VIEW);
        try {
            AdsManager.onResume(this.activity);
            ReportDataAdapter.onEvent(this.context, "home_game", this.f17930a);
            FirebaseUtils.onEvent(this.context, "home_game", this.f17930a);
            this.f17932c.setClosePage(false);
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(this.context, EventConstant.ON_RESUME_EXCEPTION, "GameDetailFragment");
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onRightButtonClick(View view) {
        super.onRightButtonClick(view);
        if (TextUtils.isEmpty(this.f17930a)) {
            return;
        }
        this.f17931b.b(this.context, this.f17930a);
        ReportDataAdapter.onEvent(this.context, AdsEventConstant.CLICK_GAME_ITEM_AD, this.f17930a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandboxol.gamedetail.a.o oVar, ba baVar) {
        oVar.a(baVar);
    }

    public ba g() {
        return this.f17932c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public ba getViewModel() {
        Game game;
        Game game2;
        if (getArguments() != null) {
            this.f17930a = getArguments().getString(StringConstant.MINI_GAME_ID);
            Game game3 = (Game) getArguments().getSerializable(StringConstant.MINI_GAME_DETAIL);
            game = (Game) getArguments().getSerializable(StringConstant.GAME_NO_DETAIL);
            game2 = game3;
        } else {
            game = null;
            game2 = null;
        }
        if (game == null) {
            game = new Game();
        }
        this.f17931b = new Z(this.context);
        this.f17932c = new ba(this.context, (com.sandboxol.gamedetail.a.o) this.binding, this.f17930a, this, game2, game);
        SandboxReportManager.onEvent("new_home_game_" + this.f17930a, ReportEventType.NEW_USER_BEHAVIOR, "app");
        SandboxReportManager.onEvent("new_home_game_" + this.f17930a, this.f17930a + ReportEventType.GAME_INTER_BASE, this.f17930a);
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, "home_game");
        com.apkfuns.logutils.c.a(ab.u).d("onEvent being called! eventEvent: 进入游戏详情页");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, NewReportEvent.NEW_HOME_GAME);
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_NUMBER, "new_home_game_" + this.f17930a, this.f17930a);
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_FREQUENCY, "new_home_game_" + this.f17930a, this.f17930a);
        return this.f17932c;
    }

    public /* synthetic */ void a(Intent intent, Object obj) {
        User user = new User();
        user.setGolds(AccountCenter.newInstance().golds.get().longValue());
        user.setDiamonds(AccountCenter.newInstance().diamonds.get().longValue());
        user.setGDiamonds(AccountCenter.newInstance().gDiamonds.get().longValue());
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            BillingManager.getInstance().updateUserMoney(this.context);
        }
        ya.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), new O(this, intent, user));
    }
}
