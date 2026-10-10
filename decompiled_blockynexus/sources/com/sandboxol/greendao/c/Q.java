package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class Q implements C.a<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f18445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ U f18447c;

    Q(U u, String str, com.sandboxol.greendao.a.c cVar) {
        this.f18447c = u;
        this.f18445a = str;
        this.f18446b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        this.f18446b.onSuccess(game);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18446b.onError(-1, th.getMessage());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Game onExecute() {
        return this.f18447c.getDao().load(this.f18445a);
    }
}
