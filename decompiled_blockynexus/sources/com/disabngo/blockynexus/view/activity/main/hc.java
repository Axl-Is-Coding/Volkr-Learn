package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.SystemHelper;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class hc implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10908a;

    hc(nc ncVar) {
        this.f10908a = ncVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        long jA = fVar.a(GameConstant.REQUEST_ADD_FRIEND_ID, 0L);
        if (jA != 0 && AccountCenter.newInstance().login.get().booleanValue() && SystemHelper.isUser(jA)) {
            com.disabngo.blockynexus.e.b.x.J.c(this.f10908a.f10939c, jA);
        }
    }
}
