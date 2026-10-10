package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PartyItemOrBuilder extends y {
    long getCaptainId();

    String getCaptainName();

    ByteString getCaptainNameBytes();

    String getCaptainPicUrl();

    ByteString getCaptainPicUrlBytes();

    int getCaptainVip();

    String getChatGroupId();

    ByteString getChatGroupIdBytes();

    int getCur();

    String getGameName();

    ByteString getGameNameBytes();

    String getGameType();

    ByteString getGameTypeBytes();

    boolean getIsNewEngine();

    String getLang();

    ByteString getLangBytes();

    int getMax();

    String getPsid();

    ByteString getPsidBytes();

    int getTeamCount();

    String getTeamId();

    ByteString getTeamIdBytes();

    int getTeamMemberCount();

    TeamMember getTeamMembers(int i);

    int getTeamMembersCount();

    List<TeamMember> getTeamMembersList();

    TeamType getTeamType();

    int getTeamTypeValue();

    String getTitle();

    ByteString getTitleBytes();
}
