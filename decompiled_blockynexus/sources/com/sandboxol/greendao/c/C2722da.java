package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.da, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameDiskCacheDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class C2722da implements C.a<GameDiskCacheInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f18481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.greendao.a.c f18482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ fa f18483c;

    C2722da(fa faVar, String str, com.sandboxol.greendao.a.c cVar) {
        this.f18483c = faVar;
        this.f18481a = str;
        this.f18482b = cVar;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GameDiskCacheInfo gameDiskCacheInfo) {
        this.f18482b.onSuccess(gameDiskCacheInfo);
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18482b.onError(-1, th.getMessage());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public GameDiskCacheInfo onExecute() {
        return this.f18483c.getDao().load(this.f18481a);
    }
}
