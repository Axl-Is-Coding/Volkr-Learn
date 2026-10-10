package com.sandboxol.report.web;

import android.content.Context;
import com.sandboxol.center.transformers.DataTransformers;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.report.entity.EventRequest;
import com.sandboxol.report.entity.NewEventInfoRequest;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public class ReportInfoApi {
    private static final IReportInfoApi api = (IReportInfoApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IReportInfoApi.class);

    public static void newReportSandboxData(final Context context, final List<NewEventInfoRequest> list, final OnResponseListener onResponseListener) {
        api.newReportSandboxData(CommonHelper.getAndroidId(context), list).compose(DataTransformers.applySchedulersIo()).subscribe((Subscriber<? super R>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.report.web.b
            @Override // rx.functions.Action0
            public final void call() {
                ReportInfoApi.newReportSandboxData(context, list, onResponseListener);
            }
        })));
    }

    public static void reportSandboxData(final Context context, final EventRequest eventRequest, final OnResponseListener onResponseListener) {
        api.reportSandboxData(CommonHelper.getAndroidId(context), eventRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.report.web.a
            @Override // rx.functions.Action0
            public final void call() {
                ReportInfoApi.reportSandboxData(context, eventRequest, onResponseListener);
            }
        })));
    }
}
