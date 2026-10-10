package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BaseGameDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class C2743z implements C.a<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f18573b;

    C2743z(B b2, com.sandboxol.greendao.a.c cVar) {
        this.f18573b = b2;
        this.f18572a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f18572a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18572a.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Game> onExecute() {
        return this.f18573b.getDao().loadAll();
    }
}
