package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;

/* JADX INFO: loaded from: classes3.dex */
public interface UpdateRequestOrBuilder extends y {
    long getCaptainid();

    String getGametype();

    ByteString getGametypeBytes();

    TeamMember getUser();

    boolean hasUser();
}
