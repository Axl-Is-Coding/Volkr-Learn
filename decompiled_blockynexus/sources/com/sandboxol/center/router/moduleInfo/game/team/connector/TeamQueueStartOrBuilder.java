package com.sandboxol.center.router.moduleInfo.game.team.connector;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamQueueStartOrBuilder extends y {
    String getAttributes();

    ByteString getAttributesBytes();

    String getCampid();

    ByteString getCampidBytes();

    long getCaptainid();

    String getGametype();

    ByteString getGametypeBytes();

    String getGamexopt();

    ByteString getGamexoptBytes();

    String getMapid();

    ByteString getMapidBytes();

    long getPriority();
}
