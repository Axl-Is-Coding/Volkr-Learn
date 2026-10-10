package com.disabngo.blockynexus.d;

import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.TribeMember;
import java.util.List;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class w extends OnResponseListener<List<TribeMember>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f7241a;

    w(x xVar) {
        this.f7241a = xVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<TribeMember> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (TribeMember tribeMember : list) {
            if (tribeMember.getNickName() != null) {
                N.a(TribeCenter.newInstance().tribeClanId.get().longValue(), tribeMember.getUserId(), tribeMember.getNickName(), tribeMember.getHeadPic());
            }
        }
    }
}
