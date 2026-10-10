package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.VideoInfo;
import java.util.List;

/* JADX INFO: compiled from: BaseVideoInfoDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class E implements C.a<List<VideoInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ F f18423b;

    E(F f2, com.sandboxol.greendao.a.c cVar) {
        this.f18423b = f2;
        this.f18422a = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<VideoInfo> list) {
        this.f18422a.onSuccess(list);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
    }

    @Override // com.sandboxol.greendao.c.C.a
    public List<VideoInfo> onExecute() {
        return this.f18423b.getDao().loadAll();
    }
}
