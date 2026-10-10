package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamJoinOrBuilder extends y {
    String getDispUrl();

    ByteString getDispUrlBytes();

    String getGametype();

    ByteString getGametypeBytes();

    int getRegionId();

    String getTeamId();

    ByteString getTeamIdBytes();

    TeamMember getUser();

    boolean hasUser();
}
