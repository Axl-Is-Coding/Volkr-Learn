package com.disabngo.blockynexus.web;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipResponse;
import com.sandboxol.center.entity.VipInfo;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import java.util.Map;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class VIPApi {
    private static final IVIPApi api = (IVIPApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IVIPApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void buyVip(final Context context, final String str, final OnResponseListener<BuyVipResponse> onResponseListener) {
        api.buyVip(str, CommonHelper.getLanguage(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.eb
            @Override // rx.functions.Action0
            public final void call() {
                VIPApi.buyVip(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void vipPriceList(final Context context, final OnResponseListener<Map<String, List<VipInfo>>> onResponseListener) {
        api.vipPriceList(AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.fb
            @Override // rx.functions.Action0
            public final void call() {
                VIPApi.vipPriceList(context, onResponseListener);
            }
        })));
    }
}
