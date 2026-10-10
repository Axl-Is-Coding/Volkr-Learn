package com.disabngo.blockynexus.d;

import android.text.TextUtils;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.FriendPartyStatus;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClassConversion.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0507d {
    public static GameMassage a(PartyAuthInfo partyAuthInfo, String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, int i5, String str5) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameName(str3);
        gameMassage.setGameType(str4);
        gameMassage.setCaptainName(AccountCenter.newInstance().nickName.get());
        gameMassage.setChatRoomId(str);
        gameMassage.setCaptainId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setRegionId(partyAuthInfo.getRegion());
        gameMassage.setDispUrl(partyAuthInfo.getDispUrl());
        gameMassage.setGameId(str4);
        gameMassage.setRoomName(str2);
        gameMassage.setMaxMember(i2);
        gameMassage.setMemberCount(i);
        if (i3 <= 0) {
            i3 = 1;
        }
        gameMassage.setTeamCount(i3);
        gameMassage.setTeamType(i4);
        gameMassage.setCreate(true);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setIsNewEngine(i5);
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(3);
        if (!TextUtils.isEmpty(str5)) {
            gameMassage.setCountry(str5);
        }
        return gameMassage;
    }

    public static GameMassage a(Friend friend, String str, int i, String str2) {
        GameMassage gameMassage = new GameMassage();
        FriendPartyStatus friendPartyStatus = friend.getFriendPartyStatus();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameType(friendPartyStatus.getGameId());
        gameMassage.setChatRoomId(friendPartyStatus.getChatGroupId());
        gameMassage.setGameName(friend.getGameName());
        gameMassage.setCaptainName(friendPartyStatus.getTitle());
        gameMassage.setCaptainId(friendPartyStatus.getCaptainId());
        gameMassage.setTeamId(friendPartyStatus.getTeamId());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setDispUrl(str);
        gameMassage.setRegionId(i);
        gameMassage.setRoomName(str2);
        gameMassage.setTeamCount(friendPartyStatus.getTeamCount() > 0 ? friendPartyStatus.getTeamCount() : 1);
        gameMassage.setMaxMember(friendPartyStatus.getTeamMemberCount() * friendPartyStatus.getTeamCount());
        gameMassage.setMemberCount(friendPartyStatus.getMax());
        gameMassage.setPsid(friendPartyStatus.getPsid());
        gameMassage.setTeamType(friend.getFriendPartyStatus().getTeamType());
        gameMassage.setCreate(false);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(5);
        return gameMassage;
    }

    public static GameMassage a(FriendPartyStatus friendPartyStatus, String str, int i, String str2, String str3, String str4, String str5) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameType(friendPartyStatus.getGameId());
        gameMassage.setChatRoomId(friendPartyStatus.getChatGroupId());
        gameMassage.setGameName(str3);
        gameMassage.setCaptainName(friendPartyStatus.getTitle());
        gameMassage.setCaptainId(friendPartyStatus.getCaptainId());
        gameMassage.setTeamId(friendPartyStatus.getTeamId());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setDispUrl(str);
        gameMassage.setRegionId(i);
        gameMassage.setRoomName(str2);
        gameMassage.setTeamCount(friendPartyStatus.getTeamCount() > 0 ? friendPartyStatus.getTeamCount() : 1);
        gameMassage.setMaxMember(friendPartyStatus.getTeamMemberCount() * friendPartyStatus.getTeamCount());
        gameMassage.setMemberCount(friendPartyStatus.getMax());
        gameMassage.setPsid(friendPartyStatus.getPsid());
        gameMassage.setTeamType(friendPartyStatus.getTeamType());
        gameMassage.setCreate(false);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(5);
        gameMassage.setIsNewEngine("v2".equals(str4) ? 1 : 0);
        if (!TextUtils.isEmpty(str5)) {
            gameMassage.setCountry(str5);
        }
        return gameMassage;
    }

    public static GameMassage a(PartyItem partyItem, String str, int i, int i2, String str2) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameType(partyItem.getGameType());
        gameMassage.setChatRoomId(partyItem.getChatGroupId());
        gameMassage.setRoomName(partyItem.getTitle());
        gameMassage.setGameName(partyItem.getGameName());
        gameMassage.setCaptainName(partyItem.getCaptainName());
        gameMassage.setCaptainId(partyItem.getCaptainId());
        gameMassage.setGamePic(partyItem.getCaptainPicUrl());
        gameMassage.setTeamId(partyItem.getTeamId());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setDispUrl(str);
        gameMassage.setRegionId(i);
        gameMassage.setTeamCount(partyItem.getTeamCount() > 0 ? partyItem.getTeamCount() : 1);
        gameMassage.setMaxMember(partyItem.getTeamMemberCount() * partyItem.getTeamCount());
        gameMassage.setMemberCount(partyItem.getMax());
        gameMassage.setPsid(partyItem.getPsid());
        gameMassage.setTeamType(partyItem.getTeamType().getNumber());
        gameMassage.setCreate(false);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setIsNewEngine(partyItem.getIsNewEngine() ? 1 : 0);
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(i2);
        if (!TextUtils.isEmpty(str2)) {
            gameMassage.setCountry(str2);
        }
        return gameMassage;
    }

    public static GameMassage a(InviteTeamMessage inviteTeamMessage, String str, String str2, int i, String str3) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameType(inviteTeamMessage.getGameType());
        gameMassage.setChatRoomId(inviteTeamMessage.getChatRoomId());
        gameMassage.setGameName(inviteTeamMessage.getGameName());
        gameMassage.setCaptainName(inviteTeamMessage.getCaptainName());
        gameMassage.setCaptainId(inviteTeamMessage.getCaptainId());
        gameMassage.setGamePic(inviteTeamMessage.getPicUrl());
        gameMassage.setTeamId(inviteTeamMessage.getTeamId());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setMessageId(str);
        gameMassage.setDispUrl(str2);
        gameMassage.setRegionId(i);
        gameMassage.setRoomName(inviteTeamMessage.getRoomName());
        gameMassage.setMaxMember(inviteTeamMessage.getMaxMember());
        gameMassage.setMemberCount(inviteTeamMessage.getMemberCount());
        gameMassage.setTeamCount(inviteTeamMessage.getTeamCount() > 0 ? inviteTeamMessage.getTeamCount() : 1);
        gameMassage.setTeamType(inviteTeamMessage.getTeamType());
        gameMassage.setPsid(inviteTeamMessage.getPsid());
        gameMassage.setCreate(false);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setIsNewEngine(inviteTeamMessage.getIsNewEngine());
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(6);
        if (!TextUtils.isEmpty(str3)) {
            gameMassage.setCountry(str3);
        }
        return gameMassage;
    }

    public static GameMassage a(InviteMessage inviteMessage, String str, int i, int i2, String str2) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameType(inviteMessage.getGameType());
        gameMassage.setChatRoomId(inviteMessage.getChatRoomId());
        gameMassage.setGameName(inviteMessage.getGameName());
        gameMassage.setCaptainName(inviteMessage.getCaptainName());
        gameMassage.setCaptainId(inviteMessage.getCaptainId());
        gameMassage.setGamePic(inviteMessage.getPicUrl());
        gameMassage.setTeamId(inviteMessage.getTeamId());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setMessageId(inviteMessage.getUId());
        gameMassage.setDispUrl(str);
        gameMassage.setRegionId(i);
        gameMassage.setRoomName(inviteMessage.getRoomName());
        gameMassage.setMaxMember(inviteMessage.getMaxMember());
        gameMassage.setMemberCount(inviteMessage.getMemberCount());
        gameMassage.setTeamCount(inviteMessage.getTeamCount() > 0 ? inviteMessage.getTeamCount() : 1);
        gameMassage.setTeamType(inviteMessage.getTeamType());
        gameMassage.setPsid(inviteMessage.getPsid());
        gameMassage.setCreate(false);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setIsNewEngine(inviteMessage.getIsNewEngine());
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(i2);
        if (!TextUtils.isEmpty(str2)) {
            gameMassage.setCountry(str2);
        }
        return gameMassage;
    }

    public static String a(int i, String str, String str2, Game game, String str3, String str4) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setUserId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setToken(AccountCenter.newInstance().token.get());
        gameMassage.setPicUrl(AccountCenter.newInstance().picUrl.get());
        gameMassage.setNickName(AccountCenter.newInstance().nickName.get());
        gameMassage.setVip(AccountCenter.newInstance().vip.get().intValue());
        gameMassage.setGameName(game.getGameTitle());
        gameMassage.setGameType(str3);
        gameMassage.setGamePic(game.getGameCoverPic());
        gameMassage.setCaptainName(AccountCenter.newInstance().nickName.get());
        gameMassage.setChatRoomId(str2);
        gameMassage.setCaptainId(AccountCenter.newInstance().userId.get().longValue());
        gameMassage.setOrganizeTeamUrl("team.game.sandboxol.com:9921");
        gameMassage.setRegionId(i);
        gameMassage.setDispUrl(str);
        gameMassage.setRoomName(str4);
        gameMassage.setCreate(true);
        gameMassage.setSex(AccountCenter.newInstance().sex.get().intValue());
        gameMassage.setIsNewEngine(game.getIsNewEngine());
        gameMassage.setAppVersion(String.valueOf(BaseApplication.getApp().getMetaDataAppVersion()));
        gameMassage.setPackageName("blockymods");
        gameMassage.setEnterType(1);
        return new com.google.gson.j().a(gameMassage);
    }

    public static GameMassage a(Game game) {
        GameMassage gameMassage = new GameMassage();
        gameMassage.setGameId(game.getGameId());
        gameMassage.setIsNewEngine(game.getIsNewEngine());
        gameMassage.setIsUgc(game.getIsUgc());
        return gameMassage;
    }
}
