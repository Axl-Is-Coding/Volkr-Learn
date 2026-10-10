package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.TribeMember;

/* JADX INFO: compiled from: TribeDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class pa implements C.a<TribeMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f18525c;

    pa(ra raVar, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18525c = raVar;
        this.f18523a = j;
        this.f18524b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeMember tribeMember) {
        this.f18524b.onSuccess(tribeMember);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18524b.onError(-1, th.getMessage());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public TribeMember onExecute() {
        ra raVar = this.f18525c;
        return raVar.a(raVar.f18535c, this.f18523a);
    }
}
