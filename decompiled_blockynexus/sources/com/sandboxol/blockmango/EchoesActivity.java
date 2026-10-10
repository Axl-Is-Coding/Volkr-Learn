package com.sandboxol.blockmango;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.sandboxol.blockmango.EchoesHandler;
import com.sandboxol.blockmango.EchoesHelper;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.blockmango.config.GameStringConstant;
import com.sandboxol.blockmango.entity.ChristmasLevel;
import com.sandboxol.blockmango.webvideo.WebVideoActivity;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.blocky.router.RealmsController;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.MTPManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.router.moduleInfo.pay.RechargeBroadcastType;
import com.sandboxol.center.router.moduleInfo.report.NewReportEvent;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.GameUtils;
import com.sandboxol.center.utils.GooglePlayPriceHelper;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.common.utils.PermissionUtils;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.game.R;
import com.sandboxol.messager.MessagerClient;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.fmod.FMOD;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EchoesActivity extends Activity implements EchoesHelper.EchoesHelperListener {
    private static final String TAG = "com.sandboxol.blockmango.EchoesActivity";
    private ChristmasLevel christmasLevel;
    private boolean isNextGame;
    protected EchoesGLSurfaceView mGLSurfaceView;
    protected String mGameId;
    protected EchoesHandler mHandler;
    protected EchoesRenderer mRenderer;
    private Timer mTimer;
    private boolean isGoPrepaid = false;
    private boolean isWatchAds = false;
    private boolean mtpInit = false;
    private long clickTime = 0;
    private boolean isNormal = true;
    public Handler mChildHandler = new Handler() { // from class: com.sandboxol.blockmango.EchoesActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (EchoesActivity.this.isFinishing()) {
                return;
            }
            Log.i(EchoesActivity.TAG, "Got an incoming message from the main thread - " + ((String) message.obj));
            int i = message.what;
            if (i != 10) {
                if (i == 16) {
                    EchoesActivity.this.RemoveLoadingView();
                    return;
                } else {
                    if (i != 17) {
                        return;
                    }
                    EchoesActivity.this.showFailedDialogForEngine2(message.getData().getString("tips"), message.getData().getBoolean("showInDialog"));
                    return;
                }
            }
            EchoesActivity.this.mRenderer.setUpdatingFlag(true);
            if (EchoesRenderer.nativeUpdateFiles() == 1) {
                EchoesActivity.this.mRenderer.setUpdatingFlag(false);
                Message message2 = new Message();
                message2.what = 4;
                message2.obj = new EchoesHandler.CopyComplete();
                EchoesActivity.this.mHandler.sendMessage(message2);
            }
        }
    };

    private void initBroadcastReceiver() {
        MessagerClient.getIns().registerMsg0(getClass(), RechargeBroadcastType.BROADCAST_GAME_BED_WAR_RECHARGE_SUCCESS, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.EchoesActivity.3
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = EchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onRechargeResult(3, 1);
                }
            }
        });
        MessagerClient.getIns().registerMsg0(getClass(), RechargeBroadcastType.BROADCAST_GAME_BED_WAR_RECHARGE_FAILED, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.EchoesActivity.4
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = EchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onRechargeResult(3, 0);
                }
            }
        });
        MessagerClient.getIns().registerMsg1(getClass(), GameBroadcastType.BROADCAST_SHOW_ENGINE1_ADS_RESULT, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.blockmango.EchoesActivity.5
            @Override // com.sandboxol.messager.a.b
            public void onCall(com.sandboxol.messager.a.f fVar) {
                int iA = fVar.a("game.ads.type", 0);
                String strC = fVar.c("game.ads.params");
                if (strC == null) {
                    strC = "";
                }
                boolean zA = fVar.a(GameConstant.GAME_ADS_IS_SUCCESS, true);
                EchoesGLSurfaceView echoesGLSurfaceView = EchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    if (zA) {
                        echoesGLSurfaceView.onWatchAdResult(iA, strC, 1);
                        EchoesActivity.this.mGLSurfaceView.onGameActionTrigger(5);
                    } else {
                        echoesGLSurfaceView.onWatchAdResult(iA, strC, 2);
                        EchoesActivity.this.mGLSurfaceView.onGameActionTrigger(5);
                    }
                }
                String strC2 = fVar.c("game.ads.id");
                if (strC2 == null) {
                    strC2 = "";
                }
                if ("".equals(strC2)) {
                    return;
                }
                MultiProcessSharedUtils.putBoolean(EchoesActivity.this, GameSharedConstant.IS_SHOW_DOUBLE_GOLD_ADS_SUCCESS, true);
            }
        });
        MessagerClient.getIns().registerMsg0(getClass(), GameBroadcastType.BROADCAST_SHOW_BED_WAR_UI, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.EchoesActivity.6
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = EchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onGameActionTrigger(21);
                }
            }
        });
    }

    public void DoMainInit() {
    }

    public abstract void RemoveLoadingView();

    public void SetUpdateTips(String str) {
    }

    public void SetVersionText(String str, String str2) {
    }

    public /* synthetic */ void a() {
        MTPManager.loginGameMTP(99, 0, String.valueOf(AccountCenter.newInstance().userId.get()), "");
        this.mtpInit = true;
        MTPManager.onAppResume();
    }

    public void addLoadingView() {
    }

    @Override // android.app.Activity
    public void finish() {
        EchoesGLSurfaceView echoesGLSurfaceView = this.mGLSurfaceView;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.onDestroy();
        }
        FMOD.close();
        Intent intent = new Intent();
        intent.putExtra(GameConstant.IS_NEXT_GAME, this.isNextGame);
        intent.putExtra(GameConstant.IS_GO_PREPAID, this.isGoPrepaid);
        intent.putExtra(GameConstant.CHRISTMAS_LEVEL_INFO, this.christmasLevel);
        intent.putExtra(GameConstant.IS_EXIT_NORMAL, this.isNormal);
        setResult(10001, intent);
        super.finish();
    }

    public void onAppActionTrigger(int i, String str) {
        if (i == 16) {
            if (RealmsController.getMe() == null || RealmsController.getMe().getEnterRealmsResult() == null || RealmsController.getMe().getEnterRealmsResult().getGame() == null) {
                return;
            }
            String gameId = RealmsController.getMe().getEnterRealmsResult().getGame().getGameId();
            SandboxReportManager.onEvent(str, gameId + ReportEventType.GAME_INTER_BASE, gameId);
            SandboxReportManager.onEvent(str, ReportEventType.NEW_USER_BEHAVIOR, "app");
            NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_NUMBER, str, gameId);
            NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_FREQUENCY, str, gameId);
            return;
        }
        if (i != 10000) {
            if (i != 10001) {
                switch (i) {
                    case 8:
                        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
                        fVar.b(StringConstant.KEY_SCREEN_SHOT_SHOW_URL_OR_PATH, str);
                        MessagerClient.getIns().sendMsg1(GameMessageToken.TOKEN_GAME_SCREEN_SHOT, fVar);
                        break;
                    case 9:
                        EchoesGLSurfaceView echoesGLSurfaceView = this.mGLSurfaceView;
                        if (echoesGLSurfaceView != null) {
                            echoesGLSurfaceView.onGameActionTrigger(10);
                        }
                        com.sandboxol.greendao.c.va.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), false);
                        break;
                    case 10:
                        EchoesGLSurfaceView echoesGLSurfaceView2 = this.mGLSurfaceView;
                        if (echoesGLSurfaceView2 != null) {
                            echoesGLSurfaceView2.onGameActionTrigger(11);
                        }
                        com.sandboxol.greendao.c.va.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), true);
                        break;
                }
                return;
            }
            return;
        }
        if (str != null) {
            try {
                Map<String, String> mapFunctionData = GameUtils.functionData(str);
                String str2 = mapFunctionData.get(GameStringConstant.FUNCTION_NAME);
                if (mapFunctionData.size() <= 0 || str2 == null) {
                    return;
                }
                byte b2 = -1;
                if (str2.hashCode() == -1081938042 && str2.equals(GameStringConstant.ON_WATCH_AUDIO)) {
                    b2 = 0;
                }
                if (b2 != 0) {
                    return;
                }
                Intent intent = new Intent(this, (Class<?>) WebVideoActivity.class);
                intent.putExtra(GameStringConstant.WEB_VIDEO, mapFunctionData.get("url"));
                startActivity(intent);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onCloseGame(int i) {
        this.isGoPrepaid = i == 2;
        finish();
        MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_CLOSE_GAME);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Log.d(TAG, "onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        EngineEnv.init();
        super.onCreate(bundle);
        this.mHandler = new EchoesHandler(this);
        initBroadcastReceiver();
        MTPManager.addReceiver();
        MTPManager.initGameMTP(Integer.valueOf(getString(R.string.mtp_game_id)).intValue(), getString(R.string.mtp_game_key), new Action0() { // from class: com.sandboxol.blockmango.E
            @Override // rx.functions.Action0
            public final void call() {
                this.f16061a.a();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        MessagerClient.getIns().unRegisterMsg(getClass());
        super.onDestroy();
        System.gc();
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onEditorDataReport(String str, String str2) {
    }

    public void onEngine2GetServerInfo() {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onExpResult(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.christmasLevel = new ChristmasLevel(i, i2, i3, i4, i5, i6, i7);
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onGameExit() {
        try {
            SandboxReportManager.onEvent(ReportEvent.NEW_GAME_QUITE_BASE + RealmsController.getMe().getEnterRealmsResult().getGame().getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
        } catch (NullPointerException e2) {
            Log.e(TAG, "onGameExit NullPointerException");
            ReportDataAdapter.onError(BaseApplication.getContext(), e2);
        }
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mGLSurfaceView.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mGLSurfaceView.onKeyUp(i, keyEvent);
    }

    public void onLoadMapComplete(int i) {
        if (i == 1) {
            String gameId = RealmsController.getMe().getEnterRealmsResult().getGame().getGameId();
            if (RealmsController.getMe().getEnterRealmsResult().isFollow()) {
                ReportDataAdapter.onEvent(this, EventConstant.FOLLOW_JIONGAMESUC);
            }
            ReportUtils.resDownloadReport(this, gameId, EventConstant.SHOW_GAME_PAGE);
            ReportDataAdapter.onEvent(this, "success_to_enter_game_page");
            SandboxReportManager.onEvent("new_game_enter_success_" + gameId, gameId + ReportEventType.GAME_INTER_BASE, gameId);
            SandboxReportManager.onEvent("new_game_enter_success_" + gameId, ReportEventType.NEW_USER_BEHAVIOR, "app");
            NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_NUMBER, "new_game_enter_success_" + gameId, gameId);
            NewSandboxReportManager.onGameEvent(NewReportEventType.FUNNEL_GAME_FREQUENCY, "new_game_enter_success_" + gameId, gameId);
            NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, NewReportEvent.GAME_ENTER_SUCCESS);
            NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, NewReportEvent.NEW_GAME_ENTER_SUCCESS);
            FirebaseUtils.onEvent(this, "success_to_enter_game_page");
        }
        if (this.mGLSurfaceView != null && BaseModuleApp.getBaseModuleApp().getIsBeta()) {
            this.mGLSurfaceView.hideRechargeBtn();
        }
        if (this.mGLSurfaceView != null) {
            MultiProcessSharedUtils.putBoolean(this, GameSharedConstant.IS_SHOW_DOUBLE_GOLD_ADS_SUCCESS, false);
            MultiProcessSharedUtils.getBoolean(this, "is.show.ads", new Action1<Boolean>() { // from class: com.sandboxol.blockmango.EchoesActivity.8
                @Override // rx.functions.Action1
                public void call(Boolean bool) {
                    if (bool.booleanValue()) {
                        EchoesActivity.this.mGLSurfaceView.onGameActionTrigger(4);
                        Log.e("isShowAds", String.valueOf(true));
                    } else {
                        EchoesActivity.this.mGLSurfaceView.onGameActionTrigger(5);
                        Log.e("isShowAds", String.valueOf(false));
                    }
                }
            });
            com.sandboxol.greendao.c.va.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), new com.sandboxol.greendao.a.c<Boolean>() { // from class: com.sandboxol.blockmango.EchoesActivity.9
                @Override // com.sandboxol.greendao.a.c
                public void onError(int i2, String str) {
                }

                @Override // com.sandboxol.greendao.a.c
                public void onSuccess(Boolean bool) {
                    if (PermissionUtils.checkAndApplyfPermissionActivity(EchoesActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 10001) && bool.booleanValue()) {
                        EchoesActivity.this.mGLSurfaceView.onGameActionTrigger(11);
                    } else {
                        EchoesActivity.this.mGLSurfaceView.onGameActionTrigger(10);
                    }
                }
            });
        }
    }

    public void onLoadingTips(String str, boolean z) {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onNextGame() {
        this.isNextGame = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.mGLSurfaceView.onPause();
        super.onPause();
        getWindow().clearFlags(128);
        if (!this.isWatchAds && this.mTimer == null) {
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.sandboxol.blockmango.EchoesActivity.7
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    EchoesActivity.this.finish();
                }
            }, 120000L);
        }
        if (this.mtpInit) {
            MTPManager.onAppPause();
        }
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onRecharge(int i) {
        if (BaseModuleApp.getBaseModuleApp().getIsBeta()) {
            AppToastUtils.showLongNegativeTipToast(this, getString(R.string.game_beta_not_support_recharge));
            return;
        }
        if (i == 1) {
            new com.sandboxol.recharge.dialog.rechargeshop.k(this).show();
            return;
        }
        if (i == 3 && System.currentTimeMillis() - this.clickTime >= 1000) {
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            Bundle bundle = new Bundle();
            bundle.putString(StringConstant.PRODUCT_ID, GooglePlayPriceHelper.GAME_BEDWAR_SUPER_PLAYER);
            fVar.a(bundle);
            MessagerClient.getIns().sendMsg1(RechargeBroadcastType.NAME_INTENT_UTILS, fVar);
            this.clickTime = System.currentTimeMillis();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mGLSurfaceView.onResume();
        super.onResume();
        getWindow().addFlags(128);
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        if (this.mtpInit) {
            MTPManager.onAppResume();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onWatchAd(final int i, final String str, final String str2) {
        MultiProcessSharedUtils.getBoolean(this, GameSharedConstant.IS_SHOW_DOUBLE_GOLD_ADS_SUCCESS, new Action1<Boolean>() { // from class: com.sandboxol.blockmango.EchoesActivity.2
            @Override // rx.functions.Action1
            public void call(Boolean bool) {
                if (bool.booleanValue() && "ResultPanelWatchAd".equals(str2)) {
                    ToastUtils.showShortToast(EchoesActivity.this, R.string.has_show_double_gold_in_single_game);
                    return;
                }
                com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
                fVar.b("game.id", EchoesActivity.this.mGameId);
                fVar.b("game.ads.type", i);
                fVar.b("game.ads.params", str);
                fVar.b("game.ads.id", str2);
                MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_VIEW_ENGINE1_ADS, fVar);
                EchoesGLSurfaceView echoesGLSurfaceView = EchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onGameActionTrigger(5);
                }
                MultiProcessSharedUtils.putBoolean(EchoesActivity.this, "is.show.ads", false);
                EchoesActivity.this.isWatchAds = true;
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            toggleHideBar();
        }
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void runOnGLThread(Runnable runnable) {
        this.mGLSurfaceView.queueEvent(runnable);
    }

    public void showDialog(String str, String str2) {
    }

    public void showEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showEditorDialog(int i) {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showEditorGallery(String str, int i, int i2) {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showEditorProgressBar(boolean z, int i, int i2, int i3) {
    }

    protected void showFailedDialogForEngine2(String str, boolean z) {
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showGameVideoAds(int i) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.SHOW_HIPPO_ADS_TYPE, i + 2);
        fVar.b(GameConstant.SHOW_HIPPO_ADS_GAME_ID, this.mGameId);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_GAME_SHOW_HIPPO_ADS, fVar);
    }

    public void showSmallEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
    }

    public void toggleHideBar() {
        if (getWindow() == null || getWindow().getDecorView() == null || Build.VERSION.SDK_INT <= 18) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onWatchAd(int i) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("game.id", this.mGameId);
        fVar.b("game.ads.type", i);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_VIEW_ENGINE2_ADS, fVar);
        EchoesGLSurfaceView echoesGLSurfaceView = this.mGLSurfaceView;
        if (echoesGLSurfaceView != null) {
            echoesGLSurfaceView.onGameActionTrigger(5);
        }
        MultiProcessSharedUtils.putBoolean(this, "is.show.ads", false);
        this.isWatchAds = true;
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onGameExit(String str) {
        try {
            this.isNormal = str.equals("normal");
            SandboxReportManager.onEvent(ReportEvent.NEW_GAME_QUITE_BASE + RealmsController.getMe().getEnterRealmsResult().getGame().getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
        } catch (NullPointerException e2) {
            Log.e(TAG, "onGameExit NullPointerException");
            ReportDataAdapter.onError(BaseApplication.getContext(), e2);
        }
        finish();
    }

    @Override // com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onRecharge(int i, String str) {
        if (BaseModuleApp.getBaseModuleApp().getIsBeta()) {
            AppToastUtils.showLongNegativeTipToast(this, getString(R.string.game_beta_not_support_recharge));
            return;
        }
        if (i == 1) {
            new com.sandboxol.recharge.dialog.rechargeshop.k(this, str).show();
            return;
        }
        if (i == 3 && System.currentTimeMillis() - this.clickTime >= 1000) {
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            Bundle bundle = new Bundle();
            bundle.putString(StringConstant.PRODUCT_ID, GooglePlayPriceHelper.GAME_BEDWAR_SUPER_PLAYER);
            fVar.a(bundle);
            MessagerClient.getIns().sendMsg1(RechargeBroadcastType.NAME_INTENT_UTILS, fVar);
            this.clickTime = System.currentTimeMillis();
        }
    }
}
