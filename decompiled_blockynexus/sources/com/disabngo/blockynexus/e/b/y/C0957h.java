package com.disabngo.blockynexus.e.b.y;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CheckGameInfoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0957h implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GameMassage f10381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0958i f10382d;

    C0957h(C0958i c0958i, String str, Context context, GameMassage gameMassage) {
        this.f10382d = c0958i;
        this.f10379a = str;
        this.f10380b = context;
        this.f10381c = gameMassage;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        if (game == null) {
            Game game2 = new Game();
            game2.setGameId(this.f10379a);
            U.newInstance().a(game2);
        }
        if (this.f10382d.f10384b != null) {
            this.f10382d.f10384b.a(this.f10380b, this.f10381c);
        } else {
            C0958i.b(this.f10380b, this.f10381c);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
