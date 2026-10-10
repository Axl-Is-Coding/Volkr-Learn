package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;
import java.util.List;

/* JADX INFO: compiled from: GameDiscoverNewDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class Z implements C.a<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f18464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2716aa f18466d;

    Z(C2716aa c2716aa, long j, int i, com.sandboxol.greendao.a.c cVar) {
        this.f18466d = c2716aa;
        this.f18463a = j;
        this.f18464b = i;
        this.f18465c = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f18465c.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18465c.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Game> onExecute() {
        org.greenrobot.greendao.d.i<Game> iVarQueryBuilder = this.f18466d.getDao().queryBuilder();
        if (this.f18463a > 0) {
            iVarQueryBuilder.a(iVarQueryBuilder.a(GameDao.Properties.CurrentPage.a(Integer.valueOf(this.f18464b)), GameDao.Properties.TypeId.a(Long.valueOf(this.f18463a)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
            iVarQueryBuilder.b(GameDao.Properties.CreateTime);
        } else {
            iVarQueryBuilder.a(GameDao.Properties.CurrentPage.a(Integer.valueOf(this.f18464b)), new org.greenrobot.greendao.d.k[0]);
            iVarQueryBuilder.b(GameDao.Properties.CreateTime);
        }
        return iVarQueryBuilder.c();
    }
}
