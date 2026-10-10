package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.center.web.UserApi;

/* JADX INFO: compiled from: WeekSignModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    public void a(Context context, String str, String str2, long j, DailySignInfo dailySignInfo) {
        new LoadingDialog(context).show();
        UserApi.clickSignIn(context, new j(this, context, dailySignInfo, str, str2, j));
    }
}
