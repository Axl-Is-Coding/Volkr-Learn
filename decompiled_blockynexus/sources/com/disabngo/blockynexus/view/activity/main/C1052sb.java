package com.disabngo.blockynexus.view.activity.main;

import android.content.Intent;
import com.disabngo.blockynexus.view.dialog.PartyTipDialog;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.PartyDressManager;
import com.sandboxol.greendao.entity.InviteMessage;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.sb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1052sb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10967a;

    C1052sb(MainActivity mainActivity) {
        this.f10967a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        AppInfoCenter.newInstance().setNowParty(false);
        PartyDressManager.onDestroy();
        InviteMessage inviteMessage = (InviteMessage) fVar.b(GameConstant.INVITE_TEAM_MESSAGE);
        if (inviteMessage != null) {
            Intent intent = new Intent(this.f10967a, (Class<?>) PartyTipDialog.class);
            intent.putExtra(GameConstant.INVITE_TEAM_MESSAGE_NEXT, inviteMessage);
            this.f10967a.startActivity(intent);
        }
    }
}
