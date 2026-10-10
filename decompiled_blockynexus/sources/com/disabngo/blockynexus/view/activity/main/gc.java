package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.SystemHelper;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class gc implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10904a;

    gc(nc ncVar) {
        this.f10904a = ncVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        long jA = fVar.a(GameConstant.AGREE_ADD_FRIEND_ID, 0L);
        if (jA != 0 && AccountCenter.newInstance().login.get().booleanValue() && SystemHelper.isUser(jA)) {
            com.disabngo.blockynexus.e.b.x.J.a(this.f10904a.f10939c, jA);
        }
    }
}
