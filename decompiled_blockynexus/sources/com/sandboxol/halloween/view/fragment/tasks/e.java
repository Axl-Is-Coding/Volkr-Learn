package com.sandboxol.halloween.view.fragment.tasks;

import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.entity.HalloweenTask;
import java.util.List;

/* JADX INFO: compiled from: TasksListModel.java */
/* JADX INFO: loaded from: classes4.dex */
class e extends OnResponseListener<List<HalloweenTask>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f18743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f18744b;

    e(f fVar, OnResponseListener onResponseListener) {
        this.f18744b = fVar;
        this.f18743a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.halloween.web.h.a(((DefaultListModel) this.f18744b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f18744b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<HalloweenTask> list) {
        this.f18743a.onSuccess(list);
    }
}
