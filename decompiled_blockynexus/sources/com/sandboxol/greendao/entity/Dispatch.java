package com.sandboxol.greendao.entity;

import com.google.gson.a.c;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Dispatch {

    @c("croomid")
    public String chatRoomId;

    @c("code")
    public int code;

    @c("dispUrl")
    public String dispUrl;

    @c("gaddr")
    public String gAddr;

    @c("gameType")
    public String gameType;

    @c("mid")
    public String mapId;

    @c("mname")
    public String mapName;

    @c("downurl")
    public String mapUrl;

    @c("name")
    public String name;

    @c("region")
    public String region;

    @c("requestIds")
    public Map<Long, String> requestIds;

    @c("resVersion")
    public int resVersion;

    @c(InAppPurchaseMetaData.KEY_SIGNATURE)
    public String signature;

    @c("timestamp")
    public long timestamp;
}
