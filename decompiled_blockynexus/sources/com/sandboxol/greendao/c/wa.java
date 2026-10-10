package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.UserGameRecordInfo;

/* JADX INFO: compiled from: UserGameRecordInfoDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class wa implements C.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ya f18562c;

    wa(ya yaVar, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18562c = yaVar;
        this.f18560a = j;
        this.f18561b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        this.f18561b.onSuccess(bool);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18561b.onSuccess(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Boolean onExecute() {
        UserGameRecordInfo userGameRecordInfoA = this.f18562c.a(this.f18560a);
        if (userGameRecordInfoA != null) {
            return Boolean.valueOf(userGameRecordInfoA.getIsPlayed());
        }
        return false;
    }
}
