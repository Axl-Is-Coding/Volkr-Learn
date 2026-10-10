package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;
import java.util.List;

/* JADX INFO: compiled from: GameDiscoverAppreciateDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class V implements C.a<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f18454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ W f18456d;

    V(W w, long j, int i, com.sandboxol.greendao.a.c cVar) {
        this.f18456d = w;
        this.f18453a = j;
        this.f18454b = i;
        this.f18455c = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f18455c.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18455c.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Game> onExecute() {
        org.greenrobot.greendao.d.i<Game> iVarQueryBuilder = this.f18456d.getDao().queryBuilder();
        if (this.f18453a > 0) {
            iVarQueryBuilder.a(iVarQueryBuilder.a(GameDao.Properties.CurrentPage.a(Integer.valueOf(this.f18454b)), GameDao.Properties.TypeId.a(Long.valueOf(this.f18453a)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
            iVarQueryBuilder.b(GameDao.Properties.PraiseNumber);
        } else {
            iVarQueryBuilder.a(GameDao.Properties.CurrentPage.a(Integer.valueOf(this.f18454b)), new org.greenrobot.greendao.d.k[0]);
            iVarQueryBuilder.b(GameDao.Properties.PraiseNumber);
        }
        return iVarQueryBuilder.c();
    }
}
