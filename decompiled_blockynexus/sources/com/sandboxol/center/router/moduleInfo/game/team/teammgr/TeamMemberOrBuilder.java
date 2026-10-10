package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

import com.google.protobuf.ByteString;
import com.google.protobuf.y;

/* JADX INFO: loaded from: classes3.dex */
public interface TeamMemberOrBuilder extends y {
    String getAppVersion();

    ByteString getAppVersionBytes();

    String getCountry();

    ByteString getCountryBytes();

    String getLang();

    ByteString getLangBytes();

    String getPackageName();

    ByteString getPackageNameBytes();

    String getPicurl();

    ByteString getPicurlBytes();

    int getPosition();

    int getSex();

    MemberStatusType getStatus();

    int getStatusValue();

    long getUserid();

    String getUsername();

    ByteString getUsernameBytes();

    int getVip();
}
