package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.config.StringConstant;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.ib, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1023ib implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10912a;

    C1023ib(MainActivity mainActivity) {
        this.f10912a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        this.f10912a.h = fVar.a(StringConstant.KEY_MAIN_LOCK, false);
    }
}
