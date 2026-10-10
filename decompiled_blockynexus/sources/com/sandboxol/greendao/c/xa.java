package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.UserGameRecordInfo;

/* JADX INFO: compiled from: UserGameRecordInfoDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class xa implements C.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ya f18568c;

    xa(ya yaVar, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18568c = yaVar;
        this.f18566a = j;
        this.f18567b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        this.f18567b.onSuccess(bool);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18567b.onSuccess(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Boolean onExecute() {
        UserGameRecordInfo userGameRecordInfoA = this.f18568c.a(this.f18566a);
        if (userGameRecordInfoA != null) {
            return Boolean.valueOf(userGameRecordInfoA.getIsSignIn());
        }
        return false;
    }
}
