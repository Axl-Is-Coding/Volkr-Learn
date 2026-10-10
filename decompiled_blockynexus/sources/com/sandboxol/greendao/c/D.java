package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.VideoInfo;

/* JADX INFO: compiled from: BaseVideoInfoDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class D implements C.a<VideoInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ F f18420b;

    D(F f2, com.sandboxol.greendao.a.c cVar) {
        this.f18420b = f2;
        this.f18419a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoInfo videoInfo) {
        this.f18419a.onSuccess(videoInfo);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public VideoInfo onExecute() {
        try {
            if (this.f18420b.getDao() == null) {
                return null;
            }
            this.f18420b.getDao().getDatabase().a("DELETE FROM VIDEO_INFO");
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
