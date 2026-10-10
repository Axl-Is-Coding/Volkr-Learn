package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDao;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BaseGameDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class C2741x implements C.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f18563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ B f18565c;

    C2741x(B b2, int i, com.sandboxol.greendao.a.c cVar) {
        this.f18565c = b2;
        this.f18563a = i;
        this.f18564b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(String str) {
        this.f18564b.onSuccess(str);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18564b.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public String onExecute() {
        org.greenrobot.greendao.d.i<Game> iVarQueryBuilder = this.f18565c.getDao().queryBuilder();
        iVarQueryBuilder.a(GameDao.Properties.CurrentPage.a(Integer.valueOf(this.f18563a)), new org.greenrobot.greendao.d.k[0]);
        iVarQueryBuilder.b().b();
        return "";
    }
}
