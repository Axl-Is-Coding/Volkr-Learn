package com.disabngo.blockynexus.e.a.a;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.c.ga;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameListDBCache.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f9072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f9073b;

    f(h hVar, List list) {
        this.f9073b = hVar;
        this.f9072a = list;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        for (int i = 0; i < this.f9072a.size(); i++) {
            ((Game) this.f9072a.get(i)).setCurrentSize(i);
        }
        ga.newInstance().a(this.f9072a);
        Messenger.getDefault().send(1, MessageToken.TOKEN_SHOW_LATELY_FRIEND_VIEW);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
