package com.sandboxol.center.web;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class FriendPublicApi {
    private static IFriendPublicApi api = (IFriendPublicApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IFriendPublicApi.class);

    public static void getFriendStatus(long j, OnResponseListener<Integer> onResponseListener) {
        api.getFriendStatus(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Integer>>) new HttpSubscriber(onResponseListener));
    }
}
