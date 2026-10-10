package com.disabngo.blockynexus.e.b.o;

import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0897u implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PageData f10016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f10017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f10018c;

    C0897u(v vVar, PageData pageData, List list) {
        this.f10018c = vVar;
        this.f10016a = pageData;
        this.f10017b = list;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        this.f10018c.f10019a.put(Integer.valueOf(this.f10016a.getPageNo()), Integer.valueOf(((Integer) this.f10018c.f10019a.get(Integer.valueOf(this.f10016a.getPageNo()))).intValue() + 1));
        if (((Integer) this.f10018c.f10019a.get(Integer.valueOf(this.f10016a.getPageNo()))).intValue() < this.f10017b.size() || this.f10016a.getTotalPage() - 1 > this.f10016a.getPageNo()) {
            return;
        }
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
