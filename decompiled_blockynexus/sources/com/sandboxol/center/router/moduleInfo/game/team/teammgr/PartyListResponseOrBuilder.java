package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.y;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface PartyListResponseOrBuilder extends y {
    PartyListResponse.DataCase getDataCase();

    PartyList getParties();

    RemovedParties getRemoves();

    UpdatedParties getUpdates();
}
