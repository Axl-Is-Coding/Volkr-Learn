package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.connector.QueueResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface QueueResponseOrBuilder extends y {
    QueueDone getDone();

    QueueGoing getGoing();

    GameStarting getStarting();

    QueueResponse.StateCase getStateCase();
}
