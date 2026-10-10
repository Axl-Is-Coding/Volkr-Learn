package com.sandboxol.blockmango;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.blockmango.BlockManEchoesActivity;
import com.sandboxol.blockmango.EchoesHandler;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.blockmango.config.GameStringConstant;
import com.sandboxol.blockmango.entity.ActionTriggerFunName;
import com.sandboxol.blockmango.entity.ActionTriggerParams;
import com.sandboxol.blockmango.entity.GameTimeToday;
import com.sandboxol.blocky.dialog.ScrapBoxDialog;
import com.sandboxol.blocky.dialog.ScrapLoadingDialog;
import com.sandboxol.blocky.dialog.scrapanim.ScrapReceivedAnimDialog;
import com.sandboxol.blocky.router.ControllerType;
import com.sandboxol.blocky.router.RealmsController;
import com.sandboxol.blocky.utils.ActionTriggerError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapTreasureBoxConfig;
import com.sandboxol.center.entity.ScrapTreasureBoxInfo;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.router.moduleInfo.mtp.MTPMessageType;
import com.sandboxol.center.router.moduleInfo.pay.RechargeBroadcastType;
import com.sandboxol.center.utils.GameSharedUtils;
import com.sandboxol.center.utils.GameUtils;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.center.utils.XCountDownTimer;
import com.sandboxol.center.view.widget.FloatCircleView;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.game.R;
import com.sandboxol.greendao.entity.FloatViewInfo;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.messager.MessagerClient;
import com.umeng.analytics.pro.au;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.fmod.FMOD;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class BlockManEchoesActivity extends EchoesActivity {
    private static final String CHILD_TAG = "ChildThread";
    private static final String TAG = "EchoesActivity";
    private Timer adsTimer;
    private InviteMessage inviteMessage;
    private boolean isGameFinish;
    private boolean isOnEvent;
    private boolean isStartScrapBoxTimer;
    private ImageView ivInvitorHeader;
    private int lastSecondesLeft;
    private int lastTime;
    private ScrapLoadingDialog loadingDialog;
    private View mBgView;
    private RelativeLayout mDialog;
    private FloatCircleView mFloatCircleView;
    private FrameLayout mFrameLayout;
    private LinearLayout mLinearLayout;
    private ProgressBar mProgressBar;
    private RelativeLayout mRelativeLayout;
    private ScrapBoxDialog mScrapBoxDialog;
    private TextView mTextView;
    private TextView mVersionTextView;
    private View mView;
    private XCountDownTimer scrapBoxTimer;
    private XCountDownTimer scrapTimer;
    private View transparentView;
    private TextView tvCountDown;
    private TextView tvGameName;
    private TextView tvInvitorName;
    private ObservableList<ScrapTreasureBoxInfo> treasureBoxInfos = new ObservableArrayList();
    private ObservableField<Integer> gameTimesToday = new ObservableField<>(0);
    private int index = 0;
    private ObservableField<Integer> todayRemainTime = new ObservableField<>(0);
    private ObservableField<Integer> probsNum = new ObservableField<>(0);
    private ObservableField<Integer> rewardValue = new ObservableField<>(0);

    /* JADX INFO: renamed from: com.sandboxol.blockmango.BlockManEchoesActivity$10, reason: invalid class name */
    class AnonymousClass10 implements com.sandboxol.messager.a.b {
        AnonymousClass10() {
        }

        static /* synthetic */ void a(long j) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onFriendOperationForAppHttpResult(3, j);
            }
        }

        @Override // com.sandboxol.messager.a.b
        public void onCall(com.sandboxol.messager.a.f fVar) {
            final long jA = fVar.a(GameConstant.GAME_FRIEND_ID_BACK, 0L);
            BlockManEchoesActivity.this.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.l
                @Override // java.lang.Runnable
                public final void run() {
                    BlockManEchoesActivity.AnonymousClass10.a(jA);
                }
            });
            Log.e("EchoesGLSurfaceView", "getFriendDetailNotNull");
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.blockmango.BlockManEchoesActivity$11, reason: invalid class name */
    class AnonymousClass11 implements com.sandboxol.messager.a.b {
        AnonymousClass11() {
        }

        static /* synthetic */ void a(long j) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onFriendOperationForAppHttpResult(10000, j);
            }
        }

        @Override // com.sandboxol.messager.a.b
        public void onCall(com.sandboxol.messager.a.f fVar) {
            final long jA = fVar.a(GameConstant.GAME_FRIEND_ID_BACK, 0L);
            BlockManEchoesActivity.this.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.m
                @Override // java.lang.Runnable
                public final void run() {
                    BlockManEchoesActivity.AnonymousClass11.a(jA);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.blockmango.BlockManEchoesActivity$12, reason: invalid class name */
    class AnonymousClass12 implements com.sandboxol.messager.a.b {
        AnonymousClass12() {
        }

        static /* synthetic */ void a(long j) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onFriendOperationForAppHttpResult(4, j);
            }
        }

        @Override // com.sandboxol.messager.a.b
        public void onCall(com.sandboxol.messager.a.f fVar) {
            final long jA = fVar.a(GameConstant.GAME_FRIEND_ID_BACK, 0L);
            BlockManEchoesActivity.this.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.n
                @Override // java.lang.Runnable
                public final void run() {
                    BlockManEchoesActivity.AnonymousClass12.a(jA);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.blockmango.BlockManEchoesActivity$13, reason: invalid class name */
    class AnonymousClass13 implements com.sandboxol.messager.a.b {
        AnonymousClass13() {
        }

        static /* synthetic */ void a(long j) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onFriendOperationForAppHttpResult(10001, j);
            }
        }

        @Override // com.sandboxol.messager.a.b
        public void onCall(com.sandboxol.messager.a.f fVar) {
            final long jA = fVar.a(GameConstant.GAME_FRIEND_ID_BACK, 0L);
            BlockManEchoesActivity.this.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.o
                @Override // java.lang.Runnable
                public final void run() {
                    BlockManEchoesActivity.AnonymousClass13.a(jA);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.blockmango.BlockManEchoesActivity$22, reason: invalid class name */
    static /* synthetic */ class AnonymousClass22 {
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$blocky$router$ControllerType = new int[ControllerType.values().length];

        static {
            try {
                $SwitchMap$com$sandboxol$blocky$router$ControllerType[ControllerType.BLOCK_MAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.blockmango.BlockManEchoesActivity$9, reason: invalid class name */
    class AnonymousClass9 implements com.sandboxol.messager.a.b {
        AnonymousClass9() {
        }

        static /* synthetic */ void a(long j) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onFriendOperationForAppHttpResult(2, j);
            }
        }

        static /* synthetic */ void b(long j) {
            if (EchoesGLSurfaceView.getInstance() != null) {
                EchoesGLSurfaceView.getInstance().onFriendOperationForAppHttpResult(1, j);
            }
        }

        @Override // com.sandboxol.messager.a.b
        public void onCall(com.sandboxol.messager.a.f fVar) {
            final long jA = fVar.a(GameConstant.GAME_FRIEND_ID_BACK, 0L);
            if (fVar.a(GameConstant.GAME_IS_FRIEND_BACK, false)) {
                BlockManEchoesActivity.this.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        BlockManEchoesActivity.AnonymousClass9.a(jA);
                    }
                });
            } else {
                BlockManEchoesActivity.this.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        BlockManEchoesActivity.AnonymousClass9.b(jA);
                    }
                });
            }
            Log.e("EchoesGLSurfaceView", "getFriendDetailNotNull");
        }
    }

    private void adsTimer() {
        if (this.adsTimer == null) {
            this.adsTimer = new Timer();
            this.adsTimer.schedule(new TimerTask() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_IS_SHOW_ADS_TIMER);
                }
            }, 60000L, 60000L);
        }
    }

    private void destroyScrap() {
        this.isGameFinish = true;
        ScrapLoadingDialog scrapLoadingDialog = this.loadingDialog;
        if (scrapLoadingDialog != null && scrapLoadingDialog.isShowing()) {
            this.loadingDialog.c();
        }
        ScrapBoxDialog scrapBoxDialog = this.mScrapBoxDialog;
        if (scrapBoxDialog != null && scrapBoxDialog.isShowing()) {
            this.mScrapBoxDialog.c();
        }
        XCountDownTimer xCountDownTimer = this.scrapTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.cancel();
            this.scrapTimer = null;
        }
        XCountDownTimer xCountDownTimer2 = this.scrapBoxTimer;
        if (xCountDownTimer2 != null) {
            xCountDownTimer2.cancel();
            this.scrapBoxTimer = null;
        }
        FloatCircleView floatCircleView = this.mFloatCircleView;
        if (floatCircleView != null) {
            this.mFrameLayout.removeView(floatCircleView);
        }
    }

    private void initBroadcastReceiver() {
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_ENTER_GAME_CHECK_BACK, new AnonymousClass9());
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND_BACK, new AnonymousClass10());
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND_ERROR_BACK, new AnonymousClass11());
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND_BACK, new AnonymousClass12());
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND_ERROR_BACK, new AnonymousClass13());
        MessagerClient.getIns().registerMsg0(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_SHOW_ADS, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.14
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                MultiProcessSharedUtils.putBoolean(BlockManEchoesActivity.this, "is.show.ads", true);
                BlockManEchoesActivity.this.mGLSurfaceView.onGameActionTrigger(4);
            }
        });
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_HIDE_ADS, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.15
            @Override // com.sandboxol.messager.a.b
            public void onCall(com.sandboxol.messager.a.f fVar) {
                MultiProcessSharedUtils.putBoolean(BlockManEchoesActivity.this, "is.show.ads", false);
                BlockManEchoesActivity.this.mGLSurfaceView.onGameActionTrigger(5);
            }
        });
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_SHOW_ENGINE2_ADS_RESULT, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.16
            @Override // com.sandboxol.messager.a.b
            public void onCall(com.sandboxol.messager.a.f fVar) {
                int iA = fVar.a("game.ads.type", 0);
                int iA2 = fVar.a("game.ads.result", 0);
                if (iA2 == 1) {
                    EchoesGLSurfaceView.getInstance().onWatchAdSuccess(iA);
                } else if (iA2 == 2) {
                    EchoesGLSurfaceView.getInstance().onWatchAdSuccess(iA);
                } else {
                    if (iA2 != 3) {
                        return;
                    }
                    EchoesGLSurfaceView.getInstance().onCloseAd(iA);
                }
            }
        });
        MessagerClient.getIns().registerMsg0(BlockManEchoesActivity.class, RechargeBroadcastType.BROADCAST_GAME_REFRESH_DRESS, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.17
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = BlockManEchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onGameActionTrigger(1);
                }
            }
        });
        MessagerClient.getIns().registerMsg1(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_SHOW_INVITE_MESSAGE_GAME, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.18
            @Override // com.sandboxol.messager.a.b
            public void onCall(com.sandboxol.messager.a.f fVar) {
                InviteMessage inviteMessage = (InviteMessage) fVar.b(GameConstant.INVITE_TEAM_MESSAGE);
                if (inviteMessage != null) {
                    BlockManEchoesActivity.this.setInviteMessage(inviteMessage);
                }
            }
        });
        MessagerClient.getIns().registerMsg0(BlockManEchoesActivity.class, RechargeBroadcastType.BROADCAST_GAME_RECHARGE_SUCCESS, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.19
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = BlockManEchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onRechargeResult(1, 1);
                }
            }
        });
        MessagerClient.getIns().registerMsg0(BlockManEchoesActivity.class, GameBroadcastType.BROADCAST_PARTY_EXIT_GAME, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.20
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = BlockManEchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.gameExit();
                }
            }
        });
        MessagerClient.getIns().registerMsg0(BlockManEchoesActivity.class, RechargeBroadcastType.BROADCAST_GAME_RECHARGE_FAILED, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.21
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                EchoesGLSurfaceView echoesGLSurfaceView = BlockManEchoesActivity.this.mGLSurfaceView;
                if (echoesGLSurfaceView != null) {
                    echoesGLSurfaceView.onRechargeResult(1, 0);
                }
            }
        });
        MessagerClient.getIns().registerMsg0(BlockManEchoesActivity.class, MTPMessageType.TOKEN_MTP_KILL_PROCESS, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.A
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f16048a.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initGameTimeToday(final com.sandboxol.blockmango.entity.ActionTriggerParams<com.sandboxol.blockmango.entity.GameTimeToday> r6) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.blockmango.BlockManEchoesActivity.initGameTimeToday(com.sandboxol.blockmango.entity.ActionTriggerParams):void");
    }

    private void initInviteView() {
        this.mDialog = new RelativeLayout(this);
        int deviceHeight = SizeUtil.getDeviceHeight(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 200.0f), (int) SizeUtil.dp2px(this, 120.0f));
        layoutParams.setMargins(0, deviceHeight / 10, 0, 0);
        this.mDialog.setLayoutParams(layoutParams);
        this.mDialog.setPadding((int) SizeUtil.dp2px(this, 10.0f), (int) SizeUtil.dp2px(this, 10.0f), (int) SizeUtil.dp2px(this, 10.0f), (int) SizeUtil.dp2px(this, 10.0f));
        this.mDialog.setBackgroundColor(getResources().getColor(R.color.inviteDialogBg));
        this.ivInvitorHeader = new ImageView(this);
        this.ivInvitorHeader.setLayoutParams(new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 40.0f), (int) SizeUtil.dp2px(this, 40.0f)));
        this.ivInvitorHeader.setBackground(getResources().getDrawable(R.drawable.bg_party_invite_friend_head_shape));
        this.mDialog.addView(this.ivInvitorHeader);
        this.tvInvitorName = new TextView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins((int) SizeUtil.dp2px(this, 45.0f), 0, 0, 0);
        this.tvInvitorName.setLayoutParams(layoutParams2);
        this.tvInvitorName.setTextColor(getResources().getColor(R.color.invitorNameColor));
        this.tvInvitorName.setTextSize(SizeUtil.sp2px(this, 4.0f));
        this.tvInvitorName.setTypeface(Typeface.DEFAULT_BOLD);
        this.mDialog.addView(this.tvInvitorName);
        this.tvGameName = new TextView(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins((int) SizeUtil.dp2px(this, 45.0f), (int) SizeUtil.dp2px(this, 18.0f), 0, 0);
        this.tvGameName.setLayoutParams(layoutParams3);
        this.tvGameName.setTextColor(getResources().getColor(R.color.invitorGameNameColor));
        this.tvGameName.setTextSize(SizeUtil.sp2px(this, 3.0f));
        this.tvGameName.setMaxLines(2);
        this.tvGameName.setEllipsize(TextUtils.TruncateAt.END);
        this.mDialog.addView(this.tvGameName);
        this.tvCountDown = new TextView(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins((int) SizeUtil.dp2px(this, 80.0f), (int) SizeUtil.dp2px(this, 45.0f), 0, 0);
        this.tvCountDown.setLayoutParams(layoutParams4);
        this.tvCountDown.setTextColor(getResources().getColor(R.color.white));
        this.tvCountDown.setTextSize(SizeUtil.sp2px(this, 4.0f));
        this.tvCountDown.setTypeface(Typeface.DEFAULT_BOLD);
        this.mDialog.addView(this.tvCountDown);
        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 85.0f), (int) SizeUtil.dp2px(this, 30.0f));
        layoutParams5.setMargins(0, (int) SizeUtil.dp2px(this, 70.0f), 0, 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setBackground(getResources().getDrawable(R.mipmap.bg_party_invite_refuse_nor));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.blockmango.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16282a.a(view);
            }
        });
        this.mDialog.addView(imageView);
        ImageView imageView2 = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams((int) SizeUtil.dp2px(this, 85.0f), (int) SizeUtil.dp2px(this, 30.0f));
        layoutParams6.setMargins((int) SizeUtil.dp2px(this, 95.0f), (int) SizeUtil.dp2px(this, 70.0f), 0, 0);
        imageView2.setLayoutParams(layoutParams6);
        imageView2.setBackground(getResources().getDrawable(R.mipmap.bg_party_invite_agree_nor));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.blockmango.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16250a.b(view);
            }
        });
        this.mDialog.addView(imageView2);
        this.mFrameLayout.addView(this.mDialog);
        this.mDialog.setVisibility(8);
    }

    private void initScrapBoxList(final String str) {
        ScrapApi.getScrapTreasureBoxList(this, new OnResponseListener<ScrapTreasureBoxConfig>() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.6
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str2) {
                ScrapOnError.showErrorTip(BlockManEchoesActivity.this.getBaseContext(), i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                ServerOnError.showOnServerError(BlockManEchoesActivity.this.getBaseContext(), i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(ScrapTreasureBoxConfig scrapTreasureBoxConfig) {
                if (scrapTreasureBoxConfig == null || scrapTreasureBoxConfig.getBoxList() == null || scrapTreasureBoxConfig.getBoxList().size() < 5) {
                    return;
                }
                BlockManEchoesActivity.this.isOnEvent = false;
                BlockManEchoesActivity.this.mFloatCircleView.setVisibility(0);
                if (BlockManEchoesActivity.this.mScrapBoxDialog != null && BlockManEchoesActivity.this.mScrapBoxDialog.isShowing() && BlockManEchoesActivity.this.treasureBoxInfos.size() != scrapTreasureBoxConfig.getBoxList().size()) {
                    BlockManEchoesActivity.this.mScrapBoxDialog.c();
                }
                BlockManEchoesActivity.this.treasureBoxInfos.clear();
                BlockManEchoesActivity.this.treasureBoxInfos.addAll(scrapTreasureBoxConfig.getBoxList());
                BlockManEchoesActivity.this.probsNum.set(Integer.valueOf(scrapTreasureBoxConfig.getProbsNum()));
                BlockManEchoesActivity.this.rewardValue.set(Integer.valueOf(scrapTreasureBoxConfig.getRewardValue()));
                ActionTriggerParams actionTriggerParams = (ActionTriggerParams) new com.google.gson.j().a(str, new TypeToken<ActionTriggerParams<GameTimeToday>>() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.6.1
                }.getType());
                if (actionTriggerParams == null || actionTriggerParams.getData() == null) {
                    return;
                }
                BlockManEchoesActivity.this.initGameTimeToday(actionTriggerParams);
            }
        });
    }

    private void setCountDownTime(int i, final io.reactivex.b.a aVar) {
        this.scrapTimer = new XCountDownTimer(i, 1000L) { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.7
            @Override // com.sandboxol.center.utils.XCountDownTimer
            public void onFinish() {
                BlockManEchoesActivity.this.mFloatCircleView.setRemainingTime(4, "");
                try {
                    aVar.run();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.sandboxol.center.utils.XCountDownTimer
            public void onTick(long j) {
                String strValueOf;
                String strValueOf2;
                long j2 = j / 60000;
                long j3 = (j % 60000) / 1000;
                if (j2 < 10) {
                    strValueOf = "0" + j2;
                } else {
                    strValueOf = String.valueOf(j2);
                }
                if (j3 < 10) {
                    strValueOf2 = "0" + j3;
                } else {
                    strValueOf2 = String.valueOf(j3);
                }
                BlockManEchoesActivity.this.gameTimesToday.set(Integer.valueOf(((Integer) BlockManEchoesActivity.this.gameTimesToday.get()).intValue() + 1));
                BlockManEchoesActivity.this.mFloatCircleView.setRemainingTime(0, strValueOf + ":" + strValueOf2);
                BlockManEchoesActivity.this.mFloatCircleView.setBoxPic(ScrapOutlineViewReturnHelper.getScrapBoxResId(((ScrapTreasureBoxInfo) BlockManEchoesActivity.this.treasureBoxInfos.get(BlockManEchoesActivity.this.index)).getTreasureBoxType()));
            }
        };
        this.scrapTimer.start();
    }

    private void setScrapBoxCountDownTime(int i) {
        if (!this.isStartScrapBoxTimer) {
            this.scrapBoxTimer = new XCountDownTimer(i, 1000L) { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.8
                @Override // com.sandboxol.center.utils.XCountDownTimer
                public void onFinish() {
                }

                @Override // com.sandboxol.center.utils.XCountDownTimer
                public void onTick(long j) {
                    BlockManEchoesActivity.this.todayRemainTime.set(Integer.valueOf(((Integer) BlockManEchoesActivity.this.todayRemainTime.get()).intValue() - 1));
                }
            };
            this.isStartScrapBoxTimer = true;
        }
        XCountDownTimer xCountDownTimer = this.scrapBoxTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.cancel();
            this.scrapBoxTimer.setMillisInFuture(i);
            this.scrapBoxTimer.start();
        }
    }

    private void showScrapBoxDialog() {
        try {
            this.mScrapBoxDialog = new ScrapBoxDialog(this, this.treasureBoxInfos, this.gameTimesToday, this.todayRemainTime, this.probsNum, this.rewardValue, new ScrapBoxDialog.Listener() { // from class: com.sandboxol.blockmango.w
                @Override // com.sandboxol.blocky.dialog.ScrapBoxDialog.Listener
                public final void callBack(String str, int i) {
                    this.f16277a.a(str, i);
                }
            });
            this.mScrapBoxDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
            ReportDataAdapter.onError(this, e2);
        }
    }

    private void stopTimer() {
        Timer timer = this.adsTimer;
        if (timer != null) {
            timer.cancel();
            this.adsTimer = null;
        }
        XCountDownTimer xCountDownTimer = this.scrapTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.cancel();
            this.scrapTimer = null;
        }
        XCountDownTimer xCountDownTimer2 = this.scrapBoxTimer;
        if (xCountDownTimer2 != null) {
            xCountDownTimer2.cancel();
            this.scrapBoxTimer = null;
        }
    }

    @Override // com.sandboxol.blockmango.EchoesActivity
    public void DoMainInit() {
        File file = new File(EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).getConfigPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        Message message = new Message();
        message.what = 4;
        message.obj = new EchoesHandler.CopyComplete();
        this.mHandler.sendMessage(message);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity
    public void RemoveLoadingView() {
        onLoadMapComplete(2);
        this.mFrameLayout.removeView(this.mTextView);
        this.mFrameLayout.removeView(this.mView);
        this.mBgView.setVisibility(8);
        this.mFrameLayout.removeView(this.mProgressBar);
        this.mFrameLayout.removeView(this.mLinearLayout);
        this.mFrameLayout.removeView(this.mRelativeLayout);
        this.mFrameLayout.removeView(this.mVersionTextView);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity
    public void SetUpdateTips(String str) {
        this.mTextView.setText(str);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity
    public void SetVersionText(String str, String str2) {
        this.mVersionTextView.setText(String.format("%s %s \n%s %s", getString(R.string.local_version_text), str, getString(R.string.server_version_text), str2));
    }

    public /* synthetic */ void a(int i) {
        if ((i & 4) == 0) {
            toggleHideBar();
        }
    }

    @Override // com.sandboxol.blockmango.EchoesActivity
    public void addLoadingView() {
        this.mBgView.setVisibility(0);
    }

    public /* synthetic */ void b() {
        this.mFloatCircleView.setListener(new FloatCircleView.FloatCircleListener() { // from class: com.sandboxol.blockmango.v
            @Override // com.sandboxol.center.view.widget.FloatCircleView.FloatCircleListener
            public final void onClick() {
                this.f16275a.e();
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mFloatCircleView.getLocationX(), this.mFloatCircleView.getLocationY(), 0, 0);
        this.mFrameLayout.addView(this.mFloatCircleView, layoutParams);
        this.mFloatCircleView.setVisibility(8);
    }

    public /* synthetic */ void c() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        finish();
        Process.killProcess(Process.myPid());
    }

    public /* synthetic */ void d() throws Exception {
        if (this.isOnEvent) {
            return;
        }
        ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.REACH_COLLECT_CHEST_CONDITION);
        this.isOnEvent = true;
    }

    public /* synthetic */ void e() {
        ReportDataAdapter.onEvent(this, EventConstant.CLICK_COLLECT_CHEST_ENTRANCE);
        if (this.treasureBoxInfos.size() >= 5) {
            showScrapBoxDialog();
        } else {
            ToastUtils.showShortToast(this, R.string.no_data);
        }
    }

    public /* synthetic */ void f() throws Exception {
        if (this.isOnEvent) {
            return;
        }
        ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.REACH_COLLECT_CHEST_CONDITION);
        this.isOnEvent = true;
    }

    public /* synthetic */ void g() throws Exception {
        if (this.isOnEvent) {
            return;
        }
        ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.REACH_COLLECT_CHEST_CONDITION);
        this.isOnEvent = true;
    }

    public void init(String str, String str2) {
        this.isGameFinish = false;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mFrameLayout = new FrameLayout(this);
        this.mFrameLayout.setLayoutParams(layoutParams);
        this.mRenderer = new EchoesRenderer(this);
        FMOD.init(this);
        onCreateView(str2);
        this.mFrameLayout.addView(this.mGLSurfaceView);
        this.mBgView = LayoutInflater.from(this).inflate(R.layout.activity_start_mc, (ViewGroup) null);
        this.mFrameLayout.addView(this.mBgView);
        this.mTextView = new TextView(this);
        this.mVersionTextView = new TextView(this);
        this.mLinearLayout = new LinearLayout(this);
        this.mRelativeLayout = new RelativeLayout(this);
        this.mView = new View(this);
        this.mProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        this.mFloatCircleView = new FloatCircleView(this, new FloatCircleView.FloatCircleLocationListener() { // from class: com.sandboxol.blockmango.z
            @Override // com.sandboxol.center.view.widget.FloatCircleView.FloatCircleLocationListener
            public final void onInitSuccess() {
                this.f16292a.b();
            }
        });
        this.transparentView = new View(this);
        this.mTextView.setGravity(81);
        this.mTextView.setTextSize(12.0f);
        this.mTextView.setTextColor(getResources().getColor(R.color.white));
        this.mTextView.setText(getString(R.string.download_map_successfull));
        this.mFrameLayout.addView(this.mTextView);
        this.mVersionTextView.setText("");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(12);
        this.mRelativeLayout.setLayoutParams(layoutParams2);
        this.mFrameLayout.addView(this.mRelativeLayout);
        this.mFrameLayout.addView(this.transparentView, -1, -1);
        com.sandboxol.greendao.c.oa.newInstance().b();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 200);
        layoutParams3.addRule(12);
        this.mView.setLayoutParams(layoutParams3);
        this.mView.setBackground(getResources().getDrawable(R.drawable.bg_item_little_funding));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(50, 0, 50, 35);
        layoutParams4.addRule(12);
        this.mLinearLayout.setLayoutParams(layoutParams4);
        this.mLinearLayout.setBackgroundColor(getResources().getColor(R.color.black));
        this.mLinearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 10);
        layoutParams5.setMargins(2, 2, 2, 2);
        this.mProgressBar.setLayoutParams(layoutParams5);
        this.mProgressBar.setMax(110);
        this.mProgressBar.setProgress(105);
        this.mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.enter_game_progress_bar));
        this.mLinearLayout.addView(this.mProgressBar);
        this.mRelativeLayout.addView(this.mView);
        this.mRelativeLayout.addView(this.mLinearLayout);
        this.mFrameLayout.addView(this.mVersionTextView);
        initInviteView();
        setContentView(this.mFrameLayout);
        getWindow().addFlags(128);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onAppActionTrigger(int i, String str) {
        ActionTriggerFunName actionTriggerFunName;
        super.onAppActionTrigger(i, str);
        if (i != 10001 || (actionTriggerFunName = (ActionTriggerFunName) new com.google.gson.j().a(str, ActionTriggerFunName.class)) == null || actionTriggerFunName.getFunctionName() == null) {
            return;
        }
        String functionName = actionTriggerFunName.getFunctionName();
        byte b2 = -1;
        int iHashCode = functionName.hashCode();
        int boxIndex = 0;
        if (iHashCode != 457852122) {
            if (iHashCode != 940385149) {
                if (iHashCode == 1000658661 && functionName.equals(GameStringConstant.ON_GAME_OVER)) {
                    b2 = 2;
                }
            } else if (functionName.equals(GameStringConstant.EXCHANGE_RECEIVE_RESULT)) {
                b2 = 1;
            }
        } else if (functionName.equals(GameStringConstant.UPDATE_EXCHANGE_INFO)) {
            b2 = 0;
        }
        if (b2 == 0) {
            if (this.isGameFinish) {
                return;
            }
            ObservableList<ScrapTreasureBoxInfo> observableList = this.treasureBoxInfos;
            if (observableList == null || observableList.size() <= 0) {
                initScrapBoxList(str);
                return;
            }
            try {
                ActionTriggerParams<GameTimeToday> actionTriggerParams = (ActionTriggerParams) new com.google.gson.j().a(str, new TypeToken<ActionTriggerParams<GameTimeToday>>() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.4
                }.getType());
                if (actionTriggerParams == null || actionTriggerParams.getData() == null) {
                    return;
                }
                if (actionTriggerParams.getData().getSecondsLeft() > this.lastSecondesLeft) {
                    initScrapBoxList(str);
                    return;
                } else {
                    initGameTimeToday(actionTriggerParams);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ReportDataAdapter.onError(this, e2);
                return;
            }
        }
        if (b2 != 1) {
            if (b2 != 2) {
                return;
            }
            destroyScrap();
            return;
        }
        if (this.isGameFinish) {
            return;
        }
        ScrapLoadingDialog scrapLoadingDialog = this.loadingDialog;
        if (scrapLoadingDialog != null && scrapLoadingDialog.isShowing()) {
            boxIndex = this.loadingDialog.getBoxIndex();
            this.loadingDialog.c();
        }
        try {
            ActionTriggerParams actionTriggerParams2 = (ActionTriggerParams) new com.google.gson.j().a(str, new TypeToken<ActionTriggerParams<List<String>>>() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.5
            }.getType());
            if (actionTriggerParams2 == null) {
                return;
            }
            if (actionTriggerParams2.getCode() != 1) {
                ActionTriggerError.showErrorTip(this, actionTriggerParams2.getCode());
                return;
            }
            List list = (List) actionTriggerParams2.getData();
            if (list != null && list.size() > 0) {
                this.treasureBoxInfos.get(boxIndex).setOpenStatus(1);
                GameUtils.setAvailableScrap(this.mFloatCircleView, this.lastTime, this.treasureBoxInfos, new io.reactivex.b.a() { // from class: com.sandboxol.blockmango.B
                    @Override // io.reactivex.b.a
                    public final void run() throws Exception {
                        this.f16050a.g();
                    }
                });
                Messenger.getDefault().sendNoMsg(GameMessageToken.TOKEN_REFRESH_SCRAP_BOX_DIALOG);
                new ScrapReceivedAnimDialog(this, this.mGameId, list, this.treasureBoxInfos.get(boxIndex).getScrapList(), false).show();
                ReportDataAdapter.onEvent(this, EventConstant.GET_COLLECT_CHEST_SUC);
            }
            Log.d("exchangeReceive: ", GameStringConstant.EXCHANGE_RECEIVE_RESULT);
        } catch (Exception e3) {
            e3.printStackTrace();
            ReportDataAdapter.onError(this, e3);
        }
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        super.onCreate(bundle);
        toggleHideBar();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.sandboxol.blockmango.t
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                this.f16258a.a(i);
            }
        });
        Intent intent = getIntent();
        String startGameInfo = GameSharedUtils.newInstance().getStartGameInfo();
        ControllerType controllerType = (ControllerType) intent.getSerializableExtra("controllerType");
        if (startGameInfo == null || controllerType == null) {
            finish();
            Process.killProcess(Process.myPid());
            return;
        }
        String stringExtra = intent.getStringExtra("flavor");
        String stringExtra2 = intent.getStringExtra("baseUrl");
        if (AnonymousClass22.$SwitchMap$com$sandboxol$blocky$router$ControllerType[controllerType.ordinal()] == 1) {
            EnterRealmsResult enterRealmsResult = RealmsController.newInstance(this).getEnterRealmsResult();
            if (enterRealmsResult == null || enterRealmsResult.getGame() == null) {
                finish();
                return;
            } else {
                if (!RealmsController.newInstance(this).isInit()) {
                    finish();
                    return;
                }
                this.mGameId = enterRealmsResult.getGame().getGameId();
            }
        }
        this.mHandler = new EchoesHandler(this);
        if (stringExtra == null) {
            stringExtra = StringConstant.THIRD_PART_LOGIN_GOOGLE;
        }
        init(stringExtra, stringExtra2);
        EchoesHelper.init(this);
        initBroadcastReceiver();
        adsTimer();
    }

    public void onCreateView(String str) {
        this.mGLSurfaceView = new EchoesGLSurfaceView(this, str);
        this.mGLSurfaceView.setEchoesRenderer(this.mRenderer);
        this.mGLSurfaceView.SetMainHandler(this.mHandler);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
        MessagerClient.getIns().unRegisterMsg(BlockManEchoesActivity.class);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onEngine2GetServerInfo() {
        Message message = new Message();
        message.what = 16;
        this.mChildHandler.sendMessage(message);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onLoadMapComplete(int i) {
        super.onLoadMapComplete(i);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("game.id", this.mGameId);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_ENTER_GAME_SUCCESS, fVar);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void onLoadingTips(String str, boolean z) {
        Message message = new Message();
        message.what = 17;
        Bundle bundle = new Bundle();
        bundle.putString("tips", str);
        bundle.putBoolean("showInDialog", z);
        message.setData(bundle);
        this.mChildHandler.sendMessage(message);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        EchoesHelper.onPause();
        com.sandboxol.greendao.c.K.newInstance().a(new FloatViewInfo(AccountCenter.newInstance().userId.get().longValue(), this.mFloatCircleView.getLocationX(), this.mFloatCircleView.getLocationY()));
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        EchoesHelper.onResume();
    }

    public void setInviteMessage(InviteMessage inviteMessage) {
        this.mDialog.setVisibility(0);
        this.inviteMessage = inviteMessage;
        try {
            com.bumptech.glide.c.a((Activity) this).mo55load(inviteMessage.getCaptainPicUrl()).into(this.ivInvitorHeader);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        this.tvInvitorName.setText(inviteMessage.getCaptainName());
        this.tvGameName.setText(getString(R.string.party_join_game_introduce, new Object[]{inviteMessage.getGameName()}));
        new XCountDownTimer(5000L, 1000L) { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.3
            @Override // com.sandboxol.center.utils.XCountDownTimer
            public void onFinish() {
                if (BlockManEchoesActivity.this.isFinishing() || BlockManEchoesActivity.this.mDialog == null) {
                    return;
                }
                BlockManEchoesActivity.this.mDialog.setVisibility(8);
            }

            @Override // com.sandboxol.center.utils.XCountDownTimer
            public void onTick(long j) {
                BlockManEchoesActivity.this.tvCountDown.setText((j / 1000) + au.ax);
            }
        }.start();
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showDialog(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        message.obj = new EchoesHandler.DialogMessage(str, str2);
        this.mHandler.sendMessage(message);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
        Message message = new Message();
        message.what = 2;
        message.obj = new EchoesHandler.EditBoxMessage(str, str2, i, i2, i3, i4);
        this.mHandler.sendMessage(message);
    }

    @Override // com.sandboxol.blockmango.EchoesActivity
    protected void showFailedDialogForEngine2(String str, boolean z) {
        if (!z) {
            this.mTextView.setText(str);
        } else {
            this.mBgView.setVisibility(0);
            new GameFailedDialog(this).setText(str).show();
        }
    }

    @Override // com.sandboxol.blockmango.EchoesActivity, com.sandboxol.blockmango.EchoesHelper.EchoesHelperListener
    public void showSmallEditTextDialog(String str, String str2, int i, int i2, int i3, int i4) {
        Message message = new Message();
        message.what = 18;
        message.obj = new EchoesHandler.EditBoxMessage(str, str2, i, i2, i3, i4);
        this.mHandler.sendMessage(message);
    }

    public /* synthetic */ void a(View view) {
        this.mDialog.setVisibility(8);
        MultiProcessSharedUtils.getInt(this, SharedConstant.PARTY_INVITE_REFUSE_COUNT, new Action1<Integer>() { // from class: com.sandboxol.blockmango.BlockManEchoesActivity.2
            @Override // rx.functions.Action1
            public void call(Integer num) {
                if (num.intValue() > 2) {
                    ToastUtils.showShortToast(BlockManEchoesActivity.this, R.string.party_refuse_invite_guide);
                } else {
                    MultiProcessSharedUtils.putInt(BlockManEchoesActivity.this, SharedConstant.PARTY_INVITE_REFUSE_COUNT, num.intValue() + 1);
                }
            }
        });
    }

    public /* synthetic */ void a(String str, int i) {
        ScrapLoadingDialog scrapLoadingDialog = this.loadingDialog;
        if (scrapLoadingDialog == null || !scrapLoadingDialog.isShowing()) {
            this.loadingDialog = new ScrapLoadingDialog(this);
            this.loadingDialog.setBoxIndex(i);
            this.loadingDialog.show();
            ActionTriggerParams actionTriggerParams = new ActionTriggerParams();
            actionTriggerParams.setFunctionName("exchangeReceive");
            actionTriggerParams.setData(str);
            this.mGLSurfaceView.onGameActionTrigger(10001, new com.google.gson.j().a(actionTriggerParams));
        }
    }

    public /* synthetic */ void b(View view) {
        InviteMessage inviteMessage = this.inviteMessage;
        if (inviteMessage != null && inviteMessage.getGameVersion() == EngineEnv.getEngineVersion(this.inviteMessage.getIsNewEngine(), this.inviteMessage.getIsUgc())) {
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.a(GameConstant.INVITE_TEAM_MESSAGE, this.inviteMessage);
            MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_INVITE_MESSAGE_NEXT, fVar);
            this.mDialog.setVisibility(8);
            return;
        }
        ToastUtils.showShortToast(this, R.string.party_version_different);
    }

    public /* synthetic */ void a(ActionTriggerParams actionTriggerParams) throws Exception {
        if (this.index + 1 < this.treasureBoxInfos.size()) {
            if (this.lastTime < this.treasureBoxInfos.get(r1.size() - 1).getDuration() * 60) {
                this.gameTimesToday.set(Integer.valueOf(this.treasureBoxInfos.get(this.index).getDuration() * 60));
                this.lastTime = this.treasureBoxInfos.get(this.index).getDuration() * 60;
                GameUtils.setAvailableScrap(this.mFloatCircleView, this.treasureBoxInfos.get(this.index).getDuration() * 60, this.treasureBoxInfos, new io.reactivex.b.a() { // from class: com.sandboxol.blockmango.y
                    @Override // io.reactivex.b.a
                    public final void run() throws Exception {
                        this.f16289a.f();
                    }
                });
                GameUtils.changeMillisInFuture(this.scrapTimer, (this.treasureBoxInfos.get(this.index + 1).getDuration() - this.treasureBoxInfos.get(this.index).getDuration()) * 60 * 1000);
                this.mFloatCircleView.setProgressPercent(((GameTimeToday) actionTriggerParams.getData()).getGameTimeToday() - (this.treasureBoxInfos.get(this.index).getDuration() * 60), (this.treasureBoxInfos.get(this.index + 1).getDuration() - this.treasureBoxInfos.get(this.index).getDuration()) * 60);
                Messenger.getDefault().sendNoMsg(GameMessageToken.TOKEN_REFRESH_SCRAP_BOX_DIALOG);
            }
        }
    }
}
