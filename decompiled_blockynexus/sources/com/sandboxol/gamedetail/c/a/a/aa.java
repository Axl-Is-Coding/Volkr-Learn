package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class aa implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f17964a;

    aa(ba baVar) {
        this.f17964a = baVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        new LoadingDialog(this.f17964a.f17966a).show();
        ba baVar = this.f17964a;
        baVar.z.set(baVar.f17966a.getString(R.string.update_text));
        long engineVersion = EngineEnv.getEngineVersion(this.f17964a.x.get().getIsNewEngine(), this.f17964a.x.get().getIsUgc());
        String str = this.f17964a.x.get().getIsNewEngine() == 0 ? "v1" : "v2";
        E e2 = this.f17964a.k;
        Game game2 = this.f17964a.x.get();
        long gresVersion = 0;
        if (game != null && game.getLatestResVersions() != null) {
            gresVersion = game.getLatestResVersions().getGresVersion();
        }
        e2.a(game2, engineVersion, gresVersion, this.f17964a.f17968c, str, true);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
