package com.disabngo.blockynexus.e.a.a;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameListDBCache.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9069a;

    d(h hVar) {
        this.f9069a = hVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        if (list != null) {
            this.f9069a.f9077b.clear();
            this.f9069a.f9077b.addAll(list);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
