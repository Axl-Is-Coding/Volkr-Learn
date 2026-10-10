package com.sandboxol.center.router.moduleInfo.game.team.listener;

import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponse;
import io.grpc.Status;

/* JADX INFO: loaded from: classes3.dex */
public interface ITeamManagerListener {
    void onTeamCompleted();

    void onTeamError(Status status);

    void onTeamNext(TeamResponse teamResponse);
}
