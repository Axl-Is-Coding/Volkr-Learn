package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.blockmango.GameResManager;
import com.sandboxol.blocky.router.StartMc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.AbstractEngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.rx.BaseRxAppCompatActivity;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GamingInfo;
import com.sandboxol.greendao.entity.MiniGameToken;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.messager.MessagerClient;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.Map;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.va, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnterMiniGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class DialogC1122va extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Game f11694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f11695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EnterRealmsResult f11696f;
    private GameResManager g;
    private AbstractEngineEnv h;
    private AnimationDrawable i;
    private boolean j;

    /* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.va$a */
    /* JADX INFO: compiled from: EnterMiniGameDialog.java */
    private class a {
        private a() {
        }

        void a(String str, OnResponseListener<MiniGameToken> onResponseListener) {
            GameApi.getMiniGameMap((int) DialogC1122va.this.h.getEngineVersion(), str, onResponseListener);
        }

        /* synthetic */ a(DialogC1122va dialogC1122va, C1120ua c1120ua) {
            this();
        }

        void a(Context context, String str, int i, OnResponseListener<MiniGameToken> onResponseListener) {
            GameApi.getTeamMiniGameToken(context, str, i, onResponseListener);
        }

        void a(String str, long j, GamingInfo gamingInfo, OnResponseListener<Dispatch> onResponseListener) {
            GameApi.followGame((int) DialogC1122va.this.h.getEngineVersion(), str, j, gamingInfo, onResponseListener);
        }
    }

    /* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.va$b */
    /* JADX INFO: compiled from: EnterMiniGameDialog.java */
    public class b extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ObservableField<String> f11698a = new ObservableField<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ObservableField<Boolean> f11699b = new ObservableField<>(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ReplyCommand f11700c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f11596a.cancel();
            }
        });

        public b() {
        }

        private void b(long j, GamingInfo gamingInfo) {
            if (DialogC1122va.this.f11691a instanceof BaseRxAppCompatActivity) {
                ((BaseRxAppCompatActivity) DialogC1122va.this.f11691a).sendLifecycleEvent(ActivityEvent.RESUME);
            }
            new a(DialogC1122va.this, null).a(DialogC1122va.this.f11692b, j, gamingInfo, new C1126xa(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel() {
            if (DialogC1122va.this.f11691a instanceof BaseRxAppCompatActivity) {
                ((BaseRxAppCompatActivity) DialogC1122va.this.f11691a).sendLifecycleEvent(ActivityEvent.DESTROY);
            }
            DialogC1122va.this.c();
        }

        private void f() {
            if (DialogC1122va.this.f11696f != null) {
                Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_TEAM_START_GAME_EXIT_CHAT);
            }
        }

        private void h() {
            if (DialogC1122va.this.f11691a instanceof BaseRxAppCompatActivity) {
                ((BaseRxAppCompatActivity) DialogC1122va.this.f11691a).sendLifecycleEvent(ActivityEvent.RESUME);
            }
            new a(DialogC1122va.this, null).a(DialogC1122va.this.f11692b, new C1124wa(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i() {
            h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i) {
            new a(DialogC1122va.this, null).a(DialogC1122va.this.f11691a, DialogC1122va.this.f11692b, i, new C1128ya(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j, GamingInfo gamingInfo) {
            b(j, gamingInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Dispatch dispatch, boolean z) {
            String mapId;
            EnterRealmsResult enterRealmsResult = new EnterRealmsResult();
            enterRealmsResult.setFollow(z);
            enterRealmsResult.setGameAddr(DialogC1122va.this.f11696f == null ? dispatch.gAddr : DialogC1122va.this.f11696f.getGameAddr());
            enterRealmsResult.setUserName(AccountCenter.newInstance().nickName.get());
            enterRealmsResult.setUserId(AccountCenter.newInstance().userId.get().longValue());
            enterRealmsResult.setUserToken(dispatch.signature);
            enterRealmsResult.setDispatchUrl(dispatch.dispUrl);
            enterRealmsResult.setGame(DialogC1122va.this.f11694d);
            if (TextUtils.isEmpty(dispatch.gameType)) {
                enterRealmsResult.getGame().setGameId(DialogC1122va.this.f11692b);
            } else {
                enterRealmsResult.getGame().setGameId(dispatch.gameType);
            }
            enterRealmsResult.setTimestamp(dispatch.timestamp);
            enterRealmsResult.setGameMode(DialogC1122va.this.f11694d.getGameMode());
            enterRealmsResult.setChatRoomId(DialogC1122va.this.f11696f == null ? dispatch.chatRoomId : DialogC1122va.this.f11696f.getChatRoomId());
            enterRealmsResult.setMapName(DialogC1122va.this.f11696f == null ? dispatch.mapName : DialogC1122va.this.f11696f.getMapName());
            enterRealmsResult.setMapUrl(DialogC1122va.this.f11696f == null ? dispatch.mapUrl : DialogC1122va.this.f11696f.getMapUrl());
            String requestId = "";
            if (DialogC1122va.this.f11696f == null) {
                mapId = dispatch.mapId;
                if (mapId == null) {
                    mapId = "";
                }
            } else {
                mapId = DialogC1122va.this.f11696f.getMapId();
            }
            enterRealmsResult.setMapId(mapId);
            if (DialogC1122va.this.f11693c != 0) {
                enterRealmsResult.setInviter(DialogC1122va.this.f11693c);
            }
            Map<Long, String> map = dispatch.requestIds;
            if (map != null && map.size() != 0 && dispatch.requestIds.get(AccountCenter.newInstance().userId.get()) != null) {
                requestId = dispatch.requestIds.get(AccountCenter.newInstance().userId.get());
            }
            Log.e("Main", "start game from enter game dialog 1.");
            if (DialogC1122va.this.f11696f != null) {
                requestId = DialogC1122va.this.f11696f.getRequestId();
            }
            enterRealmsResult.setRequestId(requestId);
            enterRealmsResult.setCountry("Oversea");
            StartMc.newInstance().startGame(DialogC1122va.this.f11691a, enterRealmsResult, StringConstant.THIRD_PART_LOGIN_GOOGLE, "https://leif-hyperritualistic-bobbye.ngrok-free.dev");
            Messenger.getDefault().send(DialogC1122va.this.f11694d, MessageToken.TOKEN_REFRESH_LATELY_TYPE);
            com.disabngo.blockynexus.d.n.e(DialogC1122va.this.f11691a);
            DialogC1122va.this.a(enterRealmsResult.getMapName());
            f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MiniGameToken miniGameToken) {
            EnterRealmsResult enterRealmsResult = new EnterRealmsResult();
            enterRealmsResult.setTargetUserId(AccountCenter.newInstance().userId.get().longValue());
            enterRealmsResult.setUserName(AccountCenter.newInstance().nickName.get());
            enterRealmsResult.setUserId(AccountCenter.newInstance().userId.get().longValue());
            enterRealmsResult.setMapUrl(miniGameToken.getDownloadUrl());
            enterRealmsResult.setUserToken(miniGameToken.getSignature());
            enterRealmsResult.setDispatchUrl(miniGameToken.getDispUrl());
            enterRealmsResult.setDispatchToken(miniGameToken.getToken());
            enterRealmsResult.setTimestamp(miniGameToken.getTimestamp());
            enterRealmsResult.setMapName(miniGameToken.getMapName());
            enterRealmsResult.setMapId(miniGameToken.getMapName());
            enterRealmsResult.setRegion(miniGameToken.getRegion());
            enterRealmsResult.setChatRoomId("");
            enterRealmsResult.setGameAddr("");
            enterRealmsResult.setResetIp("");
            enterRealmsResult.setRequestId("");
            enterRealmsResult.setTeam(false);
            enterRealmsResult.setCountry(miniGameToken.getCountry());
            enterRealmsResult.setGameMode(DialogC1122va.this.f11694d.getGameMode());
            enterRealmsResult.setNewStartMadel(true);
            enterRealmsResult.setGame(DialogC1122va.this.f11694d);
            enterRealmsResult.getGame().setGameId(DialogC1122va.this.f11692b);
            if (DialogC1122va.this.f11693c != 0) {
                enterRealmsResult.setInviter(DialogC1122va.this.f11693c);
            }
            StartMc.newInstance().startGame(DialogC1122va.this.f11691a, enterRealmsResult, StringConstant.THIRD_PART_LOGIN_GOOGLE, "https://leif-hyperritualistic-bobbye.ngrok-free.dev");
            Messenger.getDefault().send(DialogC1122va.this.f11694d, MessageToken.TOKEN_REFRESH_LATELY_TYPE);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
            if (DialogC1122va.this.j) {
                ReportDataAdapter.onEvent(DialogC1122va.this.f11691a, EventConstant.CLICK_REC_STARTGAME);
            }
            if (!TextUtils.isEmpty(DialogC1122va.this.f11692b) && DialogC1122va.this.f11692b.equals(StringConstant.BED_WAR_HALL_GAME_ID)) {
                SharedUtils.putBoolean(DialogC1122va.this.f11691a, SharedConstant.IS_BEDWARHALL_DISPLAYED, true);
            }
            DialogC1122va.this.a(enterRealmsResult.getMapName());
            f();
        }
    }

    public DialogC1122va(Context context, String str, Game game) {
        super(context, R.style.FullTranslucentStyle);
        this.f11694d = new Game();
        this.j = false;
        this.j = false;
        this.f11691a = context;
        this.f11692b = str;
        this.f11694d = game;
        this.h = EngineEnv.getEngine(game.getIsNewEngine(), game.getIsUgc());
        this.g = new GameResManager(this.f11691a, this.h);
        e();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    /* JADX INFO: renamed from: dismiss, reason: merged with bridge method [inline-methods] */
    public void c() {
        Context context = this.f11691a;
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 17 && ((Activity) this.f11691a).isDestroyed()) {
                return;
            }
        }
        MessagerClient.getIns().unRegisterMsg(DialogC1122va.class);
        if (this.i.isRunning()) {
            this.i.stop();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    private void e() {
        com.disabngo.blockynexus.databinding.Xa xa = (com.disabngo.blockynexus.databinding.Xa) androidx.databinding.e.a(LayoutInflater.from(this.f11691a), R.layout.dialog_app_enter_game, (ViewGroup) null, false);
        setContentView(xa.getRoot());
        this.f11695e = new b();
        xa.a(this.f11695e);
        this.i = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (!this.i.isRunning()) {
            this.i.start();
        }
        MessagerClient.getIns().registerMsg0(DialogC1122va.class, BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG, new com.sandboxol.messager.a.a() { // from class: com.disabngo.blockynexus.view.dialog.j
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f11609a.c();
            }
        });
    }

    public void b() {
        if (this.f11694d.getIsNewEngine() == 0) {
            this.f11695e.b((int) this.h.getEngineVersion());
        } else {
            com.disabngo.blockynexus.d.D.a(this.f11691a, this.f11694d, this.f11696f);
            c();
        }
    }

    public void d() {
        this.f11695e.i();
    }

    public void a() {
        ReportUtils.resDownloadReport(this.f11691a, this.f11692b, EventConstant.START_ENTER_GAME);
        if (this.f11694d.getIsNewEngine() == 0) {
            d();
            return;
        }
        a((String) null);
        com.disabngo.blockynexus.d.D.a(this.f11691a, this.f11694d, this.j);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f11694d != null) {
            com.sandboxol.greendao.c.fa.newInstance().a(this.f11694d.getGameId(), new C1120ua(this, str));
        }
    }

    public DialogC1122va(Context context, String str, Game game, long j) {
        super(context, R.style.FullTranslucentStyle);
        this.f11694d = new Game();
        this.j = false;
        this.f11691a = context;
        this.f11692b = str;
        this.f11694d = game;
        this.f11693c = j;
        this.h = EngineEnv.getEngine(game.getIsNewEngine(), game.getIsUgc());
        e();
    }

    public void a(long j, GamingInfo gamingInfo) {
        this.f11695e.a(j, gamingInfo);
    }

    public void a(EnterRealmsResult enterRealmsResult) {
        this.f11696f = enterRealmsResult;
    }

    public void a(boolean z) {
        this.j = z;
    }
}
