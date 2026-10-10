package com.disabngo.blockynexus.e.b.x;

import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.c.P;

/* JADX INFO: compiled from: FriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
class s implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10315a;

    s(v vVar) {
        this.f10315a = vVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        long jA = fVar.a("friend.id", 0L);
        String strC = fVar.c("friend.alias");
        int iA = fVar.a("friend.type", 0);
        if (jA == 0 || strC == null || iA == 0) {
            return;
        }
        if (iA == 1 || iA == 2) {
            P.newInstance().a(jA, strC, new r(this));
        } else if (iA == 3) {
            P.newInstance().c(jA);
            N.c(((BaseFragment) this.f10315a).context, String.valueOf(jA));
        } else if (iA == 4) {
            P.newInstance().c(jA);
            N.b(((BaseFragment) this.f10315a).context, String.valueOf(jA));
        }
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
    }
}
