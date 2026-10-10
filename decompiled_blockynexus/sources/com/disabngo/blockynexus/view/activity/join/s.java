package com.disabngo.blockynexus.view.activity.join;

import android.os.RecoverySystem;
import android.util.Log;
import android.view.View;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.blockmango.GameFailedDialog;
import com.sandboxol.blockmango.GameResManager;
import com.sandboxol.blockmango.GameResNewUpdater;
import com.sandboxol.blocky.router.StartMc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.GameResInfo;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.AbstractEngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.MiniGameToken;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends ViewModel implements RecoverySystem.ProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnterGameActivity f10737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Game f10738b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GameResInfo f10740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GameResManager f10741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EnterRealmsResult f10742f;
    private AbstractEngineEnv g;
    private boolean h;
    private String i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10739c = 0;
    public ObservableField<Integer> j = new ObservableField<>(0);
    public ObservableField<String> k = new ObservableField<>("");
    public ObservableField<Boolean> l = new ObservableField<>(false);
    public ObservableField<Boolean> m = new ObservableField<>(true);

    public s(EnterGameActivity enterGameActivity, Game game, long j, boolean z, String str, EnterRealmsResult enterRealmsResult) {
        this.f10742f = null;
        this.h = z;
        this.f10737a = enterGameActivity;
        this.i = str;
        this.f10738b = game;
        this.f10742f = enterRealmsResult;
        if (game == null) {
            return;
        }
        this.g = EngineEnv.getEngine(game.getIsNewEngine(), game.getIsUgc());
        if (game.getGameId() == null) {
            AppToastUtils.showLongNegativeTipToast(enterGameActivity, R.string.create_game_failed);
            enterGameActivity.finish();
            return;
        }
        this.f10741e = new GameResManager(this.f10737a, this.g);
        this.f10741e.setListener(this);
        if (j != 0) {
            a(j);
        } else {
            f();
        }
        SandboxReportManager.onEvent(ReportEvent.NEW_GAME_LOADING_BASE + game.getGameId(), game.getGameId() + ReportEventType.GAME_INTER_BASE, game.getGameId());
        SandboxReportManager.onEvent(ReportEvent.NEW_GAME_LOADING_BASE + game.getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    public void f() {
        int engineVersion = (int) this.g.getEngineVersion();
        this.k.set(this.f10737a.getString(R.string.checking_map_res));
        GameApi.getMiniGameToken(this.f10737a, this.f10738b.getGameId(), engineVersion, new m(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.os.RecoverySystem.ProgressListener
    public void onProgress(final int i) {
        EnterGameActivity enterGameActivity = this.f10737a;
        if (enterGameActivity == null || this.j == null || enterGameActivity.isFinishing()) {
            return;
        }
        this.f10737a.runOnUiThread(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.join.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f10720a.b(i);
            }
        });
    }

    public /* synthetic */ void b(MiniGameToken miniGameToken, int i, long j, Boolean bool) {
        if (bool.booleanValue()) {
            b(miniGameToken, i, j);
            this.j.set(100);
            this.k.set(this.f10737a.getString(R.string.download_map_successfull));
        } else {
            this.k.set(this.f10737a.getString(R.string.download_map_failed));
            b(this.f10737a.getResources().getString(R.string.download_map_failed));
            ReportDataAdapter.onEvent(this.f10737a, EventConstant.ENGINE2_ENTER_GAME_STATUS, "3");
        }
    }

    public void a(long j) {
        int engineVersion = (int) this.g.getEngineVersion();
        this.k.set(this.f10737a.getString(R.string.checking_map_res));
        GameApi.engine2FollowGameAuth(this.f10738b.getGameId(), engineVersion, j, this.i, new n(this, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        this.f10737a.runOnUiThread(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.join.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f10718a.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MiniGameToken miniGameToken, long j) {
        GameApi.onGetGameResInfo(this.f10737a, miniGameToken, this.f10738b.getGameId(), (int) this.g.getEngineVersion(), this.f10741e.getResVersion(this.f10738b.getGameId()), new o(this, miniGameToken, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MiniGameToken miniGameToken, int i, long j) {
        if (j != 0) {
            a(miniGameToken, i, j);
            return;
        }
        if (this.f10742f != null) {
            Dispatch dispatch = new Dispatch();
            dispatch.signature = miniGameToken.getSignature();
            dispatch.timestamp = miniGameToken.getTimestamp();
            a(dispatch, false);
            return;
        }
        GameApi.onGetGameDispatch(this.f10737a, miniGameToken, i, (int) this.g.getEngineVersion(), new q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MiniGameToken miniGameToken, GameResInfo gameResInfo, final long j) {
        final int resVersion = this.f10741e.getResVersion(this.f10738b.getGameId());
        this.f10740d = gameResInfo;
        if (gameResInfo.getResVersion() != resVersion) {
            if (gameResInfo.getResVersion() < resVersion) {
                this.f10741e.deleteLocalRes(this.f10738b.getGameId());
            }
            int resVersion2 = gameResInfo.getResVersion();
            String gameId = this.f10738b.getGameId();
            if (this.f10741e.getResVersion(gameId) == resVersion2) {
                this.f10741e.prepareAndCheckGameRes(gameId, new Action1() { // from class: com.disabngo.blockynexus.view.activity.join.c
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.f10703a.a(miniGameToken, resVersion, j, (Boolean) obj);
                    }
                });
                return;
            }
            ReportUtils.resDownloadReport(this.f10737a, this.f10738b.getGameId(), EventConstant.DOWNLOAD_GAME_MAP);
            SandboxReportManager.onEvent(ReportEvent.NEW_GAME_DOWNLOAD_MAP_BASE + this.f10738b.getGameId(), this.f10738b.getGameId() + ReportEventType.GAME_INTER_BASE, this.f10738b.getGameId());
            SandboxReportManager.onEvent(ReportEvent.NEW_GAME_DOWNLOAD_MAP_BASE + this.f10738b.getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
            this.k.set(this.f10737a.getResources().getString(R.string.check_map_download));
            new GameResNewUpdater(this.f10737a, new p(this, gameId, miniGameToken, resVersion, j), this.f10738b, gameResInfo, this.g).setProgressListener(this).execute();
            return;
        }
        this.k.set(this.f10737a.getResources().getString(R.string.unzip_map));
        this.f10741e.prepareAndCheckGameRes(this.f10738b.getGameId(), new Action1() { // from class: com.disabngo.blockynexus.view.activity.join.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10713a.b(miniGameToken, resVersion, j, (Boolean) obj);
            }
        });
    }

    public /* synthetic */ void b(int i) {
        this.j.set(Integer.valueOf(i));
    }

    public /* synthetic */ void a(MiniGameToken miniGameToken, int i, long j, Boolean bool) {
        if (bool.booleanValue()) {
            b(miniGameToken, i, j);
            this.j.set(100);
        } else {
            this.k.set(this.f10737a.getString(R.string.download_map_failed));
            b(this.f10737a.getResources().getString(R.string.download_map_failed));
        }
    }

    public /* synthetic */ void a(String str) {
        new GameFailedDialog(this.f10737a).setText(str).setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.join.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10722a.a(view);
            }
        }).show();
        this.l.set(true);
    }

    public /* synthetic */ void a(View view) {
        this.f10737a.finish();
    }

    private void a(MiniGameToken miniGameToken, int i, long j) {
        GameApi.followFriendInGameDispatch(this.f10737a, j, miniGameToken, i, (int) this.g.getEngineVersion(), new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Dispatch dispatch, boolean z) {
        String mapId;
        EnterRealmsResult enterRealmsResult = new EnterRealmsResult();
        enterRealmsResult.setFollow(z);
        EnterRealmsResult enterRealmsResult2 = this.f10742f;
        enterRealmsResult.setGameAddr(enterRealmsResult2 == null ? dispatch.gAddr : enterRealmsResult2.getGameAddr());
        enterRealmsResult.setUserName(AccountCenter.newInstance().nickName.get());
        enterRealmsResult.setUserId(AccountCenter.newInstance().userId.get().longValue());
        enterRealmsResult.setUserToken(dispatch.signature);
        enterRealmsResult.setGame(this.f10738b);
        enterRealmsResult.setTimestamp(dispatch.timestamp);
        enterRealmsResult.setGameMode(this.f10738b.getGameMode());
        EnterRealmsResult enterRealmsResult3 = this.f10742f;
        enterRealmsResult.setChatRoomId(enterRealmsResult3 == null ? dispatch.chatRoomId : enterRealmsResult3.getChatRoomId());
        EnterRealmsResult enterRealmsResult4 = this.f10742f;
        enterRealmsResult.setMapName(enterRealmsResult4 == null ? dispatch.mapName : enterRealmsResult4.getMapName());
        enterRealmsResult.setResVersion(this.f10740d.getResVersion());
        EnterRealmsResult enterRealmsResult5 = this.f10742f;
        if (enterRealmsResult5 == null) {
            mapId = dispatch.mapId;
            if (mapId == null) {
                mapId = "";
            }
        } else {
            mapId = enterRealmsResult5.getMapId();
        }
        enterRealmsResult.setMapId(mapId);
        EnterRealmsResult enterRealmsResult6 = this.f10742f;
        enterRealmsResult.setMapUrl(enterRealmsResult6 == null ? this.f10740d.getDurl() : enterRealmsResult6.getMapUrl());
        EnterRealmsResult enterRealmsResult7 = this.f10742f;
        if (enterRealmsResult7 != null) {
            enterRealmsResult.setRequestId(enterRealmsResult7.getRequestId());
        }
        enterRealmsResult.setCountry("Oversea");
        long j = this.f10739c;
        if (j != 0) {
            enterRealmsResult.setInviter(j);
        }
        Log.e("Main", "start game: enter game view model.");
        StartMc.newInstance().startGame(this.f10737a, enterRealmsResult, StringConstant.THIRD_PART_LOGIN_GOOGLE, "https://leif-hyperritualistic-bobbye.ngrok-free.dev");
        Messenger.getDefault().send(this.f10738b, MessageToken.TOKEN_REFRESH_LATELY_TYPE);
        Observable.just(true).delay(5L, TimeUnit.SECONDS).compose(this.f10737a.bindUntilEvent(ActivityEvent.DESTROY)).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.join.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10717a.a((Boolean) obj);
            }
        });
        if (this.h) {
            ReportDataAdapter.onEvent(this.f10737a, EventConstant.CLICK_REC_STARTGAME);
        }
        if (this.f10742f != null) {
            Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_TEAM_START_GAME_EXIT_CHAT);
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        this.m.set(false);
    }
}
