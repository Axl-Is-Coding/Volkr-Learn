package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.router.manager.BillingManager;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.vb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1061vb implements com.sandboxol.messager.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10978a;

    C1061vb(MainActivity mainActivity) {
        this.f10978a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.a
    public void onCall() {
        BillingManager.getInstance().updateUserMoney(this.f10978a);
    }
}
