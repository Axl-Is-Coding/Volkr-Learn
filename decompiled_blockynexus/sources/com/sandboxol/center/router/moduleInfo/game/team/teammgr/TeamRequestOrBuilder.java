package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequest;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamRequestOrBuilder extends y {
    TeamCreate getCreate();

    TeamJoin getJoin();

    TeamRequest.OperateCase getOperateCase();

    TeamInQueue getQueue();

    RemoveMember getRemove();

    SyncMembers getSync();
}
