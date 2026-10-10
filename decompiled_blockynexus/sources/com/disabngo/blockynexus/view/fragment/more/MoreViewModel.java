package com.disabngo.blockynexus.view.fragment.more;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.He;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.VideoStarConfig;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.greendao.c.P;
import com.tendcloud.tenddata.ab;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class MoreViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private He f11847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f11848c = new ObservableField<>("");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f11849d = new ObservableField<>(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f11850e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f11851f = new ObservableField<>(false);
    public ObservableField<Boolean> g = new ObservableField<>(true);
    public ObservableField<Boolean> h = new ObservableField<>(true);
    public ObservableField<Boolean> i = new ObservableField<>(true);
    public ObservableField<Boolean> j = new ObservableField<>(true);
    public ObservableField<VideoStarConfig> k = new ObservableField<>(new VideoStarConfig());
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.n
        @Override // rx.functions.Action0
        public final void call() {
            this.f11865a.I();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.v
        @Override // rx.functions.Action0
        public final void call() {
            this.f11873a.K();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f11857a.P();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.w
        @Override // rx.functions.Action0
        public final void call() {
            this.f11874a.M();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f11856a.R();
        }
    });
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f11862a.G();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.o
        @Override // rx.functions.Action0
        public final void call() {
            this.f11866a.N();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.x
        @Override // rx.functions.Action0
        public final void call() {
            this.f11875a.H();
        }
    });
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.r
        @Override // rx.functions.Action0
        public final void call() {
            this.f11869a.Q();
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f11861a.O();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f11863a.E();
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f11859a.F();
        }
    });
    public ReplyCommand x = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f11853a.J();
        }
    });
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f11858a.D();
        }
    });
    public ReplyCommand z = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.t
        @Override // rx.functions.Action0
        public final void call() {
            this.f11871a.L();
        }
    });
    public ReplyCommand A = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f11852a.i();
        }
    });
    public ReplyCommand B = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11854a.j();
        }
    });

    public MoreViewModel(Context context) {
        this.f11846a = context;
        p();
        initMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(StringConstant.STAR_CONFIG, this.k.get());
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.i.d.class, context.getString(R.string.fragment_cash_title), bundle);
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.STAR_CLICK_STARSINFO_TOPUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.STAR_CLICK_STARSINFO_UPPER);
        this.h.set(Boolean.valueOf(!r0.get().booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        new TwoButtonDialog(this.f11846a).setDetailText(R.string.more_diamond_whether_exchange).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.fragment.more.q
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f11868a.l();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (TextUtils.isEmpty(AppInfoCenter.newInstance().getAppConfig().getNewGratitudeUrl())) {
            AppToastUtils.showShortNegativeTipToast(this.f11846a, R.string.coming_soon);
        } else {
            WebViewActivity.a(this.f11846a, AppInfoCenter.newInstance().getAppConfig().getNewGratitudeUrl() + "?tab=0&userId=" + AccountCenter.newInstance().userId.get() + "&accessToken=" + AccountCenter.newInstance().token.get(), this.f11846a.getString(R.string.gratitude));
        }
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.THANK_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.J.f.class, context.getString(R.string.me_help));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_HELP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.L.c.class, context.getString(R.string.me_inbox), R.mipmap.ic_inbox_delete);
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_INBOX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.M.b.class, context.getString(R.string.more_tv_income_detail, ""));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.STAR_CLICK_STARSINFO_BALANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        Context context = this.f11846a;
        TemplateHelper.startTemplate(context, com.disabngo.blockynexus.view.fragment.partyhall.p.class, context.getString(R.string.party_create_party_hall));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.CLICK_PARTY_LIST);
        com.apkfuns.logutils.c.a(ab.u).d("onEvent being called! eventEvent: 点击派对大厅");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        com.disabngo.blockynexus.d.D.b((Activity) this.f11846a);
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_RANKING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.sandboxol.googlepay.view.fragment.recharge.k.class, context.getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_TOPUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ia.k.class, context.getString(R.string.me_setting));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_SETUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ja.c.class, context.getString(R.string.me_share));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_SHARE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        DressManager.startShopActivity(this.f11846a);
        SandboxReportManager.onEvent(ReportEvent.NEW_DRESS_SHOP, ReportEventType.NEW_USER_BEHAVIOR, "app");
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_SHOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            P.newInstance().a(AccountCenter.newInstance().getMyInfo().getUserId(), new D(this));
            ReportDataAdapter.onEvent(this.f11846a, EventConstant.MORE_PERSINFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        Context context = this.f11846a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.wa.b.class, context.getString(R.string.activity_video));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.HOME_VEDIO_CLICK);
    }

    private void S() {
        BillingManager.getInstance().updateUserMoney(this.f11846a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        new C().a(this.f11846a);
    }

    private void initData() {
        boolean z = false;
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            u();
        } else {
            ObservableField<String> observableField = this.f11848c;
            Context context = this.f11846a;
            observableField.set(context.getString(R.string.more_fragment_details, context.getString(R.string.more_fragment_no_details)));
        }
        String gratitudeUrl = AppInfoCenter.newInstance().getAppConfig().getGratitudeUrl();
        ObservableField<Boolean> observableField2 = this.g;
        if (gratitudeUrl != null && gratitudeUrl.length() > 0) {
            z = true;
        }
        observableField2.set(Boolean.valueOf(z));
        this.f11851f.set(Boolean.valueOf(AccountCenter.newInstance().isPerfectUserInfo()));
        if (!TextUtils.equals(AccountCenter.newInstance().account.get(), this.f11846a.getString(R.string.base_more_user_no_account))) {
            this.j.set(true);
            return;
        }
        this.j.set(Boolean.valueOf(SharedUtils.getBoolean(this.f11846a, SharedConstant.IS_HIDE_ACCOUNT_TIPS + AccountCenter.newInstance().userId.get())));
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.UNSET_USERNAME);
    }

    private void initMessage() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_ACCOUNT, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.more.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11864a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_IS_HAS_NEW_EMAIL, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.more.s
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11870a.a((Boolean) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CACHE_REFRESH, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.u
            @Override // rx.functions.Action0
            public final void call() {
                this.f11872a.p();
            }
        });
        Messenger.getDefault().register(this, MessageToken.UPDATE_USER_INFO, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f11860a.T();
            }
        });
        Messenger.getDefault().register(this, MessageToken.UPDATE_USER_INFO_RED_POINT, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.y
            @Override // rx.functions.Action0
            public final void call() {
                this.f11876a.h();
            }
        });
        Messenger.getDefault().register(this, MessageToken.UPDATE_STAR_CODE_CONFIG, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.more.z
            @Override // rx.functions.Action0
            public final void call() {
                this.f11877a.f();
            }
        });
    }

    private void onClickAccount() {
        new TwoButtonDialog(this.f11846a).setDetailText(AccountCenter.newInstance().hasPassword.get().booleanValue() ? R.string.login_account_set_account : R.string.login_account_set_account_no_password).setRightButtonText(R.string.sure).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.fragment.more.d
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f11855a.k();
            }
        }).show();
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.USERNAME_SET_TIPS_POPUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Observable.just(MoreViewModel.class).flatMap(new Func1() { // from class: com.disabngo.blockynexus.view.fragment.more.p
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return this.f11867a.a((Class) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new H(this));
    }

    private void u() {
        if (TextUtils.isEmpty(AccountCenter.newInstance().detail.get())) {
            ObservableField<String> observableField = this.f11848c;
            Context context = this.f11846a;
            observableField.set(context.getString(R.string.more_fragment_details, context.getString(R.string.more_fragment_no_details)));
        } else {
            this.f11848c.set(this.f11846a.getString(R.string.more_fragment_details, AccountCenter.newInstance().detail.get()));
        }
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            S();
            this.i.set(Boolean.valueOf(TextUtils.equals(AccountCenter.newInstance().account.get(), this.f11846a.getString(R.string.base_more_user_no_account))));
        }
        f();
    }

    public void f() {
        if (!AccountCenter.newInstance().login.get().booleanValue() || TextUtils.isEmpty(AccountCenter.newInstance().starCode.get())) {
            return;
        }
        UserApi.getStarCodeConfig(this.f11846a, new F(this));
        UserApi.getStarCodeUserInfo(this.f11846a, AccountCenter.newInstance().starCode.get(), new G(this));
    }

    public /* synthetic */ void h() {
        this.f11851f.set(Boolean.valueOf(AccountCenter.newInstance().isPerfectUserInfo()));
    }

    public /* synthetic */ void i() {
        onClickAccount();
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.CLICK_USERNAME_QUESTION);
    }

    public /* synthetic */ void j() {
        this.j.set(true);
        SharedUtils.putBoolean(this.f11846a, SharedConstant.IS_HIDE_ACCOUNT_TIPS + AccountCenter.newInstance().userId.get(), true);
    }

    public /* synthetic */ void k() {
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.USERNAME_SET_TIPS_CLICK_GO);
        if (TextUtils.equals(AccountCenter.newInstance().account.get(), this.f11846a.getString(R.string.base_more_user_no_account))) {
            if (AccountCenter.newInstance().hasPassword.get().booleanValue()) {
                Context context = this.f11846a;
                LoginManager.onConfirmPassword(context, context.getString(R.string.login_more_set_account));
            } else {
                Context context2 = this.f11846a;
                LoginManager.onSetPassword(context2, context2.getString(R.string.account_safe_set_password));
            }
        }
    }

    public /* synthetic */ void l() {
        ReportDataAdapter.onEvent(this.f11846a, EventConstant.STAR_CLICK_STARSINFO_CONVERT);
        UserApi.putCashExchange(this.f11846a, new E(this));
    }

    public void m() {
        if (!AccountCenter.newInstance().login.get().booleanValue() || TextUtils.isEmpty(AccountCenter.newInstance().starCode.get())) {
            return;
        }
        S();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        if (!TextUtils.isEmpty(AccountCenter.newInstance().starCode.get())) {
            ReportDataAdapter.onEvent(this.f11846a, EventConstant.STAR_SHOW_STARSINFO);
        }
        m();
    }

    public void a(He he) {
        this.f11847b = he;
        initData();
    }

    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 3) {
            ObservableField<String> observableField = this.f11848c;
            Context context = this.f11846a;
            observableField.set(context.getString(R.string.more_fragment_details, context.getString(R.string.more_fragment_no_details)));
        } else if (num.intValue() != 4 && num.intValue() == 5) {
            if (AccountCenter.newInstance().login.get().booleanValue()) {
                new com.disabngo.blockynexus.e.b.za.b().a(this.f11846a);
            }
        } else {
            u();
        }
        this.f11851f.set(Boolean.valueOf(AccountCenter.newInstance().isPerfectUserInfo()));
    }

    public /* synthetic */ void a(Boolean bool) {
        this.f11849d.set(bool);
    }

    public /* synthetic */ Observable a(Class cls) {
        return Observable.just(Boolean.valueOf((b.h.b.a.g.a(this.f11846a, 0, BaseApplication.getApp().getMetaDataRootPath()) / 1024) / 1024 > 300));
    }
}
