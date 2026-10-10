package com.sandboxol.decorate.web;

import android.content.Context;
import com.sandboxol.center.entity.BuyRequest;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.center.web.http.LoadingHttpListSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.greendao.entity.BuyDressResponse;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: ShopApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IShopApi f17522a = (IShopApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IShopApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final long j, final OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        f17522a.shopListByV2(CommonHelper.getLanguage(), j, "android", (int) EngineEnv.v1().getEngineVersion()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.p
            @Override // rx.functions.Action0
            public final void call() {
                w.a(context, j, (OnResponseListener<List<SingleDressInfo>>) onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(final Context context, final OnResponseListener<List<SuitDressInfo>> onResponseListener) {
        f17522a.shopSuitByV2(CommonHelper.getLanguage(), "android", (int) EngineEnv.v1().getEngineVersion()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.m
            @Override // rx.functions.Action0
            public final void call() {
                w.b(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final OnResponseListener<List<ShopRecommendDecorationInfo>> onResponseListener) {
        f17522a.shopRecommendByV2(CommonHelper.getLanguage(), "android", (int) EngineEnv.v1().getEngineVersion()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.q
            @Override // rx.functions.Action0
            public final void call() {
                w.a(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final BuyRequest buyRequest, final OnResponseListener<BuyDressResponse> onResponseListener) {
        HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.n
            @Override // rx.functions.Action0
            public final void call() {
                w.a(context, buyRequest, (OnResponseListener<BuyDressResponse>) onResponseListener);
            }
        });
        f17522a.buyByV2(CommonHelper.getLanguage(), buyRequest).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new v(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final List<Long> list, final OnResponseListener<List<SuitDressInfo>> onResponseListener) {
        f17522a.getSuitById(CommonHelper.getLanguage(), list).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoadingHttpListSubscriber(context, onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.decorate.web.o
            @Override // rx.functions.Action0
            public final void call() {
                w.a(context, (List<Long>) list, (OnResponseListener<List<SuitDressInfo>>) onResponseListener);
            }
        }), true));
    }
}
