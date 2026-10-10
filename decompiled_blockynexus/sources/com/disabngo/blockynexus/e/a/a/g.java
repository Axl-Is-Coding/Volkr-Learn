package com.disabngo.blockynexus.e.a.a;

import com.sandboxol.greendao.c.ja;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameListDBCache.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f9074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f9075b;

    g(h hVar, List list) {
        this.f9075b = hVar;
        this.f9074a = list;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        for (int i = 0; i < this.f9074a.size(); i++) {
            ((Game) this.f9074a.get(i)).setCurrentSize(i);
        }
        ja.newInstance().a(this.f9074a);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
