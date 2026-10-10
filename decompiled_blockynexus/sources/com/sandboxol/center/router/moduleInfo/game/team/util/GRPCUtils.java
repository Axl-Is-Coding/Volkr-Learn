package com.sandboxol.center.router.moduleInfo.game.team.util;

import android.text.TextUtils;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequest;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RemoveMember;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.RequestType;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.SyncMembers;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamCreate;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamInQueue;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamJoin;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamMember;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequest;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamType;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.VersionType;
import com.sandboxol.common.utils.CommonHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GRPCUtils {
    public static PartyListRequest createPartyList(int i, int i2, String str, String str2, RequestType requestType, String str3) {
        return PartyListRequest.newBuilder().addEngineVersions((int) EngineEnv.v1().getEngineVersion()).addEngineVersions((int) EngineEnv.v2().getEngineVersion()).addEngineVersions((int) EngineEnv.v3().getEngineVersion()).setGameType(str3).setLang(CommonHelper.getUserLanguage()).setSelectLang(str).setSelectGameType(str2).setRequestType(requestType).setRegionId(i2).setSize(i).setVersion(VersionType.VERSION_ONE).build();
    }

    public static TeamRequest createTeam(GameMassage gameMassage) {
        TeamCreate.Builder builderNewBuilder = TeamCreate.newBuilder();
        builderNewBuilder.setGametype(gameMassage.getGameType()).setCaptain(createTeamMember(gameMassage)).setDispUrl(gameMassage.getDispUrl()).setRegionId(gameMassage.getRegionId()).setEngineVersion((int) EngineEnv.getEngineVersion(gameMassage.getIsNewEngine(), gameMassage.getIsUgc())).setGameName(gameMassage.getGameName()).setMaxMembers(gameMassage.getMemberCount()).setTeamCount(gameMassage.getTeamCount()).setTeamMemberCount(gameMassage.getMaxMember() / gameMassage.getTeamCount()).setTeamType(TeamType.forNumber(gameMassage.getTeamType())).setTitle(gameMassage.getRoomName()).setVersion(VersionType.VERSION_ONE).setChatGroupId(gameMassage.getChatRoomId()).setIsNewEngine(gameMassage.getIsNewEngine() == 1);
        return TeamRequest.newBuilder().setCreate(builderNewBuilder).build();
    }

    private static TeamMember.Builder createTeamMember(GameMassage gameMassage) {
        return TeamMember.newBuilder().setUserid(gameMassage.getUserId()).setUsername(gameMassage.getNickName()).setPicurl(gameMassage.getPicUrl()).setPosition(0).setSex(gameMassage.getSex()).setAppVersion(gameMassage.getAppVersion()).setLang(CommonHelper.getUserLanguage()).setVip(gameMassage.getVip()).setCountry(TextUtils.isEmpty(gameMassage.getCountry()) ? CommonHelper.getCountry() : gameMassage.getCountry()).setPackageName(gameMassage.getPackageName());
    }

    public static TeamRequest joinTeam(GameMassage gameMassage) {
        TeamJoin.Builder builderNewBuilder = TeamJoin.newBuilder();
        builderNewBuilder.setUser(createTeamMember(gameMassage)).setTeamId(gameMassage.getTeamId()).setDispUrl(gameMassage.getDispUrl()).setRegionId(gameMassage.getRegionId()).setGametype(gameMassage.getGameType());
        return TeamRequest.newBuilder().setJoin(builderNewBuilder).build();
    }

    public static PartyListRequest quickIn(int i, List<String> list, String str, String str2) {
        PartyListRequest.Builder builderNewBuilder = PartyListRequest.newBuilder();
        builderNewBuilder.addEngineVersions((int) EngineEnv.v1().getEngineVersion());
        builderNewBuilder.addEngineVersions((int) EngineEnv.v2().getEngineVersion());
        builderNewBuilder.addEngineVersions((int) EngineEnv.v3().getEngineVersion());
        builderNewBuilder.setLang(CommonHelper.getUserLanguage());
        builderNewBuilder.setRequestType(RequestType.FAST);
        builderNewBuilder.setRegionId(i);
        builderNewBuilder.setSelectGameType(str);
        builderNewBuilder.setSelectLang(str2);
        builderNewBuilder.setSize(1);
        builderNewBuilder.setVersion(VersionType.VERSION_ONE);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            builderNewBuilder.addNoJoin(it.next());
        }
        return builderNewBuilder.build();
    }

    public static TeamRequest removeMember(long j) {
        RemoveMember.Builder builderNewBuilder = RemoveMember.newBuilder();
        builderNewBuilder.setUserid(j);
        return TeamRequest.newBuilder().setRemove(builderNewBuilder).build();
    }

    public static TeamRequest syncMembers(List<TeamMember> list) {
        return TeamRequest.newBuilder().setSync(SyncMembers.newBuilder().addAllTeammembers(list).m64buildPartial()).build();
    }

    public static TeamRequest teamInQueue(String str) {
        return TeamRequest.newBuilder().setQueue(TeamInQueue.newBuilder().setCntoraddr(str)).build();
    }
}
