package com.disabngo.blockynexus.e.b.x;

import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.SystemHelper;
import com.sandboxol.common.base.app.BaseFragment;

/* JADX INFO: compiled from: FriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
class u implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10317a;

    u(v vVar) {
        this.f10317a = vVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        long jA = fVar.a(GameConstant.GAME_FRIEND_ID, 0L);
        if (jA == 0 || !AccountCenter.newInstance().login.get().booleanValue() || !SystemHelper.isUser(jA) || AccountCenter.newInstance().userId.get().longValue() == jA) {
            return;
        }
        J.b(((BaseFragment) this.f10317a).context, jA);
    }
}
