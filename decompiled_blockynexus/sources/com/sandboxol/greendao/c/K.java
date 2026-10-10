package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.FloatViewInfo;
import com.sandboxol.greendao.entity.FloatViewInfoDao;

/* JADX INFO: compiled from: FloatViewDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class K extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static K f18430b;

    private K(String str) {
        super(str);
    }

    public static synchronized K newInstance() {
        if (f18430b == null) {
            f18430b = new K("bm-float-db");
        }
        return f18430b;
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getFloatViewInfoDao();
    }

    public /* synthetic */ void b(FloatViewInfo floatViewInfo) {
        getDao().insertOrReplace(floatViewInfo);
    }

    public void a(long j, com.sandboxol.greendao.a.c<FloatViewInfo> cVar) {
        post(new J(this, j, cVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public FloatViewInfoDao getDao() {
        return (FloatViewInfoDao) super.getDao();
    }

    public void a(final FloatViewInfo floatViewInfo) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f18496a.b(floatViewInfo);
            }
        });
    }
}
