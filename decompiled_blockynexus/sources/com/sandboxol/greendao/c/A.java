package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;
import java.util.List;

/* JADX INFO: compiled from: BaseGameDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class A implements C.a<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f18410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ B f18412c;

    A(B b2, int i, com.sandboxol.greendao.a.c cVar) {
        this.f18412c = b2;
        this.f18410a = i;
        this.f18411b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f18411b.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18411b.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<Game> onExecute() {
        org.greenrobot.greendao.d.i<Game> iVarQueryBuilder = this.f18412c.getDao().queryBuilder();
        iVarQueryBuilder.a(GameDao.Properties.CurrentPage.a(Integer.valueOf(this.f18410a)), new org.greenrobot.greendao.d.k[0]);
        iVarQueryBuilder.a(GameDao.Properties.CurrentSize);
        return iVarQueryBuilder.c();
    }
}
