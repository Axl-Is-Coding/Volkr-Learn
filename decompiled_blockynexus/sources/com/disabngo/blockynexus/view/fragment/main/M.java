package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GamingInfo;

/* JADX INFO: compiled from: OtherWayEnterGameLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class M extends C0953d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f11780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f11781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GamingInfo f11782c;

    M(Game game, long j, GamingInfo gamingInfo) {
        this.f11780a = game;
        this.f11781b = j;
        this.f11782c = gamingInfo;
    }

    @Override // com.disabngo.blockynexus.e.b.y.C0953d
    public void a(Context context, GameMassage gameMassage) {
        if (this.f11780a.getIsNewEngine() == 1) {
            com.disabngo.blockynexus.d.D.a(context, this.f11780a, this.f11781b, this.f11782c.getRegionId());
            return;
        }
        DialogC1122va dialogC1122va = new DialogC1122va(context, this.f11780a.getGameId(), this.f11780a);
        dialogC1122va.show();
        dialogC1122va.a(this.f11781b, this.f11782c);
    }
}
