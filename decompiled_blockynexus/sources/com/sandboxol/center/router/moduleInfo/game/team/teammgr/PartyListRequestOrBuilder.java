package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PartyListRequestOrBuilder extends y {
    int getEngineVersions(int i);

    int getEngineVersionsCount();

    List<Integer> getEngineVersionsList();

    String getGameType();

    ByteString getGameTypeBytes();

    String getLang();

    ByteString getLangBytes();

    String getNoJoin(int i);

    ByteString getNoJoinBytes(int i);

    int getNoJoinCount();

    List<String> getNoJoinList();

    int getRegionId();

    RequestType getRequestType();

    int getRequestTypeValue();

    String getSelectGameType();

    ByteString getSelectGameTypeBytes();

    String getSelectLang();

    ByteString getSelectLangBytes();

    int getSize();

    TeamType getTeamType();

    int getTeamTypeValue();

    VersionType getVersion();

    int getVersionValue();
}
