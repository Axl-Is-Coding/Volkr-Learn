package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.greendao.entity.InviteMessage;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.rb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1049rb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10960a;

    C1049rb(MainActivity mainActivity) {
        this.f10960a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        InviteMessage inviteMessage = (InviteMessage) fVar.b(GameConstant.INVITE_TEAM_MESSAGE);
        if (inviteMessage != null) {
            this.f10960a.a(inviteMessage);
        }
    }
}
