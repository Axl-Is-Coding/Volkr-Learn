package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.VideoInfo;
import com.sandboxol.greendao.entity.VideoInfoDao;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseVideoInfoDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class F extends ka {
    F(String str) {
        super(str);
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getVideoInfoDao();
    }

    public void b(com.sandboxol.greendao.a.c<List<VideoInfo>> cVar) {
        post(new E(this, cVar));
    }

    public void a(com.sandboxol.greendao.a.c<VideoInfo> cVar) {
        post(new D(this, cVar));
    }

    public /* synthetic */ void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            getDao().insertOrReplace((VideoInfo) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public VideoInfoDao getDao() {
        return (VideoInfoDao) super.getDao();
    }

    public void a(final List<VideoInfo> list) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f18493a.b(list);
            }
        });
    }
}
