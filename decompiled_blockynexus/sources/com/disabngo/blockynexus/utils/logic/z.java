package com.disabngo.blockynexus.utils.logic;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;
import java.util.List;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class z implements com.sandboxol.greendao.a.c<List<UserInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RongIM.IGroupMemberCallback f10561a;

    z(RongIM.IGroupMemberCallback iGroupMemberCallback) {
        this.f10561a = iGroupMemberCallback;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<UserInfo> list) {
        if (list != null) {
            this.f10561a.onGetGroupMembersResult(list);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
