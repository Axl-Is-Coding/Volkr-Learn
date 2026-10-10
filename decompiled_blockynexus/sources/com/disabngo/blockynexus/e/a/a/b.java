package com.disabngo.blockynexus.e.a.a;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameListDBCache.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9066a;

    b(h hVar) {
        this.f9066a = hVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        if (list != null) {
            this.f9066a.f9076a.clear();
            this.f9066a.f9076a.addAll(list);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
