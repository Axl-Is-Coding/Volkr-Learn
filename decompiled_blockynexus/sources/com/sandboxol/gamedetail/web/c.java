package com.sandboxol.gamedetail.web;

import android.content.Context;
import com.sandboxol.center.entity.BuyGameResponse;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.trello.rxlifecycle.ActivityEvent;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: GameDetailsApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IGameDetailsApi f18171a = (IGameDetailsApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IGameDetailsApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final String str, final long j, final OnResponseListener onResponseListener) {
        f18171a.buyGameDetailShopGoods(CommonHelper.getLanguage(), str, j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.gamedetail.web.b
            @Override // rx.functions.Action0
            public final void call() {
                c.a(context, str, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context context, final String str, final OnResponseListener<BuyGameResponse> onResponseListener) {
        f18171a.bugGame(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.gamedetail.web.a
            @Override // rx.functions.Action0
            public final void call() {
                c.a(context, str, onResponseListener);
            }
        })));
    }
}
