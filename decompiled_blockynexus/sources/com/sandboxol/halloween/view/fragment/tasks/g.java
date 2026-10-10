package com.sandboxol.halloween.view.fragment.tasks;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.entity.HalloweenTaskResponse;
import com.sandboxol.halloween.view.fragment.tasks.h;

/* JADX INFO: compiled from: TasksModel.java */
/* JADX INFO: loaded from: classes4.dex */
class g extends OnResponseListener<HalloweenTaskResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h.a f18746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18747b;

    g(h.a aVar, Context context) {
        this.f18746a = aVar;
        this.f18747b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(HalloweenTaskResponse halloweenTaskResponse) {
        h.a aVar = this.f18746a;
        if (aVar != null) {
            aVar.a(halloweenTaskResponse);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.halloween.web.h.a(this.f18747b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18747b, i);
    }
}
