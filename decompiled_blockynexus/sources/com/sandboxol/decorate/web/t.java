package com.sandboxol.decorate.web;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.DecorationResourcesResponse;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpListSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.decorate.entity.DressExpireInfo;
import com.sandboxol.decorate.entity.DressGuideInfo;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: DecorationApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IDecorationApi f17521a = (IDecorationApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IDecorationApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static Observable<HttpResponse<List<SingleDressInfo>>> a(Context context) {
        return context instanceof com.trello.rxlifecycle.a ? f17521a.isUsingList(CommonHelper.getLanguage(), 0L).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()) : f17521a.isUsingList(CommonHelper.getLanguage(), 0L).subscribeOn(Schedulers.io());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(final Context context, final long j, final OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.i
            @Override // rx.functions.Action0
            public final void call() {
                t.b(context, j, (OnResponseListener<List<SingleDressInfo>>) onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.friendUsingList(CommonHelper.getLanguage(), j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.friendUsingList(CommonHelper.getLanguage(), j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<SingleDressInfo>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        }
    }

    public static void c(Context context, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        a(context).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<SingleDressInfo>>>) new HttpListSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(final Context context, final long j, final OnResponseListener<SingleDressInfo> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.k
            @Override // rx.functions.Action0
            public final void call() {
                t.g(context, j, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.removeDecoration(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.removeDecoration(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<SingleDressInfo>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(final Context context, final long j, final OnResponseListener<SingleDressInfo> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.a
            @Override // rx.functions.Action0
            public final void call() {
                t.h(context, j, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.useDecoration(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.useDecoration(j, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<SingleDressInfo>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(final Context context, final List<Long> list, final OnResponseListener<Object> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.c
            @Override // rx.functions.Action0
            public final void call() {
                t.d(context, (List<Long>) list, (OnResponseListener<Object>) onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.multiUnclothe(list).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.multiUnclothe(list).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Object>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(final Context context, final List<Long> list, final OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.b
            @Override // rx.functions.Action0
            public final void call() {
                t.c(context, (List<Long>) list, (OnResponseListener<List<SingleDressInfo>>) onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.multiClothe(CommonHelper.getLanguage(), list, "android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.multiClothe(CommonHelper.getLanguage(), list, "android").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<SingleDressInfo>>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final OnResponseListener<List<DressExpireInfo>> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.f
            @Override // rx.functions.Action0
            public final void call() {
                t.a(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.getDressInfoExpireList(jLongValue, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.getDressInfoExpireList(jLongValue, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<DressExpireInfo>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(final Context context, final OnResponseListener<List<SuitDressInfo>> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.h
            @Override // rx.functions.Action0
            public final void call() {
                t.b(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.getDressSuitList(jLongValue, "android", (int) EngineEnv.v1().getEngineVersion(), CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.getDressSuitList(jLongValue, "android", (int) EngineEnv.v1().getEngineVersion(), CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<SuitDressInfo>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(final Context context, final OnResponseListener<DressGuideInfo> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.d
            @Override // rx.functions.Action0
            public final void call() {
                t.g(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.loadDressGuideConfig().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.loadDressGuideConfig().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<DressGuideInfo>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final int i, final OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        AccountCenter.newInstance().token.get();
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.e
            @Override // rx.functions.Action0
            public final void call() {
                t.a(context, i, (OnResponseListener<List<SingleDressInfo>>) onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.getDressListByType(CommonHelper.getLanguage(), jLongValue, i, "android", (int) EngineEnv.v1().getEngineVersion()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.getDressListByType(CommonHelper.getLanguage(), jLongValue, i, "android", (int) EngineEnv.v1().getEngineVersion()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<SingleDressInfo>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final long j, final OnResponseListener<DecorationResourcesResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.j
            @Override // rx.functions.Action0
            public final void call() {
                t.a(context, j, (OnResponseListener<DecorationResourcesResponse>) onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.checkDressResource(j, EngineEnv.v1().getEngineVersion(), CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.checkDressResource(j, EngineEnv.v1().getEngineVersion(), CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<DecorationResourcesResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final long j, final boolean z, final OnResponseListener<List<ShopRecommendDecorationInfo>> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str = AccountCenter.newInstance().token.get();
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.g
            @Override // rx.functions.Action0
            public final void call() {
                t.a(context, j, z, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f17521a.getRecommendList(CommonHelper.getLanguage(), jLongValue, j, "android", jLongValue, z, str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f17521a.getRecommendList(CommonHelper.getLanguage(), jLongValue, j, "android", jLongValue, z, str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<ShopRecommendDecorationInfo>>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }
}
