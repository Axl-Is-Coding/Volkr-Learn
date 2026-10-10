package com.disabngo.blockynexus.e.b.C;

import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;
import java.util.ArrayList;

/* JADX INFO: compiled from: GroupEditViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f9141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f9142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f9143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ l f9144d;

    k(l lVar, ArrayList arrayList, ArrayList arrayList2, i iVar) {
        this.f9144d = lVar;
        this.f9141a = arrayList;
        this.f9142b = arrayList2;
        this.f9143c = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        UserOnError.showErrorTip(this.f9144d.f9145a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        ServerOnError.showOnServerError(this.f9144d.f9145a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        if (str != null) {
            this.f9141a.add(str);
            if (this.f9141a.size() == this.f9142b.size()) {
                this.f9144d.f9146b.setNoticePic(this.f9141a);
                this.f9143c.a(this.f9144d.f9145a, this.f9144d.f9146b);
            }
        }
    }
}
