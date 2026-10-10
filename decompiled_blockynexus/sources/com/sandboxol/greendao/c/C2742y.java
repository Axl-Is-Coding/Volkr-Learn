package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BaseGameDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class C2742y implements C.a<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f18570b;

    C2742y(B b2, com.sandboxol.greendao.a.c cVar) {
        this.f18570b = b2;
        this.f18569a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        com.sandboxol.greendao.a.c cVar = this.f18569a;
        if (cVar != null) {
            cVar.onSuccess(game);
        }
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        com.sandboxol.greendao.a.c cVar = this.f18569a;
        if (cVar != null) {
            cVar.onError(-1, th.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Game onExecute() {
        try {
            if (this.f18570b.getDao() == null) {
                return null;
            }
            this.f18570b.getDao().getDatabase().a("DELETE FROM GAME");
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
