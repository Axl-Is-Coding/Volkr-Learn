package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.VideoDetailInfo;
import com.sandboxol.greendao.entity.VideoDetailInfoDao;
import java.util.List;

/* JADX INFO: compiled from: VideoDetailCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class za implements C.a<VideoDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f18576c;

    za(Aa aa, long j, com.sandboxol.greendao.a.c cVar) {
        this.f18576c = aa;
        this.f18574a = j;
        this.f18575b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoDetailInfo videoDetailInfo) {
        this.f18575b.onSuccess(videoDetailInfo);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public VideoDetailInfo onExecute() {
        org.greenrobot.greendao.d.i<VideoDetailInfo> iVarQueryBuilder = this.f18576c.getDao().queryBuilder();
        iVarQueryBuilder.a(VideoDetailInfoDao.Properties.VideoId.a(Long.valueOf(this.f18574a)), new org.greenrobot.greendao.d.k[0]);
        List<VideoDetailInfo> listC = iVarQueryBuilder.c();
        if (listC == null || listC.isEmpty()) {
            return null;
        }
        return listC.get(0);
    }
}
