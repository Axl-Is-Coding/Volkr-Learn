package com.disabngo.blockynexus.web;

import android.content.Context;
import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.entity.FriendStatus;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.disabngo.blockynexus.entity.StatusBean;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.FriendFollowResponse;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class FriendApi {
    private static final IFriendApi api = (IFriendApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IFriendApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void addToBlacklist(final Context context, final long j, final OnResponseListener onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.G
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.addToBlacklist(context, j, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.addToBlacklist(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.addToBlacklist(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void followFriendsList(final Context context, final OnResponseListener<PageData<FriendFollowResponse>> onResponseListener) {
        api.followFriendsList(CommonHelper.getLanguage(), 0, 20).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.t
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.followFriendsList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendAdd(final Context context, final FriendRequestAdd friendRequestAdd, final OnResponseListener onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.B
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendAdd(context, friendRequestAdd, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.friendAdd(friendRequestAdd).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.friendAdd(friendRequestAdd).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendAddAlias(final Context context, final long j, final String str, final OnResponseListener onResponseListener) {
        api.friendAddAlias(j, str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.H
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendAddAlias(context, j, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendAgreeAdd(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.friendAgreeAdd(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.u
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendAgreeAdd(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendDelete(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.friendDelete(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.y
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendDelete(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendDeleteAlias(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.friendDeleteAlias(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.z
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendDeleteAlias(context, j, onResponseListener);
            }
        })));
    }

    public static void friendDetails(final Context context, final long j, final OnResponseListener<Friend> onResponseListener) {
        api.friendDetails(j, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Friend>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.C
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendDetails(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendGamingInfo(final Context context, final long j, final OnResponseListener<StatusBean> onResponseListener) {
        api.friendGamingInfo(CommonHelper.getLanguage(), j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.v
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendGamingInfo(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendList(final Context context, final int i, final int i2, final OnResponseListener<PageData<Friend>> onResponseListener) {
        api.friendList(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.s
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendList(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendRecommendation(final Context context, final OnResponseListener<List<RecommendFriendEntity>> onResponseListener) {
        api.friendRecommendation(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.D
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendRecommendation(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendRefuseAdd(final Context context, final long j, final OnResponseListener onResponseListener) {
        api.friendRefuseAdd(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.A
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendRefuseAdd(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendRequestsList(final Context context, final int i, final int i2, final OnResponseListener<PageData<FriendRequests>> onResponseListener) {
        api.friendRequestsList(i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.r
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendRequestsList(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendSearchList(final Context context, final int i, final int i2, final String str, final String str2, final OnResponseListener<PageData<Friend>> onResponseListener) {
        api.friendSearchList(str, i, i2, str2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.x
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendSearchList(context, i, i2, str, str2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendStatus(final Context context, final OnResponseListener<FriendStatus> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.w
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendStatus(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.friendStatus(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.friendStatus(CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<FriendStatus>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void searchFriendById(final Context context, final long j, final OnResponseListener<Friend> onResponseListener) {
        api.searchFriendById(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.F
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.searchFriendById(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void friendRecommendation(final Context context, final int i, final String str, final String str2, final Integer num, final String str3, final OnResponseListener<List<RecommendFriendEntity>> onResponseListener) {
        api.friendRecommendation(i, str, str2, num, str3).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.E
            @Override // rx.functions.Action0
            public final void call() {
                FriendApi.friendRecommendation(context, i, str, str2, num, str3, onResponseListener);
            }
        })));
    }
}
