package com.disabngo.blockynexus.e.b.S;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: PartyCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends C0953d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f9439a;

    s(t tVar) {
        this.f9439a = tVar;
    }

    @Override // com.disabngo.blockynexus.e.b.y.C0953d
    public void a(Context context, GameMassage gameMassage) {
        if (gameMassage.getMemberCount() > 4 || Build.VERSION.SDK_INT < 21) {
            N.a(context, gameMassage.getChatRoomId(), gameMassage.getRoomName(), true, new com.google.gson.j().a(gameMassage));
        } else {
            N.a(context, gameMassage.getChatRoomId(), gameMassage.getRoomName(), true, false, new com.google.gson.j().a(gameMassage));
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        }
    }
}
