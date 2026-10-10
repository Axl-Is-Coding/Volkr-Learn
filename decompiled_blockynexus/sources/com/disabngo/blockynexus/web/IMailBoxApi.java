package com.disabngo.blockynexus.web;

import com.disabngo.blockynexus.entity.MailInfo;
import com.facebook.internal.AnalyticsEvents;
import com.sandboxol.common.base.web.HttpResponse;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IMailBoxApi {
    @PUT("/mailbox/api/v1/mail/attachment")
    Observable<HttpResponse<String>> getAttachment(@Query("mailId") long j);

    @GET("/mailbox/api/v1/mail/new")
    Observable<HttpResponse<Boolean>> hasNewEmail();

    @GET("/mailbox/api/v1/mail")
    Observable<HttpResponse<List<MailInfo>>> mailList();

    @PUT("/mailbox/api/v1/mail")
    Observable<HttpResponse<List<MailInfo>>> mailOperation(@Query(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) int i, @Query("ids") Long[] lArr);
}
