package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.connector.QueueRequest;

/* JADX INFO: loaded from: classes3.dex */
public interface QueueRequestOrBuilder extends y {
    QueueRequest.OperateCase getOperateCase();

    QueueStart getStart();

    QueueStop getStop();
}
