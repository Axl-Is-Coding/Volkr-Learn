package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueRequest;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamQueueRequestOrBuilder extends y {
    TeamQueueRequest.OperateCase getOperateCase();

    TeamQueueStart getStart();

    TeamQueueStop getStop();
}
