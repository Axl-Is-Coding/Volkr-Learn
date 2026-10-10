package com.disabngo.blockynexus.web;

import android.content.Context;
import com.disabngo.blockynexus.entity.UserMapInfo;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class GeoApi {
    private static final IGeoApi api = (IGeoApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IGeoApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUserMapInfoList(final Context context, final OnResponseListener<List<UserMapInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.J
            @Override // rx.functions.Action0
            public final void call() {
                GeoApi.getUserMapInfoList(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.getUserMapInfoList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        } else {
            api.getUserMapInfoList(CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<UserMapInfo>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postUserGeoInfo(final Context context, final Double d2, final Double d3, final OnResponseListener onResponseListener) {
        api.postUserGeoInfo(d2.doubleValue(), d3.doubleValue()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.I
            @Override // rx.functions.Action0
            public final void call() {
                GeoApi.postUserGeoInfo(context, d2, d3, onResponseListener);
            }
        })));
    }
}
