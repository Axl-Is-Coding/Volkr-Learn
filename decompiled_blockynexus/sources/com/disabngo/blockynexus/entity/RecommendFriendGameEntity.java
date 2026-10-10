package com.disabngo.blockynexus.entity;

import com.sandboxol.common.utils.CommonHelper;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendFriendGameEntity {
    private List<RecommendFriendGameDetailEntity> gameDetails;
    private String gameId;

    public List<RecommendFriendGameDetailEntity> getGameDetails() {
        return this.gameDetails;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameTitleByLanguage() {
        HashMap map = new HashMap();
        for (RecommendFriendGameDetailEntity recommendFriendGameDetailEntity : this.gameDetails) {
            if (recommendFriendGameDetailEntity != null && recommendFriendGameDetailEntity.getGameTitle() != null && recommendFriendGameDetailEntity.getLanguage() != null) {
                map.put(recommendFriendGameDetailEntity.getLanguage(), recommendFriendGameDetailEntity.getGameTitle());
            }
        }
        return map.size() > 0 ? map.get(CommonHelper.getUserLanguage()) != null ? (String) map.get(CommonHelper.getUserLanguage()) : (String) map.get("en") : "";
    }

    public void setGameDetails(List<RecommendFriendGameDetailEntity> list) {
        this.gameDetails = list;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }
}
