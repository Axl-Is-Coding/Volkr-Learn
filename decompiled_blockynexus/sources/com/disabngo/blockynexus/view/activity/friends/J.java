package com.disabngo.blockynexus.view.activity.friends;

import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyGameResponse;

/* JADX INFO: compiled from: FriendInfoActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class J implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M f10649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FriendInfoActivity f10650b;

    J(FriendInfoActivity friendInfoActivity, M m) {
        this.f10650b = friendInfoActivity;
        this.f10649a = m;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        BuyGameResponse buyGameResponse = (BuyGameResponse) fVar.b(StringConstant.FRIEND_MATCH_PERFECT_USER_INFO_GET_REWARD);
        AccountCenter.newInstance().golds.set(Long.valueOf(buyGameResponse.getGolds()));
        AccountCenter.newInstance().diamonds.set(Long.valueOf(buyGameResponse.getDiamonds()));
        M m = this.f10649a;
        if (m != null) {
            m.n.set(false);
        }
    }
}
