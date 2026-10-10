package com.sandboxol.blocky.router;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.sandboxol.blockmango.BlockManEchoesActivity;
import com.sandboxol.blocky.activity.StartMcActivity;
import com.sandboxol.blocky.service.McProcessChangeDataService;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.report.NewReportEvent;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.GameSharedUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.game.c;
import java.util.HashMap;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public abstract class Controller extends Handler {
    protected Context mContext;
    protected String mGameName;
    private c mIMcProcessChangeDataInterface;
    protected String mMeNickName;
    protected long mMeUserId;
    public final int mStartBlockManMsgWhat = 10088;
    protected final int mStartMcResultCodeWhat = 18825;
    protected final int mcProcessHeartbeatCode = 1999;
    protected final int mLoadSoCodeWhat = 2000;
    protected final int mReportPingCode = 10089;
    protected boolean isHost = false;
    protected boolean isInit = false;
    private EnterRealmsResult mEnterRealmsResult = null;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.sandboxol.blocky.router.Controller.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Controller.this.mIMcProcessChangeDataInterface == null) {
                Controller.this.mIMcProcessChangeDataInterface = c.a.asInterface(iBinder);
                Controller.this.sendEmptyMessageDelayed(1999, 5000L);
            }
            Controller.this.log("onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Controller.this.mIMcProcessChangeDataInterface = null;
            Controller.this.log("onServiceDisconnected");
        }
    };

    protected Controller(Context context) {
        this.mContext = context;
        bindMcService();
        sendEmptyMessageDelayed(2000, 500L);
    }

    private boolean bindMcService() {
        return this.mContext.bindService(new Intent(this.mContext, (Class<?>) McProcessChangeDataService.class), this.mServiceConnection, 1);
    }

    public /* synthetic */ void a(Subscriber subscriber) {
        if (isInit()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String startGameInfo = GameSharedUtils.newInstance().getStartGameInfo();
        if (startGameInfo == null) {
            subscriber.onError(new Exception("gameInfo is null."));
            return;
        }
        EnterRealmsResult enterRealmsResult = (EnterRealmsResult) CommonHelper.formatObject(startGameInfo, EnterRealmsResult.class);
        if (enterRealmsResult == null || enterRealmsResult.getGame() == null) {
            subscriber.onError(new Exception("json decode error."));
            return;
        }
        EngineEnv.switchEngine(enterRealmsResult.getGame().getIsNewEngine(), enterRealmsResult.getGame().getIsUgc());
        EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).loadSO(this.mContext);
        setEnterRealmsResult(enterRealmsResult);
        subscriber.onNext(getEnterRealmsResult());
        Log.e("StartMcActivity", "===============================load so : " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public Context getContext() {
        return this.mContext;
    }

    public EnterRealmsResult getEnterRealmsResult() {
        return this.mEnterRealmsResult;
    }

    public int getFps() {
        return 999;
    }

    public String getMeNickName() {
        String str = this.mMeNickName;
        return str == null ? "" : str;
    }

    public long getMeUserId() {
        return this.mMeUserId;
    }

    public int getPing() {
        return 999;
    }

    public int getRaknetPing() {
        return 999;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1999) {
            BaseApplication.getThreadPool().setName("doHeartBeat");
            BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.sandboxol.blocky.router.Controller.3
                @Override // java.lang.Runnable
                public void run() {
                    if (Controller.this.mIMcProcessChangeDataInterface != null) {
                        try {
                            Controller.this.mIMcProcessChangeDataInterface.doHeartBeat();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        Controller.this.sendEmptyMessageDelayed(1999, 5000L);
                    }
                }
            });
            return;
        }
        if (i == 2000) {
            if (this.mContext instanceof StartMcActivity) {
                initData();
                return;
            }
            return;
        }
        if (i != 10088) {
            return;
        }
        if (!(this.mContext instanceof StartMcActivity)) {
            Log.d("Controller", "---------- startActivityForResult mContext ----------" + Process.myPid() + " :  " + System.currentTimeMillis() + this.mContext);
            Context context = this.mContext;
            if (context != null) {
                ((Activity) context).finish();
                return;
            }
            return;
        }
        removeMessages(18825);
        StartMcActivity startMcActivity = (StartMcActivity) this.mContext;
        if ("IndieGame".contains(BaseModuleApp.getBaseModuleApp().getMetaDataPackageType())) {
            try {
                startMcActivity.getIntent().setComponent(new ComponentName(this.mContext, Class.forName("com.sandboxol.indiegame.view.activity.game.IndieGameEchoesActivity")));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        } else {
            startMcActivity.getIntent().setComponent(new ComponentName(this.mContext, (Class<?>) BlockManEchoesActivity.class));
        }
        Log.d("Controller", "---------- startActivityForResult ----------" + Process.myPid() + " :  " + System.currentTimeMillis());
        startMcActivity.startActivityForResult(startMcActivity.getIntent(), 10001);
    }

    protected abstract void initClient();

    protected void initData() {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.blocky.router.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16304a.a((Subscriber) obj);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<EnterRealmsResult>() { // from class: com.sandboxol.blocky.router.Controller.2
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (th != null) {
                    th.printStackTrace();
                }
                ((Activity) Controller.this.mContext).finish();
            }

            @Override // rx.Observer
            public void onNext(EnterRealmsResult enterRealmsResult) {
                String gameId = enterRealmsResult.getGame().getGameId();
                SandboxReportManager.onEvent(ReportEvent.NEW_GAME_START_BASE + enterRealmsResult.getGame().getGameId(), enterRealmsResult.getGame().getGameId() + ReportEventType.GAME_INTER_BASE, gameId);
                SandboxReportManager.onEvent(ReportEvent.NEW_GAME_START_BASE + enterRealmsResult.getGame().getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
                NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, NewReportEvent.GAME_START);
                NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, NewReportEvent.NEW_GAME_START);
            }
        });
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void log(String str) {
        Log.e("router-jni", str);
    }

    public void onDataReport(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ReportDataAdapter.onEvent(this.mContext, str);
            Log.e("jni_onDataReport", String.format("mainEvent %s", str));
        } else {
            HashMap map = new HashMap();
            map.put("childEvent", str2);
            ReportDataAdapter.onEvent(this.mContext, str, str2, map);
            Log.e("jni_onDataReport", String.format("mainEvent %s childEvent %s", str, str2));
        }
    }

    public void onErrorReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ReportDataAdapter.onError(this.mContext, new Throwable(str));
        Log.e("jni_onErrorReport", String.format("msg %s", str));
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends Controller> T setEnterRealmsResult(EnterRealmsResult enterRealmsResult) {
        this.mEnterRealmsResult = enterRealmsResult;
        this.mGameName = this.mEnterRealmsResult.getGame().getGameName();
        this.mMeUserId = this.mEnterRealmsResult.getUserId();
        this.mMeNickName = this.mEnterRealmsResult.getUserName();
        initClient();
        return this;
    }

    public void stop() {
        removeMessages(10089);
        this.mContext = null;
        this.isHost = false;
        this.isInit = false;
        stopClient();
    }

    protected void stopClient() {
    }

    public void unbindMcService(Context context) {
        try {
            if (this.mServiceConnection != null) {
                context.unbindService(this.mServiceConnection);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
