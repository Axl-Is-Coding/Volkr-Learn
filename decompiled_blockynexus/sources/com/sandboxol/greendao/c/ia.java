package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;
import java.util.List;

/* JADX INFO: compiled from: GameRecommendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class ia implements C.a<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ja f18499b;

    ia(ja jaVar, com.sandboxol.greendao.a.c cVar) {
        this.f18499b = jaVar;
        this.f18498a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f18498a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18498a.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Game> onExecute() {
        org.greenrobot.greendao.d.i<Game> iVarQueryBuilder = this.f18499b.getDao().queryBuilder();
        iVarQueryBuilder.a(GameDao.Properties.CurrentSize);
        return iVarQueryBuilder.c();
    }
}
