package com.sandboxol.imchat.entity;

/* JADX INFO: loaded from: classes4.dex */
public class TeamPositionInfo {
    private boolean isShowEmptyPosition;
    private String teamNumber;

    public String getTeamNumber() {
        return this.teamNumber;
    }

    public boolean isShowEmptyPosition() {
        return this.isShowEmptyPosition;
    }

    public void setShowEmptyPosition(boolean z) {
        this.isShowEmptyPosition = z;
    }

    public void setTeamNumber(String str) {
        this.teamNumber = str;
    }
}
