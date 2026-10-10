package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: FriendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class M implements C.a<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f18435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ P f18437d;

    M(P p, long j, String str, com.sandboxol.greendao.a.c cVar) {
        this.f18437d = p;
        this.f18434a = j;
        this.f18435b = str;
        this.f18436c = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        this.f18436c.onSuccess(friend);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18436c.onSuccess(null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Friend onExecute() {
        P p = this.f18437d;
        Friend friendA = p.a(p.f18444c, this.f18434a);
        if (friendA != null) {
            friendA.setAlias(this.f18435b);
            this.f18437d.getDao().insertOrReplace(friendA);
        }
        return friendA;
    }
}
