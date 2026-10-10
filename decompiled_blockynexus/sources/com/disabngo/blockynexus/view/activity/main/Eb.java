package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.disabngo.blockynexus.view.dialog.PartyTipDialog;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Eb extends C0953d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f10767a;

    Eb(bc bcVar) {
        this.f10767a = bcVar;
    }

    @Override // com.disabngo.blockynexus.e.b.y.C0953d
    public void a(Context context, GameMassage gameMassage) {
        super.a(context, gameMassage);
        if (context instanceof PartyTipDialog) {
            MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_PARTY_EXIT_GAME);
            PartyTipDialog partyTipDialog = (PartyTipDialog) context;
            if (partyTipDialog.isFinishing()) {
                return;
            }
            partyTipDialog.finish();
        }
    }
}
