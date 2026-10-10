package com.sandboxol.report.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.report.entity.EventRequest;
import com.sandboxol.report.entity.NewEventInfoRequest;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface IReportInfoApi {
    @POST("/datareport/api/v1/funnel/event/report")
    Observable<HttpResponse> newReportSandboxData(@Header("deviceId") String str, @Body List<NewEventInfoRequest> list);

    @POST("/datareport/api/v1/event/report")
    Observable<HttpResponse> reportSandboxData(@Header("deviceId") String str, @Body EventRequest eventRequest);
}
