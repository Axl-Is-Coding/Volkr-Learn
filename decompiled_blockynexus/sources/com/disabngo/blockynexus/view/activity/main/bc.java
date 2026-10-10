package com.disabngo.blockynexus.view.activity.main;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.I;
import com.disabngo.blockynexus.databinding.AbstractC0672o;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.disabngo.blockynexus.view.dialog.ReportDialog;
import com.disabngo.blockynexus.web.CampaignApi;
import com.disabngo.blockynexus.web.FriendApi;
import com.disabngo.blockynexus.web.MailBoxApi;
import com.sandboxol.blocky.dialog.scrapanim.ScrapAnimListLayout;
import com.sandboxol.blocky.dialog.scrapanim.ScrapAnimListModel;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.center.entity.VideoSubmitActivityConfig;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.AppManager;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.view.activity.TemplateActivity;
import com.sandboxol.center.view.dialog.ActivityGuideDialog;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.center.web.VipApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.app.SingleTemplateActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.web.ChatGameApi;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.videosubmit.constant.VideoSubmitStringConstant;
import com.sandboxol.videosubmit.view.dialog.GuideDialog;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import retrofit2.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes.dex */
public class bc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReportDialog f10881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f10882c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10880a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0953d f10883d = new Eb(this);

    /* JADX INFO: compiled from: MainModel.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        void a();
    }

    private void n(final Context context) {
        new com.disabngo.blockynexus.d.I(context, new I.a() { // from class: com.disabngo.blockynexus.view.activity.main.E
            @Override // com.disabngo.blockynexus.d.I.a
            public final void a(boolean z, String str, String str2) {
                bc.a(context, z, str, str2);
            }
        });
    }

    public void d(Context context) {
        GameApi.getAdsGameDouble(context, new Hb(this, context));
    }

    public void e(Context context) {
        UserApi.dailySignIn(context, new Xb(this, context));
    }

    public void f(Context context) {
        UserApi.getSignAdsReward(context, new Gb(this, context));
    }

    public void g(Context context) {
        MailBoxApi.hasNewEmail(context, new Nb(this));
    }

    public void h(Context context) {
        FriendApi.friendRequestsList(context, 0, 10, new Ob(this, context));
    }

    public void i(Context context) {
        SharedUtils.putBoolean(context, SharedConstant.SHARE_KEY_SHOW_PARTY_DIALOG, false);
        new Kb(this, 15000L, 1000L, context).start();
    }

    public void j(Context context) {
        com.disabngo.blockynexus.d.D.b(context);
    }

    public void k(Context context) {
        com.sandboxol.decorate.web.t.a(context, new Pb(this, context));
    }

    public void l(Context context) {
        VipApi.getSubscribeInfo(context, new Tb(this, context));
    }

    public void m(Context context) {
        UserApi.uploadDeviceId(context, new C1070yb(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, boolean z) {
        com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new _b(this, z, context));
    }

    public void b(Context context, boolean z) {
        SharedUtils.putBoolean(context, SharedConstant.KEY_STOP_SERVICIE, z);
        if (z) {
            GameApi.getStopServiceAnnouncementInfo(context, new Wb(this, context));
        }
    }

    public void c(Context context) {
        CampaignApi.signInList(context, new ac(this, context));
    }

    @SuppressLint({"CheckResult"})
    private void b(Context context, InviteMessage inviteMessage, int i) {
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_PARTY_ROOM_CLOSE);
        DialogUtils.newsInstant().showLoadingDialog(context);
        ChatGameApi.getPartyAuth(context, AccountCenter.newInstance().userId.get().longValue(), inviteMessage.getPsid(), inviteMessage.getIsNewEngine() == 1, new Db(this, context, inviteMessage, i));
    }

    public boolean b(Context context, int i) {
        return AdsManager.isShowIronAds(context, 2, i);
    }

    public void a(Context context, Action0 action0) {
        UserApi.loadAppConfig(context, new Jb(this, context, action0));
    }

    public void b(Context context) {
        CampaignApi.getActivityTaskTitleList(context, new Lb(this, context));
    }

    static /* synthetic */ void b(Context context, int i, GuideDialog.Listener listener) {
        SharedUtils.putLong(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_SHOW_VIDEO_SUBMIT_GUIDE_DIALOG + AccountCenter.newInstance().userId.get(), System.currentTimeMillis());
        SharedUtils.putInt(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_SHOW_COUNT_VIDEO_SUBMIT_GUIDE_DIALOG + AccountCenter.newInstance().userId.get(), i + 1);
        listener.callBack();
    }

    public void a(Context context, boolean z, boolean z2) {
        this.f10880a = z;
        UserApi.checkAppVersion(context, new Ub(this, context, z2, z));
    }

    public void a(Context context, a aVar) {
        UserApi.checkAppVersion(context, new Vb(this, aVar, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, LatestVersion latestVersion, boolean z) {
        int metaDataAppVersion = BaseApplication.getApp().getMetaDataAppVersion();
        try {
            boolean z2 = metaDataAppVersion < latestVersion.getSmallerThanVersion() || (metaDataAppVersion >= latestVersion.getForceUpdateMinVersionCode() && metaDataAppVersion <= latestVersion.getForceUpdateMaxVersionCode()) || latestVersion.getNeedTobeForceUpdateVersions().contains(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
            int status = latestVersion.getStatus();
            if (status == 0 || status == 1) {
                a(context, latestVersion, z, metaDataAppVersion, z2);
            } else {
                if (status != 2) {
                    return;
                }
                com.disabngo.blockynexus.d.D.a(context, latestVersion, z2);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, LatestVersion latestVersion, boolean z, int i, boolean z2) {
        if (a(context, latestVersion, i, z2)) {
            if (i < latestVersion.getNewVersionCode()) {
                if (ChannelManager.isHasGoogleService(context)) {
                    DialogUtils.newsInstant().showCheckAppVersionDialog(context, latestVersion, this.f10880a, z2);
                    return;
                } else {
                    com.disabngo.blockynexus.d.D.b(context, latestVersion, z2);
                    return;
                }
            }
            if (z) {
                n(context);
                return;
            } else {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_NEED_UPDATE);
                return;
            }
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_NEED_UPDATE);
    }

    private boolean a(Context context, LatestVersion latestVersion, int i, boolean z) {
        if (latestVersion == null || latestVersion.getNewVersionCode() == 0) {
            return false;
        }
        if (i < latestVersion.getNewVersionCode() || !this.f10880a) {
            return true;
        }
        AppToastUtils.showShortPositiveTipToast(context, context.getString(R.string.app_is_latest));
        return false;
    }

    static /* synthetic */ void a(Context context, boolean z, String str, String str2) {
        if (z) {
            com.disabngo.blockynexus.d.D.a(context, str, str2);
        }
    }

    public void a(Context context, boolean z) {
        if (!z) {
            if (com.disabngo.blockynexus.e.a.a.h.c().d().size() > 0) {
                com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), true);
                c(context, false);
                return;
            } else {
                GameApi.recentlyPlayList(context, new Yb(this, context));
                return;
            }
        }
        c(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, DailySignInfo> map, List<DailySignInfo> list) {
        try {
            if (map.get("first") != null) {
                map.get("first").setId(1L);
                list.add(0, map.get("first"));
            }
            if (map.get("second") != null) {
                map.get("second").setId(2L);
                list.add(1, map.get("second"));
            }
            if (map.get("third") != null) {
                map.get("third").setId(3L);
                list.add(2, map.get("third"));
            }
            if (map.get("fourth") != null) {
                map.get("fourth").setId(4L);
                list.add(3, map.get("fourth"));
            }
            if (map.get("fifth") != null) {
                map.get("fifth").setId(5L);
                list.add(4, map.get("fifth"));
            }
            if (map.get("sixth") != null) {
                map.get("sixth").setId(6L);
                list.add(5, map.get("sixth"));
            }
            if (map.get("seventh") != null) {
                map.get("seventh").setId(7L);
                list.add(6, map.get("seventh"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, String str, String str2) {
        UserApi.upLoadID(context, str, str2, new C1067xb(this));
    }

    public void a(Context context) {
        UserApi.dailyLifeInfo(context, new C1073zb(this));
    }

    public void a(Context context, InviteMessage inviteMessage, int i) {
        if (inviteMessage.getGameVersion() == EngineEnv.getEngineVersion(inviteMessage.getIsNewEngine(), inviteMessage.getIsUgc())) {
            b(context, inviteMessage, i);
        } else {
            new Timer().schedule(new Ab(this), 3000L);
        }
        ReportDataAdapter.onEvent(context, EventConstant.CLICK_ACCEPT_TIME, inviteMessage.getGameType());
    }

    public void a(Activity activity, ObservableField<Boolean> observableField, ObservableField<Integer> observableField2, ObservableField<Boolean> observableField3) {
        AdsManager.setRewardedVideoListener(activity, new Fb(this, observableField2, activity, observableField, observableField3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ObservableField<Integer> observableField, Activity activity, ObservableField<Boolean> observableField2, ObservableField<Boolean> observableField3) {
        if (observableField.get() != null && observableField.get().intValue() == R.id.rb_1) {
            observableField2.set(Boolean.valueOf(2 - SharedUtils.getInt(activity, com.sandboxol.adsoversea.config.SharedConstant.SHOW_ADS_TIMES) > 0));
        }
        observableField3.set(Boolean.valueOf(z));
    }

    public void a(Context context, int i) {
        if (i == 0) {
            new com.disabngo.blockynexus.view.dialog.i.b().a(context, 3);
            AdsManager.getAdsInfo().setCompleteReward(false);
        } else if (i == 1) {
            f(context);
            AdsManager.getAdsInfo().setCompleteReward(false);
        } else {
            if (i != 2) {
                return;
            }
            MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_DRESS_SHOP_SHOW_AD_SUCCESS);
        }
    }

    public void a(Activity activity, final HttpException httpException) {
        Observable.create(new Observable.OnSubscribe() { // from class: com.disabngo.blockynexus.view.activity.main.o
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                bc.a(httpException, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Ib(this, activity));
    }

    static /* synthetic */ void a(HttpException httpException, Subscriber subscriber) {
        try {
            InputStream inputStreamByteStream = httpException.response().errorBody().byteStream();
            String strInputStream2String = CommonHelper.inputStream2String(inputStreamByteStream);
            inputStreamByteStream.close();
            subscriber.onNext(strInputStream2String);
            subscriber.onCompleted();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, String str) {
        CampaignApi.getActivityTaskActionList(context, str, new Mb(this, context));
    }

    public void a(final Context context, final GuideDialog.Listener listener) {
        long j = SharedUtils.getLong(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_SHOW_VIDEO_SUBMIT_GUIDE_DIALOG + AccountCenter.newInstance().userId.get());
        boolean z = j == 0 || System.currentTimeMillis() - j > 172800000;
        final int i = SharedUtils.getInt(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_SHOW_COUNT_VIDEO_SUBMIT_GUIDE_DIALOG + AccountCenter.newInstance().userId.get());
        boolean z2 = SharedUtils.getBoolean(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_USER_ID_LINK + AccountCenter.newInstance().userId.get());
        boolean z3 = SharedUtils.getBoolean(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_USER_ID_SIGN + AccountCenter.newInstance().userId.get());
        if (z2) {
            listener.callBack();
            return;
        }
        if (z && i < 3) {
            VideoSubmitActivityConfig videoSubmitActivityConfig = AppInfoCenter.newInstance().getAppConfig().getVideoSubmitActivityConfig();
            if (videoSubmitActivityConfig == null) {
                return;
            }
            String videoActivityGuideBackgroundUrl = videoSubmitActivityConfig.getVideoActivityGuideBackgroundUrl();
            String videoActivityGuideGotoUrl = videoSubmitActivityConfig.getVideoActivityGuideGotoUrl();
            if (z3) {
                new ActivityGuideDialog(context, new ActivityGuideDialog.Listener() { // from class: com.disabngo.blockynexus.view.activity.main.B
                    @Override // com.sandboxol.center.view.dialog.ActivityGuideDialog.Listener
                    public final void callBack() {
                        bc.a(context, i, listener);
                    }
                }).setGotoLinkDialog(true).setBackgroundUrl(videoActivityGuideBackgroundUrl).setGotoUrl(videoActivityGuideGotoUrl).show();
                return;
            } else {
                new ActivityGuideDialog(context, new ActivityGuideDialog.Listener() { // from class: com.disabngo.blockynexus.view.activity.main.D
                    @Override // com.sandboxol.center.view.dialog.ActivityGuideDialog.Listener
                    public final void callBack() {
                        bc.b(context, i, listener);
                    }
                }).setBackgroundUrl(videoActivityGuideBackgroundUrl).setGotoUrl(videoActivityGuideGotoUrl).show();
                return;
            }
        }
        listener.callBack();
    }

    static /* synthetic */ void a(Context context, int i, GuideDialog.Listener listener) {
        SharedUtils.putLong(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_SHOW_VIDEO_SUBMIT_GUIDE_DIALOG + AccountCenter.newInstance().userId.get(), System.currentTimeMillis());
        SharedUtils.putInt(context, VideoSubmitStringConstant.SP_VIDEO_SUBMIT_NAME, VideoSubmitStringConstant.SP_SHOW_COUNT_VIDEO_SUBMIT_GUIDE_DIALOG + AccountCenter.newInstance().userId.get(), i + 1);
        listener.callBack();
    }

    public void a(final Context context, final AbstractC0672o abstractC0672o) {
        Activity activityPeek;
        this.f10882c = null;
        Stack<Activity> activityStack = AppManager.getActivityStack();
        if (activityStack == null || activityStack.size() <= 0 || (activityPeek = activityStack.peek()) == null) {
            return;
        }
        if (activityPeek instanceof TemplateActivity) {
            View childAt = ((ViewGroup) ((TemplateActivity) activityPeek).findViewById(android.R.id.content)).getChildAt(0);
            if (childAt instanceof RelativeLayout) {
                this.f10882c = (RelativeLayout) childAt;
            }
        } else {
            View childAt2 = ((ViewGroup) ((SingleTemplateActivity) activityPeek).findViewById(android.R.id.content)).getChildAt(0);
            if (childAt2 instanceof RelativeLayout) {
                this.f10882c = (RelativeLayout) childAt2;
            }
        }
        if (this.f10882c == null) {
            return;
        }
        com.sandboxol.greendao.c.oa.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new Action1() { // from class: com.disabngo.blockynexus.view.activity.main.C
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10751a.a(context, abstractC0672o, (List) obj);
            }
        });
    }

    public /* synthetic */ void a(Context context, AbstractC0672o abstractC0672o, List list) {
        int size = list.size();
        if (size > 0) {
            DataRecyclerView dataRecyclerView = new DataRecyclerView(context);
            dataRecyclerView.setListLayout(new ScrapAnimListLayout());
            dataRecyclerView.setModel(new ScrapAnimListModel(context, R.string.no_data, list, true));
            dataRecyclerView.setLayoutFactory(size > 4 ? me.tatarka.bindingcollectionadapter2.k.a(4) : me.tatarka.bindingcollectionadapter2.k.a(0, false));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f10882c.addView(dataRecyclerView, layoutParams);
            Observable.just(true).delay(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Qb(this, abstractC0672o, context, dataRecyclerView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbstractC0672o abstractC0672o, Context context, DataRecyclerView dataRecyclerView, RelativeLayout relativeLayout, io.reactivex.b.a aVar) {
        View viewFindViewById = abstractC0672o.f8637a.findViewById(R.id.item3);
        View viewFindViewById2 = abstractC0672o.f8637a.findViewById(R.id.tbMainBar);
        if (viewFindViewById == null || viewFindViewById2 == null || dataRecyclerView.getWidth() == 0 || dataRecyclerView.getHeight() == 0) {
            if (aVar != null) {
                try {
                    aVar.run();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        int left = (dataRecyclerView.getLeft() + dataRecyclerView.getRight()) / 2;
        int top = (dataRecyclerView.getTop() + dataRecyclerView.getBottom()) / 2;
        int left2 = (viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2;
        int top2 = ((viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2) + viewFindViewById2.getHeight();
        ObjectAnimator duration = ObjectAnimator.ofFloat(dataRecyclerView, "translationX", WheelView.DividerConfig.FILL, left2 - left).setDuration(2000L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(dataRecyclerView, "translationY", WheelView.DividerConfig.FILL, top2 - top).setDuration(2000L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(dataRecyclerView, "scaleX", 1.0f, (viewFindViewById.getWidth() / dataRecyclerView.getWidth()) * 0.3f).setDuration(2000L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(dataRecyclerView, "scaleY", 1.0f, (viewFindViewById.getHeight() / dataRecyclerView.getHeight()) * 0.3f).setDuration(2000L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(dataRecyclerView, "alpha", 1.0f, WheelView.DividerConfig.FILL).setDuration(2000L);
        ValueAnimator duration6 = ValueAnimator.ofFloat(1.0f, WheelView.DividerConfig.FILL).setDuration(1500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, duration3, duration4, duration5, duration6);
        animatorSet.start();
        duration6.addListener(new Sb(this, context, viewFindViewById, viewFindViewById2, relativeLayout, animatorSet, dataRecyclerView, aVar));
    }
}
