package com.sandboxol.pingreport.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.pingreport.dto.PingEventDto;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface IPingReportApi {
    @POST("/datareport/api/v1/app/ping/report/batch")
    Observable<HttpResponse> reportPingEvent(@Header("CloudFront-Viewer-Country") String str, @Header("deviceId") String str2, @Body PingEventDto pingEventDto);
}
