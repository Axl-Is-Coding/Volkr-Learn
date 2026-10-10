package com.disabngo.blockynexus.view.activity.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0514k;
import com.disabngo.blockynexus.databinding.AbstractC0672o;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.manager.FeedBackManager;
import com.sandboxol.center.router.manager.MTPManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.mtp.MTPMessageType;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.router.moduleInfo.pay.RechargeBroadcastType;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.common.utils.PermissionUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.greendao.entity.User;
import com.sandboxol.messager.MessagerClient;
import com.tencent.map.geolocation.TencentLocation;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity extends BaseActivity<nc, AbstractC0672o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f10802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f10803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f10804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f10805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f10806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InviteMessage f10807f;
    private long[] g = new long[2];
    private boolean h = false;
    private boolean i = false;

    private void initMessenger() {
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_GAME_PING, new C1041ob(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_GAME_RAKNET_PING, new C1044pb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_GAME_FPS, new C1047qb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_SHOW_INVITE_MESSAGE, new C1049rb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_SHOW_INVITE_MESSAGE_NEXT, new C1052sb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_DRESS_SHOP_SHOW_AD, new C1055tb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_GAME_SHOW_AD_SUCCESS, new C1058ub(this));
        MessagerClient.getIns().registerMsg0(MainActivity.class, GameBroadcastType.BROADCAST_FRESH_MONEY, new C1061vb(this));
        MessagerClient.getIns().registerMsg0(MainActivity.class, GameBroadcastType.BROADCAST_BUY_ACTION_SUCCESS, new C1064wb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_VIEW_ENGINE2_ADS, new C1008db(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_VIEW_ENGINE1_ADS, new C1011eb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, RechargeBroadcastType.NAME_INTENT_UTILS, new C1014fb(this));
        MessagerClient.getIns().registerMsg0(MainActivity.class, GameBroadcastType.BROADCAST_SHOW_RED_POINT, new C1017gb(this));
        MessagerClient.getIns().registerMsg0(MainActivity.class, GameBroadcastType.BROADCAST_IS_SHOW_ADS_TIMER, new C1020hb(this));
        MessagerClient.getIns().registerMsg1(MainActivity.class, GameBroadcastType.BROADCAST_ENTER_GAME_SUCCESS, new com.sandboxol.messager.a.b() { // from class: com.disabngo.blockynexus.view.activity.main.d
            @Override // com.sandboxol.messager.a.b
            public final void onCall(com.sandboxol.messager.a.f fVar) {
                this.f10889a.a(fVar);
            }
        });
        MessagerClient.getIns().registerMsg1(MainActivity.class, MessageToken.TOKEN_MAIN_CLICK_CLOCK, new C1023ib(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_WHEELLUCKY_RECHARGE_PAY, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10893a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_JACKPOT_RECHARGE_PAY, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10905a.b((String) obj);
            }
        });
        MessagerClient.getIns().registerMsg0(MainActivity.class, MTPMessageType.TOKEN_MTP_KILL_PROCESS, new com.sandboxol.messager.a.a() { // from class: com.disabngo.blockynexus.view.activity.main.l
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f10924a.h();
            }
        });
        MessagerClient.getIns().registerMsg0(MainActivity.class, GameBroadcastType.BROADCAST_SHOW_SCRAP_ANIM, new com.sandboxol.messager.a.a() { // from class: com.disabngo.blockynexus.view.activity.main.j
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f10914a.i();
            }
        });
        MessagerClient.getIns().registerMsg1(MainActivity.class, BroadcastType.BROADCAST_ENTER_FRIEND_CHAT, new C1026jb(this));
    }

    private void k() {
        this.f10802a = new RelativeLayout(this);
        int deviceHeight = SizeUtil.getDeviceHeight(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 200.0f), (int) SizeUtil.dp2px(this, 120.0f));
        layoutParams.setMargins(0, deviceHeight / 2, 0, 0);
        this.f10802a.setLayoutParams(layoutParams);
        this.f10802a.setPadding((int) SizeUtil.dp2px(this, 10.0f), (int) SizeUtil.dp2px(this, 10.0f), (int) SizeUtil.dp2px(this, 10.0f), (int) SizeUtil.dp2px(this, 10.0f));
        this.f10802a.setBackgroundColor(getResources().getColor(R.color.inviteDialogBg));
        this.f10803b = new ImageView(this);
        this.f10803b.setLayoutParams(new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 40.0f), (int) SizeUtil.dp2px(this, 40.0f)));
        this.f10803b.setBackground(getResources().getDrawable(R.drawable.bg_party_invite_friend_head_shape));
        this.f10802a.addView(this.f10803b);
        this.f10804c = new TextView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins((int) SizeUtil.dp2px(this, 45.0f), 0, 0, 0);
        this.f10804c.setLayoutParams(layoutParams2);
        this.f10804c.setTextColor(getResources().getColor(R.color.invitorNameColor));
        this.f10804c.setTextSize(SizeUtil.sp2px(this, 4.0f));
        this.f10804c.setTypeface(Typeface.DEFAULT_BOLD);
        this.f10802a.addView(this.f10804c);
        this.f10805d = new TextView(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins((int) SizeUtil.dp2px(this, 45.0f), (int) SizeUtil.dp2px(this, 18.0f), 0, 0);
        this.f10805d.setLayoutParams(layoutParams3);
        this.f10805d.setTextColor(getResources().getColor(R.color.invitorGameNameColor));
        this.f10805d.setTextSize(SizeUtil.sp2px(this, 3.0f));
        this.f10805d.setMaxLines(2);
        this.f10805d.setEllipsize(TextUtils.TruncateAt.END);
        this.f10802a.addView(this.f10805d);
        this.f10806e = new TextView(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins((int) SizeUtil.dp2px(this, 80.0f), (int) SizeUtil.dp2px(this, 45.0f), 0, 0);
        this.f10806e.setLayoutParams(layoutParams4);
        this.f10806e.setTextColor(getResources().getColor(R.color.white));
        this.f10806e.setTextSize(SizeUtil.sp2px(this, 4.0f));
        this.f10806e.setTypeface(Typeface.DEFAULT_BOLD);
        this.f10802a.addView(this.f10806e);
        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 85.0f), (int) SizeUtil.dp2px(this, 30.0f));
        layoutParams5.setMargins(0, (int) SizeUtil.dp2px(this, 70.0f), 0, 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setBackground(getResources().getDrawable(R.mipmap.bg_party_invite_refuse_nor));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10932a.a(view);
            }
        });
        this.f10802a.addView(imageView);
        ImageView imageView2 = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 85.0f), (int) SizeUtil.dp2px(this, 30.0f));
        layoutParams6.setMargins((int) SizeUtil.dp2px(this, 95.0f), (int) SizeUtil.dp2px(this, 70.0f), 0, 0);
        imageView2.setLayoutParams(layoutParams6);
        imageView2.setBackground(getResources().getDrawable(R.mipmap.bg_party_invite_agree_nor));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10920a.b(view);
            }
        });
        this.f10802a.addView(imageView2);
        ((AbstractC0672o) this.binding).j.addView(this.f10802a);
        this.f10802a.setVisibility(8);
    }

    private void l() {
        com.disabngo.blockynexus.d.y.b().b(this);
        MTPManager.addReceiver();
        MTPManager.initGameMTP(Integer.valueOf(getString(R.string.mtp_game_id)).intValue(), getString(R.string.mtp_game_key), new Action0() { // from class: com.disabngo.blockynexus.view.activity.main.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f10897a.j();
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public /* synthetic */ void g() {
        ChannelManager.onGooglePayRegister(this);
        initMessenger();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public /* synthetic */ void h() {
        new OneButtonDialog(this).setDetailText(R.string.mtp_kill_process_tip).setAllowBackPress(false).show();
    }

    public /* synthetic */ void i() {
        new bc().a(this, (AbstractC0672o) this.binding);
    }

    public /* synthetic */ void j() {
        MTPManager.loginGameMTP(99, 0, String.valueOf(AccountCenter.newInstance().userId.get()), "");
        this.i = true;
        MTPManager.onAppResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || this.viewModel == 0) {
            return;
        }
        if (i == 2001) {
            if (com.disabngo.blockynexus.d.p.a(this)) {
                ReportDataAdapter.onEvent(this, EventConstant.ENTER_GPS_SETTING_SUCCESS);
                ReportDataAdapter.onEvent(this, EventConstant.CLICK_FRIEND_MATCH_FAIL, EventConstant.ENTER_GPS_SETTING_SUCCESS);
                new com.disabngo.blockynexus.e.b.O.q().a((Activity) this);
                return;
            }
            return;
        }
        if (i != 10001) {
            return;
        }
        com.apkfuns.logutils.c.a("StartMc").b("onActivityResult from game -------------------------------------");
        if (intent.getBooleanExtra(GameConstant.IS_NEXT_GAME, false)) {
            ((nc) this.viewModel).ha();
        } else if (intent.getBooleanExtra(GameConstant.IS_GO_PREPAID, false)) {
            TemplateUtils.startTemplate(this, com.sandboxol.googlepay.view.fragment.recharge.k.class, getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
        } else {
            com.disabngo.blockynexus.b.b.a().a(this, intent.getSerializableExtra(GameConstant.CHRISTMAS_LEVEL_INFO), new OnDataListener() { // from class: com.disabngo.blockynexus.view.activity.main.i
                @Override // com.sandboxol.common.interfaces.OnDataListener
                public final void onSuccess(Object obj) {
                    this.f10909a.a(intent, obj);
                }
            });
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        long[] jArr = this.g;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.g;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (SystemClock.uptimeMillis() - this.g[0] >= 1000) {
            AppToastUtils.showShortPositiveTipToast(this, R.string.exit);
        } else {
            com.disabngo.blockynexus.utils.logic.N.a((Activity) this);
            finish();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        SandboxReportManager.onEvent("new_home_view", ReportEventType.NEW_USER_BEHAVIOR, "app");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, "home_view");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, "new_home_view");
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        MTPManager.setOpenMtp(false);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        ((nc) this.viewModel).ga();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        super.onPause();
        ReportDataAdapter.onPause(this);
        if (isFinishing()) {
            ChannelManager.onGooglePayDestroy(this);
            MessagerClient.getIns().unRegisterMsg(MainActivity.class);
            if (Build.VERSION.SDK_INT < 21) {
                Observable.just(true).delay(500L, TimeUnit.MILLISECONDS).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.g
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        MainActivity.a((Boolean) obj);
                    }
                });
            } else {
                Process.myPid();
            }
        }
        if (this.i) {
            MTPManager.onAppPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (!PermissionUtils.checkPermission(iArr)) {
            PermissionUtils.showPermissionsToast(this, strArr);
            return;
        }
        if (i == 1 || i == 2) {
            return;
        }
        if (i != 1004) {
            if (i != 1005) {
                return;
            }
            ReportDataAdapter.onEvent(this, EventConstant.POSITION_ACCEPT_TIME_ACCEPT);
        } else {
            com.disabngo.blockynexus.utils.logic.N.n();
            com.disabngo.blockynexus.utils.logic.N.b(this);
            ReportDataAdapter.onEvent(this, EventConstant.LOCATION_SUCCESS_GET_PERMISSION);
            new com.disabngo.blockynexus.e.a.a.l().a(this, (OnDataListener<TencentLocation>) null);
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.h) {
            this.h = false;
        }
        ChannelManager.onGooglePayResume(this);
        if (com.disabngo.blockynexus.d.A.b(this)) {
            ReportDataAdapter.onEvent(this, EventConstant.HAS_GOOGLEPLAY, "1");
        } else {
            ReportDataAdapter.onEvent(this, EventConstant.HAS_GOOGLEPLAY, "0");
        }
        if (!com.disabngo.blockynexus.utils.logic.N.h()) {
            new com.disabngo.blockynexus.e.b.o.v().b(this);
        }
        ReportDataAdapter.onEvent(this, "home_view");
        ReportDataAdapter.onEvent(this, EventConstant.ENTER_HOMEPAGE);
        FirebaseUtils.onEvent(this, EventConstant.ENTER_HOMEPAGE);
        ReportDataAdapter.onResume(this);
        FeedBackManager.getUnReadCount();
        if (this.i) {
            MTPManager.onAppResume();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
    }

    public /* synthetic */ void b(String str) {
        TemplateUtils.startTemplate(this, com.sandboxol.googlepay.view.fragment.recharge.k.class, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public nc getViewModel() {
        return getIntent().getStringExtra("GotoGame") != null ? new nc(this, getIntent().getStringExtra("GotoGame")) : new nc(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0672o abstractC0672o, nc ncVar) {
        abstractC0672o.a(ncVar);
        BaseApplication.getThreadPool().setName("init-MainActivity-Messenger");
        BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.main.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f10928a.g();
            }
        });
        k();
    }

    public /* synthetic */ void b(View view) {
        if (this.f10807f != null) {
            AppInfoCenter.newInstance().setNowParty(false);
            new bc().a(this, this.f10807f, 7);
        }
    }

    public /* synthetic */ void a(com.sandboxol.messager.a.f fVar) {
        String string;
        Bundle bundleA = fVar.a();
        if (bundleA == null || (string = bundleA.getString("game.id")) == null) {
            return;
        }
        C0514k.a(this, string);
    }

    public /* synthetic */ void a(String str) {
        TemplateUtils.startTemplate(this, com.sandboxol.googlepay.view.fragment.recharge.k.class, str);
    }

    static /* synthetic */ void a(Boolean bool) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        Process.myPid();
    }

    private void a(Intent intent) {
        Uri data;
        if (!"android.intent.action.VIEW".equals(intent.getAction()) || (data = intent.getData()) == null) {
            return;
        }
        if ("/pay".equals(data.getPath())) {
            Uri uri = Uri.parse(data.toString().replace("amp;", ""));
            Bundle bundle = new Bundle();
            bundle.putString(StringConstant.PAY_STATE, uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_STATE));
            bundle.putString(StringConstant.PAY_PRODUCT_ID, uri.getQueryParameter("productId"));
            bundle.putString(StringConstant.PAY_PM_ID, uri.getQueryParameter("pmId"));
            if (uri.getQueryParameter("productId").contains("vip")) {
                VipManager.enterVipFragment(this);
                return;
            } else {
                TemplateUtils.startTemplate(this, com.sandboxol.googlepay.view.fragment.recharge.k.class, getString(R.string.me_recharge), bundle);
                return;
            }
        }
        if (data.getPath().equals("/signature")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(StringConstant.PAY_SIGNATURE_ERROR, true);
            TemplateUtils.startTemplate(this, com.sandboxol.googlepay.view.fragment.recharge.k.class, getString(R.string.me_recharge), bundle2);
        }
    }

    public /* synthetic */ void a(View view) {
        this.f10802a.setVisibility(8);
        MultiProcessSharedUtils.getInt(this, SharedConstant.PARTY_INVITE_REFUSE_COUNT, new C1029kb(this));
    }

    public void a(InviteMessage inviteMessage) {
        if (!SharedUtils.getBoolean((Context) this, SharedConstant.SHARE_KEY_SHOW_PARTY_DIALOG, true)) {
            this.f10802a.setVisibility(8);
        } else {
            this.f10802a.setVisibility(0);
        }
        this.f10807f = inviteMessage;
        try {
            com.bumptech.glide.c.c(BaseApplication.getContext()).mo55load(inviteMessage.getCaptainPicUrl()).into(this.f10803b);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        this.f10804c.setText(inviteMessage.getCaptainName());
        this.f10805d.setText(getString(R.string.party_join_game_introduce, new Object[]{inviteMessage.getGameName()}));
        new CountDownTimerC1032lb(this, 5000L, 1000L).start();
    }

    public /* synthetic */ void a(Intent intent, Object obj) {
        User user = new User();
        user.setGolds(AccountCenter.newInstance().golds.get().longValue());
        user.setDiamonds(AccountCenter.newInstance().diamonds.get().longValue());
        user.setGDiamonds(AccountCenter.newInstance().gDiamonds.get().longValue());
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            BillingManager.getInstance().updateUserMoney(this);
        }
        com.sandboxol.greendao.c.ya.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), new C1038nb(this, intent, user));
    }
}
