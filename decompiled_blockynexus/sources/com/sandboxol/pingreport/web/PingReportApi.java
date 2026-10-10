package com.sandboxol.pingreport.web;

import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.pingreport.dto.PingEventDto;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public class PingReportApi {
    private static final IPingReportApi api = (IPingReportApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IPingReportApi.class);

    public static void reportPingEvent(final PingEventDto pingEventDto, final OnResponseListener onResponseListener) {
        api.reportPingEvent(CommonHelper.getCountry(), CommonHelper.getAndroidId(BaseApplication.getApp()), pingEventDto).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.pingreport.web.a
            @Override // rx.functions.Action0
            public final void call() {
                PingReportApi.reportPingEvent(pingEventDto, onResponseListener);
            }
        })));
    }
}
