package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamDoneOrBuilder extends y {
    int getDone();

    String getDownurl();

    ByteString getDownurlBytes();

    String getGameaddr();

    ByteString getGameaddrBytes();

    boolean getIsNewEngine();

    String getMid();

    ByteString getMidBytes();

    String getMname();

    ByteString getMnameBytes();

    String getName();

    ByteString getNameBytes();

    int getRegion();

    String getRequestId();

    ByteString getRequestIdBytes();

    int getResVersion();
}
