package com.sandboxol.center.web;

import android.content.Context;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.HttpUtils;
import com.trello.rxlifecycle.ActivityEvent;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class VipApi {
    private static final IVipApi api = (IVipApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IVipApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getSubscribeInfo(final Context context, final OnResponseListener<VipSubInfo> onResponseListener) {
        api.getSubscribeInfo("android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.kb
            @Override // rx.functions.Action0
            public final void call() {
                VipApi.getSubscribeInfo(context, onResponseListener);
            }
        })));
    }
}
