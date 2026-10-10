package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.BuyDressResponse;
import com.sandboxol.recharge.entity.BuyRequest;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: ShopApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IShopApi f17767a = (IShopApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IShopApi.class);

    public static void a(BuyRequest buyRequest, OnResponseListener<BuyDressResponse> onResponseListener) {
        f17767a.buyByV2(CommonHelper.getLanguage(), buyRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<BuyDressResponse>>) new r(onResponseListener));
    }
}
