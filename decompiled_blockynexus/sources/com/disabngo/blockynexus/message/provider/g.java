package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;

/* JADX INFO: compiled from: InviteTeamMessageProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends C0953d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f10458a;

    g(h hVar) {
        this.f10458a = hVar;
    }

    @Override // com.disabngo.blockynexus.e.b.y.C0953d
    public void a(Context context, GameMassage gameMassage) {
        if (System.currentTimeMillis() - this.f10458a.f10459a >= this.f10458a.f10460b) {
            this.f10458a.f10459a = System.currentTimeMillis();
            super.a(context, gameMassage);
        }
    }
}
