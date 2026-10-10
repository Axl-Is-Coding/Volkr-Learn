package com.sandboxol.halloween.web;

import android.content.Context;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.halloween.entity.ExchangeResponse;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.entity.HalloweenTask;
import com.sandboxol.halloween.entity.HalloweenTaskResponse;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: HalloweenApi.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IHalloweenApi f18766a = (IHalloweenApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IHalloweenApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final int i, final OnResponseListener<Integer> onResponseListener) {
        f18766a.exchangeCandy(i, ActivityType.THANKSGIVING).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.halloween.web.b
            @Override // rx.functions.Action0
            public final void call() {
                g.a(context, i, (OnResponseListener<Integer>) onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(final Context context, final OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.halloween.web.e
            @Override // rx.functions.Action0
            public final void call() {
                g.c(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            f18766a.isUsingList(CommonHelper.getLanguage(), 0L).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            f18766a.isUsingList(CommonHelper.getLanguage(), 0L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<SingleDressInfo>>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(final Context context, final String str, final OnResponseListener<HalloweenTaskResponse> onResponseListener) {
        f18766a.receiveTaskReward(CommonHelper.getLanguage(), str, ActivityType.THANKSGIVING).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.halloween.web.f
            @Override // rx.functions.Action0
            public final void call() {
                g.b(context, str, (OnResponseListener<HalloweenTaskResponse>) onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final OnResponseListener<HalloweenInfoResponse> onResponseListener) {
        f18766a.getDetailInfo(CommonHelper.getLanguage(), ActivityType.THANKSGIVING).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.halloween.web.c
            @Override // rx.functions.Action0
            public final void call() {
                g.a(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(final Context context, final OnResponseListener<List<HalloweenTask>> onResponseListener) {
        f18766a.getTaskList(CommonHelper.getLanguage(), ActivityType.THANKSGIVING).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.halloween.web.d
            @Override // rx.functions.Action0
            public final void call() {
                g.b(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final long j, final OnResponseListener<ExchangeResponse> onResponseListener) {
        f18766a.exchangeReward(CommonHelper.getLanguage(), j, ActivityType.THANKSGIVING).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.halloween.web.a
            @Override // rx.functions.Action0
            public final void call() {
                g.a(context, j, (OnResponseListener<ExchangeResponse>) onResponseListener);
            }
        })));
    }
}
