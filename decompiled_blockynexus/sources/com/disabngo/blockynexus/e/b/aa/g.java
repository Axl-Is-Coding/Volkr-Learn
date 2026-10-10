package com.disabngo.blockynexus.e.b.aa;

import android.content.Context;
import com.sandboxol.center.entity.ReportRequest;
import com.sandboxol.center.web.UserApi;

/* JADX INFO: compiled from: ReportDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public void a(Context context, ReportRequest reportRequest) {
        UserApi.postReport(context, reportRequest, new f(this, context));
    }
}
