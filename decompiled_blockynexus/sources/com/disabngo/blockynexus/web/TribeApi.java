package com.disabngo.blockynexus.web;

import android.content.Context;
import com.disabngo.blockynexus.entity.ClanResponse;
import com.disabngo.blockynexus.entity.RequestJoinTribe;
import com.disabngo.blockynexus.entity.TribeClanRequest;
import com.disabngo.blockynexus.entity.TribeDonationHistory;
import com.disabngo.blockynexus.entity.TribeDonationInfo;
import com.disabngo.blockynexus.entity.TribeDonationResponse;
import com.disabngo.blockynexus.entity.TribeMessage;
import com.disabngo.blockynexus.entity.TribeNoticeGet;
import com.disabngo.blockynexus.entity.TribeNoticePost;
import com.disabngo.blockynexus.entity.TribeRank;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.entity.TribeTask;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.TribeMember;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class TribeApi {
    private static final ITribeApi api = (ITribeApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", ITribeApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void acceptTask(final Context context, final long j, final int i, final OnResponseListener onResponseListener) {
        api.acceptTask(j, i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ha
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.acceptTask(context, j, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void agreeJoin(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.agreeJoin(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Fa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.agreeJoin(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void agreeJoinTribe(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.agreeJoinTribe(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ja
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.agreeJoinTribe(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void buyDecoration(final Context context, final String[] strArr, final OnResponseListener onResponseListener) {
        api.buyDecoration(CommonHelper.getLanguage(), strArr).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ga
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.buyDecoration(context, strArr, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clanRequest(final Context context, final TribeClanRequest tribeClanRequest, final OnResponseListener<TribeClanRequest> onResponseListener) {
        api.clanRequest(CommonHelper.getLanguage(), tribeClanRequest).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ka
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.clanRequest(context, tribeClanRequest, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clanUpdate(final Context context, final TribeClanRequest tribeClanRequest, final OnResponseListener<TribeClanRequest> onResponseListener) {
        api.clanUpdate(tribeClanRequest, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ua
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.clanUpdate(context, tribeClanRequest, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dissolveTribe(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.dissolveTribe(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.La
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.dissolveTribe(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void donationHistory(final Context context, final int i, final int i2, final OnResponseListener<PageData<TribeDonationHistory>> onResponseListener) {
        api.donationHistory(i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ya
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.donationHistory(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void donationInfo(final Context context, final OnResponseListener<TribeDonationInfo> onResponseListener) {
        api.donationInfo(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Za
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.donationInfo(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void donationResponse(final Context context, final int i, final int i2, final OnResponseListener<TribeDonationResponse> onResponseListener) {
        api.donationResponse(i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ya
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.donationResponse(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void exitTribe(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.exitTribe(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ra
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.exitTribe(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAllTribeRank(final Context context, final String str, final int i, final int i2, final OnResponseListener<RankInfo<TribeRank>> onResponseListener) {
        api.getAllTribeRank(str, i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.za
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getAllTribeRank(context, str, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMyTribeGold(final Context context, final OnResponseListener<Long> onResponseListener) {
        api.getMyTribeGold(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Wa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getMyTribeGold(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMyTribeRank(final Context context, final String str, final OnResponseListener<TribeRank> onResponseListener) {
        api.getMyTribeRank(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Na
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getMyTribeRank(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getPersonTask(final Context context, final int i, final OnResponseListener<TribeTask> onResponseListener) {
        api.getPersonTask(i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Sa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getPersonTask(context, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTaskReward(final Context context, final long j, final int i, final OnResponseListener onResponseListener) {
        api.getTaskReward(j, i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ta
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getTaskReward(context, j, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTribeId(final Context context, final OnResponseListener<String> onResponseListener) {
        api.getTribeId(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Xa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getTribeId(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTribeNotice(final Context context, final OnResponseListener<TribeNoticeGet> onResponseListener) {
        api.getTribeNotice(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ab
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getTribeNotice(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTribeShopGoodsList(final Context context, final long j, final int i, final int i2, final OnResponseListener<PageData<TribeShopPageList>> onResponseListener) {
        api.tribeShopGoodsList(CommonHelper.getLanguage(), j, i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ia
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getTribeShopGoodsList(context, j, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTribeTask(final Context context, final int i, final OnResponseListener<TribeTask> onResponseListener) {
        api.getTribeTask(i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ba
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.getTribeTask(context, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void inviteFriend(final Context context, final String[] strArr, final String str, final OnResponseListener onResponseListener) {
        api.inviteFriend(strArr, str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ca
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.inviteFriend(context, strArr, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postTribeNotice(final Context context, final TribeNoticePost tribeNoticePost, final OnResponseListener onResponseListener) {
        api.postTribeNotice(tribeNoticePost, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Da
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.postTribeNotice(context, tribeNoticePost, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void rejectJoin(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.rejectJoin(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Oa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.rejectJoin(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void rejectJoinTribe(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.rejectJoinTribe(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Pa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.rejectJoinTribe(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void removeMember(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.removeMember(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ma
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.removeMember(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestJoinTribe(final Context context, final RequestJoinTribe requestJoinTribe, final OnResponseListener onResponseListener) {
        api.requestJoinTribe(requestJoinTribe, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Qa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.requestJoinTribe(context, requestJoinTribe, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void searchTribe(final Context context, final String str, final int i, final int i2, final OnResponseListener<PageData<TribeRecommendation>> onResponseListener) {
        api.searchTribe(str, i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Ea
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.searchTribe(context, str, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setIdentity(final Context context, final long j, final int i, final OnResponseListener onResponseListener) {
        api.setIdentity(j, i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web._a
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.setIdentity(context, j, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void tribeBaseInfo(final Context context, final OnResponseListener<TribeDetail> onResponseListener) {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            api.tribeBaseInfo(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Va
                @Override // rx.functions.Action0
                public final void call() {
                    TribeApi.tribeBaseInfo(context, onResponseListener);
                }
            })));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void tribeDetail(final Context context, final long j, final OnResponseListener<TribeDetail> onResponseListener) {
        api.tribeDetail(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.bb
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.tribeDetail(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void tribeMember(final Context context, final int i, final OnResponseListener<List<TribeMember>> onResponseListener) {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            api.tribeMember(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Aa
                @Override // rx.functions.Action0
                public final void call() {
                    TribeApi.tribeMember(context, i, onResponseListener);
                }
            })));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void tribeMessage(final Context context, final OnResponseListener<List<TribeMessage>> onResponseListener) {
        api.tribeMessage(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.db
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.tribeMessage(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void tribeRecommendList(final Context context, final int i, final OnResponseListener<List<TribeRecommendation>> onResponseListener) {
        api.recommendList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.xa
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.tribeRecommendList(context, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void verification(final Context context, final int i, final OnResponseListener<ClanResponse> onResponseListener) {
        api.verification(i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.cb
            @Override // rx.functions.Action0
            public final void call() {
                TribeApi.verification(context, i, onResponseListener);
            }
        })));
    }
}
