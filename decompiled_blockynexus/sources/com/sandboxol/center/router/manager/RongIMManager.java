package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.entity.InviteTeamMessage;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IRongIMService;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.InviteMessage;

/* JADX INFO: loaded from: classes3.dex */
public class RongIMManager {
    private static IRongIMService iRongIMService = (IRongIMService) RouteServiceManager.provide(RouterServicePath.EventRongIM.RONG_SERVICE);

    public static GameMassage friendToGameMassage(Friend friend, String str, int i, String str2) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            return iRongIMService2.friendToGameMassage(friend, str, i, str2);
        }
        return null;
    }

    public static GameMassage game2GameMassage(PartyAuthInfo partyAuthInfo, String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, int i5) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            return iRongIMService2.game2GameMassage(partyAuthInfo, str, str2, i, i2, i3, i4, str3, str4, i5);
        }
        return null;
    }

    public static GameMassage inviteMessageToGameMassage(InviteMessage inviteMessage, String str, int i, int i2) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            return iRongIMService2.inviteMessageToGameMassage(inviteMessage, str, i, i2);
        }
        return null;
    }

    public static GameMassage inviteTeamToGameMessage(InviteTeamMessage inviteTeamMessage, String str, String str2, int i) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            return iRongIMService2.inviteTeamToGameMessage(inviteTeamMessage, str, str2, i);
        }
        return null;
    }

    public static GameMassage partyItemToGameMassage(PartyItem partyItem, String str, int i, int i2) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            return iRongIMService2.partyItemToGameMassage(partyItem, str, i, i2);
        }
        return null;
    }

    public static void sendInviteTeamMessage(Context context, boolean z, String str, GameMassage gameMassage) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            iRongIMService2.sendInviteTeamMessage(context, z, str, gameMassage);
        }
    }

    public static void startPartyChat(Context context, String str, String str2, boolean z, String str3) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            iRongIMService2.startPartyChat(context, str, str2, z, str3);
        }
    }

    public static void startPartyDressChat(Context context, String str, String str2, boolean z, boolean z2, String str3) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            iRongIMService2.startPartyDressChat(context, str, str2, z, z2, str3);
        }
    }

    public static String game2GameMassage(int i, String str, String str2, Game game, String str3, String str4) {
        IRongIMService iRongIMService2 = iRongIMService;
        if (iRongIMService2 != null) {
            return iRongIMService2.game2GameMassage(i, str, str2, game, str3, str4);
        }
        return null;
    }
}
