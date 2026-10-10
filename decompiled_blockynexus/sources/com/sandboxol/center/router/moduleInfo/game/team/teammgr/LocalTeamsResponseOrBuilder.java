package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.LocalTeamsResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface LocalTeamsResponseOrBuilder extends y {
    RemoveLocalTeams getRmvteams();

    LocalTeamsResponse.StateCase getStateCase();

    LocalTeams getTeams();

    UpdateLocalTeams getUpdateteams();
}
