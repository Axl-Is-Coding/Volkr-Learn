package com.sandboxol.blockmango;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.sandboxol.blocky.router.Controller;
import com.sandboxol.blocky.router.RealmsController;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.pay.RechargeBroadcastType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.game.R;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.MiniGameToken;
import com.sandboxol.messager.MessagerClient;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class EchoesGLSurfaceView extends GLSurfaceView {
    private static EchoesGLSurfaceView mEchoesGLSurfaceView;
    private volatile boolean isInitGaming;
    private String mBaseUrl;
    public EchoesRenderer mEchoesRenderer;
    private boolean mIsNewStartModel;
    private boolean mIsResetGame;
    private EchoesHandler mMainHandler;
    private QueueThread mQueueThread;
    private Timer mTimer;
    private final String[] subGameids;

    /* JADX INFO: renamed from: com.sandboxol.blockmango.EchoesGLSurfaceView$1, reason: invalid class name */
    class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        public /* synthetic */ void a() {
            EchoesGLSurfaceView echoesGLSurfaceView = EchoesGLSurfaceView.this;
            if (echoesGLSurfaceView.mEchoesRenderer == null || echoesGLSurfaceView.isInitGaming) {
                return;
            }
            EchoesGLSurfaceView.this.mEchoesRenderer.onDrawFrame(null);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            EchoesGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.K
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16082a.a();
                }
            });
        }
    }

    class QueueThread extends Thread implements Runnable {
        private Vector<Runnable> mEventQueue = new Vector<>();
        private final Lock mLock = new Lock();

        final class Lock {
            Lock() {
            }
        }

        QueueThread() {
        }

        public void addQueue(Runnable runnable) {
            this.mEventQueue.add(runnable);
            lockNotify();
        }

        public void lockNotify() {
            synchronized (this.mLock) {
                this.mLock.notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (this.mEventQueue.isEmpty() || EchoesGLSurfaceView.this.isInitGaming) {
                    synchronized (this.mLock) {
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    this.mEventQueue.remove(0).run();
                }
            }
        }
    }

    public EchoesGLSurfaceView(Context context, String str) {
        super(context);
        this.mBaseUrl = "";
        this.isInitGaming = false;
        this.mIsResetGame = false;
        this.mIsNewStartModel = false;
        this.subGameids = new String[]{StringConstant.BED_WAR_HALL_GAME_ID, "g1042"};
        this.mQueueThread = new QueueThread();
        this.mQueueThread.start();
        this.mBaseUrl = str;
        initView();
    }

    private void cancelTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    public static EchoesGLSurfaceView getInstance() {
        return mEchoesGLSurfaceView;
    }

    private void initEngine(Controller controller) {
        this.mEchoesRenderer.handleNativeSetUserInfo(this.mBaseUrl, AccountCenter.newInstance().token.get(), controller.getEnterRealmsResult().getInviter());
        if ("IndieGame".contains(BaseModuleApp.getBaseModuleApp().getMetaDataPackageType())) {
            onGameActionTrigger(2);
        }
        this.mEchoesRenderer.handleInitGame(getResources().getDisplayMetrics().density, controller.getMeNickName(), controller.getMeUserId(), controller.getEnterRealmsResult().getUserToken(), controller.getEnterRealmsResult().getGameAddr(), controller.getEnterRealmsResult().getTimestamp(), CommonHelper.getGameLanguage(), controller.getEnterRealmsResult().getGame().getGameId(), controller.getEnterRealmsResult().getMapName() == null ? "hunger_game_1" : controller.getEnterRealmsResult().getMapId(), controller.getEnterRealmsResult().getMapUrl() == null ? "" : controller.getEnterRealmsResult().getMapUrl(), this.mEchoesRenderer.getScreenWidth(), this.mEchoesRenderer.getScreenHeight(), controller.getEnterRealmsResult().getRequestId(), controller.getEnterRealmsResult().getResVersion(), this.mIsNewStartModel, controller.getEnterRealmsResult().isTeam(), controller.getEnterRealmsResult().getCountry());
        controller.getEnterRealmsResult().setNewStartMadel(this.mIsNewStartModel);
        this.mEchoesRenderer.setInitOK(true);
        Message message = new Message();
        message.what = 5;
        this.mMainHandler.sendMessage(message);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isSocialGame(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case 96630148: goto L50;
                case 96630180: goto L46;
                case 96630217: goto L3c;
                case 96630218: goto L32;
                case 96630219: goto L28;
                case 96630241: goto L1e;
                case 96630243: goto L14;
                case 96630272: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "g1060"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 7
            goto L5b
        L14:
            java.lang.String r0 = "g1052"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 6
            goto L5b
        L1e:
            java.lang.String r0 = "g1050"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 5
            goto L5b
        L28:
            java.lang.String r0 = "g1049"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 4
            goto L5b
        L32:
            java.lang.String r0 = "g1048"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 3
            goto L5b
        L3c:
            java.lang.String r0 = "g1047"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 2
            goto L5b
        L46:
            java.lang.String r0 = "g1031"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 1
            goto L5b
        L50:
            java.lang.String r0 = "g1020"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 0
            goto L5b
        L5a:
            r4 = -1
        L5b:
            switch(r4) {
                case 0: goto L5f;
                case 1: goto L5f;
                case 2: goto L5f;
                case 3: goto L5f;
                case 4: goto L5f;
                case 5: goto L5f;
                case 6: goto L5f;
                case 7: goto L5f;
                default: goto L5e;
            }
        L5e:
            return r2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.blockmango.EchoesGLSurfaceView.isSocialGame(java.lang.String):boolean");
    }

    private void loadMiniGameToken(final String str, String str2, final long j, final String str3) {
        com.sandboxol.gameblocky.web.p.a(getContext(), j, str, str2, new OnResponseListener<MiniGameToken>() { // from class: com.sandboxol.blockmango.EchoesGLSurfaceView.2
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str4) {
                Log.e("web.loadMiniGameToken", "onError code: " + i + " msg: " + str4);
                EchoesGLSurfaceView.this.mIsResetGame = false;
                EchoesGLSurfaceView.this.onResetGameResult(7);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                Log.e("web.loadMiniGameToken", "onServerError code: " + i);
                EchoesGLSurfaceView.this.mIsResetGame = false;
                EchoesGLSurfaceView.this.onResetGameResult(7);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(MiniGameToken miniGameToken) {
                RealmsController me2 = RealmsController.getMe();
                if (me2 == null) {
                    Log.e("web.loadMiniGameToken", "controller is null.");
                    EchoesGLSurfaceView.this.onResetGameResult(7);
                    return;
                }
                me2.getEnterRealmsResult().setDispatchToken(miniGameToken.getToken());
                me2.getEnterRealmsResult().setUserToken(miniGameToken.getSignature());
                me2.getEnterRealmsResult().setDispatchUrl(miniGameToken.getDispUrl());
                me2.getEnterRealmsResult().setTimestamp(miniGameToken.getTimestamp());
                me2.getEnterRealmsResult().setMapUrl(miniGameToken.getDownloadUrl());
                me2.getEnterRealmsResult().setRegion(miniGameToken.getRegion());
                me2.getEnterRealmsResult().getGame().setGameId(str);
                me2.getEnterRealmsResult().setTargetUserId(j);
                me2.getEnterRealmsResult().setMapName(miniGameToken.getMapName());
                me2.getEnterRealmsResult().setMapId(miniGameToken.getMapName());
                me2.getEnterRealmsResult().setChatRoomId("");
                me2.getEnterRealmsResult().setGameAddr("");
                me2.getEnterRealmsResult().setResetIp(str3);
                if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
                    me2.getEnterRealmsResult().setCountry(miniGameToken.getCountry());
                }
                EchoesGLSurfaceView.this.initGame(true);
            }
        });
    }

    private void resetGameDispatch(final String str, String str2, final long j, final String str3, String str4, String str5) {
        com.sandboxol.gameblocky.web.p.a(getContext(), j, str, str2, str3, str4, str5, new OnResponseListener<Dispatch>() { // from class: com.sandboxol.blockmango.EchoesGLSurfaceView.3
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str6) {
                Log.e("web.resetGame", "onError code: " + i + " msg: " + str6);
                EchoesGLSurfaceView.this.mIsResetGame = false;
                if (EchoesGLSurfaceView.this.getContext() == null) {
                    return;
                }
                if (i == 3) {
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 4);
                    return;
                }
                if (i == 2010 || i == 2009) {
                    ToastUtils.showShortToast(EchoesGLSurfaceView.this.getContext(), R.string.game_version_too_low);
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 5);
                } else if (i != 2011) {
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 2);
                } else {
                    ToastUtils.showShortToast(EchoesGLSurfaceView.this.getContext(), R.string.game_version_not_match);
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 5);
                }
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                Log.e("web.resetGame", "onServerError code: " + i);
                EchoesGLSurfaceView.this.mIsResetGame = false;
                if (EchoesGLSurfaceView.this.getContext() == null) {
                    return;
                }
                int i2 = (AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 2;
                EchoesGLSurfaceView echoesGLSurfaceView = EchoesGLSurfaceView.this;
                if (!str3.isEmpty()) {
                    i2 = 6;
                }
                echoesGLSurfaceView.onResetGameResult(i2);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(Dispatch dispatch) {
                EchoesGLSurfaceView.this.mIsResetGame = false;
                RealmsController me2 = RealmsController.getMe();
                if (me2 == null) {
                    Log.e("web.resetGame", "controller is null.");
                    EchoesGLSurfaceView.this.onResetGameResult(6);
                    return;
                }
                me2.getEnterRealmsResult().getGame().setGameId(str);
                me2.getEnterRealmsResult().setGameAddr(dispatch.gAddr);
                me2.getEnterRealmsResult().setUserToken(dispatch.signature);
                me2.getEnterRealmsResult().setDispatchUrl(dispatch.dispUrl);
                me2.getEnterRealmsResult().setTimestamp(dispatch.timestamp);
                me2.getEnterRealmsResult().setChatRoomId(dispatch.chatRoomId);
                me2.getEnterRealmsResult().setMapName(dispatch.mapName);
                me2.getEnterRealmsResult().setMapUrl(dispatch.mapUrl);
                me2.getEnterRealmsResult().setMapId(dispatch.mapId);
                me2.getEnterRealmsResult().setRequestId(dispatch.requestIds.get(AccountCenter.newInstance().userId.get()));
                me2.getEnterRealmsResult().setTeam(false);
                EchoesGLSurfaceView.this.initGame(true);
            }
        });
    }

    private void startTimer() {
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            this.mTimer.schedule(new AnonymousClass1(), 0L, 600L);
        }
    }

    public void SetMainHandler(EchoesHandler echoesHandler) {
        this.mMainHandler = echoesHandler;
        this.mEchoesRenderer.SetMainHandler(echoesHandler);
    }

    public /* synthetic */ void a(int i, float f2, float f3) {
        this.mEchoesRenderer.handleActionDown(i, f2, f3);
    }

    public /* synthetic */ void b(int i, float f2, float f3) {
        this.mEchoesRenderer.handleActionDown(i, f2, f3);
    }

    public void buyActionResult(final int i, final int i2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ga
            @Override // java.lang.Runnable
            public final void run() {
                this.f16191a.a(i, i2);
            }
        });
    }

    public /* synthetic */ void c(int i, float f2, float f3) {
        this.mEchoesRenderer.handleActionUp(i, f2, f3);
    }

    public void changeSurface(final int i, final int i2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.pa
            @Override // java.lang.Runnable
            public final void run() {
                this.f16232a.b(i, i2);
            }
        });
    }

    public /* synthetic */ void d() {
        this.mEchoesRenderer.handleOnPause();
    }

    public /* synthetic */ void e() {
        this.mEchoesRenderer.handleOnResume();
    }

    public void exitGame() {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ja
            @Override // java.lang.Runnable
            public final void run() {
                this.f16205a.a();
            }
        });
    }

    public /* synthetic */ void f(int i) {
        this.mEchoesRenderer.handleOnNativeResetGameResult(i);
    }

    public void followGame(final long j, final String str) {
        if (this.mIsResetGame) {
            Log.e("web.followGame", "reset game dispatch ......");
            return;
        }
        this.mIsResetGame = true;
        this.mIsNewStartModel = false;
        com.sandboxol.gameblocky.web.p.a(str, j, new OnResponseListener<Dispatch>() { // from class: com.sandboxol.blockmango.EchoesGLSurfaceView.5
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str2) {
                Log.e("web.followGame", "onError code: " + i + " msg: " + str2);
                EchoesGLSurfaceView.this.mIsResetGame = false;
                if (EchoesGLSurfaceView.this.getContext() == null) {
                    return;
                }
                int i2 = 2;
                if (i == 2) {
                    EchoesGLSurfaceView.this.onResetGameResult(7);
                    return;
                }
                if (i == 3) {
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 4);
                    return;
                }
                if (i == 2010 || i == 2009) {
                    ToastUtils.showShortToast(EchoesGLSurfaceView.this.getContext(), R.string.game_version_too_low);
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 5);
                } else if (i == 2011) {
                    ToastUtils.showShortToast(EchoesGLSurfaceView.this.getContext(), R.string.game_version_not_match);
                    EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 5);
                } else {
                    if (AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) {
                        i2 = 3;
                    }
                    EchoesGLSurfaceView.this.onResetGameResult(i2);
                }
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                Log.e("web.followGame", "onServerError code: " + i);
                EchoesGLSurfaceView.this.mIsResetGame = false;
                if (EchoesGLSurfaceView.this.getContext() == null) {
                    return;
                }
                EchoesGLSurfaceView.this.onResetGameResult((AccountCenter.newInstance().login.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() == j) ? 3 : 2);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(Dispatch dispatch) {
                EchoesGLSurfaceView.this.mIsResetGame = false;
                RealmsController me2 = RealmsController.getMe();
                if (me2 == null) {
                    Log.e("web.followGame", "controller is null.");
                    EchoesGLSurfaceView.this.onResetGameResult(6);
                    return;
                }
                me2.getEnterRealmsResult().getGame().setGameId(str);
                me2.getEnterRealmsResult().setGameAddr(dispatch.gAddr);
                me2.getEnterRealmsResult().setUserToken(dispatch.signature);
                me2.getEnterRealmsResult().setDispatchUrl(dispatch.dispUrl);
                me2.getEnterRealmsResult().setTimestamp(dispatch.timestamp);
                me2.getEnterRealmsResult().setChatRoomId(dispatch.chatRoomId);
                me2.getEnterRealmsResult().setMapName(dispatch.mapName);
                me2.getEnterRealmsResult().setMapUrl(dispatch.mapUrl);
                me2.getEnterRealmsResult().setMapId(dispatch.mapId);
                me2.getEnterRealmsResult().setTargetUserId(j);
                me2.getEnterRealmsResult().setRequestId(dispatch.requestIds.get(AccountCenter.newInstance().userId.get()));
                me2.getEnterRealmsResult().setTeam(false);
                EchoesGLSurfaceView.this.initGame(true);
            }
        });
    }

    public /* synthetic */ void g(int i) {
        this.mEchoesRenderer.handleWatchAdSuccess(i);
    }

    public void gameExit() {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ca
            @Override // java.lang.Runnable
            public final void run() {
                this.f16170a.b();
            }
        });
    }

    public EchoesRenderer getRenderer() {
        return this.mEchoesRenderer;
    }

    public void hideRechargeBtn() {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f16106a.c();
            }
        });
    }

    public void initGame(final boolean z) {
        final RealmsController me2 = RealmsController.getMe();
        if (me2 != null) {
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ia
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16200a.a(z, me2);
                }
            });
            return;
        }
        try {
            ((Activity) getContext()).finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void initStartModel() {
        RealmsController me2 = RealmsController.getMe();
        if (me2 == null || !me2.getEnterRealmsResult().isNewStartMadel()) {
            return;
        }
        this.mIsNewStartModel = me2.getEnterRealmsResult().isNewStartMadel();
    }

    protected void initView() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setFocusableInTouchMode(true);
        mEchoesGLSurfaceView = this;
    }

    public void onCloseAd(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.M
            @Override // java.lang.Runnable
            public final void run() {
                this.f16093a.a(i);
            }
        });
    }

    public void onDestroy() {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.setInitOK(false);
            this.mEchoesRenderer.releaseRes();
        }
        cancelTimer();
    }

    public void onFriendOperationForAppHttpResult(final int i, final long j) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.aa
            @Override // java.lang.Runnable
            public final void run() {
                this.f16157a.a(i, j);
            }
        });
    }

    public void onGameActionTrigger(int i) {
        onGameActionTrigger(i, "");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(final int i, KeyEvent keyEvent) {
        if (this.isInitGaming) {
            return super.onKeyDown(i, keyEvent);
        }
        if (i == 4) {
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.O
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16100a.b(i);
                }
            });
            return true;
        }
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f16143a.c(i);
            }
        });
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(final int i, KeyEvent keyEvent) {
        if (this.isInitGaming) {
            return super.onKeyDown(i, keyEvent);
        }
        if (i == 4) {
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.fa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16186a.d(i);
                }
            });
            return true;
        }
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.oa
            @Override // java.lang.Runnable
            public final void run() {
                this.f16228a.e(i);
            }
        });
        return true;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        EchoesSound echoesSound = EchoesHelper.sEchoesSound;
        if (echoesSound != null) {
            echoesSound.setPause(true);
        }
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.U
            @Override // java.lang.Runnable
            public final void run() {
                this.f16123a.d();
            }
        });
        startTimer();
    }

    public void onRechargeResult(final int i, final int i2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.na
            @Override // java.lang.Runnable
            public final void run() {
                this.f16223a.c(i, i2);
            }
        });
    }

    public void onResetGameResult(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ma
            @Override // java.lang.Runnable
            public final void run() {
                this.f16219a.f(i);
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        EchoesSound echoesSound = EchoesHelper.sEchoesSound;
        if (echoesSound != null) {
            echoesSound.setPause(false);
        }
        super.onResume();
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.P
            @Override // java.lang.Runnable
            public final void run() {
                this.f16103a.e();
            }
        });
        cancelTimer();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (isInEditMode()) {
            return;
        }
        this.mEchoesRenderer.setScreenWidthAndHeight(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isInitGaming) {
            return true;
        }
        int pointerCount = motionEvent.getPointerCount();
        final int[] iArr = new int[pointerCount];
        final float[] fArr = new float[pointerCount];
        final float[] fArr2 = new float[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            fArr[i] = motionEvent.getX(i);
            fArr2[i] = motionEvent.getY(i);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            final int pointerId = motionEvent.getPointerId(0);
            final float f2 = fArr[0];
            final float f3 = fArr2[0];
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.S
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16112a.b(pointerId, f2, f3);
                }
            });
        } else if (action == 1) {
            final int pointerId2 = motionEvent.getPointerId(0);
            final float f4 = fArr[0];
            final float f5 = fArr2[0];
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.L
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16084a.d(pointerId2, f4, f5);
                }
            });
        } else if (action == 2) {
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.W
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16132a.a(iArr, fArr, fArr2);
                }
            });
        } else if (action == 3) {
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.T
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16118a.b(iArr, fArr, fArr2);
                }
            });
        } else if (action == 5) {
            int action2 = motionEvent.getAction() >> 8;
            final int pointerId3 = motionEvent.getPointerId(action2);
            final float x = motionEvent.getX(action2);
            final float y = motionEvent.getY(action2);
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.X
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16138a.a(pointerId3, x, y);
                }
            });
        } else if (action == 6) {
            int action3 = motionEvent.getAction() >> 8;
            final int pointerId4 = motionEvent.getPointerId(action3);
            final float x2 = motionEvent.getX(action3);
            final float y2 = motionEvent.getY(action3);
            queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.Z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16146a.c(pointerId4, x2, y2);
                }
            });
        }
        return true;
    }

    public void onVoiceOperationResult(final int i, final int i2, final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ea
            @Override // java.lang.Runnable
            public final void run() {
                this.f16178a.a(i, i2, str);
            }
        });
    }

    public void onWatchAdResult(final int i, final String str, final int i2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ka
            @Override // java.lang.Runnable
            public final void run() {
                this.f16209a.a(i, str, i2);
            }
        });
    }

    public void onWatchAdSuccess(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.N
            @Override // java.lang.Runnable
            public final void run() {
                this.f16096a.g(i);
            }
        });
    }

    public void resetGame(String str, String str2, long j, String str3, String str4, String str5) {
        if (this.mIsResetGame) {
            Log.e("web.loadMiniGameToken", "reset game dispatch ......");
            return;
        }
        this.mIsResetGame = true;
        RealmsController me2 = RealmsController.getMe();
        if (me2 == null || !me2.getEnterRealmsResult().isNewStartMadel() || isSocialGame(str)) {
            this.mIsNewStartModel = false;
            resetGameDispatch(str, str2, j, str3, str4, str5);
        } else {
            this.mIsNewStartModel = true;
            loadMiniGameToken(str, str2, j, str3);
        }
        for (String str6 : this.subGameids) {
            if (str6.equals(str)) {
                MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_SHOW_VIDEO_ADS);
            }
        }
    }

    public void setEchoesRenderer(EchoesRenderer echoesRenderer) {
        this.mEchoesRenderer = echoesRenderer;
        setRenderer(this.mEchoesRenderer);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int i, final int i2, final int i3) {
        this.mQueueThread.addQueue(new Runnable() { // from class: com.sandboxol.blockmango.V
            @Override // java.lang.Runnable
            public final void run() {
                this.f16125a.a(surfaceHolder, i, i2, i3);
            }
        });
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
        this.mQueueThread.addQueue(new Runnable() { // from class: com.sandboxol.blockmango.da
            @Override // java.lang.Runnable
            public final void run() {
                this.f16174a.a(surfaceHolder);
            }
        });
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
        this.mQueueThread.addQueue(new Runnable() { // from class: com.sandboxol.blockmango.ha
            @Override // java.lang.Runnable
            public final void run() {
                this.f16196a.b(surfaceHolder);
            }
        });
    }

    public void useProp(final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.la
            @Override // java.lang.Runnable
            public final void run() {
                this.f16215a.a(str);
            }
        });
    }

    public /* synthetic */ void a(int[] iArr, float[] fArr, float[] fArr2) {
        this.mEchoesRenderer.handleActionMove(iArr, fArr, fArr2);
    }

    public /* synthetic */ void b(int[] iArr, float[] fArr, float[] fArr2) {
        this.mEchoesRenderer.handleActionCancel(iArr, fArr, fArr2);
    }

    public /* synthetic */ void c(int i) {
        this.mEchoesRenderer.handleKeyDown(i);
    }

    public /* synthetic */ void d(int i, float f2, float f3) {
        this.mEchoesRenderer.handleActionUp(i, f2, f3);
    }

    public /* synthetic */ void e(int i) {
        this.mEchoesRenderer.handleKeyUp(i);
    }

    public void onGameActionTrigger(final int i, final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.blockmango.ba
            @Override // java.lang.Runnable
            public final void run() {
                this.f16165a.a(i, str);
            }
        });
    }

    public void resetGameDispatch() {
        final RealmsController me2 = RealmsController.getMe();
        if (me2 != null) {
            Log.e("web.resetGameDispatch1", new com.google.gson.j().a(me2.getEnterRealmsResult()));
            com.sandboxol.gameblocky.web.p.a(getContext(), me2.getEnterRealmsResult().getDispatchUrl(), me2.getEnterRealmsResult().getDispatchToken(), me2.getEnterRealmsResult().getTargetUserId(), me2.getEnterRealmsResult().getRegion(), me2.getEnterRealmsResult().getMapId(), me2.getEnterRealmsResult().getResetIp(), null, me2.getEnterRealmsResult().getCountry(), new OnResponseListener<Dispatch>() { // from class: com.sandboxol.blockmango.EchoesGLSurfaceView.4
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i, String str) {
                    Log.e("web.resetGameDispatch", "onError code: " + i + " msg: " + str);
                    EchoesGLSurfaceView.this.mIsResetGame = false;
                    if (EchoesGLSurfaceView.this.getContext() == null) {
                        return;
                    }
                    EchoesGLSurfaceView.this.onResetGameResult(7);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i) {
                    Log.e("web.resetGameDispatch", "onServerError code: " + i);
                    EchoesGLSurfaceView.this.mIsResetGame = false;
                    if (EchoesGLSurfaceView.this.getContext() == null) {
                        return;
                    }
                    EchoesGLSurfaceView.this.onResetGameResult(7);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(Dispatch dispatch) {
                    EchoesGLSurfaceView.this.mIsResetGame = false;
                    String[] strArrSplit = dispatch.gAddr.split(":");
                    String str = strArrSplit[0];
                    int iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                    Log.e("web.resetGameDispatch2", new com.google.gson.j().a(dispatch));
                    Map<Long, String> map = dispatch.requestIds;
                    if (map == null || map.size() == 0) {
                        EchoesGLSurfaceView.this.mEchoesRenderer.handleConnectServer(str, iIntValue, "");
                    } else {
                        EchoesGLSurfaceView.this.mEchoesRenderer.handleConnectServer(str, iIntValue, dispatch.requestIds.get(AccountCenter.newInstance().userId.get()));
                    }
                    me2.getEnterRealmsResult().getGame().getGameId();
                }
            });
        } else {
            Log.e("web.resetGameDispatch", "controller is null.");
            onResetGameResult(6);
        }
    }

    public /* synthetic */ void a(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    public /* synthetic */ void b(int i) {
        this.mEchoesRenderer.handleKeyDown(i);
    }

    public /* synthetic */ void c(int i, int i2) {
        this.mEchoesRenderer.handleRechargeResult(i, i2);
    }

    public /* synthetic */ void d(int i) {
        this.mEchoesRenderer.handleKeyUp(i);
    }

    public /* synthetic */ void a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        changeSurface(i2, i3);
    }

    public /* synthetic */ void b(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
    }

    public /* synthetic */ void c() {
        this.mEchoesRenderer.handleHideRechargeBtn();
    }

    public /* synthetic */ void b(int i, int i2) {
        this.mEchoesRenderer.handleSurfaceChanged(i, i2);
    }

    public /* synthetic */ void a(boolean z, Controller controller) {
        if (z) {
            Message message = new Message();
            message.what = 15;
            this.mMainHandler.sendMessage(message);
            this.mEchoesRenderer.handleOnDestroy();
        }
        this.isInitGaming = true;
        initEngine(controller);
        this.isInitGaming = false;
        this.mQueueThread.lockNotify();
    }

    public /* synthetic */ void b() {
        this.mEchoesRenderer.handleExitGame();
    }

    public EchoesGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBaseUrl = "";
        this.isInitGaming = false;
        this.mIsResetGame = false;
        this.mIsNewStartModel = false;
        this.subGameids = new String[]{StringConstant.BED_WAR_HALL_GAME_ID, "g1042"};
        this.mQueueThread = new QueueThread();
        this.mQueueThread.start();
        initView();
    }

    public /* synthetic */ void a() {
        this.mEchoesRenderer.handleOnDestroy();
    }

    public /* synthetic */ void a(String str) {
        this.mEchoesRenderer.handleUseProp(str);
    }

    public /* synthetic */ void a(int i, long j) {
        this.mEchoesRenderer.handleOnFriendOperationForAppHttpResult(i, j);
    }

    public /* synthetic */ void a(int i, String str) {
        this.mEchoesRenderer.handleGameActionTrigger(i, str);
    }

    public /* synthetic */ void a(int i, String str, int i2) {
        this.mEchoesRenderer.handleWatchAdResult(i, str, i2);
    }

    public /* synthetic */ void a(int i) {
        this.mEchoesRenderer.handleCloseAd(i);
    }

    public /* synthetic */ void a(int i, int i2) {
        this.mEchoesRenderer.handleBuyActionResult(i, i2);
    }

    public /* synthetic */ void a(int i, int i2, String str) {
        this.mEchoesRenderer.handleVoiceOperationResult(i, i2, str);
    }
}
