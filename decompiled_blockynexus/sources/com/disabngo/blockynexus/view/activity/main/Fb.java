package com.disabngo.blockynexus.view.activity.main;

import android.app.Activity;
import androidx.databinding.ObservableField;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.interfaces.RewardVideoAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Fb extends RewardVideoAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f10770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f10772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f10773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bc f10774e;

    Fb(bc bcVar, ObservableField observableField, Activity activity, ObservableField observableField2, ObservableField observableField3) {
        this.f10774e = bcVar;
        this.f10770a = observableField;
        this.f10771b = activity;
        this.f10772c = observableField2;
        this.f10773d = observableField3;
    }

    public /* synthetic */ void a(Activity activity) {
        int nowType = AdsManager.getAdsInfo().getNowType();
        if (nowType == 3) {
            Messenger.getDefault().sendNoMsg(MessageToken.ADS_TURNTABLE_GET_REWARD);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_SHOW_ADS);
            AdsManager.getAdsInfo().setCompleteReward(false);
            return;
        }
        if (nowType == 5) {
            Messenger.getDefault().sendNoMsg(MessageToken.ADS_RECHARGE_GET_REWARD);
            AdsManager.getAdsInfo().setCompleteReward(false);
            return;
        }
        if (nowType == 6) {
            AdsManager.getAdsInfo().setCompleteReward(false);
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.b("game.ads.type", AdsManager.getAdsInfo().getGameIntType());
            fVar.b("game.ads.result", 1);
            MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE2_ADS_RESULT, fVar);
            ReportDataAdapter.onEvent(activity, AdsEventConstant.REWARD_AD_GIVE, String.valueOf(AdsManager.getAdsInfo().getGameIntType()));
            return;
        }
        if (nowType != 7) {
            if (nowType != 8) {
                return;
            }
            this.f10774e.d(activity);
            AdsManager.getAdsInfo().setCompleteReward(false);
            return;
        }
        AdsManager.getAdsInfo().setCompleteReward(false);
        com.sandboxol.messager.a.f fVar2 = new com.sandboxol.messager.a.f();
        fVar2.b("game.ads.type", AdsManager.getAdsInfo().getGameIntType());
        fVar2.b("game.ads.params", AdsManager.getAdsInfo().getGameParams());
        fVar2.b(GameConstant.GAME_ADS_IS_SUCCESS, true);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE1_ADS_RESULT, fVar2);
        ReportDataAdapter.onEvent(activity, AdsEventConstant.REWARD_AD_GIVE, String.valueOf(AdsManager.getAdsInfo().getGameIntType()));
    }

    public /* synthetic */ void b(Activity activity) {
        this.f10774e.a(activity, AdsManager.getAdsInfo().getNowType());
    }

    @Override // com.sandboxol.common.interfaces.RewardVideoAdapter, com.sandboxol.common.interfaces.RewardVideoListener
    public void onRewardedVideoAdClosed() {
        super.onRewardedVideoAdClosed();
        if (this.f10771b != null) {
            if (AdsManager.getAdsInfo().isCompleteReward()) {
                final Activity activity = this.f10771b;
                activity.runOnUiThread(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.main.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10972a.a(activity);
                    }
                });
                FirebaseUtils.onEvent(this.f10771b, EventConstant.WATCH_ADS_SUCCESS, String.valueOf(AdsManager.getAdsInfo().getNowType()));
                return;
            }
            int nowType = AdsManager.getAdsInfo().getNowType();
            if (nowType == 6) {
                com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
                fVar.b("game.ads.type", AdsManager.getAdsInfo().getGameIntType());
                fVar.b("game.ads.result", 3);
                MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE2_ADS_RESULT, fVar);
                return;
            }
            if (nowType != 7) {
                return;
            }
            AdsManager.getAdsInfo().setCompleteReward(false);
            com.sandboxol.messager.a.f fVar2 = new com.sandboxol.messager.a.f();
            fVar2.b("game.ads.type", AdsManager.getAdsInfo().getGameIntType());
            fVar2.b("game.ads.params", AdsManager.getAdsInfo().getGameParams());
            fVar2.b(GameConstant.GAME_ADS_IS_SUCCESS, false);
            MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE1_ADS_RESULT, fVar2);
        }
    }

    @Override // com.sandboxol.common.interfaces.RewardVideoAdapter, com.sandboxol.common.interfaces.RewardVideoListener
    public void onRewardedVideoAdLoaded(boolean z) {
        super.onRewardedVideoAdLoaded(z);
        this.f10774e.a(z, (ObservableField<Integer>) this.f10770a, this.f10771b, (ObservableField<Boolean>) this.f10772c, (ObservableField<Boolean>) this.f10773d);
        if (z) {
            MultiProcessSharedUtils.putBoolean(this.f10771b, "is.show.ads", true);
            MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_SHOW_ADS);
        }
    }

    @Override // com.sandboxol.common.interfaces.RewardVideoAdapter, com.sandboxol.common.interfaces.RewardVideoListener
    public void onRewardedVideoAdOpened() {
        super.onRewardedVideoAdOpened();
        int nowType = AdsManager.getAdsInfo().getNowType();
        if (nowType == 0) {
            AdsManager.clickToShowVideo(this.f10771b, 1);
        } else if (nowType != 1 && nowType != 2 && nowType != 3 && nowType != 4 && nowType == 5) {
            AdsManager.clickToShowVideo(this.f10771b, 5);
        }
        ReportDataAdapter.onEvent(this.f10771b, AdsEventConstant.REWARD_AD_SHOW, String.valueOf(AdsManager.getAdsInfo().getNowType()));
    }

    @Override // com.sandboxol.common.interfaces.RewardVideoAdapter, com.sandboxol.common.interfaces.RewardVideoListener
    public void onRewardedVideoCompleted() {
        super.onRewardedVideoCompleted();
        AdsManager.getAdsInfo().setCompleteReward(true);
        final Activity activity = this.f10771b;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.disabngo.blockynexus.view.activity.main.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10968a.b(activity);
                }
            });
            this.f10774e.a(AdsManager.isVideoLoaded(), (ObservableField<Integer>) this.f10770a, this.f10771b, (ObservableField<Boolean>) this.f10772c, (ObservableField<Boolean>) this.f10773d);
            ReportDataAdapter.onEvent(this.f10771b, AdsEventConstant.REWARD_AD_FINISH, String.valueOf(AdsManager.getAdsInfo().getNowType()));
        }
    }
}
