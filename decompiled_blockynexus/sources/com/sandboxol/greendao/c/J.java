package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.FloatViewInfo;
import com.sandboxol.greendao.entity.FloatViewInfoDao;
import java.util.List;

/* JADX INFO: compiled from: FloatViewDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class J implements C.a<FloatViewInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ K f18429c;

    J(K k, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18429c = k;
        this.f18427a = j;
        this.f18428b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(FloatViewInfo floatViewInfo) {
        this.f18428b.onSuccess(floatViewInfo);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public FloatViewInfo onExecute() {
        org.greenrobot.greendao.d.i<FloatViewInfo> iVarQueryBuilder = this.f18429c.getDao().queryBuilder();
        iVarQueryBuilder.a(FloatViewInfoDao.Properties.UserId.a(Long.valueOf(this.f18427a)), new org.greenrobot.greendao.d.k[0]);
        List<FloatViewInfo> listC = iVarQueryBuilder.c();
        if (listC == null || listC.size() <= 0) {
            return null;
        }
        return listC.get(0);
    }
}
