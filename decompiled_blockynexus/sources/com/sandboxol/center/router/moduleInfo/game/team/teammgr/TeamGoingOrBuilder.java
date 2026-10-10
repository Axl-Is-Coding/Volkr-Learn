package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamGoingOrBuilder extends y {
    long getCaptainId();

    String getLang();

    ByteString getLangBytes();

    String getPsid();

    ByteString getPsidBytes();

    String getTeamId();

    ByteString getTeamIdBytes();

    TeamMember getTeammembers(int i);

    int getTeammembersCount();

    List<TeamMember> getTeammembersList();
}
