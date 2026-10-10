package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.PartyMemberInfo;

/* JADX INFO: compiled from: PartyMemberDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class la implements C.a<PartyMemberInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ma f18509c;

    la(ma maVar, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18509c = maVar;
        this.f18507a = j;
        this.f18508b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(PartyMemberInfo partyMemberInfo) {
        this.f18508b.onSuccess(partyMemberInfo);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public PartyMemberInfo onExecute() {
        ma maVar = this.f18509c;
        return maVar.a(maVar.f18513c, this.f18507a);
    }
}
