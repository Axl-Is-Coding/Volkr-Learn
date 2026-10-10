package com.disabngo.blockynexus.view.activity.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.o.C0891o;
import com.disabngo.blockynexus.e.b.y.C0960k;
import com.disabngo.blockynexus.entity.CampaignCenter;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.receiver.NetworkConnectChangedReceiver;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.disabngo.blockynexus.view.activity.thirdproxy.ThirdProxyActivity;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;
import com.disabngo.blockynexus.view.dialog.DialogC1118ta;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.disabngo.blockynexus.view.dialog.ReportDialog;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.center.entity.XScrapCardInfo;
import com.sandboxol.center.listener.ISuccessListener;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.manager.FeedBackManager;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.center.router.manager.HalloweenManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.PartyDressManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.router.moduleInfo.login.LoginMessageToken;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.DelayExecutor;
import com.sandboxol.center.utils.EventLogicUtils;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.greendao.entity.User;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.CampaignRedPointPush;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;
import com.sandboxol.messager.MessagerClient;
import io.rong.imlib.model.Message;
import java.util.concurrent.TimeUnit;
import retrofit2.HttpException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class nc extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f10938b;
    private boolean A;
    private long B;
    public ReplyCommand C;
    public ReplyCommand D;
    public ReplyCommand E;
    public ReplyCommand F;
    public ReplyCommand G;
    private com.disabngo.blockynexus.view.fragment.main.H H;
    private com.disabngo.blockynexus.e.b.O.n I;
    private com.sandboxol.decorate.view.fragment.dress.Y J;
    private C0891o K;
    private com.disabngo.blockynexus.view.fragment.more.A L;
    private BaseFragment M;
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> N;
    private NetworkConnectChangedReceiver O;
    private EnterRealmsResult P;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MainActivity f10939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private bc f10940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10942f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    public ObservableField<Integer> m;
    public ObservableField<String> n;
    public ObservableField<String> o;
    public ObservableField<String> p;
    public ObservableField<Boolean> q;
    public ObservableField<Boolean> r;
    public ObservableField<Boolean> s;
    public ObservableField<Boolean> t;
    public ObservableField<Boolean> u;
    public ObservableField<Boolean> v;
    public ObservableField<Integer> w;
    public ObservableField<Boolean> x;
    public ObservableField<Boolean> y;
    public ObservableField<Boolean> z;

    public nc(MainActivity mainActivity) {
        this.f10941e = 0;
        this.f10942f = 0;
        this.g = 0;
        this.h = true;
        this.m = new ObservableField<>();
        this.n = new ObservableField<>();
        this.o = new ObservableField<>("add_friend");
        this.p = new ObservableField<>("sign_in");
        this.q = new ObservableField<>(false);
        this.r = new ObservableField<>();
        this.s = new ObservableField<>();
        this.t = new ObservableField<>(false);
        this.u = new ObservableField<>(false);
        this.v = new ObservableField<>(false);
        this.w = new ObservableField<>();
        this.x = new ObservableField<>(false);
        this.y = new ObservableField<>(false);
        this.z = new ObservableField<>(false);
        this.A = true;
        this.B = 0L;
        this.C = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Ga
            @Override // rx.functions.Action0
            public final void call() {
                this.f10776a.Da();
            }
        });
        this.D = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ga
            @Override // rx.functions.Action0
            public final void call() {
                this.f10902a.Ba();
            }
        });
        this.E = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Oa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10814a.Aa();
            }
        });
        this.F = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.U
            @Override // rx.functions.Action0
            public final void call() {
                this.f10842a.Ca();
            }
        });
        this.G = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.H
            @Override // rx.functions.Action0
            public final void call() {
                this.f10779a.da();
            }
        });
        this.N = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Z
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10865a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
            }
        });
        this.f10939c = mainActivity;
        h();
        ma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        new DialogC1118ta(this.f10939c).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        MainActivity mainActivity = this.f10939c;
        TemplateUtils.startTemplate(mainActivity, com.sandboxol.googlepay.view.fragment.recharge.k.class, mainActivity.getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca() {
        try {
            String str = this.p.get();
            byte b2 = -1;
            if (str.hashCode() == 756439695 && str.equals("ads_cubes")) {
                b2 = 0;
            }
            if (b2 == 0) {
                AdsManager.showRewardVideo(0);
                ReportDataAdapter.onEvent(this.f10939c, EventConstant.CLICK_AD);
                FirebaseUtils.onEvent(this.f10939c, EventConstant.CLICK_AD);
            }
            ReportDataAdapter.onEvent(this.f10939c, EventConstant.CLICK_CALENDAR);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Da() {
        /*
            r6 = this;
            androidx.databinding.ObservableField<java.lang.String> r0 = r6.o
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.hashCode()
            r2 = -65350658(0xfffffffffc1ad3fe, float:-3.2156537E36)
            java.lang.String r3 = "dress_shop"
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L34
            r2 = 109400031(0x6854fdf, float:5.01464E-35)
            if (r1 == r2) goto L2a
            r2 = 1685768188(0x647ac7fc, float:1.8504386E22)
            if (r1 == r2) goto L20
            goto L3c
        L20:
            java.lang.String r1 = "add_friend"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3c
            r0 = 2
            goto L3d
        L2a:
            java.lang.String r1 = "share"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3c
            r0 = 0
            goto L3d
        L34:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L3c
            r0 = 1
            goto L3d
        L3c:
            r0 = -1
        L3d:
            if (r0 == 0) goto L5e
            if (r0 == r5) goto L53
            if (r0 == r4) goto L44
            goto L6c
        L44:
            com.disabngo.blockynexus.view.activity.main.MainActivity r0 = r6.f10939c
            com.disabngo.blockynexus.d.D.e(r0)
            com.disabngo.blockynexus.view.activity.main.MainActivity r0 = r6.f10939c
            java.lang.String r1 = "chat_add_friend_click"
            java.lang.String r2 = "Main"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r0, r1, r2)
            goto L6c
        L53:
            com.disabngo.blockynexus.view.activity.main.MainActivity r0 = r6.f10939c
            com.disabngo.blockynexus.c.a.a(r0)
            com.disabngo.blockynexus.view.activity.main.MainActivity r0 = r6.f10939c
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r0, r3)
            goto L6c
        L5e:
            com.disabngo.blockynexus.view.activity.main.MainActivity r0 = r6.f10939c
            java.lang.Class<com.disabngo.blockynexus.e.b.ja.c> r1 = com.disabngo.blockynexus.e.b.ja.c.class
            r2 = 2131822454(0x7f110776, float:1.927768E38)
            java.lang.String r2 = r0.getString(r2)
            com.sandboxol.center.utils.TemplateUtils.startTemplate(r0, r1, r2)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.activity.main.nc.Da():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
        if (this.k || !AppInfoCenter.newInstance().getAppConfig().isShowTopActivity()) {
            return;
        }
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.HALLOWEEN_ACT_TIME);
        HalloweenManager.openActivity(this.f10939c);
    }

    private void Fa() {
        if (this.f10941e + this.f10942f + this.g > 0) {
            this.s.set(true);
        } else {
            this.s.set(false);
        }
    }

    private void Ga() {
        DelayExecutor.doDelay(2000L, new DelayExecutor.OnDelayExecutorListener() { // from class: com.disabngo.blockynexus.view.activity.main.da
            @Override // com.sandboxol.center.utils.DelayExecutor.OnDelayExecutorListener
            public final void onFinish() {
                this.f10890a.fa();
            }
        });
    }

    static /* synthetic */ void Y() {
        try {
            PartyDressManager.onDestroy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void ia() {
        this.h = (AccountCenter.newInstance().nickName.get() == null || AccountCenter.newInstance().nickName.get().equals(this.f10939c.getString(R.string.more_fragment_visitor))) ? false : true;
        this.i = AccountCenter.newInstance().login.get().booleanValue();
        if (!this.h) {
            ga();
        }
        ja();
        ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initMessage, reason: merged with bridge method [inline-methods] */
    public void ca() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.va
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10977a.f((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REGISTER_SUCCESS, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Ja
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10788a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_OPEN_MAIN_ACTIVITY, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.aa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10873a.l();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_GAME, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Sa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10831a.b((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_MAIN_SELECT_DRESS, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ja
            @Override // rx.functions.Action0
            public final void call() {
                this.f10915a.m();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SELECT_TRIBE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Ya
            @Override // rx.functions.Action0
            public final void call() {
                this.f10862a.p();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SELECT_CHAT, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.La
            @Override // rx.functions.Action0
            public final void call() {
                this.f10797a.u();
            }
        });
        Messenger.getDefault().register(this, "token.open.dress.fragment", new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.xa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10985a.D();
            }
        });
        Messenger.getDefault().register(this, "token.open.dress.fragment", new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Fa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10769a.E();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_OPEN_SHOP, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.oa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10944a.F();
            }
        });
        MessagerClient.getIns().registerMsg0(nc.class, CommonMessageToken.TOKEN_REPEAT_LOGIN, new com.sandboxol.messager.a.a() { // from class: com.disabngo.blockynexus.view.activity.main.Qa
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f10822a.G();
            }
        });
        MessagerClient.getIns().registerMsg0(nc.class, LoginMessageToken.REPEAT_LOGIN, new com.sandboxol.messager.a.a() { // from class: com.disabngo.blockynexus.view.activity.main.cb
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f10887a.H();
            }
        });
        ya();
        Messenger.getDefault().register(this, "token.chat.new.friend", Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Va
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10849a.c((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CHAT_UNREAD_MESSAGE_COUNT, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.L
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10796a.d((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GROUP_CHAT_RED_POINT, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Ka
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10793a.e((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLAN_IS_SHOW_UNREAD_MESSAGE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Xa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10858a.a(((Boolean) obj).booleanValue());
            }
        });
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_EVENT_MAIN_EVENT, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Ea
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10766a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_ERROR_MAIN_ERROR, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.M
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10800a.b((String) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CAMPAIGN_RED_POINT, CampaignRedPointPush.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.fa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                nc.a((CampaignRedPointPush) obj);
            }
        });
        Messenger.getDefault().register(this, CommonMessageToken.TOKEN_ANDROID_DEVICE_ID_TYPE, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Y
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10861a.c((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_CAMPAIGN, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Aa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10744a.d((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_PARTY, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.qa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10954a.I();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_TO_SHARE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Na
            @Override // rx.functions.Action0
            public final void call() {
                this.f10811a.J();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_APP, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Pa
            @Override // rx.functions.Action0
            public final void call() {
                this.f10818a.K();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REGISTER_FINISH_DIALOG_CLOSE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ia
            @Override // rx.functions.Action0
            public final void call() {
                this.f10911a.L();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_PARTY_INVITE_FRIEND, Message.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.ba
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10878a.a((Message) obj);
            }
        });
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_ENTER_GAME, EnterRealmsResult.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.la
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10925a.a((EnterRealmsResult) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_JUMP_TO_ACTIVITY, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.X
            @Override // rx.functions.Action0
            public final void call() {
                this.f10857a.M();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_GET_GROUP_INVITE_APPLY_MESSAGE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Za
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10866a.a((Boolean) obj);
            }
        });
        MessagerClient.getIns().registerMsg1(nc.class, "token.refresh.friend.list", new dc(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_JACKPOT_ENTER_FRIEND_DETAIL, Long.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.pa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10949a.a((Long) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_START_PASS_BUY, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.za
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10997a.e((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_OPEN_RECHARGE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.bb
            @Override // rx.functions.Action0
            public final void call() {
                this.f10879a.N();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_OPEN_VIP_RECHARGE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.G
            @Override // rx.functions.Action0
            public final void call() {
                this.f10775a.O();
            }
        });
        Messenger.getDefault().register(this, CommonMessageToken.TOKEN_ACTIVITY_RECHARGE, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.N
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10810a.f((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.UPDATE_RECHARGE_EVENT_RED_POINT_STATUS, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Q
            @Override // rx.functions.Action0
            public final void call() {
                this.f10821a.P();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_IS_HAS_NEW_EMAIL, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.O
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10813a.b((Boolean) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.REFRESH_ACTIVITY_RED_POINT, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.W
            @Override // rx.functions.Action0
            public final void call() {
                this.f10853a.Q();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_IS_NEED_UPDATE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.F
            @Override // rx.functions.Action0
            public final void call() {
                this.f10768a.R();
            }
        });
        Messenger.getDefault().register(this, MessageToken.REFRESH_NEW_USER_INFO, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ua
            @Override // rx.functions.Action0
            public final void call() {
                com.disabngo.blockynexus.utils.logic.N.p();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_TO_FORGET_FRAGMENT, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.ma
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10929a.g((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SEND_LOGIN_REPORT, ReportInfo.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.ra
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10959a.a((ReportInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_OPEN_SCRAP_MAIN, new ec(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_SEND_SCRAP_CARD, XScrapCardInfo.class, new fc(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_BY_GPLUS, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.V
            @Override // rx.functions.Action0
            public final void call() {
                this.f10848a.T();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_BY_FACEBOOK, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Ba
            @Override // rx.functions.Action0
            public final void call() {
                this.f10749a.U();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_BY_TWITTER, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ca
            @Override // rx.functions.Action0
            public final void call() {
                this.f10886a.V();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.START_PARTY_FRIEND_INFO_DIALOG, Long.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.ab
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10874a.b((Long) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CLICK_START_SHOW_LOADING_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ha
            @Override // rx.functions.Action0
            public final void call() {
                this.f10906a.W();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TEAM_CLICK_HEAD, Long.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Ia
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10784a.c((Long) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CHAT_CLICK_TO_ENTER_ROOM, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Ta
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10839a.h((String) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CHAT_ROOM_SHOW, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Ha
            @Override // rx.functions.Action0
            public final void call() {
                this.f10780a.X();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CHAT_CREATE_GROUP_TIME, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.T
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10838a.i((String) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CHAT_UPLOAD_ENTER_TEAM_WRONG, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.ya
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10991a.j((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_EXIT_PARTY, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.sa
            @Override // rx.functions.Action0
            public final void call() {
                nc.Y();
            }
        });
        MessagerClient.getIns().registerMsg1(nc.class, GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND, new gc(this));
        MessagerClient.getIns().registerMsg1(nc.class, GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND, new hc(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_NOTICE, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.K
            @Override // rx.functions.Action0
            public final void call() {
                this.f10792a.Z();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SHOW_SIGN_IN_FROM_EXIT_ENGINE_V2, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.J
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10787a.c((Boolean) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_SUCCESS_START_MAIN, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ta
            @Override // rx.functions.Action0
            public final void call() {
                this.f10970a.aa();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_IS_TO_ACTIVITY, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.I
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10783a.k((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_IS_TO_GOOGLE_PLAY, new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.Ca
            @Override // rx.functions.Action0
            public final void call() {
                this.f10754a.ba();
            }
        });
        Messenger.getDefault().register(this, MessageToken.UPDATE_VIP_SUB_INFO, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.Wa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10854a.l((String) obj);
            }
        });
    }

    private void initView() {
        ua();
    }

    private void ja() {
        BaseApplication.getThreadPool().setName("checkPackage");
        BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.main.Da
            @Override // java.lang.Runnable
            public final void run() {
                this.f10760a.i();
            }
        });
    }

    private void ka() {
        int i = SharedUtils.getInt(this.f10939c, SharedConstant.SAVE_CDN_DOWNLOAD_APP_VERSION);
        if (i == 0 || i >= BaseApplication.getApp().getMetaDataAppVersion()) {
            return;
        }
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.UPDATE_SUCCESS);
        SharedUtils.putInt(this.f10939c, SharedConstant.SAVE_CDN_DOWNLOAD_APP_VERSION, 0);
    }

    private void la() {
        this.f10940d.a(this.f10939c);
    }

    @SuppressLint({"CheckResult"})
    private void ma() {
        if (SharedUtils.getBoolean(this.f10939c, SharedConstant.IS_FIRST_CLEAR_DOWNLOAD)) {
            return;
        }
        new com.sandboxol.file.c.d(new com.sandboxol.file.b.a()).f();
        SharedUtils.putBoolean(this.f10939c, SharedConstant.IS_FIRST_CLEAR_DOWNLOAD, true);
    }

    private void n(String str) {
        if (this.l) {
            return;
        }
        this.l = true;
        AccountCenter.newInstance().login.set(false);
        AccountCenter.newInstance().token.set("");
        AccountCenter.putAccountInfo();
        Messenger.getDefault().send(3, MessageToken.TOKEN_ACCOUNT);
        if (CommonMessageToken.TOKEN_REPEAT_LOGIN.equals(str)) {
            LoginManager.authRelogin(this.f10939c);
        } else if (LoginMessageToken.REPEAT_LOGIN.equals(str)) {
            LoginManager.forceReLogin(this.f10939c);
        }
    }

    private void na() {
        if (this.j && !ChannelManager.isBeta()) {
            com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new lc(this));
        }
    }

    private void oa() {
        DelayExecutor.doDelay(1500L, new DelayExecutor.OnDelayExecutorListener() { // from class: com.disabngo.blockynexus.view.activity.main.Ua
            @Override // com.sandboxol.center.utils.DelayExecutor.OnDelayExecutorListener
            public final void onFinish() {
                this.f10843a.j();
            }
        });
    }

    private void pa() {
        if (this.h && this.i) {
            va();
            FeedBackManager.setUI(R.mipmap.btn_back, String.valueOf(AccountCenter.newInstance().userId.get()), AccountCenter.newInstance().nickName.get());
        }
    }

    private void qa() {
        AdsManager.init(this.f10939c);
        MultiProcessSharedUtils.putBoolean(this.f10939c, "is.show.ads", false);
    }

    private void ra() {
        this.f10940d = new bc();
        this.f10940d.i(this.f10939c);
        com.disabngo.blockynexus.d.C.b(BaseApplication.getApp().getMetaDataRootPath());
        if (TextUtils.equals(AccountCenter.newInstance().account.get(), this.f10939c.getString(R.string.base_more_user_no_account))) {
            return;
        }
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.USERNAME_DONE);
    }

    private void sa() {
        if (this.k) {
            return;
        }
        this.f10940d.a(this.f10939c, new bc.a() { // from class: com.disabngo.blockynexus.view.activity.main.S
            @Override // com.disabngo.blockynexus.view.activity.main.bc.a
            public final void a() {
                this.f10830a.k();
            }
        });
    }

    private void ta() {
        Fragment fragment;
        androidx.fragment.app.F fA = this.f10939c.getSupportFragmentManager().a();
        String stringExtra = this.f10939c.getIntent().getStringExtra(StringConstant.RONGCLOUD_PUSH_SELECT_TYPE);
        Integer numValueOf = Integer.valueOf(R.id.rb_1);
        if (stringExtra != null) {
            byte b2 = -1;
            int iHashCode = stringExtra.hashCode();
            if (iHashCode != -618533115) {
                if (iHashCode != -418345461) {
                    if (iHashCode == 1942132344 && stringExtra.equals(StringConstant.RONGCLOUD_PUSH_SELECT_ADD_FRIEND)) {
                        b2 = 1;
                    }
                } else if (stringExtra.equals(StringConstant.RONGCLOUD_PUSH_SELECT_AGREE_JOIN_CLAN)) {
                    b2 = 2;
                }
            } else if (stringExtra.equals(StringConstant.RONGCLOUD_PUSH_SELECT_CHAT)) {
                b2 = 0;
            }
            if (b2 == 0 || b2 == 1) {
                this.m.set(Integer.valueOf(R.id.rb_4));
                C0891o c0891o = this.K;
                if (c0891o != null && c0891o.g() == null) {
                    fA.a(R.id.flHomePage, this.K, "chatFragment");
                    this.K.a("chatFragment");
                }
                fragment = this.K;
            } else if (b2 != 2) {
                this.m.set(numValueOf);
                com.disabngo.blockynexus.view.fragment.main.H h = this.H;
                if (h != null && h.g() == null) {
                    fA.a(R.id.flHomePage, this.H, "mainFragment");
                    this.H.a("mainFragment");
                }
                fragment = this.H;
            } else {
                this.m.set(Integer.valueOf(R.id.rb_3));
                com.disabngo.blockynexus.e.b.O.n nVar = this.I;
                if (nVar != null && nVar.g() == null) {
                    fA.a(R.id.flHomePage, this.I, "makeFriendFragment");
                    this.I.a("makeFriendFragment");
                }
                fragment = this.I;
            }
        } else {
            this.m.set(numValueOf);
            com.disabngo.blockynexus.view.fragment.main.H h2 = this.H;
            if (h2 != null && h2.g() == null) {
                fA.a(R.id.flHomePage, this.H, "mainFragment");
                this.H.a("mainFragment");
            }
            fragment = this.H;
        }
        fA.e(fragment);
        fA.c();
    }

    private void ua() {
        this.H = new com.disabngo.blockynexus.view.fragment.main.H(this);
        this.K = new C0891o(this, this.f10939c);
        this.I = new com.disabngo.blockynexus.e.b.O.n(this, this.f10939c);
        this.J = new com.sandboxol.decorate.view.fragment.dress.Y();
        this.L = new com.disabngo.blockynexus.view.fragment.more.A(this.f10939c);
        ta();
    }

    private void va() {
        this.f10940d.a(this.f10939c, this.q, this.m, this.y);
    }

    private void wa() {
        BaseApplication.getThreadPool().setName("init-MainViewModel-Messenger");
        BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.main.ea
            @Override // java.lang.Runnable
            public final void run() {
                this.f10894a.ca();
            }
        });
        xa();
    }

    private void xa() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.O = new NetworkConnectChangedReceiver();
        this.f10939c.registerReceiver(this.O, intentFilter);
        MessagerClient.getIns().registerMsg0(nc.class, GameBroadcastType.ENTER_RECHARGE_PAGE_GAME, new mc(this));
        MessagerClient.getIns().registerMsg1(nc.class, GameBroadcastType.TOP_UP_DIAMONDS_GAME, new cc(this));
    }

    private void ya() {
        final PublishSubject publishSubjectCreate = PublishSubject.create();
        publishSubjectCreate.throttleFirst(3L, TimeUnit.SECONDS).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.na
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10933a.a((HttpException) obj);
            }
        });
        Messenger messenger = Messenger.getDefault();
        publishSubjectCreate.getClass();
        messenger.register(this, CommonMessageToken.TOKEN_BE_REPORT, HttpException.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                publishSubjectCreate.onNext((HttpException) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: za, reason: merged with bridge method [inline-methods] */
    public void L() {
        this.k = false;
        if (this.j) {
            na();
        } else {
            sa();
        }
        if (ChannelManager.isBeta()) {
            return;
        }
        Messenger.getDefault().send(false, MessageToken.TOKEN_MAKE_ROLE_ACTIVITY_IS_EXIST);
        Messenger.getDefault().send(true, MessageToken.TOKEN_NEW_USER_MAIN_FRAGMENT_GUIDE);
    }

    public /* synthetic */ void D() {
        this.m.set(Integer.valueOf(R.id.rb_2));
        com.disabngo.blockynexus.d.D.d(this.f10939c);
    }

    public /* synthetic */ void E() {
        this.m.set(Integer.valueOf(R.id.rb_2));
    }

    public /* synthetic */ void F() {
        com.disabngo.blockynexus.c.a.a(this.f10939c);
    }

    public /* synthetic */ void G() {
        n(CommonMessageToken.TOKEN_REPEAT_LOGIN);
    }

    public /* synthetic */ void H() {
        n(LoginMessageToken.REPEAT_LOGIN);
    }

    public /* synthetic */ void I() {
        MainActivity mainActivity = this.f10939c;
        TemplateHelper.startTemplate(mainActivity, com.disabngo.blockynexus.view.fragment.partyhall.p.class, mainActivity.getString(R.string.party_create_party_hall));
    }

    public /* synthetic */ void J() {
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.SHARE_PAGE_TIME);
        WebViewActivity.a(this.f10939c, UrlConstant.SHARE_URL_INVITATION, "", false);
    }

    public /* synthetic */ void K() {
        this.f10939c.finish();
    }

    public /* synthetic */ void M() {
        bc bcVar = this.f10940d;
        if (bcVar != null) {
            bcVar.j(this.f10939c);
        }
    }

    public /* synthetic */ void N() {
        MainActivity mainActivity = this.f10939c;
        TemplateUtils.startTemplate(mainActivity, com.sandboxol.googlepay.view.fragment.recharge.k.class, mainActivity.getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
    }

    public /* synthetic */ void O() {
        VipManager.enterVipFragment(this.f10939c);
    }

    public /* synthetic */ void P() {
        this.f10940d.b(this.f10939c);
    }

    public /* synthetic */ void Q() {
        com.disabngo.blockynexus.b.b.a().d(this.f10939c, this.w);
    }

    public /* synthetic */ void R() {
        if (this.j) {
            return;
        }
        this.j = true;
        na();
    }

    public /* synthetic */ void T() {
        Intent intent = new Intent(this.f10939c, (Class<?>) ThirdProxyActivity.class);
        intent.putExtra("platForm", "gplus");
        this.f10939c.startActivity(intent);
    }

    public /* synthetic */ void U() {
        Intent intent = new Intent(this.f10939c, (Class<?>) ThirdProxyActivity.class);
        intent.putExtra("platForm", StringConstant.THIRD_PART_LOGIN_FB);
        this.f10939c.startActivity(intent);
    }

    public /* synthetic */ void V() {
        Intent intent = new Intent(this.f10939c, (Class<?>) ThirdProxyActivity.class);
        intent.putExtra("platForm", StringConstant.THIRD_PART_LOGIN_TW);
        this.f10939c.startActivity(intent);
    }

    public /* synthetic */ void W() {
        com.disabngo.blockynexus.d.D.c((Activity) this.f10939c);
    }

    public /* synthetic */ void X() {
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.PARTY_TALK_TIME);
    }

    public /* synthetic */ void Z() {
        MainActivity mainActivity = this.f10939c;
        TemplateUtils.startTemplate(mainActivity, com.disabngo.blockynexus.e.b.R.a.class, mainActivity.getString(R.string.notice_title));
    }

    public /* synthetic */ void aa() {
        this.m.set(Integer.valueOf(R.id.rb_1));
        com.disabngo.blockynexus.d.D.d(this.f10939c);
    }

    public /* synthetic */ void ba() {
        if (!ChannelManager.isHasGoogleService(this.f10939c)) {
            AppToastUtils.showShortNegativeTipToast(this.f10939c, R.string.ads_tips_mario_google_play);
            return;
        }
        try {
            this.f10939c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
        } catch (Exception unused) {
            AppToastUtils.showShortNegativeTipToast(this.f10939c, R.string.ads_tips_mario_google_play);
        }
    }

    public /* synthetic */ void c(Integer num) {
        this.f10941e = num.intValue();
        Fa();
    }

    public /* synthetic */ void d(Boolean bool) {
        if (bool.booleanValue()) {
            ReportDataAdapter.onEvent(this.f10939c, EventConstant.HOME_LUCKYBOX_TAB);
        }
    }

    public /* synthetic */ void da() {
        m(BaseModuleApp.getBaseModuleApp().getMetaDataActivityId());
        EventLogicUtils.isDaily(this.f10939c, SharedConstant.IS_DAILY_ENTRANCE, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.wa
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10980a.d((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void e(Integer num) {
        this.g = num.intValue();
        Fa();
    }

    public /* synthetic */ void ea() {
        if (AccountCenter.newInstance().nickName == null) {
            LoginManager.initRoleInfo(this.f10939c);
            this.k = true;
        } else if (AccountCenter.newInstance().nickName.get().equals(this.f10939c.getString(R.string.more_fragment_visitor))) {
            LoginManager.initRoleInfo(this.f10939c);
            this.k = true;
        }
    }

    public /* synthetic */ void f(Integer num) {
        if (num.intValue() == 2 || num.intValue() == 1) {
            this.m.set(Integer.valueOf(R.id.rb_1));
            Messenger.getDefault().sendNoMsg(MessageToken.RE_LOGIN_CLOSE_SINGLE_SHOP);
            new C0960k().a();
            com.disabngo.blockynexus.b.b.a().a(this.f10939c, this.w);
            this.f10940d.m(this.f10939c);
            FeedBackManager.setUI(R.mipmap.btn_back, String.valueOf(AccountCenter.newInstance().userId.get()), AccountCenter.newInstance().nickName.get());
            com.disabngo.blockynexus.e.a.a.l.a(this.f10939c);
            com.disabngo.blockynexus.view.dialog.activity.w.a(this.f10939c).a(0L);
            BillingManager.getInstance().initClient(BaseApplication.getContext());
            this.f10940d.i(this.f10939c);
            com.disabngo.blockynexus.e.a.a.h.c().a();
            VipManager.resetVipInfo();
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_LATELY_TYPE);
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_CATEGORY_TYPE);
            this.l = false;
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
            Messenger.getDefault().sendNoMsg(MessageToken.CLOSE_START_ACTIVITY);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS);
            if (AccountCenter.newInstance().nickName.get() != null) {
                if (AccountCenter.newInstance().nickName.get().equals(this.f10939c.getString(R.string.more_fragment_visitor))) {
                    LoginManager.initRoleInfo(this.f10939c);
                } else {
                    this.f10940d.b(this.f10939c);
                    na();
                }
            }
            if (num.intValue() == 1) {
                Ea();
            }
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM);
        }
    }

    public /* synthetic */ void fa() {
        if (this.h && this.i) {
            this.f10940d.m(this.f10939c);
        }
        la();
        com.disabngo.blockynexus.e.a.a.l.a(this.f10939c);
    }

    public /* synthetic */ void g(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.UID, str);
        MainActivity mainActivity = this.f10939c;
        TemplateHelper.startTemplate(mainActivity, com.disabngo.blockynexus.e.b.w.e.class, mainActivity.getString(R.string.item_view_forget_password), bundle);
    }

    public void ga() {
        AccountCenter.getAccountInfo(new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.ka
            @Override // rx.functions.Action0
            public final void call() {
                this.f10921a.ea();
            }
        });
    }

    public void h() {
        qa();
        ra();
        initView();
        ia();
        sa();
        oa();
        wa();
        Ga();
        pa();
        Ea();
    }

    public void ha() {
        EnterRealmsResult enterRealmsResult = this.P;
        if (enterRealmsResult == null || enterRealmsResult.getGame() == null) {
            return;
        }
        this.P.setTeam(false);
        f();
    }

    public /* synthetic */ void i() {
        if (CommonHelper.isAvilible(this.f10939c, "com.mclauncher.peonlinebox.mcmultiplayer")) {
            if (!SharedUtils.getBoolean(this.f10939c, "first.upload.has.blocky.mods")) {
                ReportDataAdapter.onEvent(this.f10939c, EventConstant.HAS_MULTIPLAYER);
                SharedUtils.putBoolean(this.f10939c, "first.upload.has.blocky.mods", true);
            }
            ReportDataAdapter.onEvent(this.f10939c, EventConstant.HAS_MULTIPLAYER_EVERYTIMES);
        }
    }

    public /* synthetic */ void j() {
        com.disabngo.blockynexus.b.b.a().c(this.f10939c, this.v);
        if (this.h) {
            com.disabngo.blockynexus.b.b.a().a(this.f10939c, this.w);
            if (this.i) {
                this.f10940d.b(this.f10939c);
            }
        }
        new com.disabngo.blockynexus.e.b.L.j().b(this.f10939c);
    }

    public /* synthetic */ void k() {
        this.j = true;
        na();
    }

    public /* synthetic */ void l() {
        com.disabngo.blockynexus.d.D.d(this.f10939c);
    }

    public /* synthetic */ void m() {
        this.m.set(Integer.valueOf(R.id.rb_2));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
        MessagerClient.getIns().unRegisterMsg(nc.class);
        try {
            if (this.O != null) {
                this.f10939c.unregisterReceiver(this.O);
                this.O = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        super.onPause();
        AdsManager.onPause(this.f10939c);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        try {
            com.disabngo.blockynexus.b.b.a().b(this.f10939c, this.w);
            AdsManager.onResume(this.f10939c);
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(this.f10939c, EventConstant.ON_RESUME_EXCEPTION, "MainViewModel");
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    public /* synthetic */ void p() {
        this.m.set(Integer.valueOf(R.id.rb_3));
    }

    public /* synthetic */ void u() {
        this.m.set(Integer.valueOf(R.id.rb_4));
    }

    private void m(String str) {
        com.disabngo.blockynexus.b.b.a().a(this.f10939c, str);
        if (str != null) {
            if (str.equals(ActivityType.SLOT_MACHINE) || str.equals(ActivityType.LUCKY_2020)) {
                ReportDataAdapter.onEvent(this.f10939c, EventConstant.CLICK_WHEEL_HOME);
            }
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        c(checkedDataWrapper.getCheckedId());
    }

    public /* synthetic */ void b(Integer num) {
        this.m.set(Integer.valueOf(R.id.rb_1));
    }

    public /* synthetic */ void l(String str) {
        if ("2".equals(str)) {
            this.f10940d.l(this.f10939c);
        }
    }

    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 1) {
            if (AccountCenter.newInstance().hasPassword.get().booleanValue()) {
                MainActivity mainActivity = this.f10939c;
                LoginManager.showRegisterFinishDialog(mainActivity, new ISuccessListener() { // from class: com.disabngo.blockynexus.view.activity.main.Ma
                    @Override // com.sandboxol.center.listener.ISuccessListener
                    public final void onSuccess() {
                        this.f10801a.Ea();
                    }
                }, mainActivity.getString(R.string.account_register_success));
            } else {
                L();
            }
        }
    }

    public /* synthetic */ void b(String str) {
        ReportDataAdapter.onError(this.f10939c, new GameInnerException(str));
    }

    public /* synthetic */ void c(String str) {
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.ANDROID_DEVICE_ID_TYPE, str);
    }

    public /* synthetic */ void d(Integer num) {
        this.f10942f = num.intValue();
        Fa();
    }

    public /* synthetic */ void e(Boolean bool) {
        if (bool.booleanValue()) {
            ReportDataAdapter.onEvent(this.f10939c, EventConstant.BANNER_LUCKYBOX_TAB);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void k(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 79847359(0x4c25fbf, float:4.569711E-36)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = 501479174(0x1de3f706, float:6.0341816E-21)
            if (r0 == r1) goto L21
            r1 = 1639462740(0x61b83754, float:4.2477347E20)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "Lucky 2020"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L21:
            java.lang.String r0 = "slot_machine"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 0
            goto L36
        L2b:
            java.lang.String r0 = "Share"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 2
            goto L36
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L57
            if (r0 == r4) goto L57
            if (r0 == r3) goto L46
            com.disabngo.blockynexus.b.b r0 = com.disabngo.blockynexus.b.b.a()
            com.disabngo.blockynexus.view.activity.main.MainActivity r1 = r5.f10939c
            r0.a(r1, r6)
            goto L67
        L46:
            com.disabngo.blockynexus.view.activity.main.MainActivity r6 = r5.f10939c
            java.lang.String r0 = "share_page_time"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r6, r0)
            com.disabngo.blockynexus.view.activity.main.MainActivity r6 = r5.f10939c
            java.lang.String r0 = "https://www.blockmango.net/rareWings2C.html"
            java.lang.String r1 = ""
            com.disabngo.blockynexus.view.activity.webview.WebViewActivity.a(r6, r0, r1, r2)
            goto L67
        L57:
            com.disabngo.blockynexus.view.activity.main.MainActivity r0 = r5.f10939c
            java.lang.String r1 = "click_shop_wheel"
            com.sandboxol.common.interfaces.ReportDataAdapter.onEvent(r0, r1)
            com.disabngo.blockynexus.b.b r0 = com.disabngo.blockynexus.b.b.a()
            com.disabngo.blockynexus.view.activity.main.MainActivity r1 = r5.f10939c
            r0.a(r1, r6)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.activity.main.nc.k(java.lang.String):void");
    }

    public /* synthetic */ void b(Boolean bool) {
        this.u.set(bool);
    }

    public /* synthetic */ void c(Long l) {
        com.disabngo.blockynexus.e.b.x.J.a(this.f10939c, (Friend) null, new FriendActivityIntentInfo(l.longValue(), 3));
    }

    public /* synthetic */ void b(Long l) {
        com.disabngo.blockynexus.d.D.a(this.f10939c, l.longValue());
    }

    public /* synthetic */ void c(Boolean bool) {
        User user = new User();
        user.setGolds(AccountCenter.newInstance().golds.get().longValue());
        user.setDiamonds(AccountCenter.newInstance().diamonds.get().longValue());
        user.setGDiamonds(AccountCenter.newInstance().gDiamonds.get().longValue());
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            BillingManager.getInstance().updateUserMoney(this.f10939c);
        }
        com.sandboxol.greendao.c.ya.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), new jc(this, bool, user));
    }

    public /* synthetic */ void d(String str) {
        m(str);
        EventLogicUtils.isDaily(this.f10939c, SharedConstant.IS_DAILY_ENTRANCE, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main._a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10868a.e((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void e(String str) {
        IntentUtils.startGooglePayActivity(this.f10939c, str, MessageToken.TOKEN_RECHARGE_PAY, "userId=" + AccountCenter.newInstance().userId.get());
    }

    private InviteMessage b(Message message) {
        InviteTeamMessage inviteTeamMessage = (InviteTeamMessage) message.getContent();
        return new InviteMessage(inviteTeamMessage.getGameName(), inviteTeamMessage.getGameType(), inviteTeamMessage.getPicUrl(), inviteTeamMessage.getCaptainPicUrl(), inviteTeamMessage.getCaptainId(), inviteTeamMessage.getChatRoomId(), inviteTeamMessage.getCaptainName(), inviteTeamMessage.getTeamId(), inviteTeamMessage.getGameVersion(), inviteTeamMessage.getRoomName(), inviteTeamMessage.getMaxMember(), inviteTeamMessage.getMemberCount(), inviteTeamMessage.getTeamCount(), inviteTeamMessage.getTeamType(), inviteTeamMessage.getPsid(), inviteTeamMessage.getIsNewEngine(), inviteTeamMessage.getIsUgc(), message.getUId());
    }

    public /* synthetic */ void i(String str) {
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.CREATE_GROUP_TIME, str);
    }

    public /* synthetic */ void a(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 1) {
            ReportDataAdapter.onEvent(this.f10939c, strArrSplit[0]);
        } else {
            ReportDataAdapter.onEvent(this.f10939c, strArrSplit[0], strArrSplit[1]);
        }
    }

    public /* synthetic */ void j(String str) {
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.UPLOAD_TEAM_ERROR, str);
    }

    static /* synthetic */ void a(CampaignRedPointPush campaignRedPointPush) {
        int type = campaignRedPointPush.getType();
        if (type == 1) {
            CampaignCenter.newInstance().addTaskFinished();
        } else if (type == 2) {
            CampaignCenter.newInstance().addIntegralReward();
        } else {
            if (type != 3) {
                return;
            }
            CampaignCenter.newInstance().addBetUpdateResult();
        }
    }

    public /* synthetic */ void h(String str) {
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.CLICK_PARTY_JOIN, str);
    }

    private boolean b(int i) {
        androidx.fragment.app.F fA = this.f10939c.getSupportFragmentManager().a();
        switch (i) {
            case R.id.rb_1 /* 2131297318 */:
                com.disabngo.blockynexus.view.fragment.main.H h = this.H;
                if (h == null || h.g() != null) {
                    return true;
                }
                fA.a(R.id.flHomePage, this.H, "mainFragment");
                this.H.a("mainFragment");
                fA.b();
                return true;
            case R.id.rb_2 /* 2131297319 */:
                com.sandboxol.decorate.view.fragment.dress.Y y = this.J;
                if (y == null || y.g() != null) {
                    return true;
                }
                fA.a(R.id.flHomePage, this.J, "dressFragment");
                this.J.a("dressFragment");
                fA.b();
                return true;
            case R.id.rb_3 /* 2131297320 */:
                com.disabngo.blockynexus.e.b.O.n nVar = this.I;
                if (nVar == null || nVar.g() != null) {
                    return true;
                }
                fA.a(R.id.flHomePage, this.I, "makeFriendFragment");
                this.I.a("makeFriendFragment");
                fA.b();
                return true;
            case R.id.rb_4 /* 2131297321 */:
                C0891o c0891o = this.K;
                if (c0891o == null || c0891o.g() != null) {
                    return true;
                }
                fA.a(R.id.flHomePage, this.K, "chatFragment");
                this.K.a("chatFragment");
                fA.b();
                return true;
            case R.id.rb_5 /* 2131297322 */:
                com.disabngo.blockynexus.view.fragment.more.A a2 = this.L;
                if (a2 == null || a2.g() != null) {
                    return true;
                }
                fA.a(R.id.flHomePage, this.L, "moreFragment");
                this.L.a("moreFragment");
                fA.b();
                return true;
            default:
                return false;
        }
    }

    @SuppressLint({"CheckResult"})
    private void c(int i) {
        FeedBackManager.getUnReadCount();
        if (b(i)) {
            BaseFragment baseFragment = this.M;
            if ((baseFragment == null || baseFragment.getTag() == null || !"dressFragment".equals(this.M.getTag())) ? false : true) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ROLLBACK_TO_DRESS);
            }
            switch (i) {
                case R.id.rb_1 /* 2131297318 */:
                    a(this.f10939c.getString(R.string.titile_main), this.f10940d.b(this.f10939c, 1), false, 0, this.H);
                    this.p.set("ads_cubes");
                    if (!this.A) {
                        ReportDataAdapter.onEvent(this.f10939c, EventConstant.HOME_GAME_TAB);
                        SandboxReportManager.onEvent(ReportEvent.NEW_HOME_GAME_TAB, ReportEventType.NEW_USER_BEHAVIOR, "app");
                    }
                    if (AccountCenter.newInstance().login.get().booleanValue()) {
                        this.x.set(true);
                    } else {
                        this.x.set(false);
                    }
                    break;
                case R.id.rb_2 /* 2131297319 */:
                    a("", false, false, 1, this.J);
                    this.x.set(false);
                    if (AccountCenter.newInstance().isShowDressGuide.get().booleanValue()) {
                        AccountCenter.newInstance().setIsShowDressGuide(false);
                    } else if (this.f10940d != null && this.B != AccountCenter.newInstance().userId.get().longValue()) {
                        this.f10940d.k(this.f10939c);
                        this.B = AccountCenter.newInstance().userId.get().longValue();
                    }
                    ReportDataAdapter.onEvent(this.f10939c, EventConstant.HOME_DRESS_TAB);
                    SandboxReportManager.onEvent(ReportEvent.NEW_HOME_DRESS_TAB, ReportEventType.NEW_USER_BEHAVIOR, "app");
                    break;
                case R.id.rb_3 /* 2131297320 */:
                    a(this.f10939c.getString(R.string.friend_make_friend), false, false, 2, this.I);
                    if (this.t.get().booleanValue()) {
                        this.t.set(false);
                    }
                    this.x.set(false);
                    ReportDataAdapter.onEvent(this.f10939c, EventConstant.CLICK_FIND_TAB);
                    SandboxReportManager.onEvent(ReportEvent.NEW_HOME_FIND_TAB, ReportEventType.NEW_USER_BEHAVIOR, "app");
                    break;
                case R.id.rb_4 /* 2131297321 */:
                    a(this.f10939c.getString(R.string.main_chat), false, true, 3, this.K);
                    this.o.set("add_friend");
                    this.x.set(false);
                    ReportDataAdapter.onEvent(this.f10939c, EventConstant.HOME_CHAT_TAB);
                    SandboxReportManager.onEvent(ReportEvent.NEW_HOME_CHAT_TAB, ReportEventType.NEW_USER_BEHAVIOR, "app");
                    if (!CommonHelper.hasWriteExternalStorage(this.f10939c)) {
                        new RxPermissions2(this.f10939c).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.activity.main.Ra
                            @Override // io.reactivex.b.g
                            public final void accept(Object obj) throws Exception {
                                nc.f((Boolean) obj);
                            }
                        }, new kc(this));
                    }
                    break;
                case R.id.rb_5 /* 2131297322 */:
                    a("", false, false, 4, this.L);
                    new com.disabngo.blockynexus.e.b.L.j().b(this.f10939c);
                    this.x.set(false);
                    ReportDataAdapter.onEvent(this.f10939c, EventConstant.HOME_MORE_TAB);
                    SandboxReportManager.onEvent(ReportEvent.NEW_HOME_MORE_TAB, ReportEventType.NEW_USER_BEHAVIOR, "app");
                    break;
            }
            if (this.A) {
                this.A = false;
            }
        }
    }

    public /* synthetic */ void a(Message message) {
        if (com.disabngo.blockynexus.d.A.b(this.f10939c, this.f10939c.getPackageName() + ":BlockmanGo")) {
            if (AppInfoCenter.newInstance().getAppConfig() == null || !AppInfoCenter.newInstance().getAppConfig().isShowPartyInvite()) {
                return;
            }
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.a(GameConstant.INVITE_TEAM_MESSAGE, b(message));
            MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_INVITE_MESSAGE_GAME, fVar);
            ReportDataAdapter.onEvent(this.f10939c, EventConstant.INVITE_WIN_TIME, "game");
            return;
        }
        com.sandboxol.messager.a.f fVar2 = new com.sandboxol.messager.a.f();
        fVar2.a(GameConstant.INVITE_TEAM_MESSAGE, b(message));
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_INVITE_MESSAGE, fVar2);
        ReportDataAdapter.onEvent(this.f10939c, EventConstant.INVITE_WIN_TIME, "app");
    }

    public /* synthetic */ void a(EnterRealmsResult enterRealmsResult) {
        this.P = enterRealmsResult;
        this.P.setTeam(true);
        f();
    }

    public /* synthetic */ void a(Boolean bool) {
        this.z.set(bool);
    }

    public /* synthetic */ void f(String str) {
        IntentUtils.startGooglePayActivity(this.f10939c, str, MessageToken.TOKEN_RECHARGE_PAY, "userId=" + AccountCenter.newInstance().userId.get());
    }

    public /* synthetic */ void a(Long l) {
        com.disabngo.blockynexus.e.b.x.K.a(this.f10939c, null, new FriendActivityIntentInfo(l.longValue(), l.longValue() == AccountCenter.newInstance().userId.get().longValue() ? 4 : 2));
    }

    public void f() {
        EnterRealmsResult enterRealmsResult = this.P;
        if (enterRealmsResult == null || enterRealmsResult.getGame() == null) {
            return;
        }
        DialogC1122va dialogC1122va = new DialogC1122va(this.f10939c, this.P.getGame().getGameId(), this.P.getGame());
        dialogC1122va.show();
        dialogC1122va.a(this.P);
        dialogC1122va.b();
        new com.disabngo.blockynexus.e.b.P.b(this.f10939c).a(this.P.getChatRoomId());
    }

    public nc(MainActivity mainActivity, String str) {
        this(mainActivity);
        h();
        GameDetailManager.enterGameDetail(mainActivity, mainActivity.getString(R.string.main_game), str);
    }

    public /* synthetic */ void a(ReportInfo reportInfo) {
        new ReportDialog(this.f10939c, reportInfo).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (2 != f10937a) {
            this.t.set(Boolean.valueOf(z));
        }
    }

    private void a(String str, boolean z, boolean z2, int i, BaseFragment baseFragment) {
        this.n.set(str);
        this.q.set(Boolean.valueOf(z));
        this.r.set(Boolean.valueOf(z2));
        f10937a = i;
        a(baseFragment);
        this.M = baseFragment;
    }

    static /* synthetic */ void f(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            Messenger.getDefault().sendNoMsg("token.init.rong.cloud");
        }
    }

    private void a(BaseFragment baseFragment) {
        androidx.fragment.app.F fA = this.f10939c.getSupportFragmentManager().a();
        fA.a(0);
        BaseFragment baseFragment2 = this.M;
        if (baseFragment2 != null) {
            fA.c(baseFragment2);
        }
        fA.e(baseFragment);
        fA.b();
    }

    public /* synthetic */ void a(HttpException httpException) {
        this.f10940d.a(this.f10939c, httpException);
    }
}
