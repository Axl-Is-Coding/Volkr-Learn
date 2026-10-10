package com.disabngo.blockynexus.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.utils.logic.N;
import com.google.gson.j;
import com.sandboxol.center.entity.InviteTeamMessage;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleApi.IRongIMService;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.InviteMessage;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventRongIM.RONG_SERVICE)
public class RongIMService implements IRongIMService {
    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public GameMassage friendToGameMassage(Friend friend, String str, int i, String str2) {
        return C0507d.a(friend, str, i, str2);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public GameMassage game2GameMassage(PartyAuthInfo partyAuthInfo, String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, int i5) {
        return C0507d.a(partyAuthInfo, str, str2, i, i2, i3, i4, str3, str4, i5, "");
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public GameMassage inviteMessageToGameMassage(InviteMessage inviteMessage, String str, int i, int i2) {
        return C0507d.a(inviteMessage, str, i, i2, "");
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public GameMassage inviteTeamToGameMessage(InviteTeamMessage inviteTeamMessage, String str, String str2, int i) {
        j jVar = new j();
        return C0507d.a((com.sandboxol.imchat.message.entity.InviteTeamMessage) jVar.a(jVar.a(inviteTeamMessage), com.sandboxol.imchat.message.entity.InviteTeamMessage.class), str, str2, i, "");
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public GameMassage partyItemToGameMassage(PartyItem partyItem, String str, int i, int i2) {
        return C0507d.a(partyItem, str, i, i2, "");
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public void sendInviteTeamMessage(Context context, boolean z, String str, GameMassage gameMassage) {
        N.a(context, z, str, gameMassage);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public void startPartyChat(Context context, String str, String str2, boolean z, String str3) {
        N.a(context, str, str2, z, str3);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public void startPartyDressChat(Context context, String str, String str2, boolean z, boolean z2, String str3) {
        N.a(context, str, str2, z, z2, str3);
    }

    @Override // com.sandboxol.center.router.moduleApi.IRongIMService
    public String game2GameMassage(int i, String str, String str2, Game game, String str3, String str4) {
        return C0507d.a(i, str, str2, game, str3, str4);
    }
}
