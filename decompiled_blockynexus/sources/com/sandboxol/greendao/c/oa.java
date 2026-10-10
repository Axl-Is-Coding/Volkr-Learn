package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfoDao;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: ScrapDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class oa extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static oa f18520b;

    private oa(String str) {
        super(str);
    }

    public static synchronized oa newInstance() {
        if (f18520b == null) {
            f18520b = new oa("bm-scrap-db");
        }
        return f18520b;
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getScrapTreasureRewardInfoDao();
    }

    public /* synthetic */ void b(List list) {
        getDao().insertOrReplaceInTx(list);
    }

    public void a(long j, Action1<List<ScrapTreasureRewardInfo>> action1) {
        post(new na(this, j, action1));
    }

    public void b() {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f18514a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public ScrapTreasureRewardInfoDao getDao() {
        return (ScrapTreasureRewardInfoDao) super.getDao();
    }

    public void a(final List<ScrapTreasureRewardInfo> list) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f18518a.b(list);
            }
        });
    }

    public /* synthetic */ void a() {
        try {
            getDao().deleteAll();
        } catch (Exception unused) {
        }
    }
}
