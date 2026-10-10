package com.disabngo.blockynexus.e.b.p;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.databinding.Ve;
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.disabngo.blockynexus.view.dialog.ReportDialog;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.sandboxol.blockmango.config.GameStringConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.BlockAccountResult;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.DelayExecutor;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.utils.GameResVersionManager;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: CheckUpdateViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends ViewModel implements b.h.b.a.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f10044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f10045b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Subscription f10047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Ve f10048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SVGAImageView f10049f;
    private SVGAParser g;
    private com.disabngo.blockynexus.view.activity.start.p j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10046c = 0;
    private int h = 0;
    private int i = 0;
    private ObservableField<Boolean> k = new ObservableField<>(false);
    public ObservableField<String> l = new ObservableField<>();
    public ObservableField<String> m = new ObservableField<>();
    public ObservableField<Integer> n = new ObservableField<>(0);
    public ObservableField<String> o = new ObservableField<>("0%");
    public ObservableField<String> p = new ObservableField<>("");

    public o(final Activity activity, Ve ve) {
        this.f10044a = activity;
        this.f10048e = ve;
        this.m.set(activity.getResources().getString(R.string.app_prepare_text_progress));
        this.l.set(activity.getString(R.string.version_name, new Object[]{"1.24.4"}));
        D();
        p.a(activity);
        initMessage();
        new bc().a(activity, new Action0() { // from class: com.disabngo.blockynexus.e.b.p.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f10039a.a(activity);
            }
        });
        com.sandboxol.decorate.manager.o.a().b(BaseApplication.getContext());
    }

    private void D() {
        this.f10049f = this.f10048e.f7963c;
        this.g = new SVGAParser(this.f10044a);
        this.f10045b = new ArrayList();
        this.f10045b.add(this.f10044a.getString(R.string.app_prepare_tips_1));
        this.f10045b.add(this.f10044a.getString(R.string.app_prepare_tips_2));
        this.f10045b.add(this.f10044a.getString(R.string.app_prepare_tips_3));
        E();
    }

    private void E() {
        this.p.set(this.f10045b.get(this.f10046c));
        a("app_start_banner.svga");
        this.f10047d = Observable.interval(2975L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).onBackpressureDrop().subscribe((Subscriber<? super Long>) new m(this));
    }

    static /* synthetic */ void h() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        Process.killProcess(Process.myPid());
    }

    private void initMessage() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_AUTH_TOKEN_FINISH, new Action0() { // from class: com.disabngo.blockynexus.e.b.p.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f10031a.l();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.p.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10036a.a((Integer) obj);
            }
        });
    }

    private boolean m() {
        BlockAccountResult blockAccount = AppInfoCenter.newInstance().getBlockAccount();
        if (blockAccount == null) {
            return false;
        }
        new ReportDialog(this.f10044a, blockAccount).show();
        return true;
    }

    private boolean p() {
        ReportInfo reportInfo = (ReportInfo) new com.google.gson.j().a(SharedUtils.getString(this.f10044a, SharedConstant.REPORT_INFO), ReportInfo.class);
        if (reportInfo == null || 1 != reportInfo.getStatus() || reportInfo.getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
            return false;
        }
        new ReportDialog(this.f10044a, reportInfo).a(new ReportDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.p.k
            @Override // com.disabngo.blockynexus.view.dialog.ReportDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10041a.f();
            }
        }).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (!this.k.get().booleanValue()) {
            if (this.i < 20) {
                DelayExecutor.doDelay(500L, new DelayExecutor.OnDelayExecutorListener() { // from class: com.disabngo.blockynexus.e.b.p.a
                    @Override // com.sandboxol.center.utils.DelayExecutor.OnDelayExecutorListener
                    public final void onFinish() {
                        this.f10030a.j();
                    }
                });
                return;
            } else {
                ReportDataAdapter.onEvent(this.f10044a, EventConstant.NONETWORK_TIME, "CheckUpdateViewModel times out");
                new OneButtonDialog(this.f10044a).setButtonText(R.string.retry).setDetailText(R.string.connect_server_no_connect).setListener(new OneButtonDialog.OneButtonDialogListener() { // from class: com.disabngo.blockynexus.e.b.p.h
                    @Override // com.sandboxol.center.view.dialog.OneButtonDialog.OneButtonDialogListener
                    public final void onClick() {
                        this.f10037a.k();
                    }
                }).show();
                return;
            }
        }
        if (p() || m()) {
            return;
        }
        if (!AppInfoCenter.newInstance().isAuthTokenSuccess()) {
            LoginManager.forceReLogin(this.f10044a);
            Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_FINISH, new i(this));
            return;
        }
        D.d(this.f10044a);
        com.disabngo.blockynexus.d.a.e eVarB = com.disabngo.blockynexus.d.a.e.b();
        eVarB.a(this.f10044a);
        eVarB.a(SharedUtils.getLong(this.f10044a, SharedConstant.CLOTHES_RES_VERSION_CODE));
        GameDownloadUtils.gameDownload(this.f10044a);
        com.disabngo.blockynexus.d.m.a(this.f10044a);
        this.f10044a.finish();
    }

    @Override // b.h.b.a.h
    public void e() {
        if (this.h == 0) {
            this.n.set(50);
            this.o.set("50%");
            DelayExecutor.doDelay(500L, new DelayExecutor.OnDelayExecutorListener() { // from class: com.disabngo.blockynexus.e.b.p.d
                @Override // com.sandboxol.center.utils.DelayExecutor.OnDelayExecutorListener
                public final void onFinish() {
                    this.f10033a.i();
                }
            });
        } else {
            this.n.set(100);
            this.o.set("100%");
            this.m.set(this.f10044a.getString(R.string.app_resource_check_finish));
        }
        ReportDataAdapter.onEvent(this.f10044a, ReportEvent.APP_SOURCE_CHECK_END);
        c(this.f10044a);
        SandboxReportManager.onEvent("new_home_startapp", ReportEventType.NEW_USER_BEHAVIOR, "app");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, "home_startapp");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, "new_home_startapp");
        if (SharedUtils.getBoolean((Context) this.f10044a, SharedConstant.KEY_STOP_SERVICIE, false)) {
            new com.disabngo.blockynexus.e.a.a.l().a(this.f10044a, new OnViewClickListener() { // from class: com.disabngo.blockynexus.e.b.p.f
                @Override // com.disabngo.blockynexus.interfaces.OnViewClickListener
                public final void onClick() {
                    this.f10035a.u();
                }
            });
        } else {
            u();
        }
    }

    public /* synthetic */ void f() {
        LoginManager.forceReLogin(this.f10044a);
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_FINISH, new i(this));
    }

    public /* synthetic */ void i() {
        this.n.set(100);
        this.o.set("100%");
        this.m.set(this.f10044a.getString(R.string.app_resource_check_finish));
    }

    public /* synthetic */ void j() {
        this.i++;
        u();
    }

    public /* synthetic */ void k() {
        this.i = 0;
        if (this.j == null) {
            this.j = new com.disabngo.blockynexus.view.activity.start.p();
        }
        this.j.a(this.f10044a);
        u();
    }

    public /* synthetic */ void l() {
        this.k.set(true);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
        this.f10047d.unsubscribe();
        this.f10049f.clearAnimation();
    }

    @Override // b.h.b.a.h
    public void b() {
        DialogUtils.newsInstant().showCloseAppDialog(this.f10044a);
    }

    @Override // b.h.b.a.h
    public void c() {
        new OneButtonDialog(this.f10044a).setButtonText(R.string.sure).setDetailText(R.string.copy_md5_failed).setListener(new OneButtonDialog.OneButtonDialogListener() { // from class: com.disabngo.blockynexus.e.b.p.c
            @Override // com.sandboxol.center.view.dialog.OneButtonDialog.OneButtonDialogListener
            public final void onClick() {
                o.h();
            }
        }).show();
        ReportDataAdapter.onEvent(this.f10044a, EventConstant.CHECK_MD5_FAILED);
    }

    static /* synthetic */ void b(Context context) {
        try {
            GameResVersionManager.defaultGameResVersionMap.put(StringConstant.KEY_DEFAULT_GAME_RES_VERSION_OLD_ENGINE, b.h.b.a.i.a(context.getAssets().open(EngineEnv.v1().getResAssertName() + File.separator + GameStringConstant.DEFAULT_GAME_RES_VERSION_FILENAME)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Activity activity) {
        new b.h.b.a.k(activity, StringConstant.THIRD_PART_LOGIN_GOOGLE, this);
    }

    @Override // b.h.b.a.h
    @SuppressLint({"DefaultLocale"})
    public void a(int i, int i2, int i3) {
        float f2 = (i * 100.0f) / i2;
        if (f2 >= 100.0f) {
            f2 = 100.0f;
        }
        if (f2 - this.h >= 1.0f) {
            int i4 = (int) f2;
            this.n.set(Integer.valueOf(i4));
            this.o.set(i4 + "%");
            this.h = i4;
            if (i3 != 1 || this.h < 100) {
                return;
            }
            this.h = 1;
        }
    }

    public void c(final Context context) {
        BaseApplication.getThreadPool().setName("readGameResVersionFile");
        BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.disabngo.blockynexus.e.b.p.e
            @Override // java.lang.Runnable
            public final void run() {
                o.b(context);
            }
        });
    }

    private void a(String str) {
        this.g.a(str, new n(this));
    }

    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 2 || num.intValue() == 1) {
            AppInfoCenter.newInstance().setAuthTokenSuccess(true);
            u();
        }
    }
}
