package com.disabngo.blockynexus;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.webkit.WebView;
import com.disabngo.blockynexus.d.F;
import com.disabngo.blockynexus.receiver.RongCloudPushReceiver;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.google.gson.j;
import com.localapi.LocalServer;
import com.sandboxol.adsoversea.config.AdsSourcesType;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.download.client.DownloadClient;
import com.sandboxol.center.router.manager.AppManager;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.router.module_application.ModuleApplication;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.utils.DialogUtilsWrap;
import com.sandboxol.center.utils.Logger;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.imchat.config.BroadcastConstant;
import com.sandboxol.messager.MessagerClient;
import io.reactivex.exceptions.UndeliverableException;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class App extends BaseApplication {
    static /* synthetic */ void a(Throwable th) throws Exception {
        if ((th instanceof UndeliverableException) || th.getMessage() == null) {
            return;
        }
        Log.w("APP", th.getMessage());
    }

    private void b() {
        BaseApplication.getApp().setBaseUrl("http://127.0.0.1:18080");
        BaseApplication.getApp().setBackupBaseUrl("http://127.0.0.1:18080");
        BaseApplication.getApp().setVersionCode(4003);
        BaseApplication.getApp().setRootPath("SandboxOL");
    }

    private void c() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        if (getResources() == null) {
            Process.killProcess(Process.myPid());
        }
    }

    private void d() {
        BaseModuleApp.getBaseModuleApp().setApplicationId("com.disabngo.blockynexus");
        BaseModuleApp.getBaseModuleApp().setActivityId(ActivityType.SLOT_MACHINE);
        BaseModuleApp.getBaseModuleApp().setBeta(e.f9062f.booleanValue());
        BaseModuleApp.getBaseModuleApp().setCopyV1ToV2(e.f9058b.booleanValue());
        BaseModuleApp.getBaseModuleApp().setChina(e.f9060d.booleanValue());
        BaseModuleApp.getBaseModuleApp().setChannelId(StringConstant.THIRD_PART_LOGIN_GOOGLE);
        BaseModuleApp.getBaseModuleApp().setOpenMtp(e.f9059c.booleanValue());
        BaseModuleApp.getBaseModuleApp().setThirdPartPayUrl("https://www.blockmango.net/recharge.html#/");
        BaseModuleApp.getBaseModuleApp().setPayUrl("http://127.0.0.1:18080/web/public/pay/api/v2/public/pay/signature");
        BaseModuleApp.getBaseModuleApp().setBlockmanOrganizeTeam("team.game.sandboxol.com:9921");
        BaseModuleApp.getBaseModuleApp().setGoogleKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArZ1Y9l2zkLi6NlDlj89wU/zKhqo30+4Rv+JbKL878c3Oe+ZgvtE9+njdD8Yx3b5mZ91G8ZEDcgOB9WztUDPd/PoqDZmY7dH97IyLM5UpZYMbtFG+8oauK/SO2ic+dINNH9pvBKeFqw2Iud71/8cNXUx6IrlY9f+PqhSN34R70NyC+rTIhG56KZCDEXrU9YTx+aL0ggM/BD+miZKyflkqq1OTOG5U2fDAyiqmbOgxGPDIq8BjV5Y6MCZcnYa7xWQrGH+MIilYXomUuoO4Yh/BtMrAECnBfs5ppXwL0WMDY3aBaZlS4uMiebJJ9Dp9rXBPNlYsPwTz0/FE1NWN+wO24wIDAQAB");
        BaseModuleApp.getBaseModuleApp().setUmKey("5c7894220cafb2931200065c");
        BaseModuleApp.getBaseModuleApp().setTalkingDataKey("D2D70DC78C2A45BD99D3983FB331F37D");
        BaseModuleApp.getBaseModuleApp().setEventType("");
        BaseModuleApp.getBaseModuleApp().setPackageName("blockymods");
        BaseModuleApp.getBaseModuleApp().setPackageType("Blockymods");
        BaseModuleApp.getBaseModuleApp().setIsPackNewEngineRes(e.f9061e.booleanValue());
        BaseModuleApp.getBaseModuleApp().setDownloadSdk("RxDownload4");
        BaseModuleApp.getBaseModuleApp().setAdsSources(AdsSourcesType.IRONSOURCE);
        BaseModuleApp.getBaseModuleApp().setAdmobKey("");
        BaseModuleApp.getBaseModuleApp().setAdmobInterstitialKey("");
        BaseModuleApp.getBaseModuleApp().setAdmobVideoKey("");
        BaseModuleApp.getBaseModuleApp().setIronsourceKey("9570423d");
        BaseModuleApp.getBaseModuleApp().setBroadcastType("com.disabngo.blockynexus");
    }

    private void e() {
        int iA = F.a(BaseApplication.getContext());
        boolean z = true;
        boolean z2 = iA == F.f7185a;
        boolean z3 = iA == F.f7187c;
        if (iA != F.f7188d && iA != F.f7189e) {
            z = false;
        }
        if (z2) {
            m();
            n();
        } else if (z3) {
            m();
        }
        if (z) {
            return;
        }
        l();
        ReportDataAdapter.onEvent(this, EventConstant.ENTER_SANDBOX_PAGE);
    }

    private void f() {
        DialogUtilsWrap.newsInstant().setImpl(DialogUtils.newsInstant());
    }

    private void g() {
        if (getApplicationInfo().packageName.equals(com.sandboxol.messager.b.a.a(this))) {
            DownloadClient.getInstance().onStart(BaseApplication.getContext());
            io.reactivex.e.a.a(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.b
                @Override // io.reactivex.b.g
                public final void accept(Object obj) throws Exception {
                    App.a((Throwable) obj);
                }
            });
        }
    }

    private void h() {
        AppManager.registerAppInBackground(this, new Action0() { // from class: com.disabngo.blockynexus.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f7146a.a();
            }
        }, null);
        AppManager.registerAppForScrapAnim(this);
    }

    private void i() {
        Logger.config(Logger.TYPE.WITH_THREAD_PATH, false);
    }

    private void j() {
        if (getApplicationInfo().packageName.equals(com.sandboxol.messager.b.a.a(this))) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BroadcastConstant.RongCloudChatOnLeft);
            intentFilter.addAction(BroadcastConstant.RongCloudPushRequestFriend);
            intentFilter.addAction(BroadcastConstant.RongCloudPushRequestClan);
            registerReceiver(new RongCloudPushReceiver(), intentFilter);
        }
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 28) {
            String strB = F.b(this);
            if (getPackageName().equals(strB)) {
                return;
            }
            WebView.setDataDirectorySuffix(strB);
        }
    }

    private void l() {
        AccountManager.getInstance().setAccountManagerImpl(new com.disabngo.blockynexus.service.e());
        MessagerClient.getIns().init(BaseApplication.getContext());
        ModuleApplication.getInstance().onCreate(this);
        b();
        d();
        i();
        f.a(this);
        j();
        g();
        k();
        EngineEnv.init();
        h();
        ChannelManager.init(BaseApplication.getContext());
        f();
    }

    private void m() {
        com.github.moduth.blockcanary.a.a(this, new d()).b();
        N.j();
    }

    private void n() {
    }

    @Override // com.sandboxol.common.base.app.BaseApplication, com.tencent.tpshell.TPShellApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        androidx.multidex.a.a(this);
    }

    @Override // com.sandboxol.common.base.app.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        LocalServer.startIfNeeded(this);
        c();
        e();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        MessagerClient.getIns().unInit(this);
        DownloadClient.getInstance().onDestroy();
        ModuleApplication.getInstance().onDestroy(this);
        DressManager.onDestroy();
    }

    public /* synthetic */ void a() {
        new bc().a(this, "android", CommonHelper.getAndroidId(this));
        SandboxReportManager.onEvent(ReportEvent.USER_DEVICE_INFO, ReportEventType.DEVICE_INFO_BEHAVIOR, "app", new j().a(F.c(BaseApplication.getContext())));
    }
}
