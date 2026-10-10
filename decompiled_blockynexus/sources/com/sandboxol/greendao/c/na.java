package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfoDao;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: ScrapDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class na implements C.a<List<ScrapTreasureRewardInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Action1 f18516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ oa f18517c;

    na(oa oaVar, long j, Action1 action1) {
        this.f18517c = oaVar;
        this.f18515a = j;
        this.f18516b = action1;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<ScrapTreasureRewardInfo> list) {
        this.f18516b.call(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<ScrapTreasureRewardInfo> onExecute() {
        org.greenrobot.greendao.d.i<ScrapTreasureRewardInfo> iVarQueryBuilder = this.f18517c.getDao().queryBuilder();
        iVarQueryBuilder.a(iVarQueryBuilder.a(ScrapTreasureRewardInfoDao.Properties.Status.a(0), ScrapTreasureRewardInfoDao.Properties.UserId.a(Long.valueOf(this.f18515a)), new org.greenrobot.greendao.d.k[0]), new org.greenrobot.greendao.d.k[0]);
        return iVarQueryBuilder.c();
    }
}
