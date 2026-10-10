package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamResponseOrBuilder extends y {
    TeamDone getDone();

    TeamError getErr();

    TeamGoing getGoing();

    boolean getStartGame();

    TeamResponse.StateCase getStateCase();
}
