package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: FriendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class N implements C.a<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ P f18440c;

    N(P p, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18440c = p;
        this.f18438a = j;
        this.f18439b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        this.f18439b.onSuccess(friend);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18439b.onError(-1, th.getMessage());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Friend onExecute() {
        P p = this.f18440c;
        return p.a(p.f18444c, this.f18438a);
    }
}
