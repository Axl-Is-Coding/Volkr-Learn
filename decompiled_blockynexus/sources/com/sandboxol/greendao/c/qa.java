package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.TribeMember;
import java.util.List;

/* JADX INFO: compiled from: TribeDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class qa implements C.a<List<TribeMember>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra f18530b;

    qa(ra raVar, com.sandboxol.greendao.a.c cVar) {
        this.f18530b = raVar;
        this.f18529a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<TribeMember> list) {
        this.f18529a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<TribeMember> onExecute() {
        ra raVar = this.f18530b;
        return raVar.c(raVar.f18535c);
    }
}
