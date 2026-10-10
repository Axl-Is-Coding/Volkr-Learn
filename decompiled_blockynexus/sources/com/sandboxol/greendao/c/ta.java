package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.UserCache;

/* JADX INFO: compiled from: UserCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class ta implements C.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ va f18547c;

    ta(va vaVar, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18547c = vaVar;
        this.f18545a = j;
        this.f18546b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        this.f18546b.onSuccess(bool);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18546b.onSuccess(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Boolean onExecute() {
        UserCache userCacheA = this.f18547c.a(this.f18545a);
        if (userCacheA != null) {
            return Boolean.valueOf(userCacheA.getIsShowPasswordSettingDialog());
        }
        return false;
    }
}
