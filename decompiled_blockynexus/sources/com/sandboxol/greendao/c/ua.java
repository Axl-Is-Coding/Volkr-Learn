package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.UserCache;

/* JADX INFO: compiled from: UserCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class ua implements C.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ va f18553c;

    ua(va vaVar, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18553c = vaVar;
        this.f18551a = j;
        this.f18552b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        this.f18552b.onSuccess(bool);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18552b.onSuccess(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Boolean onExecute() {
        UserCache userCacheA = this.f18553c.a(this.f18551a);
        if (userCacheA != null) {
            return Boolean.valueOf(userCacheA.getIsExistGamePay());
        }
        return false;
    }
}
