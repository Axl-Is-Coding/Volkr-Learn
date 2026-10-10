package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;
import java.util.List;

/* JADX INFO: compiled from: GameDetailDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class S implements C.a<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f18449b;

    S(U u, com.sandboxol.greendao.a.c cVar) {
        this.f18449b = u;
        this.f18448a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f18448a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18448a.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Game> onExecute() {
        org.greenrobot.greendao.d.i<Game> iVarQueryBuilder = this.f18449b.getDao().queryBuilder();
        iVarQueryBuilder.a(GameDao.Properties.IsNewEngine.a(1), new org.greenrobot.greendao.d.k[0]);
        return iVarQueryBuilder.c();
    }
}
