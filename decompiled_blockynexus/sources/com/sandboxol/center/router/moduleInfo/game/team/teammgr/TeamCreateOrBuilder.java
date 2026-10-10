package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamCreateOrBuilder extends y {
    TeamMember getCaptain();

    String getChatGroupId();

    ByteString getChatGroupIdBytes();

    String getDispUrl();

    ByteString getDispUrlBytes();

    int getEngineVersion();

    String getGameName();

    ByteString getGameNameBytes();

    String getGametype();

    ByteString getGametypeBytes();

    boolean getIsNewEngine();

    int getMaxMembers();

    int getRegionId();

    int getTeamCount();

    int getTeamMemberCount();

    TeamType getTeamType();

    int getTeamTypeValue();

    String getTitle();

    ByteString getTitleBytes();

    VersionType getVersion();

    int getVersionValue();

    boolean hasCaptain();
}
