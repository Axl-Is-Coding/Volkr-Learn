package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class VipSubInfo {
    private PlayerInfo playerInfo;
    private List<SubscribeInfo> subInfo;

    public PlayerInfo getPlayerInfo() {
        return this.playerInfo;
    }

    public List<SubscribeInfo> getSubInfo() {
        return this.subInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public void setSubInfo(List<SubscribeInfo> list) {
        this.subInfo = list;
    }
}
