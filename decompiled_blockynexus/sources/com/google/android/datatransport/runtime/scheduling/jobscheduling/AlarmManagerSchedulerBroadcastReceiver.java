package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.u;

/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    static /* synthetic */ void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        u.a(context);
        q.a aVarA = com.google.android.datatransport.runtime.q.a();
        aVarA.a(queryParameter);
        aVarA.a(com.google.android.datatransport.runtime.f.a.a(iIntValue));
        if (queryParameter2 != null) {
            aVarA.a(Base64.decode(queryParameter2, 0));
        }
        u.a().b().a(aVarA.a(), i, b.a());
    }
}
