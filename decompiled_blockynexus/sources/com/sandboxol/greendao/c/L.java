package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: FriendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class L implements C.a<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Friend f18431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ P f18433c;

    L(P p, Friend friend, com.sandboxol.greendao.a.c cVar) {
        this.f18433c = p;
        this.f18431a = friend;
        this.f18432b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        com.sandboxol.greendao.a.c cVar = this.f18432b;
        if (cVar != null) {
            cVar.onSuccess(friend);
        }
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Friend onExecute() {
        P p = this.f18433c;
        Friend friendA = p.a(p.f18444c, this.f18431a.getUserId());
        if (friendA != null) {
            this.f18431a.setID(friendA.getID());
        }
        this.f18431a.setLocalUserId(this.f18433c.f18444c);
        this.f18433c.getDao().insertOrReplace(this.f18431a);
        return this.f18431a;
    }
}
