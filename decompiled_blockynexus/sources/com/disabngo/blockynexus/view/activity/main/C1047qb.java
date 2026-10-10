package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.router.manager.PingReportManager;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.qb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1047qb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10955a;

    C1047qb(MainActivity mainActivity) {
        this.f10955a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        PingReportManager.onFpsEvent(fVar.a(GameConstant.GAME_PING_ID, (String) null), fVar.a(GameConstant.GAME_FPS, -1));
    }
}
