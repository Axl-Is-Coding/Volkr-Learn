package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import com.sandboxol.greendao.entity.GameDiskCacheInfoDao;
import java.util.List;

/* JADX INFO: compiled from: GameDiskCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class ea implements C.a<List<GameDiskCacheInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ fa f18487b;

    ea(fa faVar, com.sandboxol.greendao.a.c cVar) {
        this.f18487b = faVar;
        this.f18486a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<GameDiskCacheInfo> list) {
        this.f18486a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18486a.onError(-1, th.getMessage());
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<GameDiskCacheInfo> onExecute() {
        org.greenrobot.greendao.d.i<GameDiskCacheInfo> iVarQueryBuilder = this.f18487b.getDao().queryBuilder();
        iVarQueryBuilder.a(GameDiskCacheInfoDao.Properties.LastOpenedTime);
        return iVarQueryBuilder.c();
    }
}
