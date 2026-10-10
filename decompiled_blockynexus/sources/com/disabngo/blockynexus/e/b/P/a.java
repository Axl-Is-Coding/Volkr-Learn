package com.disabngo.blockynexus.e.b.P;

import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: MiniGameDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9393a;

    a(b bVar) {
        this.f9393a = bVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.d("deleteChatRoom", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.d("deleteChatRoom", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        Log.d("deleteChatRoom", "Success");
    }
}
