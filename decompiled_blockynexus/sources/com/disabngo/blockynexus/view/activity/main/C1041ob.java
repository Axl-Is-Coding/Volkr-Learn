package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.router.manager.PingReportManager;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.ob, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1041ob implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10945a;

    C1041ob(MainActivity mainActivity) {
        this.f10945a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        int iA = fVar.a(GameConstant.GAME_PING, -1);
        if (iA > 0) {
            PingReportManager.onPingEvent(fVar.a(GameConstant.GAME_PING_ID, (String) null), iA);
        }
    }
}
