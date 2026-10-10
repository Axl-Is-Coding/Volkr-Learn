package com.sandboxol.gamedetail.c.a.a;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.fragment.app.AbstractC0336n;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.blockmango.entity.ChristmasLevel;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.entity.AppConfig;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.CampaignManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.NewReportEvent;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.EventLogicUtils;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.BannerEntity;
import com.sandboxol.greendao.entity.Game;
import java.lang.ref.WeakReference;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GameDetailViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class ba extends ViewModel implements wa {
    public ObservableField<Integer> A;
    private WeakReference<Activity> K;
    private Game L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.sandboxol.gamedetail.a.o f17967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17968c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<AppEngineResourceUpdateResult> f17971f;
    private Z h;
    private M i;
    private P j;
    private E k;
    private BaseFragment l;
    private com.sandboxol.gamedetail.c.a.b.f m;
    private com.sandboxol.gamedetail.c.a.d.f n;
    private com.sandboxol.gamedetail.c.a.c.f o;
    public ObservableField<Boolean> y;
    public ObservableField<String> z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17969d = 0;
    private int g = 0;
    public ObservableField<Boolean> p = new ObservableField<>(false);
    public ObservableField<Integer> q = new ObservableField<>();
    public ObservableField<Boolean> r = new ObservableField<>(false);
    public ObservableField<Boolean> s = new ObservableField<>(false);
    public ObservableField<Integer> t = new ObservableField<>();
    public ObservableField<Drawable> u = new ObservableField<>();
    public ObservableField<String> v = new ObservableField<>("");
    public ObservableField<Boolean> w = new ObservableField<>();
    public ObservableField<Game> x = new ObservableField<>();
    public ObservableList<String> B = new ObservableArrayList();
    public ObservableList<String> C = new ObservableArrayList();
    public ObservableList<BannerEntity> D = new ObservableArrayList();
    public ObservableField<Boolean> E = new ObservableField<>(true);
    public ObservableField<Boolean> F = new ObservableField<>(true);
    public ObservableField<Integer> G = new ObservableField<>(0);
    public ObservableField<Boolean> H = new ObservableField<>(true);
    public ObservableField<String> I = new ObservableField<>("0");
    public ObservableField<Boolean> J = new ObservableField<>(false);
    public ReplyCommand M = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.x
        @Override // rx.functions.Action0
        public final void call() {
            this.f18048a.m();
        }
    });
    public ReplyCommand N = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.o
        @Override // rx.functions.Action0
        public final void call() {
            this.f18019a.p();
        }
    });
    public ReplyCommand O = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.n
        @Override // rx.functions.Action0
        public final void call() {
            this.f18016a.u();
        }
    });
    public ReplyCommand P = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.v
        @Override // rx.functions.Action0
        public final void call() {
            this.f18040a.D();
        }
    });
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> Q = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.gamedetail.c.a.a.w
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f18047a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });
    public ReplyCommand R = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.p
        @Override // rx.functions.Action0
        public final void call() {
            this.f18022a.E();
        }
    });
    private boolean S = false;

    public ba(Context context, com.sandboxol.gamedetail.a.o oVar, String str, P p, Game game, Game game2) {
        this.f17966a = context;
        this.f17968c = str;
        this.j = p;
        this.f17967b = oVar;
        this.L = game2;
        this.K = new WeakReference<>(p.getActivity());
        c(game);
        initMessenger();
        F();
        G();
    }

    private void F() {
        this.f17967b.f17862f.setEnabled(false);
        this.f17967b.f17862f.setTouchListener(new OnDataListener() { // from class: com.sandboxol.gamedetail.c.a.a.t
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f18034a.a((Integer) obj);
            }
        });
    }

    private void G() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f17967b.f17858b, "alpha", WheelView.DividerConfig.FILL, 1.0f, WheelView.DividerConfig.FILL, 1.0f, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL).setDuration(4000L);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.setRepeatCount(-1);
        duration.start();
    }

    private void H() {
        if (this.x.get() == null || this.x.get().getWarmUpResponse() == null) {
            return;
        }
        this.x.get().getWarmUpResponse().setAuthorInfo(this.x.get().getAuthorInfo());
        Bundle bundle = new Bundle();
        bundle.putSerializable(StringConstant.GAME_DETAIL_INTRODUCTION, this.x.get());
        a(0, this.m, bundle);
    }

    private void I() {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.MINI_GAME_ID, this.f17968c);
        a(2, this.o, bundle);
    }

    private void J() {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.MINI_GAME_ID, this.f17968c);
        a(1, this.n, bundle);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK, new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.r
            @Override // rx.functions.Action0
            public final void call() {
                this.f18028a.k();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SHOW_CHRISTMAS_RESULT_ANIMATION, ChristmasLevel.class, new Action1() { // from class: com.sandboxol.gamedetail.c.a.a.s
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18031a.a((ChristmasLevel) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.UPGRADE_INTERFACE_IS_NOT_READY, new Action0() { // from class: com.sandboxol.gamedetail.c.a.a.y
            @Override // rx.functions.Action0
            public final void call() {
                this.f18049a.l();
            }
        });
    }

    public /* synthetic */ void D() {
        this.h.a(this.f17968c, this.x, this.J, this.I);
    }

    public /* synthetic */ void E() {
        CampaignManager.onGoCampaign(this.f17966a, BaseModuleApp.getBaseModuleApp().getMetaDataActivityId());
        EventLogicUtils.isDaily(this.f17966a, SharedConstant.IS_DAILY_ENTRANCE, new Action1() { // from class: com.sandboxol.gamedetail.c.a.a.u
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18037a.a((Boolean) obj);
            }
        });
    }

    public boolean f() {
        return this.f17970e;
    }

    public M h() {
        return this.i;
    }

    public Game i() {
        return this.L;
    }

    public /* synthetic */ void j() {
        this.i.b(this.x.get(), this.f17971f);
        ReportDataAdapter.onEvent(this.f17966a, EventConstant.CLICK_GAME_GUIDE);
    }

    public /* synthetic */ void k() {
        this.y.set(false);
    }

    public /* synthetic */ void l() {
        Log.e("GameDetailViewModel", new com.google.gson.j().a(this.x.get()));
        ObservableField<Game> observableField = this.x;
        if (observableField == null || observableField.get() == null || this.x.get().getLatestResVersions() == null) {
            Log.e("GameDetailViewModel", "Get upgrade interface error");
        } else {
            com.sandboxol.greendao.c.U.newInstance().a(this.f17968c, new aa(this));
        }
    }

    public /* synthetic */ void m() {
        SandboxReportManager.onEvent(ReportEvent.GAME_ACTIVE_NUM, ReportEventType.GAME_ORDINARY_BEHAVIOR, "android", this.f17968c);
        SandboxReportManager.onEvent(ReportEvent.USER_PLAY_GAME_NUM, ReportEventType.GAME_ORDINARY_BEHAVIOR, "android", this.f17968c);
        SandboxReportManager.onEvent("new_click_enter_game_" + this.f17968c, ReportEventType.NEW_USER_BEHAVIOR, "app");
        SandboxReportManager.onEvent("new_click_enter_game_" + this.f17968c, this.f17968c + ReportEventType.GAME_INTER_BASE, this.f17968c);
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, "click_enter_game");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, NewReportEvent.NEW_CLICK_ENTER_GAME);
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_NUMBER, "new_click_enter_game_" + this.f17968c, this.f17968c);
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_FREQUENCY, "new_click_enter_game_" + this.f17968c, this.f17968c);
        ObservableField<Game> observableField = this.x;
        if (observableField == null || observableField.get() == null || this.y.get().booleanValue()) {
            return;
        }
        if (Helper.isBelowKitKat(this.x.get().getIsNewEngine() == 1)) {
            AppToastUtils.showLongNegativeTipToast(this.f17966a, R.string.base_below_kit_kat);
            return;
        }
        Log.d("DressDownload&Unzip", "click enter game");
        ReportUtils.resDownloadReport(this.f17966a, this.f17968c, EventConstant.DOWNLOAD_CLICK_ENTER_GAME);
        this.g = 1;
        b.h.b.a.j.a(this.f17966a, this.f17968c);
        this.i.b(this.x.get(), this.f17971f);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        this.i.b();
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        if (!this.S) {
            this.S = true;
            this.k.a(this.j);
        }
        CampaignManager.isGoCampaignRefresh(this.f17966a, this.t);
        this.H.set(Boolean.valueOf(SharedUtils.getBoolean(this.f17966a, SharedConstant.IS_BEDWARHALL_DISPLAYED)));
    }

    public /* synthetic */ void p() {
        SandboxReportManager.onEvent(ReportEvent.GAME_ACTIVE_NUM, ReportEventType.GAME_ORDINARY_BEHAVIOR, "android", this.f17968c);
        SandboxReportManager.onEvent(ReportEvent.USER_PLAY_GAME_NUM, ReportEventType.GAME_ORDINARY_BEHAVIOR, "android", this.f17968c);
        SandboxReportManager.onEvent(ReportEvent.NEW_CLICK_ENTER_GAME_Hall_BASE + this.f17968c, ReportEventType.NEW_USER_BEHAVIOR, "app");
        SandboxReportManager.onEvent(ReportEvent.NEW_CLICK_ENTER_GAME_Hall_BASE + this.f17968c, this.f17968c + ReportEventType.GAME_INTER_BASE, this.f17968c);
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, "click_enter_game");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, NewReportEvent.NEW_CLICK_ENTER_GAME);
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_NUMBER, "new_click_enter_game_" + this.f17968c, this.f17968c);
        NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_FREQUENCY, "new_click_enter_game_" + this.f17968c, this.f17968c);
        if (!this.E.get().booleanValue()) {
            AppToastUtils.showShortPositiveTipToast(this.f17966a, R.string.gamedetail_downloading);
            return;
        }
        ObservableField<Game> observableField = this.x;
        if (observableField == null || observableField.get() == null) {
            return;
        }
        this.x.get().setGameId(GameIdRemarkUtils.singleGameToHallGame(this.x.get().getGameId()));
        this.g = 3;
        this.i.a(this.x.get(), this.f17971f);
        Log.d("DressDownload&Unzip", "click enter hall game");
    }

    public void setClosePage(boolean z) {
        this.f17970e = z;
    }

    public /* synthetic */ void u() {
        if (!this.E.get().booleanValue()) {
            AppToastUtils.showShortPositiveTipToast(this.f17966a, R.string.gamedetail_downloading);
            return;
        }
        ObservableField<Game> observableField = this.x;
        if (observableField == null || observableField.get() == null) {
            return;
        }
        this.g = 2;
        this.i.c(this.x.get(), this.f17971f);
        Log.d("DressDownload&Unzip", "click enter party");
    }

    private void b(int i) {
        this.q.set(Integer.valueOf(i));
        if (i == R.id.tab_introduction) {
            H();
            ReportDataAdapter.onEvent(this.f17966a, EventConstant.CLICK_GAMEDETAIL_TAB);
        } else if (i == R.id.tab_shop) {
            J();
            ReportDataAdapter.onEvent(this.f17966a, EventConstant.CLICK_SHOP_TAB);
        } else if (i == R.id.tab_rank) {
            I();
            ReportDataAdapter.onEvent(this.f17966a, EventConstant.CLICK_RANK_TAB);
        }
    }

    private void c(Game game) {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(this.f17968c);
        this.y = gameProgressInfo == null ? new ObservableField<>(false) : gameProgressInfo.getIsDownload();
        this.z = gameProgressInfo == null ? new ObservableField<>() : gameProgressInfo.getProgressText();
        this.A = gameProgressInfo == null ? new ObservableField<>() : gameProgressInfo.getProgressValue();
        this.E = gameProgressInfo == null ? new ObservableField<>(true) : gameProgressInfo.getIsFinish();
        this.h = new Z(this.f17966a);
        this.k = new E(this.f17966a, this.f17968c, this.B, this.C, this.D, this);
        this.i = new M(this.f17966a, game, this, this);
        this.i.a(this.y);
        this.i.b(this.E);
        this.i.d(this.z);
        this.i.a(this.K);
        this.i.a(this.f17967b);
        this.i.c(this.F);
        this.x.set(game);
        if (game != null) {
            this.I.set(String.valueOf(game.getPraiseNumber()));
            this.J.set(Boolean.valueOf(game.getAppreciate()));
        }
        a(true);
        CampaignManager.isShowCampaign(this.f17966a, this.r);
        CampaignManager.isCampaignHasRedPoint(this.f17966a, this.t);
        String str = this.f17968c;
        byte b2 = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != 96630216) {
            if (iHashCode == 96630249 && str.equals(StringConstant.LUCKY_BLOCK_HALL_GAME_ID)) {
                b2 = 1;
            }
        } else if (str.equals(StringConstant.BED_WAR_HALL_GAME_ID)) {
            b2 = 0;
        }
        if (b2 == 0) {
            this.H.set(Boolean.valueOf(SharedUtils.getBoolean(this.f17966a, SharedConstant.IS_BEDWARHALL_DISPLAYED)));
            this.G.set(1);
        } else if (b2 != 1) {
            this.G.set(0);
        } else {
            this.G.set(2);
        }
        this.h.a(this.f17966a, this.f17968c);
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }

    public /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            ReportDataAdapter.onEvent(this.f17966a, EventConstant.HOME_LUCKYBOX_TAB);
        }
    }

    public /* synthetic */ void a(ChristmasLevel christmasLevel) {
        AppConfig appConfig;
        Context context;
        if (christmasLevel == null || (appConfig = AppInfoCenter.newInstance().getAppConfig()) == null || !appConfig.isShowActivity() || BaseApplication.getApp().getMetaDataAppVersion() < appConfig.getActivityVersionCode() || (context = this.f17966a) == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).isFinishing();
    }

    public /* synthetic */ void a(Integer num) {
        if (this.x.get() == null || this.x.get().getTurntableStatus() != 1 || this.f17969d == num.intValue()) {
            return;
        }
        if (this.x.get().getTurntableRemainCount() > 0 || this.x.get().getTurntableRemainCount() == -1) {
            if (num.intValue() == 2) {
                this.h.a(4);
            } else {
                this.h.a(0);
            }
            this.f17969d = num.intValue();
        }
    }

    @Override // com.sandboxol.gamedetail.c.a.a.wa
    public void b(Game game) {
        this.p.set(false);
        this.h.a(this.f17966a, game.getGameId(), this.p, this.u, this.w, this.v, game);
    }

    private void a(boolean z) {
        if (z) {
            if (!this.f17968c.equals(StringConstant.ENDER_VS_SLENDER_GAME_ID) && !this.f17968c.equals(StringConstant.DRAGON_EGG_GAME_ID)) {
                b(R.id.tab_introduction);
            } else {
                b(R.id.tab_shop);
            }
        }
    }

    private void a(int i, BaseFragment baseFragment, Bundle bundle) {
        AbstractC0336n fragmentManager = this.j.getFragmentManager();
        if (fragmentManager != null) {
            androidx.fragment.app.F fA = fragmentManager.a();
            fA.a(0);
            if (baseFragment == null) {
                if (i == 0) {
                    this.m = new com.sandboxol.gamedetail.c.a.b.f();
                    baseFragment = this.m;
                    if (bundle != null) {
                        baseFragment.setArguments(bundle);
                    }
                    if (fragmentManager.a("introduceFragment") == null) {
                        fA.a(R.id.flGameDetail, baseFragment, "introduceFragment");
                        fA.c(baseFragment);
                    }
                } else if (i == 1) {
                    this.n = new com.sandboxol.gamedetail.c.a.d.f();
                    baseFragment = this.n;
                    if (bundle != null) {
                        baseFragment.setArguments(bundle);
                    }
                    if (fragmentManager.a("gameDetailShopFragment") == null) {
                        fA.a(R.id.flGameDetail, baseFragment, "gameDetailShopFragment");
                        fA.c(baseFragment);
                    }
                } else if (i == 2) {
                    this.o = new com.sandboxol.gamedetail.c.a.c.f();
                    baseFragment = this.o;
                    if (bundle != null) {
                        baseFragment.setArguments(bundle);
                    }
                    if (fragmentManager.a("gameDetailRankFragment") == null) {
                        fA.a(R.id.flGameDetail, baseFragment, "gameDetailRankFragment");
                        fA.c(baseFragment);
                    }
                }
            }
            BaseFragment baseFragment2 = this.l;
            if (baseFragment2 != null) {
                fA.c(baseFragment2);
            }
            fA.e(baseFragment);
            this.l = baseFragment;
            fA.b();
        }
    }

    @Override // com.sandboxol.gamedetail.c.a.a.wa
    public void a(Game game) {
        this.I.set(String.valueOf(game.getPraiseNumber()));
        this.J.set(Boolean.valueOf(game.getAppreciate()));
        a(game, true);
    }

    @Override // com.sandboxol.gamedetail.c.a.a.wa
    public void a(boolean z, List<AppEngineResourceUpdateResult> list, Game game) {
        this.f17971f = list;
        if (z) {
            int i = this.g;
            if (i == 1) {
                b.h.b.a.j.a(this.f17966a, this.f17968c);
                this.i.b(this.x.get(), this.f17971f);
            } else if (i == 2) {
                this.i.c(this.x.get(), this.f17971f);
            } else {
                if (i != 3) {
                    return;
                }
                this.i.a(this.x.get(), this.f17971f);
            }
        }
    }

    @Override // com.sandboxol.gamedetail.c.a.a.wa
    public void a(Game game, boolean z) {
        this.x.set(game);
        if (!this.f17968c.equals(StringConstant.ENDER_VS_SLENDER_GAME_ID) && !this.f17968c.equals(StringConstant.DRAGON_EGG_GAME_ID)) {
            H();
        } else {
            J();
        }
        if (z) {
            this.p.set(true);
            this.h.a(this.u, this.v, this.w, game);
        } else {
            this.p.set(false);
        }
        if (SharedUtils.getBoolean(this.f17966a, SharedConstant.FIRST_ENTER_GAME, true) && game.getIsPay() != 1 && AppInfoCenter.newInstance().getAppConfig().isShowGameGuide()) {
            SharedUtils.putBoolean(this.f17966a, SharedConstant.FIRST_ENTER_GAME, false);
            com.sandboxol.gamedetail.view.dialog.d dVar = new com.sandboxol.gamedetail.view.dialog.d(this.f17966a, game.getIsOpenParty() == 1, this.G.get().intValue(), this);
            dVar.a(new OnViewClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.q
                @Override // com.sandboxol.common.listener.OnViewClickListener
                public final void onClick() {
                    this.f18025a.j();
                }
            });
            dVar.show();
        }
    }
}
