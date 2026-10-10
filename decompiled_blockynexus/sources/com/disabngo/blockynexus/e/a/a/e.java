package com.disabngo.blockynexus.e.a.a;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: GameListDBCache.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Action1 f9070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f9071b;

    e(h hVar, Action1 action1) {
        this.f9071b = hVar;
        this.f9070a = action1;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<Game> list) {
        if (list != null) {
            this.f9071b.a((List<Game>) list);
            this.f9071b.f9077b.clear();
            this.f9071b.f9077b.addAll(list);
            Action1 action1 = this.f9070a;
            if (action1 != null) {
                action1.call(list);
            }
        }
    }
}
