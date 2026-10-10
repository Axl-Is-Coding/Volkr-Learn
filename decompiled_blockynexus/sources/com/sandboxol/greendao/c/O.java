package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: FriendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class O implements C.a<List<Friend>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ P f18442b;

    O(P p, com.sandboxol.greendao.a.c cVar) {
        this.f18442b = p;
        this.f18441a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Friend> list) {
        this.f18441a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Friend> onExecute() {
        P p = this.f18442b;
        return p.e(p.f18444c);
    }
}
