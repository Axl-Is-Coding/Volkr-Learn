package com.disabngo.blockynexus.web;

import android.content.Context;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankHomePageInfoResponse;
import com.sandboxol.greendao.entity.RankInfoResponse;
import com.trello.rxlifecycle.ActivityEvent;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class RankingApi {
    private static final IRankingApi api = (IRankingApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IRankingApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActiveGlobalOverallRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getActiveGlobalOverallRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ja
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getActiveGlobalOverallRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActiveGlobalWeeklyRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getActiveGlobalWeeklyRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ta
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getActiveGlobalWeeklyRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActiveRegionOverallRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getActiveRegionOverallRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ma
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getActiveRegionOverallRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getActiveRegionWeeklyRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getActiveRegionWeeklyRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ra
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getActiveRegionWeeklyRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getClanGlobalOverallRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getClanGlobalOverallRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ua
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getClanGlobalOverallRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getClanGlobalWeeklyRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getClanGlobalWeeklyRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.pa
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getClanGlobalWeeklyRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getClanRegionOverallRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getClanRegionOverallRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ka
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getClanRegionOverallRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getClanRegionWeeklyRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getClanRegionWeeklyRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.va
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getClanRegionWeeklyRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGDiamondGlobalOverallRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getGDiamondGlobalOverallRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.na
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getGDiamondGlobalOverallRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGDiamondGlobalWeeklyRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getGDiamondGlobalWeeklyRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.la
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getGDiamondGlobalWeeklyRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGDiamondRegionOverallRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getGDiamondRegionOverallRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.sa
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getGDiamondRegionOverallRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGDiamondRegionWeeklyRanks(final Context context, final int i, final int i2, final OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        api.getGDiamondRegionWeeklyRanks(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.wa
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getGDiamondRegionWeeklyRanks(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getRegionRankHomePageInfoResponse(final Context context, final String str, final OnResponseListener<RankHomePageInfoResponse> onResponseListener) {
        api.getRegionRankHomePageInfoResponse(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.qa
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getRegionRankHomePageInfoResponse(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUserRankInfoResponse(final Context context, final String str, final String str2, final boolean z, final OnResponseListener<RankInfoResponse> onResponseListener) {
        api.getUserRankInfoResponse(str, str2, z).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.oa
            @Override // rx.functions.Action0
            public final void call() {
                RankingApi.getUserRankInfoResponse(context, str, str2, z, onResponseListener);
            }
        })));
    }
}
