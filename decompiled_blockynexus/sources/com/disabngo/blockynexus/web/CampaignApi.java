package com.disabngo.blockynexus.web;

import android.content.Context;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.entity.ActivityTaskTitleList;
import com.disabngo.blockynexus.entity.CampaignBetRequest;
import com.disabngo.blockynexus.entity.CampaignGame;
import com.disabngo.blockynexus.entity.CampaignHistory;
import com.disabngo.blockynexus.entity.CampaignRankRewardWithTime;
import com.disabngo.blockynexus.entity.CampaignRedPoint;
import com.disabngo.blockynexus.entity.CampaignReward;
import com.disabngo.blockynexus.entity.CampaignTask;
import com.disabngo.blockynexus.entity.TurntableStatus;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.center.web.http.LoadingHttpSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import java.util.Map;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class CampaignApi {
    private static final ICampaignApi api = (ICampaignApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", ICampaignApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void campaignGameList(final Context context, final OnResponseListener<List<CampaignGame>> onResponseListener) {
        AccountCenter.newInstance().userId.get().longValue();
        AccountCenter.newInstance().token.get();
        api.campaignGameList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.d
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.campaignGameList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActivityTaskActionList(final Context context, final String str, final OnResponseListener<List<ActivityTaskAction>> onResponseListener) {
        api.getActivityTaskActionList(CommonHelper.getLanguage(), str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.f
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getActivityTaskActionList(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActivityTaskReward(final Context context, final String str, final long j, final OnResponseListener<ActivityTaskAction> onResponseListener) {
        api.getActivityTaskReward(CommonHelper.getLanguage(), str, j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.n
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getActivityTaskReward(context, str, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActivityTaskTitleList(final Context context, final OnResponseListener<ActivityTaskTitleList> onResponseListener) {
        api.getActivityTaskTitleList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoadingHttpSubscriber(context, onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.h
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getActivityTaskTitleList(context, onResponseListener);
            }
        }), false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getBetHistory(final Context context, final OnResponseListener<List<CampaignHistory>> onResponseListener) {
        api.getBetHistory(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.q
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getBetHistory(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getCampaignRedPoint(final Context context, final OnResponseListener<CampaignRedPoint> onResponseListener) {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            api.getCampaignRedPoint(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.j
                @Override // rx.functions.Action0
                public final void call() {
                    CampaignApi.getCampaignRedPoint(context, onResponseListener);
                }
            })));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getIntegralReward(final Context context, final String str, final long j, final OnResponseListener onResponseListener) {
        api.getIntegralReward(str, j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.m
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getIntegralReward(context, str, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMyIntegral(final Context context, final OnResponseListener<Integer> onResponseListener) {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            api.myIntegral(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.i
                @Override // rx.functions.Action0
                public final void call() {
                    CampaignApi.getMyIntegral(context, onResponseListener);
                }
            })));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMyRank(final Context context, final OnResponseListener<CampaignRank> onResponseListener) {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            api.myRank(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.e
                @Override // rx.functions.Action0
                public final void call() {
                    CampaignApi.getMyRank(context, onResponseListener);
                }
            })));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getRankReward(final Context context, final OnResponseListener<CampaignRankRewardWithTime> onResponseListener) {
        AccountCenter.newInstance().userId.get().longValue();
        AccountCenter.newInstance().token.get();
        api.getRankReward(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.a
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getRankReward(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getRewardList(final Context context, final String str, final OnResponseListener<CampaignReward> onResponseListener) {
        api.rewardList(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.g
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getRewardList(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTaskList(final Context context, final OnResponseListener<List<CampaignTask>> onResponseListener) {
        AccountCenter.newInstance().userId.get().longValue();
        AccountCenter.newInstance().token.get();
        api.getTaskList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.p
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getTaskList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTaskReward(final Context context, final long j, final OnResponseListener<Integer> onResponseListener) {
        api.getTaskReward(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.o
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getTaskReward(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTotalRank(final Context context, final int i, final int i2, final OnResponseListener<PageData<CampaignRank>> onResponseListener) {
        api.totalRank(i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.c
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.getTotalRank(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTurntableRedPoint(Context context, String str, OnResponseListener<TurntableStatus> onResponseListener) {
        if (str.equals(ActivityType.SLOT_MACHINE)) {
            api.getGoldDrawStatus(CommonHelper.getLanguage(), "slm_new").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        } else {
            api.getTurntableRedPoint(CommonHelper.getLanguage(), str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postBetRequest(final Context context, final CampaignBetRequest campaignBetRequest, final OnResponseListener onResponseListener) {
        api.postBetRequest(campaignBetRequest, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.l
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.postBetRequest(context, campaignBetRequest, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void signIn(final Context context, final OnResponseListener<Map<String, Integer>> onResponseListener) {
        api.signIn(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.k
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.signIn(context, onResponseListener);
            }
        })));
    }

    public static void signInList(final Context context, final OnResponseListener<UserSignInResponse> onResponseListener) {
        api.signInList(CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<UserSignInResponse>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.b
            @Override // rx.functions.Action0
            public final void call() {
                CampaignApi.signInList(context, onResponseListener);
            }
        })));
    }
}
