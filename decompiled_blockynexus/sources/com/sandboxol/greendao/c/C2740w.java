package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BaseGameDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class C2740w implements C.a<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f18557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ B f18559c;

    C2740w(B b2, String str, com.sandboxol.greendao.a.c cVar) {
        this.f18559c = b2;
        this.f18557a = str;
        this.f18558b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        this.f18558b.onSuccess(game);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18558b.onError(-1, th.getMessage());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Game onExecute() {
        return this.f18559c.getDao().load(this.f18557a);
    }
}
