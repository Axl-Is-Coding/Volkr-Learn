package com.disabngo.blockynexus.view.activity.main;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.jb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1026jb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10916a;

    C1026jb(MainActivity mainActivity) {
        this.f10916a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        try {
            com.disabngo.blockynexus.utils.logic.N.a(this.f10916a, String.valueOf(fVar.a("friend.user.id", 0L)), fVar.c("friend.nickname"));
        } catch (ExceptionInInitializerError e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        }
    }
}
