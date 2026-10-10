package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.DaoSession;
import com.sandboxol.greendao.entity.VideoDetailInfo;
import com.sandboxol.greendao.entity.VideoDetailInfoDao;

/* JADX INFO: compiled from: VideoDetailCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class Aa extends ka {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Aa f18413b;

    Aa(String str) {
        super(str);
    }

    public static synchronized Aa newInstance() {
        if (f18413b == null) {
            f18413b = new Aa("bm-video-detail-cache-db");
        }
        return f18413b;
    }

    @Override // com.sandboxol.greendao.c.ka
    protected org.greenrobot.greendao.a a(DaoSession daoSession) {
        return daoSession.getVideoDetailInfoDao();
    }

    public /* synthetic */ void b(VideoDetailInfo videoDetailInfo) {
        getDao().insertOrReplace(videoDetailInfo);
    }

    public void a(long j, com.sandboxol.greendao.a.c<VideoDetailInfo> cVar) {
        post(new za(this, j, cVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.greendao.c.C
    public VideoDetailInfoDao getDao() {
        return (VideoDetailInfoDao) super.getDao();
    }

    public void a(final VideoDetailInfo videoDetailInfo) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f18554a.b(videoDetailInfo);
            }
        });
    }
}
