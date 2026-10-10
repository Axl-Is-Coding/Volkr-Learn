package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import com.sandboxol.center.entity.InviteTeamMessage;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.InviteMessage;

/* JADX INFO: loaded from: classes3.dex */
public interface IRongIMService extends IBaseService {
    GameMassage friendToGameMassage(Friend friend, String str, int i, String str2);

    GameMassage game2GameMassage(PartyAuthInfo partyAuthInfo, String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, int i5);

    String game2GameMassage(int i, String str, String str2, Game game, String str3, String str4);

    GameMassage inviteMessageToGameMassage(InviteMessage inviteMessage, String str, int i, int i2);

    GameMassage inviteTeamToGameMessage(InviteTeamMessage inviteTeamMessage, String str, String str2, int i);

    GameMassage partyItemToGameMassage(PartyItem partyItem, String str, int i, int i2);

    void sendInviteTeamMessage(Context context, boolean z, String str, GameMassage gameMassage);

    void startPartyChat(Context context, String str, String str2, boolean z, String str3);

    void startPartyDressChat(Context context, String str, String str2, boolean z, boolean z2, String str3);
}
