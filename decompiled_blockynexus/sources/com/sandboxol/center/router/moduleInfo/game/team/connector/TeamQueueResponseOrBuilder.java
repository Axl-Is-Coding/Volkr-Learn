package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamQueueResponseOrBuilder extends y {
    TeamQueueDone getDone();

    TeamQueueGoing getGoing();

    TeamGameStarting getStarting();

    TeamQueueResponse.StateCase getStateCase();
}
